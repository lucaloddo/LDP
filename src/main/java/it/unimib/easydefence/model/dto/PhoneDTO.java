package it.unimib.easydefence.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    private Boolean valid;
    private String country;
    private String countryLoc;
    private String nationalFormat;
    private List<String> timezones;
    private String riskRating;
    private Integer riskLevel;
}
