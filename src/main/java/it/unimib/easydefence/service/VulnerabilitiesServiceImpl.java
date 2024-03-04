package it.unimib.easydefence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.NistClient;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.nist.response.CveResponse;
import it.unimib.easydefence.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VulnerabilitiesServiceImpl {

    private final NistClient nistClient;

    private ObjectMapper objectMapper;

    @Autowired
    public VulnerabilitiesServiceImpl(
            NistClient nistClient,
            ObjectMapper objectMapper
    ) {
        this.nistClient = nistClient;
        this.objectMapper = objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static final Logger LOG = LoggerFactory.getLogger(VulnerabilitiesServiceImpl.class);

    public CveResponse getVulnerabilities(String device) throws JsonProcessingException {
        LOG.info("VulnerabilitiesService: getVulnerabilities START");

        if (device == null) {
            LOG.error("ERROR: device is null or empty");
            throw new BadRequestException("ERROR: device is null or empty");
        }

        CveResponse responseCve;

        try {
            responseCve = nistClient.vulnerabilities(device, 20);
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }

        if (responseCve == null) {
            LOG.error(Constants.RESPONSE_NULL_OR_EMPTY);
            throw new NotFoundException(Constants.RESPONSE_NULL_OR_EMPTY);
        }

        String msg = objectMapper.writer().writeValueAsString(responseCve);
        LOG.info("{}", msg);

        LOG.info("VulnerabilitiesService: getVulnerabilities COMPLETED");
        return responseCve;
    }

}
