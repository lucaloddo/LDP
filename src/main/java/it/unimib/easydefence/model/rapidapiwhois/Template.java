
package it.unimib.easydefence.model.rapidapiwhois;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Template {

    @JsonProperty("whois.pir.org")
    public String whoisPirOrg;
    @JsonProperty("whois.tucows.com")
    public String whoisTucowsCom;

}
