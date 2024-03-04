package it.unimib.easydefence.model.virustotalmitre.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    @JsonProperty("VirusTotal Observer")
    public VirusTotalObserver virusTotalObserver;

    @JsonProperty("Zenbox Linux")
    public Zenbox zenboxLinux;

    @JsonProperty("Zenbox")
    public Zenbox zenbox;

    @JsonProperty("VirusTotal Jujubox")
    public VirusTotalJujubox virusTotalJujubox;

}
