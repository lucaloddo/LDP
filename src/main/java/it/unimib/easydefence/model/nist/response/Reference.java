
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
public class Reference {

    @JsonProperty("url")
    private String url;
    @JsonProperty("source")
    private String source;
    @JsonProperty("tags")
    private List<String> tags;

}
