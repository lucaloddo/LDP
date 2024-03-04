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
public class TrustedVerdict {
    @JsonProperty("link")
    String link;
    @JsonProperty("organization")
    String organization;
    @JsonProperty("verdict")
    String verdict;
    @JsonProperty("filename")
    String filename;
}
