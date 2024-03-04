package it.unimib.easydefence.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.RapidPasswordClient;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.rapidapipassword.response.RapidApiPasswordResponse;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static it.unimib.easydefence.utils.TestUtils.TEST_LENGTH_PASSWORD;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PasswordServiceImplTest {

    @InjectMocks
    PasswordServiceImpl passwordService;

    @Mock
    RapidPasswordClient rapidPasswordClient;

    private static RapidApiPasswordResponse rapidApiPasswordResponse;

    @BeforeEach
    void beforeEach() {
        passwordService.setObjectMapper(new ObjectMapper());
        rapidApiPasswordResponse = TestUtils.buildRapidApiPasswordResponse();
    }

    @Test
    void testGetPassword() throws Exception {
        when(rapidPasswordClient.generation(
                any(),
                any(),
                any(),
                any()
        )).thenReturn(rapidApiPasswordResponse);

        String response = passwordService.getPassword(
                TEST_LENGTH_PASSWORD,
                Boolean.FALSE,
                Boolean.FALSE
        );
        assertNotNull(response);
    }

    @Test
    void testGetPasswordInternalServerError() {
        Mockito.when(rapidPasswordClient.generation(
                any(),
                any(),
                any(),
                any()
        )).thenThrow(InternalServerErrorException.class);

        assertThrows(InternalServerErrorException.class, () -> passwordService.getPassword(
                TEST_LENGTH_PASSWORD,
                Boolean.FALSE,
                Boolean.FALSE
        ));
    }

    @Test
    void testGetPasswordResponseNull() {
        when(rapidPasswordClient.generation(
                any(),
                any(),
                any(),
                any()
        )).thenReturn(null);

        assertThrows(NotFoundException.class, () -> passwordService.getPassword(
                TEST_LENGTH_PASSWORD,
                Boolean.FALSE,
                Boolean.FALSE
        ));
    }
}