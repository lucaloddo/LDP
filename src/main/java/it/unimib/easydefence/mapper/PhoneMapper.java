package it.unimib.easydefence.mapper;

import it.unimib.easydefence.model.dto.PhoneDTO;
import it.unimib.easydefence.model.ninja.response.PhoneResponse;
import it.unimib.easydefence.model.rapidapi.response.RapidApi;

public class PhoneMapper {

    private PhoneMapper() {
    }

    public static PhoneDTO toPhoneDTO(
            PhoneResponse phoneResponse,
            RapidApi validationResponse
    ) {
        if (phoneResponse == null) {
            return null;
        }
        return PhoneDTO.builder()
                .valid(phoneResponse.getIsValid())
                .country(phoneResponse.getCountry())
                .countryLoc(phoneResponse.getLocation())
                .nationalFormat(phoneResponse.getFormatNational())
                .timezones(phoneResponse.getTimezones())
                .riskRating(validationResponse.getRiskRating())
                .riskLevel(validationResponse.getRiskLevel())
                .build();
    }

}
