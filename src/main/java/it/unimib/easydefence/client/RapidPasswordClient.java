package it.unimib.easydefence.client;

import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.model.rapidapipassword.request.RapidApiPasswordRequest;
import it.unimib.easydefence.model.rapidapipassword.response.RapidApiPasswordResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "rapidPasswordClient", url = "${rapidPasswordClient.url}")
public interface RapidPasswordClient {

    @PostMapping(value = "/api")
    RapidApiPasswordResponse generation(
            @RequestHeader("X-RapidAPI-Key") String accessKey,
            @RequestHeader("X-RapidAPI-Host") String host,
            @RequestHeader(value = "Accept") String type,
            @RequestBody RapidApiPasswordRequest body
    ) throws InternalServerErrorException;

}
