package it.unimib.easydefence.client;

import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.model.userstack.response.DetectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "userStackClient", url = "${userstack.url}")
public interface UserStackClient {
    @GetMapping("/detect")
    DetectResponse detect(
            @RequestParam("access_key") String accessKey,
            @RequestParam("ua") String userAgent
    ) throws InternalServerErrorException;
}