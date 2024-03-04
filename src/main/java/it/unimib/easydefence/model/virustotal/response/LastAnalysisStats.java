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
public class LastAnalysisStats {
    @JsonProperty("harmless")
    Integer harmless;
    @JsonProperty("type-unsupported")
    Integer typeUnsupported;
    @JsonProperty("suspicious")
    Integer suspicious;
    @JsonProperty("confirmed-timeout")
    Integer confirmedTimeout;
    @JsonProperty("timeout")
    Integer timeout;
    @JsonProperty("failure")
    Integer failure;
    @JsonProperty("malicious")
    Integer malicious;
    @JsonProperty("undetected")
    Integer undetected;
}
