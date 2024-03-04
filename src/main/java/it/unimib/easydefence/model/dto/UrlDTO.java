package it.unimib.easydefence.model.dto;

import it.unimib.easydefence.model.virustotal.response.LastAnalysisStats;
import it.unimib.easydefence.model.virustotal.response.TotalVotes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UrlDTO {
    private TotalVotes votes;
    private List<String> filenameDistributions;
    private List<String> tags;
    private LastAnalysisStats analysisStats;
}
