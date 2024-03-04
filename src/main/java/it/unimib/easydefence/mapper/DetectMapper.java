package it.unimib.easydefence.mapper;

import it.unimib.easydefence.model.dto.BrowserDTO;
import it.unimib.easydefence.model.dto.DeviceDTO;
import it.unimib.easydefence.model.dto.VulnerabilityDTO;
import it.unimib.easydefence.model.nist.response.*;
import it.unimib.easydefence.model.userstack.response.DetectResponse;

import java.util.ArrayList;
import java.util.List;

public class DetectMapper {

    private DetectMapper() {
    }

    public static DeviceDTO toDeviceDTO(
            DetectResponse device,
            List<Vulnerability> vulnerabilityList
    ) {
        if (device == null || vulnerabilityList == null || vulnerabilityList.isEmpty()) {
            return buildDeviceDTO(device);
        }

        List<VulnerabilityDTO> vulnerabilites = new ArrayList<>();

        for (Vulnerability vulnerability : vulnerabilityList) {
            VulnerabilityDTO vulnerabilityDTO = buildVulnerabilityDTO(vulnerability);

            if (vulnerabilityDTO != null) {
                vulnerabilites.add(vulnerabilityDTO);
            }
        }

        return DeviceDTO.builder()
                .vulnerabilities(vulnerabilites)
                .severitiesAverage(calculateAverage(vulnerabilites))
                .os(device.getOs().getName())
                .browser(buildBrowserDTO(device))
                .build();
    }

    private static DeviceDTO buildDeviceDTO(DetectResponse device) {
        if (device == null) {
            return null;
        }
        return DeviceDTO.builder()
                .os(device.getOs().getName())
                .browser(buildBrowserDTO(device))
                .build();
    }

    private static BrowserDTO buildBrowserDTO(DetectResponse device) {
        return BrowserDTO.builder()
                .nome(device.getBrowser().getName())
                .versione(device.getBrowser().getVersion())
                .build();
    }

    private static VulnerabilityDTO buildVulnerabilityDTO(Vulnerability vulnerability) {
        if (vulnerability == null || vulnerability.getCve() == null || vulnerability.getCve().getDescriptions() == null
                || vulnerability.getCve().getDescriptions().isEmpty()) {
            return null;
        }

        Cve cve = vulnerability.getCve();

        VulnerabilityDTO vulnerabilityDTO = VulnerabilityDTO.builder().build();

        for (Description description : cve.getDescriptions()) {
            if (description != null && description.getLang() != null && description.getLang().equalsIgnoreCase("en")) {
                vulnerabilityDTO.setDescription(description.getValue());
            }
        }

        vulnerabilityDTO.setCveId(cve.getId());

        Metrics metrics = cve.getMetrics();
        if (metrics == null || metrics.getCvssMetricV2() == null || metrics.getCvssMetricV2().isEmpty()) {
            return null;
        }

        for (CvssMetricV2 cvss : metrics.getCvssMetricV2()) {
            if (cvss == null || cvss.getCvssData() == null) {
                return null;
            }
            Double baseScore = cvss.getCvssData().getBaseScore();
            vulnerabilityDTO.setSeverity(baseScore);
        }

        return vulnerabilityDTO;
    }

    private static double calculateAverage(List<VulnerabilityDTO> vulnerabilites) {
        if (vulnerabilites != null && !vulnerabilites.isEmpty()) {
            double total = 0d;
            for (VulnerabilityDTO vulnerabilityDTO : vulnerabilites) {
                total += vulnerabilityDTO.getSeverity();
            }
            return total / vulnerabilites.size();
        }
        return 0d;
    }

}
