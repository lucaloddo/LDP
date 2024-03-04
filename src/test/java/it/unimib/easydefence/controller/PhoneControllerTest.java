package it.unimib.easydefence.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.ninja.response.PhoneResponse;
import it.unimib.easydefence.model.rapidapi.response.RapidApi;
import it.unimib.easydefence.service.PhoneServiceImpl;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static it.unimib.easydefence.utils.TestUtils.buildPhoneResponse;
import static it.unimib.easydefence.utils.TestUtils.buildRapidApiResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PhoneControllerTest {

    @InjectMocks
    PhoneController phoneController;

    @Mock
    PhoneServiceImpl phoneService;

    @Mock
    Model model;

    private static PhoneResponse phoneResponse;
    private RapidApi rapidApi;

    @BeforeEach
    public void beforeEach() {
        phoneController.setMock(Boolean.FALSE);
        phoneController.setObjectMapper(new ObjectMapper());
        phoneResponse = buildPhoneResponse();
        rapidApi = buildRapidApiResponse();
    }

    @Test
    void testGetPhonePage() {
        assertEquals("phoneCheck", phoneController.getPhonePage());
    }

    @Test
    void testGetPhone() throws Exception {
        when(phoneService.getPhone(any())).thenReturn(phoneResponse);
        when(phoneService.getValidationNumber(any())).thenReturn(rapidApi);

        assertEquals("phone", phoneController.getPhone(
                model,
                TestUtils.TEST_PHONE_NUMBER,
                TestUtils.TEST_PREFIX
        ));
    }

    @Test
    void testGetPhoneMockTrue() throws Exception {
        phoneController.setMock(Boolean.TRUE);

        assertEquals("phone", phoneController.getPhone(
                model,
                TestUtils.TEST_PHONE_NUMBER,
                TestUtils.TEST_PREFIX
        ));
    }

    @Test
    void testGetPhoneNumberNull() {
        assertThrows(BadRequestException.class, () -> phoneController.getPhone(
                model,
                null,
                TestUtils.TEST_PREFIX
        ));
    }

    @Test
    void testGetPhonePrefixNull() {
        assertThrows(BadRequestException.class, () -> phoneController.getPhone(
                model,
                TestUtils.TEST_PHONE_NUMBER,
                null
        ));
    }

    @Test
    void testGetPhonePhoneResponseNull() throws Exception {
        when(phoneService.getPhone(any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> phoneController.getPhone(
                model,
                TestUtils.TEST_PHONE_NUMBER,
                TestUtils.TEST_PREFIX
        ));
    }

    @Test
    void testGetPhoneRapidApiNull() throws Exception {
        when(phoneService.getPhone(any())).thenReturn(phoneResponse);
        when(phoneService.getValidationNumber(any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> phoneController.getPhone(
                model,
                TestUtils.TEST_PHONE_NUMBER,
                TestUtils.TEST_PREFIX
        ));
    }

    @Test
    void testGetPhonePhoneDTONull() throws Exception {
        rapidApi.setRiskRating(null);
        when(phoneService.getPhone(any())).thenReturn(phoneResponse);
        when(phoneService.getValidationNumber(any())).thenReturn(rapidApi);

        assertThrows(NotFoundException.class, () -> phoneController.getPhone(
                model,
                TestUtils.TEST_PHONE_NUMBER,
                TestUtils.TEST_PREFIX
        ));
    }
}