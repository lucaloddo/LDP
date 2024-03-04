package it.unimib.easydefence.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.nist.response.CveResponse;
import it.unimib.easydefence.model.userstack.response.DetectResponse;
import it.unimib.easydefence.service.DetectServiceImpl;
import it.unimib.easydefence.service.VulnerabilitiesServiceImpl;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static it.unimib.easydefence.utils.TestUtils.TEST_DETECT_USER_AGENT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DetectControllerTest {

    @InjectMocks
    DetectController detectController;

    @Mock
    DetectServiceImpl detectService;

    @Mock
    VulnerabilitiesServiceImpl vulnerabilitiesService;

    @Mock
    Model model;

    private static DetectResponse detectResponse;
    private static CveResponse cveResponse;

    @BeforeEach
    void beforeEach() {
        detectController.setMock(Boolean.FALSE);
        detectController.setObjectMapper(new ObjectMapper());
        detectResponse = TestUtils.buildDetectResponse();
        cveResponse = TestUtils.buildCveResponse();
    }

    @Test
    void testDetectDevice() throws Exception {
        when(detectService.getDetect(any())).thenReturn(detectResponse);
        when(vulnerabilitiesService.getVulnerabilities(any())).thenReturn(cveResponse);
        assertEquals("index", detectController.detectDevice(model, TEST_DETECT_USER_AGENT));
    }

    @Test
    void testDetectMockTrue() throws Exception {
        detectController.setMock(Boolean.TRUE);
        assertEquals("index", detectController.detectDevice(model, TEST_DETECT_USER_AGENT));
    }

    @Test
    void testDetectDeviceIdUaNullOrEmpty() {
        assertThrows(BadRequestException.class, () -> detectController.detectDevice(model, null));
        assertThrows(BadRequestException.class, () -> detectController.detectDevice(model, ""));
    }

    @Test
    void testDetectDeviceOsNull() throws Exception {
        detectResponse.setOs(null);
        when(detectService.getDetect(any())).thenReturn(detectResponse);

        assertThrows(NotFoundException.class, () -> detectController.detectDevice(model, TEST_DETECT_USER_AGENT));
    }

    @Test
    void testDetectDeviceVulnerabilitiesNull() throws Exception {
        cveResponse.setVulnerabilities(null);
        when(detectService.getDetect(any())).thenReturn(detectResponse);
        when(vulnerabilitiesService.getVulnerabilities(any())).thenReturn(cveResponse);

        assertThrows(NotFoundException.class, () -> detectController.detectDevice(model, TEST_DETECT_USER_AGENT));
    }

}