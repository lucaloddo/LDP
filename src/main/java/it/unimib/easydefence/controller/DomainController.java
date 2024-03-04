package it.unimib.easydefence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.rapidapiwhois.Contacts;
import it.unimib.easydefence.model.rapidapiwhois.Owner;
import it.unimib.easydefence.model.rapidapiwhois.Response;
import it.unimib.easydefence.service.WhoisServiceImpl;
import it.unimib.easydefence.utils.Constants;
import it.unimib.easydefence.utils.DateUtils;
import it.unimib.easydefence.utils.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/domain")
public class DomainController {
    private final WhoisServiceImpl whoisService;
    private ObjectMapper objectMapper;
    @Value("${mock.domain}")
    private Boolean mock;

    @Autowired
    public DomainController(WhoisServiceImpl whoisService, ObjectMapper objectMapper) {
        this.whoisService = whoisService;
        this.objectMapper = objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void setMock(Boolean mock) {
        this.mock = mock;
    }

    private static final Logger LOG = LoggerFactory.getLogger(DomainController.class);

    @GetMapping("")
    public String showInitialPage() {
        LOG.info("DomainController: showInitialPage START");
        LOG.info("DomainController: showInitialPage COMPLETED");
        return "domain";
    }

    @GetMapping("/getWhois")
    public String getDomain(
            Model model,
            @RequestParam("dominio") String dominio
    ) throws JsonProcessingException {
        LOG.info("DomainController: getDomain START");

        Response domainInformation;

        if (Boolean.TRUE.equals(mock)) {
            LOG.info("DomainController: service mocked");
            domainInformation = Mock.buildDomain();
        } else {
            checkInputParameters(dominio);

            domainInformation = whoisService.getWhois(dominio);

            if (domainInformation == null || (domainInformation.getStatus() != null && domainInformation.getStatus().equalsIgnoreCase("fail"))) {
                LOG.error("ERROR: whois domain is empty or null");
                throw new NotFoundException("ERROR: whois domain is empty or null");
            }

            domainInformation = parseResponseDates(domainInformation);
        }

        String msg = objectMapper.writer().writeValueAsString(domainInformation);
        LOG.info("{}", msg);

        model.addAttribute("domainInformation", domainInformation);

        LOG.info("DomainController: getDomain COMPLETED");
        return "domainInfo";
    }

    private void checkInputParameters(String domain) {
        if (domain == null) {
            LOG.error("ERROR: domain is null");
            throw new BadRequestException("ERROR: domain is null");
        }
    }

    private Response parseResponseDates(Response response) {
        if (response != null) {
            response.setCreated(DateUtils.convertDate(response.getCreated(), Constants.DATE_TIME_PATTERN, Constants.DATE_PATTERN));
            response.setChanged(DateUtils.convertDate(response.getChanged(), Constants.DATE_TIME_PATTERN, Constants.DATE_PATTERN));
            response.setExpires(DateUtils.convertDate(response.getExpires(), Constants.DATE_TIME_PATTERN, Constants.DATE_PATTERN));

            Contacts contacts = response.getContacts();

            if (contacts != null) {
                parseDatesInContactsLists(contacts.getOwner());
                parseDatesInContactsLists(contacts.getAdmin());
                parseDatesInContactsLists(contacts.getTech());
            }
        }

        return response;
    }

    private static void parseDatesInContactsLists(List<Owner> contacts) {
        if (contacts != null && !contacts.isEmpty()) {
            contacts.forEach(contact -> {
                contact.setChanged(DateUtils.convertDate(
                        contact.getChanged(),
                        Constants.DATE_TIME_PATTERN,
                        Constants.DATE_PATTERN));
                contact.setCreated(DateUtils.convertDate(
                        contact.getCreated(),
                        Constants.DATE_TIME_PATTERN,
                        Constants.DATE_PATTERN));
            });
        }
    }

}
