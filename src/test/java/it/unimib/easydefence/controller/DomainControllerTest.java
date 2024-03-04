package it.unimib.easydefence.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.rapidapiwhois.Response;
import it.unimib.easydefence.service.WhoisServiceImpl;
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
class DomainControllerTest {

    @InjectMocks
    DomainController domainController;

    @Mock
    WhoisServiceImpl whoisService;

    @Mock
    Model model;

    private static Response value;

    @BeforeEach
    void beforeEach() {
        domainController.setMock(Boolean.FALSE);
        domainController.setObjectMapper(new ObjectMapper());
        value = TestUtils.buildWhoisDomainResponse();
    }

    @Test
    void testShowInitialPage() {
        assertEquals("domain", domainController.showInitialPage());
    }

    @Test
    void testGetDomain() throws Exception {
        when(whoisService.getWhois(TestUtils.TEST_DOMAIN)).thenReturn(value);

        assertEquals("domainInfo", domainController.getDomain(model, TEST_DOMAIN));
    }

    @Test
    void testGetDomainMockTrue() throws Exception {
        domainController.setMock(Boolean.TRUE);

        assertEquals("domainInfo", domainController.getDomain(model, TEST_DOMAIN));
    }

    @Test
    void testGetDomainDomainNull() {
        assertThrows(BadRequestException.class, () -> domainController.getDomain(model, null));
    }

    @Test
    void testGetDomainNotFound() throws Exception {
        when(whoisService.getWhois(TestUtils.TEST_DOMAIN)).thenReturn(null);

        assertThrows(NotFoundException.class, () -> domainController.getDomain(model, TEST_DOMAIN));
    }
}