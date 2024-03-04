package it.unimib.easydefence.mapper;

import it.unimib.easydefence.model.dto.DeviceDTO;
import it.unimib.easydefence.model.nist.response.Vulnerability;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DetectMapperTest {

    private List<Vulnerability> vulnerabilityList;

    @BeforeEach
    void beforeEach() {
        vulnerabilityList = TestUtils.buildCveResponse().getVulnerabilities();
    }

    @Test
    void testToDeviceDTO() {
        DeviceDTO mapped = DetectMapper.toDeviceDTO(
                TestUtils.buildDetectResponse(),
                vulnerabilityList
        );

        assertNotNull(mapped);
    }

    @Test
    void testToDeviceDTODetectResponseNull() {
        DeviceDTO mapped = DetectMapper.toDeviceDTO(
                null,
                vulnerabilityList
        );

        assertNull(mapped);
    }

    @Test
    void testToDeviceDTOVulnerabilityListNull() {
        DeviceDTO mapped = DetectMapper.toDeviceDTO(
                TestUtils.buildDetectResponse(),
                null
        );

        assertNotNull(mapped);
        assertNull(mapped.getVulnerabilities());
        assertNull(mapped.getSeveritiesAverage());
        assertEquals(TestUtils.TEST_OS, mapped.getOs());
    }

    @Test
    void testToDeviceDTOVulnerabilityListEmpty() {
        DeviceDTO mapped = DetectMapper.toDeviceDTO(
                TestUtils.buildDetectResponse(),
                List.of()
        );

        assertNotNull(mapped);
        assertNull(mapped.getVulnerabilities());
        assertNull(mapped.getSeveritiesAverage());
        assertEquals(TestUtils.TEST_OS, mapped.getOs());
    }

    @Test
    void testToDeviceDTOCVEDescriptionsNull() {
        vulnerabilityList.get(0).getCve().setDescriptions(null);
        DeviceDTO mapped = DetectMapper.toDeviceDTO(
                TestUtils.buildDetectResponse(),
                vulnerabilityList
        );

        assertNotNull(mapped);
        assertNotNull(mapped.getVulnerabilities());
    }

    @Test
    void testToDeviceDTOCVEMetricsNull() {
        vulnerabilityList.get(0).getCve().setMetrics(null);
        DeviceDTO mapped = DetectMapper.toDeviceDTO(TestUtils.buildDetectResponse(), vulnerabilityList);

        assertNotNull(mapped);
    }

    @Test
    void testToDeviceDTOCVECvssNull() {
        vulnerabilityList.get(0).getCve().getMetrics().getCvssMetricV2().set(0, null);
        DeviceDTO mapped = DetectMapper.toDeviceDTO(TestUtils.buildDetectResponse(), vulnerabilityList);

        assertNotNull(mapped);
    }
}