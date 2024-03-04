package it.unimib.easydefence.mapper;

import it.unimib.easydefence.model.dto.PhoneDTO;
import it.unimib.easydefence.model.ninja.response.PhoneResponse;
import it.unimib.easydefence.model.rapidapi.response.RapidApi;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class PhoneMapperTest {

    private static PhoneResponse phoneResponse;
    private static RapidApi validationResponse;

    @BeforeEach
    void beforeEach() {
        phoneResponse = TestUtils.buildPhoneResponse();
        validationResponse = TestUtils.buildRapidApiResponse();
    }

    @Test
    void testToPhoneDTO() {
        PhoneDTO mapped = PhoneMapper.toPhoneDTO(phoneResponse, validationResponse);

        assertNotNull(mapped);
    }

    @Test
    void testToPhoneDTONull() {
        PhoneDTO mapped = PhoneMapper.toPhoneDTO(null, validationResponse);

        assertNull(mapped);
    }

}