package it.unimib.easydefence.model.virustotalmitre.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Signature {
    @JsonProperty("severity")
    public String severity;
    @JsonProperty("description")
    public String description;
}
