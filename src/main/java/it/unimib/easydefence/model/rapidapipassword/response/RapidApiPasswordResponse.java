package it.unimib.easydefence.model.rapidapipassword.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RapidApiPasswordResponse {
    @JsonProperty("password")
    private String password;
}
