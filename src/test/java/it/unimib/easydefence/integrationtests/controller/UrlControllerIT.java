package it.unimib.easydefence.integrationtests.controller;

import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UrlControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void whenShowUploadPage_thenUrl() throws Exception {
        mockMvc.perform(get("/url"))
                .andExpect(status().isOk());
    }

    @Test
    void givenUrl_whenGetReputation_thenUrl() throws Exception {
        String url = "www.google.it";

        mockMvc.perform(get("/url/urlReputation")
                        .param("dominio", url))
                .andExpect(status().isOk());
    }

    @Test
    void givenNullUrl_whenGetReputation_thenBadRequestException() throws Exception {
        mockMvc.perform(get("/url/urlReputation"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenInvalidUrl_whenGetReputation_thenNotFoundException() throws Exception {
        mockMvc.perform(get("/url/urlReputation")
                        .param("dominio", TestUtils.TEST_DOMAIN))
                .andExpect(status().is5xxServerError());
    }

}
