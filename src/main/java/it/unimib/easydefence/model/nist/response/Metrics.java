
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
public class Metrics {

    @JsonProperty("cvssMetricV31")
    private List<CvssMetricV31> cvssMetricV31;
    @JsonProperty("cvssMetricV2")
    private List<CvssMetricV2> cvssMetricV2;

}
