package it.unimib.easydefence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.service.PasswordServiceImpl;
import it.unimib.easydefence.utils.Constants;
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
@RequestMapping("/password")
public class PasswordController {

    private final PasswordServiceImpl passwordService;
    private ObjectMapper objectMapper;
    @Value("${mock.pwd}")
    private Boolean mock;

    @Autowired
    public PasswordController(
            PasswordServiceImpl passwordService,
            ObjectMapper objectMapper
    ) {
        this.passwordService = passwordService;
        this.objectMapper = objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void setMock(Boolean mock) {
        this.mock = mock;
    }

    private static final Logger LOG = LoggerFactory.getLogger(PasswordController.class);

    @GetMapping("")
    public String getPasswordPage() {
        LOG.info("PasswordController: getPasswordPage START");
        LOG.info("PasswordController: getPasswordPage COMPLETED");
        return "password";
    }

    @GetMapping("/generator")
    public String getRandomPassword(
            Model model,
            @RequestParam("length") Integer length,
            @RequestParam("isNumbers") Boolean excludeNumbers,
            @RequestParam("isSymbols") Boolean excludeSpecial
    ) throws JsonProcessingException {
        LOG.info("PasswordController: getRandomPassword START");

        String pwd;

        if (Boolean.TRUE.equals(mock)) {
            LOG.info("PasswordController: service mocked");
            pwd = Mock.buildPwd();
            excludeNumbers = Boolean.FALSE;
            excludeSpecial = Boolean.TRUE;
        } else {
            checkInputParameters(
                    length,
                    excludeNumbers,
                    excludeSpecial
            );

            pwd = passwordService.getPassword(length, excludeNumbers, excludeSpecial);

            if (pwd == null || pwd.isEmpty()) {
                LOG.error("ERROR: generated password is empty or null");
                throw new NotFoundException(pwd);
            }
        }

        String msg = objectMapper.writer().writeValueAsString(pwd);
        LOG.info("{}", msg);

        model.addAttribute("generatedPassword", pwd);
        model.addAttribute("excludeNumbers", excludeNumbers);
        model.addAttribute("excludeSpecial", excludeSpecial);

        LOG.info("PasswordController: getRandomPassword COMPLETED");
        return "password";
    }

    private void checkInputParameters(
            Integer length,
            Boolean excludeNumbers,
            Boolean excludeSpecial
    ) {
        if (length == null || length <= 0) {
            LOG.error(Constants.LENGTH_NULL_OR_LESS_THAN_OR_EQUAL_TO_ZERO);
            throw new BadRequestException(Constants.LENGTH_NULL_OR_LESS_THAN_OR_EQUAL_TO_ZERO);
        }
        if (excludeNumbers == null) {
            LOG.error(Constants.EXCLUDE_NUMBERS_NULL);
            throw new BadRequestException(Constants.EXCLUDE_NUMBERS_NULL);
        }
        if (excludeSpecial == null) {
            LOG.error(Constants.EXCLUDE_SPECIAL_NULL);
            throw new BadRequestException(Constants.EXCLUDE_SPECIAL_NULL);
        }
    }

}
