package it.unimib.easydefence.model.nist.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CvssDataV3 {

    @JsonProperty("version")
    private String version;
    @JsonProperty("vectorString")
    private String vectorString;
    @JsonProperty("attackVector")
    private String attackVector;
    @JsonProperty("attackComplexity")
    private String attackComplexity;
    @JsonProperty("privilegesRequired")
    private String privilegesRequired;
    @JsonProperty("userInteraction")
    private String userInteraction;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("confidentialityImpact")
    private String confidentialityImpact;
    @JsonProperty("integrityImpact")
    private String integrityImpact;
    @JsonProperty("availabilityImpact")
    private String availabilityImpact;
    @JsonProperty("baseScore")
    private Double baseScore;
    @JsonProperty("baseSeverity")
    private String baseSeverity;

}
