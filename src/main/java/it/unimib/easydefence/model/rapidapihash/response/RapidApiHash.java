package it.unimib.easydefence.model.rapidapihash.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RapidApiHash {

    @JsonProperty("hashHexString")
    public String hashHexString;
    @JsonProperty("hashBase64String")
    public String hashBase64String;
    @JsonProperty("result")
    public String result;

}
