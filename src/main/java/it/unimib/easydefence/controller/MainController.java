package it.unimib.easydefence.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String homeBeforeDetect() {
        LOG.info("MainController: homeBeforeDetect START");
        LOG.info("MainController: homeBeforeDetect COMPLETED");
        return "homeBeforeDetect";
    }

}
