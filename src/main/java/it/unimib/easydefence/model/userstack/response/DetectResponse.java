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
public class DetectResponse {

    @JsonProperty("ua")
    private String ua;
    @JsonProperty("type")
    private String type;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("os")
    private Os os;
    @JsonProperty("device")
    private Device device;
    @JsonProperty("browser")
    private Browser browser;
    @JsonProperty("crawler")
    private Crawler crawler;

}
