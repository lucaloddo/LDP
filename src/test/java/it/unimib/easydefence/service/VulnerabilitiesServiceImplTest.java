package it.unimib.easydefence.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.NistClient;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.nist.response.CveResponse;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static it.unimib.easydefence.utils.TestUtils.TEST_DEVICE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class VulnerabilitiesServiceImplTest {

    @InjectMocks
    VulnerabilitiesServiceImpl vulnerabilitiesService;

    @Mock
    NistClient nistClient;

    private static CveResponse cveResponse;

    @BeforeEach
    void beforeEach() {
        vulnerabilitiesService.setObjectMapper(new ObjectMapper());
        cveResponse = TestUtils.buildCveResponse();
    }

    @Test
    void testGetVulnerabilities() throws Exception {
        when(nistClient.vulnerabilities(any(), any())).thenReturn(cveResponse);

        CveResponse response = vulnerabilitiesService.getVulnerabilities(TEST_DEVICE);

        assertNotNull(response);
    }

    @Test
    void testGetVulnerabilitiesDeviceNull() {
        assertThrows(BadRequestException.class, () -> vulnerabilitiesService.getVulnerabilities(null));
    }

    @Test
    void testGetVulnerabilitiesInternalServerError() throws Exception {
        //Mockito.doThrow(new InternalServerErrorException(new Exception())).when(nistClient).vulnerabilities(any(), any());
        Mockito.when(nistClient.vulnerabilities(any(), any())).thenThrow(InternalServerErrorException.class);

        assertThrows(InternalServerErrorException.class, () -> vulnerabilitiesService.getVulnerabilities(TEST_DEVICE));
    }

    @Test
    void testGetVulnerabilitiesResponseNull() throws Exception {
        when(nistClient.vulnerabilities(any(), any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> vulnerabilitiesService.getVulnerabilities(TEST_DEVICE));
    }

}