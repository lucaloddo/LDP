package it.unimib.easydefence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.RapidPasswordClient;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.mapper.PasswordMapper;
import it.unimib.easydefence.model.rapidapipassword.request.RapidApiPasswordRequest;
import it.unimib.easydefence.model.rapidapipassword.response.RapidApiPasswordResponse;
import it.unimib.easydefence.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl {
    private final RapidPasswordClient rapidApiPasswordClient;
    @Value("${rapidPasswordClient.key}")
    String rapidKey;
    @Value("${rapidPasswordClient.host}")
    String rapidHost;
    @Value("${rapidPasswordClient.type}")
    String rapidType;
    private ObjectMapper objectMapper;

    @Autowired
    public PasswordServiceImpl(
            RapidPasswordClient rapidApiPasswordClient,
            ObjectMapper objectMapper
    ) {
        this.rapidApiPasswordClient = rapidApiPasswordClient;
        this.objectMapper = objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static final Logger LOG = LoggerFactory.getLogger(PasswordServiceImpl.class);

    public String getPassword(
            Integer length,
            Boolean excludeNumber,
            Boolean excludeSpecial
    ) throws JsonProcessingException {
        LOG.info("PasswordService: getPassword START");

        RapidApiPasswordRequest body = PasswordMapper.toRapidApiPasswordRequest(length, excludeNumber, excludeSpecial);

        RapidApiPasswordResponse response;

        try {
            response = rapidApiPasswordClient.generation(rapidKey, rapidHost, rapidType, body);
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }

        if (response == null) {
            LOG.error(Constants.RESPONSE_NULL_OR_EMPTY);
            throw new NotFoundException(Constants.RESPONSE_NULL_OR_EMPTY);
        }

        String msg = objectMapper.writer().writeValueAsString(response);
        LOG.info("{}", msg);

        LOG.info("PasswordService: getPassword COMPLETED");
        return response.getPassword();
    }

}
