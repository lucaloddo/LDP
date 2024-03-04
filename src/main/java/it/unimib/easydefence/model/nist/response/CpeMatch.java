
package it.unimib.easydefence.model.nist.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "vulnerable",
        "criteria",
        "matchCriteriaId",
        "versionEndIncluding"
})
@Generated("jsonschema2pojo")
public class CpeMatch {

    @JsonProperty("vulnerable")
    private Boolean vulnerable;
    @JsonProperty("criteria")
    private String criteria;
    @JsonProperty("matchCriteriaId")
    private String matchCriteriaId;
    @JsonProperty("versionEndIncluding")
    private String versionEndIncluding;

}
