
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
public class Cve {

    @JsonProperty("id")
    private String id;
    @JsonProperty("sourceIdentifier")
    private String sourceIdentifier;
    @JsonProperty("published")
    private String published;
    @JsonProperty("lastModified")
    private String lastModified;
    @JsonProperty("vulnStatus")
    private String vulnStatus;
    @JsonProperty("descriptions")
    private List<Description> descriptions;
    @JsonProperty("metrics")
    private Metrics metrics;
    @JsonProperty("weaknesses")
    private List<Weakness> weaknesses;
    @JsonProperty("configurations")
    private List<Configuration> configurations;
    @JsonProperty("references")
    private List<Reference> references;

}
