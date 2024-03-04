package it.unimib.easydefence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.NinjaClient;
import it.unimib.easydefence.client.RapidApiClient;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.ninja.response.PhoneResponse;
import it.unimib.easydefence.model.rapidapi.response.RapidApi;
import it.unimib.easydefence.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl {

    private final NinjaClient ninjaClient;
    private final RapidApiClient rapidApiClient;
    private ObjectMapper objectMapper;

    @Autowired
    public PhoneServiceImpl(
            NinjaClient ninjaClient,
            RapidApiClient rapidApiClient,
            ObjectMapper objectMapper
    ) {
        this.ninjaClient = ninjaClient;
        this.rapidApiClient = rapidApiClient;
        this.objectMapper = objectMapper;
    }

    @Value("${ninja.key}")
    String ninjaKey;
    @Value("${rapidApi.key}")
    String rapidApiKey;
    @Value("${rapidApi.host}")
    String rapidApiHost;

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static final Logger LOG = LoggerFactory.getLogger(PhoneServiceImpl.class);

    public RapidApi getValidationNumber(String number) throws JsonProcessingException {
        LOG.info("PhoneService: getValidationNumber START");

        RapidApi responseReputation;

        try {
            responseReputation = rapidApiClient.reputation(rapidApiKey, rapidApiHost, number);
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }

        if (responseReputation == null) {
            LOG.error(Constants.RESPONSE_NULL_OR_EMPTY);
            throw new NotFoundException(Constants.RESPONSE_NULL_OR_EMPTY);
        }

        String msg = objectMapper.writer().writeValueAsString(responseReputation);
        LOG.info("{}", msg);

        LOG.info("PhoneService: getValidationNumber COMPLETED");
        return responseReputation;

    }

    public PhoneResponse getPhone(String number) throws JsonProcessingException {
        LOG.info("PhoneService: getPhone START");

        PhoneResponse response;

        try {
            response = ninjaClient.validatePhone(ninjaKey, number);
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }

        if (response == null) {
            LOG.error(Constants.RESPONSE_NULL_OR_EMPTY);
            throw new NotFoundException(Constants.RESPONSE_NULL_OR_EMPTY);
        }

        String msg = objectMapper.writer().writeValueAsString(response);
        LOG.info("{}", msg);

        LOG.info("PhoneService: getPhone COMPLETED");
        return response;

    }
}
