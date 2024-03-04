package it.unimib.easydefence.mapper;

import it.unimib.easydefence.model.dto.FileDTO;
import it.unimib.easydefence.model.virustotal.response.DataResp;
import it.unimib.easydefence.model.virustotalmitre.response.Zenbox;

public class FileMapper {
    private FileMapper() {

    }

    public static FileDTO toFileDTO(DataResp report, Zenbox mitre) {
        if (report == null) {
            return null;
        }

        return FileDTO.builder()
                .analysisStats(report.getAttributes().getLastAnalysisStats())
                .votes(report.getAttributes().getTotalVotes())
                .filenameDistributions(report.getAttributes().getNames())
                .tags(report.getAttributes().getTags())
                .zenbox(mitre)
                .build();
    }
}
