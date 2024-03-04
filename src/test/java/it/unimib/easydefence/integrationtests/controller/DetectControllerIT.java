package it.unimib.easydefence.integrationtests.controller;

import it.unimib.easydefence.model.dto.BrowserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DetectControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void givenUserAgent_whenGetDetect_thenDevice() throws Exception {
        String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 16_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.6 Mobile/15E148 Safari/604.1";

        mockMvc.perform(get("/detect/device")
                        .param("idUa", userAgent))
                .andExpect(status().isOk())
                .andExpect(model().attribute("deviceDTO", hasProperty("os", is("iOS 16"))))
                .andExpect(model().attribute("deviceDTO", hasProperty("browser", is(BrowserDTO.builder().nome("Safari mobile").versione("16.6").build()))));
    }

    @Test
    void givenNullUserAgent_whenGetDetect_thenBadRequestException() throws Exception {
        mockMvc.perform(get("/detect/device"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenInvalidUserAgent_whenGetDetect_thenNotFoundException() throws Exception {
        String userAgent = "USER_AGENT";

        mockMvc.perform(get("/detect/device")
                        .param("idUa", userAgent))
                .andExpect(status().isNotFound());
    }

}
