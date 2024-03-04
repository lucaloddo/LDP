package it.unimib.easydefence.mapper;

import it.unimib.easydefence.model.dto.FileDTO;
import it.unimib.easydefence.model.virustotal.response.DataResp;
import it.unimib.easydefence.model.virustotalmitre.response.Zenbox;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class FileMapperTest {

    private static DataResp dataResp;
    private static Zenbox zenboxLinux;

    @BeforeEach
    void beforeEach() {
        dataResp = TestUtils.buildDataResp();
        zenboxLinux = TestUtils.buildMitreZenbox().getData().getZenboxLinux();
    }

    @Test
    void testToFileDTO() {
        FileDTO mapped = FileMapper.toFileDTO(
                dataResp,
                zenboxLinux
        );

        assertNotNull(mapped);
    }

    @Test
    void testToFileDTOReportNull() {
        FileDTO mapped = FileMapper.toFileDTO(
                null,
                zenboxLinux
        );

        assertNull(mapped);
    }

}