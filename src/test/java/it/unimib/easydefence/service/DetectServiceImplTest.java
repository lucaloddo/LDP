package it.unimib.easydefence.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.UserStackClient;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.userstack.response.DetectResponse;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static it.unimib.easydefence.utils.TestUtils.TEST_DETECT_USER_AGENT;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class DetectServiceImplTest {

    @InjectMocks
    DetectServiceImpl detectService;

    @Mock
    UserStackClient userStackClient;

    private static DetectResponse detectResponse;

    @BeforeEach
    void beforeEach() {
        detectService.setObjectMapper(new ObjectMapper());
        detectResponse = TestUtils.buildDetectResponse();
    }

    @Test
    void testGetDetect() throws Exception {
        when(userStackClient.detect(any(), any())).thenReturn(detectResponse);

        DetectResponse response = detectService.getDetect(TEST_DETECT_USER_AGENT);

        assertNotNull(response);
    }

    @Test
    void testGetDetectUserAgentNull() {
        assertThrows(BadRequestException.class, () -> detectService.getDetect(null));
    }

    @Test
    void testGetDetectInternalServerError() throws Exception {
        Mockito.when(userStackClient.detect(any(), any())).thenThrow(InternalServerErrorException.class);

        assertThrows(InternalServerErrorException.class, () -> detectService.getDetect(TEST_DETECT_USER_AGENT));
    }

    @Test
    void testGetDetectResponseNull() throws Exception {
        when(userStackClient.detect(any(), any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> detectService.getDetect(TEST_DETECT_USER_AGENT));
    }
}