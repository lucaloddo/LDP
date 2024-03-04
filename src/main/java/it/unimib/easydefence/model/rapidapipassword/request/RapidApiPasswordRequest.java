package it.unimib.easydefence.model.rapidapipassword.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RapidApiPasswordRequest {
    @JsonProperty("length")
    private Integer length;
    @JsonProperty("excludeNumbers")
    private Boolean excludeNumbers;
    @JsonProperty("excludeSpecial")
    private Boolean excludeSpecial;

}
