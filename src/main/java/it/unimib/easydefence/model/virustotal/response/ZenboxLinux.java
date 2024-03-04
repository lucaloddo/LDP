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
public class ZenboxLinux {
    @JsonProperty("category")
    String category;
    @JsonProperty("confidence")
    Integer confidence;
    @JsonProperty("sandbox_name")
    String sandboxName;
    @JsonProperty("malware_classification")
    List<String> malwareClassification;
}
