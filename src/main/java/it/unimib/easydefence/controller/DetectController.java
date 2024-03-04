package it.unimib.easydefence.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.mapper.DetectMapper;
import it.unimib.easydefence.model.dto.DeviceDTO;
import it.unimib.easydefence.model.nist.response.CveResponse;
import it.unimib.easydefence.model.userstack.response.DetectResponse;
import it.unimib.easydefence.service.DetectServiceImpl;
import it.unimib.easydefence.service.VulnerabilitiesServiceImpl;
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
@RequestMapping("/detect")
public class DetectController {

    private final DetectServiceImpl detectService;
    private final VulnerabilitiesServiceImpl vulnerabilitiesService;
    private ObjectMapper objectMapper;
    @Value("${mock.detect}")
    private Boolean mock;

    @Autowired
    public DetectController(
            DetectServiceImpl detectService,
            VulnerabilitiesServiceImpl vulnerabilitiesService,
            ObjectMapper objectMapper
    ) {
        this.vulnerabilitiesService = vulnerabilitiesService;
        this.detectService = detectService;
        this.objectMapper = objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void setMock(Boolean mock) {
        this.mock = mock;
    }

    private static final Logger LOG = LoggerFactory.getLogger(DetectController.class);

    @GetMapping("/device")
    public String detectDevice(
            Model model,
            @RequestParam("idUa") String idUa
    ) throws Exception {
        LOG.info("DetectController: detectDevice START");
        DeviceDTO deviceDTO;
        if (Boolean.TRUE.equals(mock)) {
            LOG.info("DetectController: service mocked");
            deviceDTO = Mock.buildDeviceDTO();
        } else {
            checkInputParameters(idUa);


            DetectResponse detectResponse = detectService.getDetect(idUa);

            if (detectResponse.getOs() == null || detectResponse.getOs().getName() == null
                    || detectResponse.getOs().getName().isEmpty()) {
                LOG.error("ERROR: os is empty or null");
                throw new NotFoundException("ERROR: os is empty or null");
            }

            CveResponse cveResponse = vulnerabilitiesService.getVulnerabilities(detectResponse.getOs().getName());
            if (cveResponse.getVulnerabilities() == null) {
                LOG.error("ERROR: vulnerability list is null");
                throw new NotFoundException("ERROR: vulnerability list is null");
            }

            deviceDTO = DetectMapper.toDeviceDTO(detectResponse, cveResponse.getVulnerabilities());
        }

        String msg = objectMapper.writer().writeValueAsString(deviceDTO);
        LOG.info("{}", msg);

        model.addAttribute("deviceDTO", deviceDTO);

        LOG.info("DetectController: detectDevice COMPLETED");
        return "index";
    }

    private void checkInputParameters(String idUa) {
        if (idUa == null || idUa.isEmpty()) {
            LOG.error("ERROR: userAgent is empty or null");
            throw new BadRequestException("ERROR: userAgent is empty or null");
        }
    }

}
