package it.unimib.easydefence.model.rapidapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RapidApi {

    @JsonProperty("dialcode_e164")
    public String dialcodeE164;
    @JsonProperty("timezone")
    public String timezone;
    @JsonProperty("timezone_short")
    public String timezoneShort;
    @JsonProperty("timezone_utc_offset")
    public String timezoneUtcOffset;
    @JsonProperty("region")
    public String region;
    @JsonProperty("sub_region")
    public String subRegion;
    @JsonProperty("administrative_area_level_3")
    public Object administrativeAreaLevel3;
    @JsonProperty("administrative_area_level_2")
    public String administrativeAreaLevel2;
    @JsonProperty("administrative_area_level_1")
    public String administrativeAreaLevel1;
    @JsonProperty("administrative_area_level_1_short")
    public String administrativeAreaLevel1Short;
    @JsonProperty("locality")
    public String locality;
    @JsonProperty("sublocality_level_1")
    public Object sublocalityLevel1;
    @JsonProperty("point_of_interest")
    public Object pointOfInterest;
    @JsonProperty("neighborhood")
    public Object neighborhood;
    @JsonProperty("clli")
    public String clli;
    @JsonProperty("switch_assignment_date")
    public String switchAssignmentDate;
    @JsonProperty("country")
    public String country;
    @JsonProperty("country_short")
    public String countryShort;
    @JsonProperty("postal_code")
    public String postalCode;
    @JsonProperty("operating_company_name")
    public String operatingCompanyName;
    @JsonProperty("operating_company_type")
    public String operatingCompanyType;
    @JsonProperty("lata")
    public String lata;
    @JsonProperty("ocn")
    public String ocn;
    @JsonProperty("line_type")
    public String lineType;
    @JsonProperty("location_routing_number")
    public String locationRoutingNumber;
    @JsonProperty("ported")
    public Boolean ported;
    @JsonProperty("risk_rating")
    public String riskRating;
    @JsonProperty("risk_level")
    public Integer riskLevel;
    @JsonProperty("ported_date")
    public Object portedDate;
    @JsonProperty("dialcode_invalid")
    public Boolean dialcodeInvalid;
    @JsonProperty("dialcode_impossible")
    public Boolean dialcodeImpossible;
    @JsonProperty("notes")
    public String notes;

}
