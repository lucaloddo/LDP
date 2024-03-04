package it.unimib.easydefence.client;

import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.model.rapidapiwhois.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rapidWhoisClient", url = "${rapidWhoisClient.url}")
public interface RapidWhoisClient {
    @GetMapping("/")
    Response getWhoisInformation(
            @RequestHeader("X-RapidAPI-Key") String accessKey,
            @RequestHeader("X-RapidAPI-Host") String host,
            @RequestParam("domain") String domain,
            @RequestParam("format") String type
    ) throws InternalServerErrorException;
}
