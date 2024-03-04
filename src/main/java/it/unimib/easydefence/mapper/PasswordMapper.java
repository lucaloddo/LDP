package it.unimib.easydefence.mapper;

import it.unimib.easydefence.model.rapidapipassword.request.RapidApiPasswordRequest;

public class PasswordMapper {
    private PasswordMapper() {

    }

    public static RapidApiPasswordRequest toRapidApiPasswordRequest(
            Integer length,
            Boolean excludeNumbers,
            Boolean excludeSpecial
    ) {
        return RapidApiPasswordRequest.builder()
                .length(length)
                .excludeNumbers(excludeNumbers)
                .excludeSpecial(excludeSpecial)
                .build();
    }
}
