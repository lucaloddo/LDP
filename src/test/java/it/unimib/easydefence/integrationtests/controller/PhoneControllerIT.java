package it.unimib.easydefence.integrationtests.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PhoneControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void whenGetPhonePage_thenPhonePage() throws Exception {
        mockMvc.perform(get("/phone"))
                .andExpect(status().isOk());
    }

    // temporary unavailable
    /*@Test
    void givenNumberAndPrefix_whenGetPhone_thenPhoneDTO() throws Exception {
        String number = "3451942847";
        String prefix = "+39";
        mockMvc.perform(get("/phone/phoneCheck")
                        .param("number", number)
                        .param("prefix", prefix))
                .andExpect(status().isOk())
                .andExpect(model().attribute("phoneDTO", hasProperty("valid", is(Boolean.TRUE))));
    }*/

    @Test
    void givenNullNumber_whenGetPhone_thenBadRequestException() throws Exception {
        String number = null;
        String prefix = "+39";
        mockMvc.perform(get("/phone/phoneCheck")
                        .param("number", number)
                        .param("prefix", prefix))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenNullPrefix_whenGetPhone_thenBadRequestException() throws Exception {
        String number = "3451942847";
        String prefix = null;
        mockMvc.perform(get("/phone/phoneCheck")
                        .param("number", number)
                        .param("prefix", prefix))
                .andExpect(status().isBadRequest());
    }

}
