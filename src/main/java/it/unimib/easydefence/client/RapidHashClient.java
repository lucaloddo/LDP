package it.unimib.easydefence.client;

import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.model.rapidapihash.response.RapidApiHash;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "rapidHashClient", url = "${rapidHashClient.url}")
public interface RapidHashClient {
    @GetMapping(value = "/hashfile", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    RapidApiHash createHash(
            @RequestHeader("X-RapidAPI-Key") String accessKey,
            @RequestHeader("X-RapidAPI-Host") String host,
            @RequestPart(value = "file") final MultipartFile file,
            @RequestParam("mode") Integer typehash
    ) throws InternalServerErrorException;
}
