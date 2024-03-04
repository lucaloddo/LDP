package it.unimib.easydefence.model.rapidapiwhois;

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
public class Contacts {

    @JsonProperty("owner")
    public List<Owner> owner;
    @JsonProperty("admin")
    public List<Owner> admin;
    @JsonProperty("tech")
    public List<Owner> tech;

}
