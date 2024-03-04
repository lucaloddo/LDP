package it.unimib.easydefence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.VirusTotalClient;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.virustotal.response.FileResponse;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UrlServiceImplTest {

    @InjectMocks
    UrlServiceImpl urlService;

    @Mock
    VirusTotalClient virusTotalClient;

    private static FileResponse fileResponse;

    @BeforeEach
    void beforeEach() {
        urlService.setObjectMapper(new ObjectMapper());
        fileResponse = TestUtils.buildFileResponse();
    }

    @Test
    void testReputationDominio() throws JsonProcessingException {
        when(virusTotalClient.reputationDomain(any(), any())).thenReturn(fileResponse);

        FileResponse response = urlService.reputationDominio(TestUtils.TEST_DOMAIN);

        assertNotNull(response);
    }

    @Test
    void testReputationDominioInternalServerError() {
        Mockito.when(virusTotalClient.reputationDomain(any(), any())).thenThrow(InternalServerErrorException.class);

        assertThrows(InternalServerErrorException.class, () -> urlService.reputationDominio(TestUtils.TEST_DOMAIN));
    }

    @Test
    void testReputationDominioResponseNull() {
        when(virusTotalClient.reputationDomain(any(), any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> urlService.reputationDominio(TestUtils.TEST_DOMAIN));
    }

}