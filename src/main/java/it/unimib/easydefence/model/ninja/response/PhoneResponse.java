package it.unimib.easydefence.model.ninja.response;

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
public class PhoneResponse {

    @JsonProperty("is_valid")
    private Boolean isValid;
    @JsonProperty("is_formatted_properly")
    private Boolean isFormattedProperly;
    @JsonProperty("country")
    private String country;
    @JsonProperty("location")
    private String location;
    @JsonProperty("timezones")
    private List<String> timezones;
    @JsonProperty("format_national")
    private String formatNational;
    @JsonProperty("format_international")
    private String formatInternational;
    @JsonProperty("format_e164")
    private String formatE164;
    @JsonProperty("country_code")
    private Integer countryCode;

}
