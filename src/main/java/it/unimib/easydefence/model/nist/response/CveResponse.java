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
public class CveResponse {

    @JsonProperty("resultsPerPage")
    private Integer resultsPerPage;
    @JsonProperty("startIndex")
    private Integer startIndex;
    @JsonProperty("totalResults")
    private Integer totalResults;
    @JsonProperty("format")
    private String format;
    @JsonProperty("version")
    private String version;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("vulnerabilities")
    private List<Vulnerability> vulnerabilities;

}
