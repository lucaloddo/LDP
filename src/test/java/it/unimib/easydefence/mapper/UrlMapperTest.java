package it.unimib.easydefence.mapper;

import it.unimib.easydefence.model.dto.UrlDTO;
import it.unimib.easydefence.model.virustotal.response.DataResp;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UrlMapperTest {

    private static DataResp dataResp;

    @BeforeEach
    void beforeEach() {
        dataResp = TestUtils.buildDataResp();
    }

    @Test
    void testToUrlDTO() {
        UrlDTO mapped = UrlMapper.toUrlDTO(dataResp);

        assertNotNull(mapped);
    }

    @Test
    void testToUrlDTOReportNull() {
        UrlDTO mapped = UrlMapper.toUrlDTO(null);

        assertNull(mapped);
    }

}