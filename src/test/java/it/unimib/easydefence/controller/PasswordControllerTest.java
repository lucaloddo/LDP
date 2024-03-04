package it.unimib.easydefence.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.service.PasswordServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static it.unimib.easydefence.utils.TestUtils.TEST_LENGTH_PASSWORD;
import static it.unimib.easydefence.utils.TestUtils.TEST_RANDOM_PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PasswordControllerTest {

    @InjectMocks
    PasswordController passwordController;
    @Mock
    PasswordServiceImpl passwordService;
    @Mock
    Model model;

    @BeforeEach
    void beforeEach() {
        passwordController.setMock(Boolean.FALSE);
        passwordController.setObjectMapper(new ObjectMapper());
    }

    @Test
    void testGetPasswordPage() {
        assertEquals("password", passwordController.getPasswordPage());
    }

    @Test
    void testGetRandomPassword() throws Exception {
        when(passwordService.getPassword(
                any(),
                any(),
                any()
        )).thenReturn(TEST_RANDOM_PASSWORD);

        assertEquals("password", passwordController.getRandomPassword(
                model,
                TEST_LENGTH_PASSWORD,
                Boolean.FALSE,
                Boolean.FALSE
        ));
    }

    @Test
    void testGetRandomPasswordMockTrue() throws Exception {
        passwordController.setMock(Boolean.TRUE);

        assertEquals("password", passwordController.getRandomPassword(
                model,
                TEST_LENGTH_PASSWORD,
                Boolean.TRUE,
                Boolean.FALSE
        ));
    }

    @Test
    void testGetRandomPasswordLengthNull() {
        assertThrows(BadRequestException.class, () -> passwordController.getRandomPassword(
                model,
                null,
                Boolean.FALSE,
                Boolean.FALSE
        ));
    }

    @Test
    void testGetRandomPasswordLengthLessThanOrEqualToZero() {
        assertThrows(BadRequestException.class, () -> passwordController.getRandomPassword(
                model,
                0,
                Boolean.FALSE,
                Boolean.FALSE
        ));
    }

    @Test
    void testGetRandomPasswordExcludeNumbersNull() {
        assertThrows(BadRequestException.class, () -> passwordController.getRandomPassword(
                model,
                TEST_LENGTH_PASSWORD,
                null,
                Boolean.FALSE
        ));
    }

    @Test
    void testGetRandomPasswordExcludeSpecialNull() {
        assertThrows(BadRequestException.class, () -> passwordController.getRandomPassword(
                model,
                TEST_LENGTH_PASSWORD,
                Boolean.FALSE,
                null
        ));
    }

    @Test
    void testGetRandomPasswordPwdNull() throws Exception {
        when(passwordService.getPassword(any(), any(), any())).thenReturn(null);
        assertThrows(NotFoundException.class, () -> passwordController.getRandomPassword(
                model,
                TEST_LENGTH_PASSWORD,
                Boolean.FALSE,
                Boolean.FALSE
        ));
    }

    @Test
    void testGetRandomPasswordPwdEmpty() throws Exception {
        when(passwordService.getPassword(any(), any(), any())).thenReturn("");
        assertThrows(NotFoundException.class, () -> passwordController.getRandomPassword(
                model,
                TEST_LENGTH_PASSWORD,
                Boolean.FALSE,
                Boolean.FALSE
        ));
    }
}