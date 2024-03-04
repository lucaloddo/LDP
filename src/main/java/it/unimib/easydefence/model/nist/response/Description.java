
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
public class Description {

    @JsonProperty("lang")
    private String lang;
    @JsonProperty("value")
    private String value;

}
