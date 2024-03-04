package it.unimib.easydefence.mapper;

import it.unimib.easydefence.model.dto.UrlDTO;
import it.unimib.easydefence.model.virustotal.response.DataResp;

public class UrlMapper {
    private UrlMapper() {

    }

    public static UrlDTO toUrlDTO(DataResp report) {
        if (report == null) {
            return null;
        }

        return UrlDTO.builder()
                .analysisStats(report.getAttributes().getLastAnalysisStats())
                .votes(report.getAttributes().getTotalVotes())
                .filenameDistributions(report.getAttributes().getNames())
                .tags(report.getAttributes().getTags())
                .build();
    }

}
