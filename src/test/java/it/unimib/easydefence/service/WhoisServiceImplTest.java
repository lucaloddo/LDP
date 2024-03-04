package it.unimib.easydefence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.RapidWhoisClient;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.rapidapiwhois.Response;
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
class WhoisServiceImplTest {

    @InjectMocks
    WhoisServiceImpl whoisService;

    @Mock
    RapidWhoisClient rapidWhoisClient;

    private static FileResponse fileResponse;
    private static Response response;

    @BeforeEach
    void beforeEach() {
        whoisService.setObjectMapper(new ObjectMapper());
        response = TestUtils.buildWhoisDomainResponse();
    }

    @Test
    void testGetWhois() throws JsonProcessingException {
        when(rapidWhoisClient.getWhoisInformation(
                any(),
                any(),
                any(),
                any()
        )).thenReturn(response);

        Response response = whoisService.getWhois(TestUtils.TEST_DOMAIN);

        assertNotNull(response);
    }

    @Test
    void testGetWhoisInternalServerError() {
        Mockito.when(rapidWhoisClient.getWhoisInformation(
                any(),
                any(),
                any(),
                any()
        )).thenThrow(InternalServerErrorException.class);

        assertThrows(InternalServerErrorException.class, () -> whoisService.getWhois(TestUtils.TEST_DOMAIN));
    }

    @Test
    void testGetWhoisResponseNull() {
        when(rapidWhoisClient.getWhoisInformation(
                any(),
                any(),
                any(),
                any()
        )).thenReturn(null);

        assertThrows(NotFoundException.class, () -> whoisService.getWhois(TestUtils.TEST_DOMAIN));
    }

}