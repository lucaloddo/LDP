package it.unimib.easydefence.mapper;

import it.unimib.easydefence.model.rapidapipassword.request.RapidApiPasswordRequest;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PasswordMapperTest {

    @BeforeEach
    void beforeEach() {

    }

    @Test
    void testToRapidApiPasswordRequest() {
        RapidApiPasswordRequest mapped = PasswordMapper.toRapidApiPasswordRequest(
                TestUtils.TEST_LENGTH_PASSWORD,
                Boolean.FALSE,
                Boolean.FALSE
        );

        assertNotNull(mapped);
    }

}