package it.unimib.easydefence.client;

import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.model.nist.response.CveResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nist", url = "${nist.url}")
public interface NistClient {
    @GetMapping("/rest/json/cves/2.0")
    CveResponse vulnerabilities(
            @RequestParam("keywordSearch") String device,
            @RequestParam("resultsPerPage") Integer num
    ) throws InternalServerErrorException;
}