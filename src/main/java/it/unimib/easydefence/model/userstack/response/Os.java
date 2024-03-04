package it.unimib.easydefence.model.userstack.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Os {

    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private String code;
    @JsonProperty("url")
    private String url;
    @JsonProperty("family")
    private String family;
    @JsonProperty("family_code")
    private String familyCode;
    @JsonProperty("family_vendor")
    private String familyVendor;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("icon_large")
    private String iconLarge;

}
