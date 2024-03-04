package it.unimib.easydefence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.mapper.UrlMapper;
import it.unimib.easydefence.model.dto.UrlDTO;
import it.unimib.easydefence.model.virustotal.response.FileResponse;
import it.unimib.easydefence.service.UrlServiceImpl;
import it.unimib.easydefence.utils.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/url")
public class UrlController {
    private final UrlServiceImpl urlService;

    private ObjectMapper objectMapper;
    @Value("${mock.url}")
    private Boolean mock;

    @Autowired
    public UrlController(
            UrlServiceImpl urlService,
            ObjectMapper objectMapper
    ) {
        this.urlService = urlService;
        this.objectMapper = objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void setMock(Boolean mock) {
        this.mock = mock;
    }

    private static final Logger LOG = LoggerFactory.getLogger(UrlController.class);

    @GetMapping("")
    public String showUploadPage() {
        LOG.info("UrlController: showUploadPage START");
        LOG.info("UrlController: showUploadPage COMPLETED");
        return "url";
    }

    @GetMapping("/urlReputation")
    public String getReputation(
            Model model,
            @RequestParam("dominio") String dominio
    ) throws JsonProcessingException {
        LOG.info("UrlController: getReputation START");

        UrlDTO urlDTO;

        if (Boolean.TRUE.equals(mock)) {
            LOG.info("DetectController: service mocked");
            urlDTO = Mock.buildUrlDTO();
        } else {
            checkInputParameters(dominio);
            FileResponse reputation = urlService.reputationDominio(dominio);
            if (checkDataResp(reputation)) {
                LOG.error("ERROR: reputation is empty or null");
                throw new NotFoundException("ERROR: reputation is empty or null");
            }
            LOG.info("reputation: {}", reputation);
            urlDTO = UrlMapper.toUrlDTO(reputation.getDataResp());
        }

        String msg = objectMapper.writer().writeValueAsString(urlDTO);
        LOG.info("{}", msg);
        model.addAttribute("urlDTO", urlDTO);

        LOG.info("UrlController: getReputation COMPLETED");
        return "urlInfo";
    }

    private void checkInputParameters(String dominio) {
        if (dominio == null) {
            LOG.error("ERROR: dominio is null");
            throw new BadRequestException("ERROR: dominio is null ");
        }
    }

    private static boolean checkDataResp(FileResponse dataResp) {
        return dataResp == null || dataResp.getDataResp() == null
                || dataResp.getDataResp().getAttributes() == null
                || dataResp.getDataResp().getAttributes().getLastAnalysisStats() == null;
    }
}
