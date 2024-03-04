package it.unimib.easydefence.model.virustotal.response;

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
public class KnownDistributors {
    @JsonProperty("filenames")
    List<String> filenames;
    @JsonProperty("products")
    List<String> products;
    @JsonProperty("distributors")
    List<String> distributors;
    @JsonProperty("links")
    List<String> links;
    @JsonProperty("data_sources")
    List<String> dataSources;
}
