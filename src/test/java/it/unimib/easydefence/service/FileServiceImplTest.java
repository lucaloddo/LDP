package it.unimib.easydefence.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.client.RapidHashClient;
import it.unimib.easydefence.client.VirusTotalClient;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.InternalServerErrorException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.rapidapihash.response.RapidApiHash;
import it.unimib.easydefence.model.virustotal.response.FileResponse;
import it.unimib.easydefence.model.virustotalmitre.response.Mitre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.nio.file.Files;

import static it.unimib.easydefence.utils.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class FileServiceImplTest {

    @InjectMocks
    FileServiceImpl fileService;
    @Mock
    VirusTotalClient virusTotalClient;
    @Mock
    RapidHashClient rapidHashClient;

    @Value("classpath:static/eicar_com.zip")
    Resource testFile;

    private FileResponse fileResponse;
    private RapidApiHash rapidApiHash;
    private Mitre mitreZenboxLinux;
    private MockMultipartFile file;

    private byte[] getBytes() throws IOException {
        return Files.readAllBytes(testFile.getFile().toPath());
    }

    @BeforeEach
    void beforeEach() throws IOException {
        fileService.setObjectMapper(new ObjectMapper());
        fileResponse = buildFileResponse();
        rapidApiHash = buildRapidApiHashResponse();
        mitreZenboxLinux = buildMitreZenboxLinux();
        file = buildMultipartZipFile(getBytes());
    }

    @Test
    void testGetReport() throws Exception {
        when(virusTotalClient.report(any(), any())).thenReturn(fileResponse);

        FileResponse report = fileService.getReport(TEST_HASH_FILE_STRING);

        assertNotNull(report);
    }

    @Test
    void testGetReportHashFileNull() {
        assertThrows(BadRequestException.class, () -> fileService.getReport(null));
    }

    @Test
    void testGetReportInternalServerError() {
        Mockito.when(virusTotalClient.report(any(), any())).thenThrow(InternalServerErrorException.class);

        assertThrows(InternalServerErrorException.class, () -> fileService.getReport(TEST_HASH_FILE_STRING));
    }

    @Test
    void testGetDetectResponseNull() {
        when(virusTotalClient.report(any(), any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> fileService.getReport(TEST_HASH_FILE_STRING));
    }

    @Test
    void testGetHash() throws Exception {
        when(rapidHashClient.createHash(any(), any(), any(), any())).thenReturn(rapidApiHash);

        RapidApiHash hash = fileService.getHash(file);

        assertNotNull(hash);
    }

    @Test
    void testGetHashFileNull() {
        assertThrows(BadRequestException.class, () -> fileService.getHash(null));
    }

    @Test
    void testGetHashInternalServerError() {
        Mockito.when(rapidHashClient.createHash(any(), any(), any(), any())).thenThrow(InternalServerErrorException.class);

        assertThrows(InternalServerErrorException.class, () -> fileService.getHash(file));
    }

    @Test
    void testGetHashResponseNull() {
        when(rapidHashClient.createHash(any(), any(), any(), any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> fileService.getHash(file));
    }

    @Test
    void testGetMitreAttack() throws Exception {
        when(virusTotalClient.mitreAttack(any(), any())).thenReturn(mitreZenboxLinux);

        Mitre mitreAttack = fileService.getMitreAttack(TEST_HASH_FILE_STRING);

        assertNotNull(mitreAttack);
    }

    @Test
    void testGetMitreAttackNull() {
        assertThrows(BadRequestException.class, () -> fileService.getMitreAttack(null));
    }

    @Test
    void testGetMitreAttackInternalServerError() {
        Mockito.when(virusTotalClient.mitreAttack(any(), any())).thenThrow(InternalServerErrorException.class);

        assertThrows(InternalServerErrorException.class, () -> fileService.getMitreAttack(TEST_HASH_FILE_STRING));
    }

    @Test
    void testGetMitreAttackResponseNull() {
        when(virusTotalClient.mitreAttack(any(), any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> fileService.getMitreAttack(TEST_HASH_FILE_STRING));
    }

}