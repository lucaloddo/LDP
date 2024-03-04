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
public class Attributes {
    @JsonProperty("type_description")
    String typeDescription;
    @JsonProperty("tlsh")
    String tlsh;
    @JsonProperty("type_tags")
    List<String> typeTags;
    @JsonProperty("nsrl_info")
    NsrlInfo nsrlInfo;
    @JsonProperty("names")
    List<String> names;
    @JsonProperty("last_modification_date")
    Integer lastModificationDate;
    @JsonProperty("type_tag")
    String typeTag;
    @JsonProperty("times_submitted")
    Integer timesSubmitted;
    @JsonProperty("total_votes")
    TotalVotes totalVotes;
    @JsonProperty("size")
    Integer size;
    @JsonProperty("type_extension")
    String typeExtension;
    @JsonProperty("last_submission_date")
    Integer lastSubmissionDate;
    @JsonProperty("known_distributors")
    KnownDistributors knownDistributors;
    @JsonProperty("last_analysis_results")
    LastAnalysisResults lastAnalysisResults;
    @JsonProperty("trid")
    List<Trid> trid;
    @JsonProperty("sandbox_verdicts")
    SandboxVerdicts sandboxVerdicts;
    @JsonProperty("sha256")
    String sha256;
    @JsonProperty("wireshark")
    Wireshark wireshark;
    @JsonProperty("trusted_verdict")
    TrustedVerdict trustedVerdict;
    @JsonProperty("tags")
    List<String> tags;
    @JsonProperty("last_analysis_date")
    Integer lastAnalysisDate;
    @JsonProperty("unique_sources")
    Integer uniqueSources;
    @JsonProperty("first_submission_date")
    Integer firstSubmissionDate;
    @JsonProperty("ssdeep")
    String ssdeep;
    @JsonProperty("md5")
    String md5;
    @JsonProperty("sha1")
    String sha1;
    @JsonProperty("magic")
    String magic;
    @JsonProperty("last_analysis_stats")
    LastAnalysisStats lastAnalysisStats;
    @JsonProperty("meaningful_name")
    String meaningfulName;
    @JsonProperty("reputation")
    Integer reputation;
    @JsonProperty("first_seen_itw_date")
    Integer firstSeenItwDate;
}
