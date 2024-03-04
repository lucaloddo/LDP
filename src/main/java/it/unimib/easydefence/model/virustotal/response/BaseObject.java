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
public class BaseObject {
    @JsonProperty("category")
    String category;
    @JsonProperty("engine_name")
    String engineName;
    @JsonProperty("engine_version")
    String engineVersion;
    @JsonProperty("result")
    Object result;
    @JsonProperty("method")
    String method;
    @JsonProperty("engine_update")
    String engineUpdate;
}
