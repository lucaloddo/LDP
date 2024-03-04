package it.unimib.easydefence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import it.unimib.easydefence.client.RapidHashClient;
import it.unimib.easydefence.client.VirusTotalClient;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.rapidapihash.response.RapidApiHash;
import it.unimib.easydefence.model.virustotal.response.DataResp;
import it.unimib.easydefence.model.virustotal.response.FileResponse;
import it.unimib.easydefence.model.virustotalmitre.response.Mitre;
import it.unimib.easydefence.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl {

    private final VirusTotalClient virusTotalClient;
    private final RapidHashClient rapidHashClient;
    private ObjectMapper objectMapper;

    @Autowired
    public FileServiceImpl(
            VirusTotalClient virusTotalClient,
            RapidHashClient rapidHashClient,
            ObjectMapper objectMapper
    ) {
        this.virusTotalClient = virusTotalClient;
        this.rapidHashClient = rapidHashClient;
        this.objectMapper = objectMapper;
    }

    @Value("${virusTotal.key}")
    String virusTotalKey;
    @Value("${rapidHashClient.key}")
    String rapidHashKey;
    @Value("${rapidHashClient.host}")
    String rapidHashHost;

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static final Logger LOG = LoggerFactory.getLogger(FileServiceImpl.class);

    public FileResponse getReport(String hashFile) throws JsonProcessingException {
        LOG.info("FileService: getReport START");

        if (hashFile == null) {
            LOG.error(Constants.HASH_NULL_OR_EMPTY);
            throw new BadRequestException(Constants.HASH_NULL_OR_EMPTY);
        }

        FileResponse responseReport = null;
        try {
            responseReport = virusTotalClient.report(virusTotalKey, hashFile);
        } catch (FeignException fe) {
            if (fe.status() == 404) {
                responseReport = FileResponse.builder().dataResp(DataResp.builder().type("NOT_FOUND").build()).build();
            }
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }

        if (responseReport == null) {
            LOG.error(Constants.RESPONSE_REPORT_NULL_OR_EMPTY);
            throw new NotFoundException(Constants.RESPONSE_REPORT_NULL_OR_EMPTY);
        }

        String msg = objectMapper.writer().writeValueAsString(responseReport);
        LOG.info("{}", msg);

        LOG.info("FileService: getReport COMPLETED");
        return responseReport;

    }

    public RapidApiHash getHash(MultipartFile file) throws JsonProcessingException {
        LOG.info("FileService: getHash START");
        if (file == null) {
            LOG.error(Constants.HASH_NULL_OR_EMPTY);
            throw new BadRequestException(Constants.HASH_NULL_OR_EMPTY);
        }

        RapidApiHash responseHash;
        try {
            responseHash = rapidHashClient.createHash(rapidHashKey, rapidHashHost, file, 256);
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        if (responseHash == null) {
            LOG.error(Constants.RESPONSE_REPORT_NULL_OR_EMPTY);
            throw new NotFoundException(Constants.RESPONSE_REPORT_NULL_OR_EMPTY);
        }

        String msg = objectMapper.writer().writeValueAsString(responseHash);
        LOG.info("{}", msg);

        LOG.info("FileService: getHash COMPLETED");
        return responseHash;

    }

    public Mitre getMitreAttack(String hash) throws JsonProcessingException {
        LOG.info("FileService: getMitreAttack START");
        if (hash == null) {
            LOG.error(Constants.HASH_NULL_OR_EMPTY);
            throw new BadRequestException(Constants.HASH_NULL_OR_EMPTY);
        }

        Mitre responseMitre;
        try {
            LOG.info(virusTotalKey);
            responseMitre = virusTotalClient.mitreAttack(virusTotalKey, hash);

        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }

        if (responseMitre == null || responseMitre.getData() == null) {
            LOG.error("ERROR: responseMitre is null");
            throw new NotFoundException("ERROR: responseMitre is null");
        }

        String msg = objectMapper.writer().writeValueAsString(responseMitre);
        LOG.info("{}", msg);

        LOG.info("FileService: getMitreAttack COMPLETED");
        return responseMitre;
    }

}
