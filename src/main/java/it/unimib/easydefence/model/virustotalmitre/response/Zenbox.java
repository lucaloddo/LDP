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
public class Zenbox {

    @JsonProperty("tactics")
    public List<Tactic> tactics;

}
