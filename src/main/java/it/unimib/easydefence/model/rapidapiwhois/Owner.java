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
public class Owner {

    @JsonProperty("handle")
    public String handle;
    @JsonProperty("type")
    public String type;
    @JsonProperty("name")
    public String name;
    @JsonProperty("organization")
    public String organization;
    @JsonProperty("email")
    public String email;
    @JsonProperty("address")
    public String address;
    @JsonProperty("zipcode")
    public String zipcode;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("country")
    public String country;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("fax")
    public String fax;
    @JsonProperty("created")
    public String created;
    @JsonProperty("changed")
    public String changed;

}
