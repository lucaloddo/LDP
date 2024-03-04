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
class DomainControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void whenShowInitialPage_thenDomain() throws Exception {
        mockMvc.perform(get("/domain"))
                .andExpect(status().isOk());
    }

    @Test
    void givenDomain_whenGetDomain_thenDomain() throws Exception {
        String dominio = "www.google.it";

        mockMvc.perform(get("/domain/getWhois")
                        .param("dominio", dominio))
                .andExpect(status().isOk());
    }

    @Test
    void givenNullDomain_whenGetDomain_thenBadRequestException() throws Exception {
        mockMvc.perform(get("/domain/getWhois"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenInvalidDomain_whenGetDomain_thenNotFoundException() throws Exception {
        mockMvc.perform(get("/domain/getWhois")
                        .param("dominio", TestUtils.TEST_DOMAIN))
                .andExpect(status().isNotFound());
    }

}
