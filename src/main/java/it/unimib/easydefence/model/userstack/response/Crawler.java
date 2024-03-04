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
public class Crawler {

    @JsonProperty("is_crawler")
    private Boolean isCrawler;
    @JsonProperty("category")
    private String category;
    @JsonProperty("last_seen")
    private String lastSeen;

}
