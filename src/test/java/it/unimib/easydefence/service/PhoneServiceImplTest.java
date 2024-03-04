package it.unimib.easydefence.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.NinjaClient;
import it.unimib.easydefence.client.RapidApiClient;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.ninja.response.PhoneResponse;
import it.unimib.easydefence.model.rapidapi.response.RapidApi;
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
class PhoneServiceImplTest {

    @InjectMocks
    PhoneServiceImpl phoneService;

    @Mock
    NinjaClient ninjaClient;

    @Mock
    RapidApiClient rapidApiClient;

    private static PhoneResponse phoneResponse;
    private static RapidApi rapidApiResponse;

    @BeforeEach
    void beforeEach() {
        phoneService.setObjectMapper(new ObjectMapper());
        phoneResponse = TestUtils.buildPhoneResponse();
        rapidApiResponse = TestUtils.buildRapidApiResponse();
    }

    @Test
    void testGetValidationNumber() throws JsonProcessingException {
        when(rapidApiClient.reputation(
                any(),
                any(),
                any()
        )).thenReturn(rapidApiResponse);

        RapidApi response = phoneService.getValidationNumber(TestUtils.TEST_PHONE_NUMBER);

        assertNotNull(response);
    }

    @Test
    void testGetValidationNumberInternalServerError() {
        Mockito.when(rapidApiClient.reputation(
                any(),
                any(),
                any()
        )).thenThrow(InternalServerErrorException.class);

        assertThrows(InternalServerErrorException.class, () -> phoneService.getValidationNumber(TestUtils.TEST_PHONE_NUMBER));
    }

    @Test
    void testGetValidationNumberResponseNull() {
        when(rapidApiClient.reputation(
                any(),
                any(),
                any()
        )).thenReturn(null);

        assertThrows(NotFoundException.class, () -> phoneService.getValidationNumber(TestUtils.TEST_PHONE_NUMBER));
    }

    @Test
    void testGetPhone() throws Exception {
        when(ninjaClient.validatePhone(any(), any())).thenReturn(phoneResponse);

        PhoneResponse response = phoneService.getPhone(TestUtils.TEST_PHONE_NUMBER);

        assertNotNull(response);
    }

    @Test
    void testGetPhoneInternalServerError() {
        Mockito.when(ninjaClient.validatePhone(any(), any())).thenThrow(InternalServerErrorException.class);

        assertThrows(InternalServerErrorException.class, () -> phoneService.getPhone(TestUtils.TEST_PHONE_NUMBER));
    }

    @Test
    void testGetPhoneResponseNull() {
        when(ninjaClient.validatePhone(any(), any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> phoneService.getPhone(TestUtils.TEST_PHONE_NUMBER));
    }

}