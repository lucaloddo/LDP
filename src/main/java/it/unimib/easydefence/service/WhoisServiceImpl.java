package it.unimib.easydefence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.RapidWhoisClient;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.rapidapiwhois.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhoisServiceImpl {
    private final RapidWhoisClient rapidWhoisClient;
    private ObjectMapper objectMapper;

    @Autowired
    public WhoisServiceImpl(
            RapidWhoisClient rapidWhoisClient,
            ObjectMapper objectMapper
    ) {
        this.rapidWhoisClient = rapidWhoisClient;
        this.objectMapper = objectMapper;
    }

    @Value("${rapidWhoisClient.key}")
    String whoisKey;
    @Value("${rapidWhoisClient.host}")
    String whoisHost;

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static final Logger LOG = LoggerFactory.getLogger(WhoisServiceImpl.class);

    public Response getWhois(String domain) throws JsonProcessingException {
        LOG.info("WhoisService: getWhois START");

        Response response;

        try {
            response = rapidWhoisClient.getWhoisInformation(whoisKey, whoisHost, domain, "json");
        } catch (Exception e) {
            throw new InternalServerErrorException(e.toString());
        }

        if (response == null) {
            LOG.error("ERROR: response is null or empty");
            throw new NotFoundException("ERROR: response is null or empty");
        }

        String msg = objectMapper.writer().writeValueAsString(response);
        LOG.info("{}", msg);

        LOG.info("WhoisService: getWhois COMPLETED");
        return response;
    }

}
