package it.unimib.easydefence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unimib.easydefence.exception.BadRequestException;
import it.unimib.easydefence.exception.NotFoundException;
import it.unimib.easydefence.model.rapidapihash.response.RapidApiHash;
import it.unimib.easydefence.model.virustotal.response.FileResponse;
import it.unimib.easydefence.model.virustotalmitre.response.Mitre;
import it.unimib.easydefence.service.FileServiceImpl;
import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.ui.Model;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class FileControllerTest {

    @InjectMocks
    FileController fileController;

    @Mock
    FileServiceImpl fileService;

    @Mock
    Model model;

    @Value("classpath:static/eicar_com.zip")
    Resource testFile;

    private static MockMultipartFile file;
    private static RapidApiHash rapidApiHash;
    private static FileResponse fileResponse;
    private static Mitre mitreZenboxLinux;
    private static Mitre mitreZenbox;

    private byte[] getBytes() throws IOException {
        return Files.readAllBytes(testFile.getFile().toPath());
    }

    @BeforeEach
    void beforeEach() throws IOException {
        fileController.setMock(Boolean.FALSE);
        fileController.setObjectMapper(new ObjectMapper());
        file = TestUtils.buildMultipartZipFile(getBytes());
        rapidApiHash = TestUtils.buildRapidApiHashResponse();
        fileResponse = TestUtils.buildFileResponse();
        mitreZenboxLinux = TestUtils.buildMitreZenboxLinux();
        mitreZenbox = TestUtils.buildMitreZenbox();
    }

    @Test
    void testShowUploadPage() {
        assertEquals("fileUploader", fileController.showUploadPage());
    }

    @Test
    void testGetFilePage() throws Exception {
        when(fileService.getHash(any())).thenReturn(rapidApiHash);
        when(fileService.getReport(any())).thenReturn(fileResponse);
        when(fileService.getMitreAttack(any())).thenReturn(mitreZenboxLinux);

        assertEquals("file", fileController.getFilePage(model, file));
    }

    @Test
    void testGetFilePageMockTrue() throws Exception {
        fileController.setMock(Boolean.TRUE);

        assertEquals("file", fileController.getFilePage(model, file));
    }

    @Test
    void testGetFilePageFileNull() {
        assertThrows(BadRequestException.class, () -> fileController.getFilePage(model, null));
    }

    @Test
    void testGetFilePageResponseHashNull() throws JsonProcessingException {
        when(fileService.getHash(any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> fileController.getFilePage(model, file));
    }

    @Test
    void testGetFilePageResponseHashHashHexStringNull() throws Exception {
        rapidApiHash.setHashHexString(null);
        when(fileService.getHash(any())).thenReturn(rapidApiHash);

        assertThrows(NotFoundException.class, () -> fileController.getFilePage(model, file));
    }

    @Test
    void testGetFilePageDataRespNull() throws Exception {
        when(fileService.getHash(any())).thenReturn(rapidApiHash);
        when(fileService.getReport(any())).thenReturn(null);

        assertEquals("file", fileController.getFilePage(model, file));
    }

    @Test
    void testGetFilePageDataMitreResponseNull() throws Exception {
        when(fileService.getHash(any())).thenReturn(rapidApiHash);
        when(fileService.getReport(any())).thenReturn(fileResponse);
        when(fileService.getMitreAttack(any())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> fileController.getFilePage(model, file));
    }

    @Test
    void testGetFilePageMitreZenboxNull() throws Exception {
        mitreZenboxLinux.getData().setZenbox(null);
        when(fileService.getHash(any())).thenReturn(rapidApiHash);
        when(fileService.getReport(any())).thenReturn(fileResponse);
        when(fileService.getMitreAttack(any())).thenReturn(mitreZenboxLinux);

        assertEquals("file", fileController.getFilePage(model, file));
    }

    @Test
    void testGetFilePageMitreZenboxLinuxNull() throws Exception {
        mitreZenbox.getData().setZenboxLinux(null);
        when(fileService.getHash(any())).thenReturn(rapidApiHash);
        when(fileService.getReport(any())).thenReturn(fileResponse);
        when(fileService.getMitreAttack(any())).thenReturn(mitreZenbox);

        assertEquals("file", fileController.getFilePage(model, file));
    }

    @Test
    void testGetFilePageMitreZenboxLinuxNullZenboxNull() throws Exception {
        mitreZenbox.getData().setZenboxLinux(null);
        mitreZenbox.getData().setZenbox(null);
        when(fileService.getHash(any())).thenReturn(rapidApiHash);
        when(fileService.getReport(any())).thenReturn(fileResponse);
        when(fileService.getMitreAttack(any())).thenReturn(mitreZenbox);

        assertEquals("file", fileController.getFilePage(model, file));
    }

    @Test
    void testGetFilePageFileTacticsNullOrEmpty() throws Exception {
        mitreZenboxLinux.getData().getZenboxLinux().getTactics().set(0, null);

        when(fileService.getHash(any())).thenReturn(rapidApiHash);
        when(fileService.getReport(any())).thenReturn(fileResponse);
        when(fileService.getMitreAttack(any())).thenReturn(mitreZenboxLinux);

        assertThrows(NotFoundException.class, () -> fileController.getFilePage(model, file));
    }

    @Test
    void testGetFilePageFileTechniquesNullOrEmpty() throws Exception {
        mitreZenboxLinux.getData().getZenboxLinux().getTactics().get(0).getTechniques().set(0, null);

        when(fileService.getHash(any())).thenReturn(rapidApiHash);
        when(fileService.getReport(any())).thenReturn(fileResponse);
        when(fileService.getMitreAttack(any())).thenReturn(mitreZenboxLinux);

        assertThrows(NotFoundException.class, () -> fileController.getFilePage(model, file));
    }

}