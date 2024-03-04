package it.unimib.easydefence.model.nist.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    @JsonProperty("operator")
    private String operator;
    @JsonProperty("negate")
    private Boolean negate;
    @JsonProperty("cpeMatch")
    private List<CpeMatch> cpeMatch;

}
