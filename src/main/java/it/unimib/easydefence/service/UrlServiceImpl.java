package it.unimib.easydefence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.VirusTotalClient;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.virustotal.response.FileResponse;
import it.unimib.easydefence.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl {

    private final VirusTotalClient virusTotalClient;

    private ObjectMapper objectMapper;

    @Autowired
    public UrlServiceImpl(
            VirusTotalClient virusTotalClient,
            ObjectMapper objectMapper
    ) {
        this.virusTotalClient = virusTotalClient;
        this.objectMapper = objectMapper;
    }

    @Value("${virusTotal.key}")
    String rapidKey;

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private static final Logger LOG = LoggerFactory.getLogger(UrlServiceImpl.class);

    public FileResponse reputationDominio(String dominio) throws JsonProcessingException {
        LOG.info("UrlService: reputationDominio START");

        FileResponse response;

        try {
            response = virusTotalClient.reputationDomain(rapidKey, dominio);
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }

        if (response == null) {
            LOG.error(Constants.RESPONSE_NULL_OR_EMPTY);
            throw new NotFoundException(Constants.RESPONSE_NULL_OR_EMPTY);
        }

        String msg = objectMapper.writer().writeValueAsString(response);
        LOG.info("{}", msg);

        LOG.info("UrlService: reputationDominio COMPLETED");
        return response;
    }

}
