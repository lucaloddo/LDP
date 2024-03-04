package it.unimib.easydefence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.UserStackClient;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.userstack.response.DetectResponse;
import it.unimib.easydefence.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DetectServiceImpl {

    private final UserStackClient userStackClient;

    private ObjectMapper objectMapper;

    @Autowired
    public DetectServiceImpl(
            UserStackClient userStackClient,
            ObjectMapper objectMapper
    ) {
        this.userStackClient = userStackClient;
        this.objectMapper = objectMapper;
    }

    @Value("${userstack.key}")
    String userStackKey;

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static final Logger LOG = LoggerFactory.getLogger(DetectServiceImpl.class);

    public DetectResponse getDetect(String userAgent) throws JsonProcessingException {
        LOG.info("DetectService: getDetect START");

        if (userAgent == null) {
            LOG.error("ERROR: userAgent is null or empty");
            throw new BadRequestException("ERROR: userAgent is null or empty");
        }

        DetectResponse detect;

        try {
            detect = userStackClient.detect(
                    userStackKey,
                    userAgent
            );
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }

        if (detect == null) {
            LOG.error(Constants.RESPONSE_NULL_OR_EMPTY);
            throw new NotFoundException(Constants.RESPONSE_NULL_OR_EMPTY);
        }

        String msg = objectMapper.writer().writeValueAsString(detect);
        LOG.info("{}", msg);

        LOG.info("DetectService: getDetect COMPLETED");
        return detect;
    }

}
