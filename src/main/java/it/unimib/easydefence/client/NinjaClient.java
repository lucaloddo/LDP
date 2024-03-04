package it.unimib.easydefence.client;

import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.model.ninja.response.PasswordResponse;
import it.unimib.easydefence.model.ninja.response.PhoneResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ninja", url = "${ninja.url}")
public interface NinjaClient {
    @GetMapping("/validatephone")
    PhoneResponse validatePhone(
            @RequestHeader("X-Api-Key") String accessKey,
            @RequestParam("number") String number
    ) throws InternalServerErrorException;

    @GetMapping("/passwordgenerator")
    PasswordResponse generation(
            @RequestHeader("X-Api-Key") String accessKey,
            @RequestParam("length") Integer length
    ) throws InternalServerErrorException;
}
