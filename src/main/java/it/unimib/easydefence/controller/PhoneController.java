package it.unimib.easydefence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.mapper.PhoneMapper;
import it.unimib.easydefence.model.dto.PhoneDTO;
import it.unimib.easydefence.model.ninja.response.PhoneResponse;
import it.unimib.easydefence.model.rapidapi.response.RapidApi;
import it.unimib.easydefence.service.PhoneServiceImpl;
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

@Controller
@RequestMapping("/phone")
public class PhoneController {
    private final PhoneServiceImpl phoneService;
    private ObjectMapper objectMapper;
    @Value("${mock.phone}")
    private Boolean mock;

    @Autowired
    public PhoneController(
            PhoneServiceImpl phoneService,
            ObjectMapper objectMapper
    ) {
        this.phoneService = phoneService;
        this.objectMapper = objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void setMock(Boolean mock) {
        this.mock = mock;
    }

    private static final Logger LOG = LoggerFactory.getLogger(PhoneController.class);

    @GetMapping("")
    public String getPhonePage() {
        LOG.info("PhoneController: getPhonePage START");
        LOG.info("PhoneController: getPhonePage COMPLETED");
        return "phoneCheck";
    }

    @GetMapping("/phoneCheck")
    public String getPhone(
            Model model,
            @RequestParam("number") String number,
            @RequestParam("prefix") String prefix
    ) throws JsonProcessingException {
        LOG.info("PhoneController: getPhone START");

        PhoneDTO phoneDTO;

        if (Boolean.TRUE.equals(mock)) {
            LOG.info("PhoneController: service mocked");
            phoneDTO = Mock.buildPhoneDTO();
        } else {
            checkInputParameters(number, prefix);

            number = prefix.concat(number);

            PhoneResponse phoneResponse = phoneService.getPhone(number);

            if (phoneResponse == null) {
                LOG.error("ERROR: phoneResponse is empty or null");
                throw new NotFoundException("ERROR: phoneResponse is empty or null");
            }

            RapidApi rapidApi = phoneService.getValidationNumber(number);

            if (rapidApi == null) {
                LOG.error("ERROR: rapidApi is empty or null");
                throw new NotFoundException("ERROR: rapidApi is empty or null");
            }

            phoneDTO = PhoneMapper.toPhoneDTO(phoneResponse, rapidApi);

            if (phoneDTO == null || phoneDTO.getRiskLevel() == null || phoneDTO.getRiskRating() == null) {
                LOG.error("ERROR: wrong creation of phoneDTO");
                throw new NotFoundException("ERROR: wrong creation of phoneDTO");
            }
        }

        String msg = objectMapper.writer().writeValueAsString(phoneDTO);
        LOG.info("{}", msg);
        model.addAttribute("phoneDTO", phoneDTO);

        LOG.info("PhoneController: getPhone COMPLETED");
        return "phone";
    }

    private void checkInputParameters(String number, String prefix) {
        if (number == null) {
            LOG.error("ERROR: number is null or empty");
            throw new BadRequestException("ERROR: number is null or empty");
        }
        if (prefix == null) {
            LOG.error("ERROR: prefix is null or empty");
            throw new BadRequestException("ERROR: prefix is null or empty");
        }
    }

}

