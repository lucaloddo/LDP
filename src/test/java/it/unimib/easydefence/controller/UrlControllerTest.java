package it.unimib.easydefence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.virustotal.response.FileResponse;
import it.unimib.easydefence.service.UrlServiceImpl;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static it.unimib.easydefence.utils.TestUtils.TEST_DOMAIN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class UrlControllerTest {

    @InjectMocks
    UrlController urlController;

    @Mock
    UrlServiceImpl urlService;

    @Mock
    Model model;

    private static FileResponse fileResponse;

    @BeforeEach
    void beforeEach() {
        urlController.setMock(Boolean.FALSE);
        urlController.setObjectMapper(new ObjectMapper());
        fileResponse = TestUtils.buildFileResponse();
    }

    @Test
    void testShowUploadPage() {
        assertEquals("url", urlController.showUploadPage());
    }

    @Test
    void testGetReputation() throws JsonProcessingException {
        when(urlService.reputationDominio(TEST_DOMAIN)).thenReturn(fileResponse);

        assertEquals("urlInfo", urlController.getReputation(model, TEST_DOMAIN));
    }

    @Test
    void testGetReputationMockTrue() throws JsonProcessingException {
        urlController.setMock(Boolean.TRUE);

        assertEquals("urlInfo", urlController.getReputation(model, TEST_DOMAIN));
    }

    @Test
    void testGetReputationDomainNull() {
        assertThrows(BadRequestException.class, () -> urlController.getReputation(model, null));
    }

    @Test
    void testGetReputationDataRespNull() throws JsonProcessingException {
        when(urlService.reputationDominio(TEST_DOMAIN)).thenReturn(null);

        assertThrows(NotFoundException.class, () -> urlController.getReputation(model, TEST_DOMAIN));
    }
}