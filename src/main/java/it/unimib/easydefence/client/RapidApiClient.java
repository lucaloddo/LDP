package it.unimib.easydefence.client;

import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.model.rapidapi.response.RapidApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rapidApiClient", url = "${rapidApi.url}")
public interface RapidApiClient {
    @GetMapping("/search")
    RapidApi reputation(
            @RequestHeader("X-RapidAPI-Key") String accessKey,
            @RequestHeader("X-RapidAPI-Host") String host,
            @RequestParam("dialcode") String number
    ) throws InternalServerErrorException;
}
