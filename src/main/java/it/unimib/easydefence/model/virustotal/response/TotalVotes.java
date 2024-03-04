package it.unimib.easydefence.model.virustotal.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TotalVotes {
    @JsonProperty("harmless")
    Integer harmless;
    @JsonProperty("malicious")
    Integer malicious;
}
