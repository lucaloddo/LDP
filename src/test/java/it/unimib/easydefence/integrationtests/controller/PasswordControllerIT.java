package it.unimib.easydefence.integrationtests.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasLength;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PasswordControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void whenGetPasswordPage_thenPasswordPage() throws Exception {
        mockMvc.perform(get("/password"))
                .andExpect(status().isOk());
    }

    // temporary unreachable
    /*@Test
    void givenPasswordLength_whenGetRandomPassword_thenGeneratedPassword() throws Exception {
        String length = "5";
        String isNumbers = "false";
        String isSymbols = "false";
        mockMvc.perform(get("/password/generator")
                        .param("length", length)
                        .param("isNumbers", isNumbers)
                        .param("isSymbols", isSymbols))
                .andExpect(status().isOk())
                .andExpect(model().attribute("generatedPassword", hasLength(5)));
    }*/

    @Test
    void givenNullPasswordLength_whenGetRandomPassword_thenBadRequestException() throws Exception {
        String length = null;
        String isNumbers = "false";
        String isSymbols = "false";
        mockMvc.perform(get("/password/generator")
                        .param("length", length)
                        .param("isNumbers", isNumbers)
                        .param("isSymbols", isSymbols))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenLessThanZeroPasswordLength_whenGetRandomPassword_thenBadRequestException() throws Exception {
        String length = "0";
        String isNumbers = "false";
        String isSymbols = "false";
        mockMvc.perform(get("/password/generator")
                        .param("length", length)
                        .param("isNumbers", isNumbers)
                        .param("isSymbols", isSymbols))
                .andExpect(status().isBadRequest());
    }

}
