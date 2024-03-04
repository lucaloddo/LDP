package it.unimib.easydefence.model.virustotal.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataResp {
    @JsonProperty("attributes")
    Attributes attributes;
    @JsonProperty("type")
    String type;
    @JsonProperty("id")
    String id;
    @JsonProperty("links")
    Links links;
}
