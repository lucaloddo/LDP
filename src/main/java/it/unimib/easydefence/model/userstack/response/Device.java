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
public class Device {

    @JsonProperty("is_mobile_device")
    private Boolean isMobileDevice;
    @JsonProperty("type")
    private String type;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("brand_code")
    private String brandCode;
    @JsonProperty("brand_url")
    private String brandUrl;
    @JsonProperty("name")
    private String name;

}
