package it.unimib.easydefence.model.virustotalmitre.response;

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
public class Technique {

    @JsonProperty("description")
    public String description;
    @JsonProperty("signatures")
    public List<Signature> signatures;
    @JsonProperty("link")
    public String link;
    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;

}
