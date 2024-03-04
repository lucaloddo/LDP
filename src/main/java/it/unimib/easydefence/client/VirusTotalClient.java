package it.unimib.easydefence.client;

import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.model.virustotal.response.FileResponse;
import it.unimib.easydefence.model.virustotalmitre.response.Mitre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "virusTotalClient", url = "${virusTotal.url}")
public interface VirusTotalClient {
    @GetMapping("/files/{valoreHash}")
    FileResponse report(
            @RequestHeader("x-apikey") String accessKey,
            @PathVariable("valoreHash") String valoreHash
    ) throws InternalServerErrorException;

    @GetMapping("/files/{id}/behaviour_mitre_trees")
    Mitre mitreAttack(
            @RequestHeader("x-apikey") String accessKey,
            @PathVariable("id") String hash
    ) throws InternalServerErrorException;

    @GetMapping("/domains/{domain}")
    FileResponse reputationDomain(
            @RequestHeader("x-apikey") String accessKey,
            @PathVariable("domain") String domain
    ) throws InternalServerErrorException;
}