package it.unimib.easydefence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.mapper.FileMapper;
import it.unimib.easydefence.model.dto.FileDTO;
import it.unimib.easydefence.model.rapidapihash.response.RapidApiHash;
import it.unimib.easydefence.model.virustotal.response.FileResponse;
import it.unimib.easydefence.model.virustotalmitre.response.Mitre;
import it.unimib.easydefence.model.virustotalmitre.response.Tactic;
import it.unimib.easydefence.model.virustotalmitre.response.Technique;
import it.unimib.easydefence.service.FileServiceImpl;
import it.unimib.easydefence.utils.Constants;
import it.unimib.easydefence.utils.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    private final FileServiceImpl fileService;

    private ObjectMapper objectMapper;

    @Autowired
    public FileController(
            FileServiceImpl fileService,
            ObjectMapper objectMapper
    ) {
        this.fileService = fileService;
        this.objectMapper = objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static final Logger LOG = LoggerFactory.getLogger(FileController.class);

    @Value("${mock.file}")
    private Boolean mock;

    public void setMock(Boolean mock) {
        this.mock = mock;
    }

    @GetMapping("")
    public String showUploadPage() {
        LOG.info("FileController: showUploadPage START");
        LOG.info("FileController: showUploadPage COMPLETED");
        return "fileUploader";
    }

    @PostMapping("/fileUploader")
    public String getFilePage(
            Model model,
            @RequestParam("file") MultipartFile file
    ) throws JsonProcessingException {
        LOG.info("FileController: getFilePage START");

        FileDTO fileDTO;

        if (Boolean.TRUE.equals(mock)) {
            LOG.info("FileController: service mocked");
            fileDTO = Mock.buildFileDTO();
        } else {
            fileDTO = processFile(file, model);
        }

        String msg = objectMapper.writer().writeValueAsString(fileDTO);
        LOG.info("{}", msg);
        model.addAttribute("fileDTO", fileDTO);

        LOG.info("FileController: getFilePage COMPLETED");
        return "file";
    }

    private FileDTO processFile(MultipartFile file, Model model) throws JsonProcessingException {
        checkInputParameters(file);

        FileDTO fileDTO = null;

        RapidApiHash responseHash = fileService.getHash(file);

        if (checkResponseHash(responseHash)) {
            LOG.error("ERROR: responseHash is empty or null");
            throw new NotFoundException("ERROR: responseHash is empty or null");
        }

        FileResponse dataResp = fileService.getReport(responseHash.getHashHexString());

        if (checkDataResp(dataResp)) {
            return null;
        }

        if (dataResp.getDataResp().getType().equals("NOT_FOUND")) {
            return null;
        }

        Mitre dataMitreResponse = fileService.getMitreAttack(responseHash.getHashHexString());

        String msg = objectMapper.writer().writeValueAsString(dataMitreResponse);
        LOG.info("{}", msg);

        if (checkDataMitreResponse(dataMitreResponse)) {
            LOG.error("ERROR: dataMitreResponse is empty or null");
            throw new NotFoundException("ERROR: dataMitreResponse is empty or null");
        }

        if (dataMitreResponse.getData().getZenbox() == null) {
            fileDTO = FileMapper.toFileDTO(dataResp.getDataResp(), dataMitreResponse.getData().getZenboxLinux());
        }
        if (dataMitreResponse.getData().getZenboxLinux() == null) {
            fileDTO = FileMapper.toFileDTO(dataResp.getDataResp(), dataMitreResponse.getData().getZenbox());
        }
        if (dataMitreResponse.getData().getZenboxLinux() == null && dataMitreResponse.getData().getZenbox() == null) {
            fileDTO = FileMapper.toFileDTO(dataResp.getDataResp(), null);
        }

        if (fileDTO != null && fileDTO.getZenbox() != null) {
            iterateOnTactics(fileDTO.getZenbox().getTactics());
        }

        msg = objectMapper.writer().writeValueAsString(fileDTO);
        LOG.info("{}", msg);
        model.addAttribute("fileDTO", fileDTO);

        LOG.info("FileController: getFilePage COMPLETED");
        return fileDTO;
    }

    private static void iterateOnTactics(List<Tactic> tactics) {
        for (Tactic tactic : tactics) {
            if (checkTechniques(tactic)) {
                LOG.error(Constants.FILE_TACTICS_NULL_OR_EMPTY);
                throw new NotFoundException(Constants.FILE_TACTICS_NULL_OR_EMPTY);
            }

            List<Technique> techniques = tactic.getTechniques();

            for (Technique technique : techniques) {
                if (checkSignatures(technique)) {
                    LOG.error(Constants.FILE_TECHNIQUES_NULL_OR_EMPTY);
                    throw new NotFoundException(Constants.FILE_TECHNIQUES_NULL_OR_EMPTY);
                }
            }
        }
    }

    private static boolean checkSignatures(Technique technique) {
        return technique == null || technique.getSignatures() == null || technique.getSignatures().isEmpty();
    }

    private static boolean checkTechniques(Tactic tactic) {
        return tactic == null || tactic.getTechniques() == null || tactic.getTechniques().isEmpty();
    }

    private static boolean checkDataMitreResponse(Mitre dataMitreResponse) {
        return dataMitreResponse == null || dataMitreResponse.getData() == null;
    }

    private static boolean checkDataResp(FileResponse dataResp) {
        return dataResp == null || dataResp.getDataResp() == null
                || dataResp.getDataResp().getAttributes() == null
                || dataResp.getDataResp().getAttributes().getLastAnalysisStats() == null;
    }

    private static boolean checkResponseHash(RapidApiHash responseHash) {
        return responseHash == null || responseHash.getHashHexString() == null;
    }

    private void checkInputParameters(MultipartFile file) {
        if (file == null) {
            LOG.error("ERROR: file is null");
            throw new BadRequestException("ERROR: file is null");
        }
    }

}