package it.unimib.easydefence.integrationtests.controller;

import it.unimib.easydefence.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FileControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Value("classpath:static/eicar_com.zip")
    Resource testFile;

    private static MockMultipartFile mockMultipartZipFile;
    private static MockMultipartFile mockMultipartTextFile;

    @BeforeEach
    void beforeEach() throws IOException {
        mockMultipartZipFile = TestUtils.buildMultipartZipFile(Files.readAllBytes(testFile.getFile().toPath()));
        mockMultipartTextFile = TestUtils.buildMultipartTextFile();
    }

    @Test
    void whenShowUploadPage_thenFileUploader() throws Exception {
        mockMvc.perform(get("/file"))
                .andExpect(status().isOk());
    }

    // temporary unavailable
    /*@Test
    void givenFile_whenGetFilePage_thenFile() throws Exception {
        mockMvc.perform(multipart("/file/fileUploader")
                        .file(mockMultipartZipFile))
                .andExpect(status().isOk());
    }*/

    @Test
    void givenNullFile_whenGetFilePage_thenBadRequestException() throws Exception {
        mockMvc.perform(multipart("/file/fileUploader"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void givenInvalidFile_whenGetFilePage_thenNotFoundException() throws Exception {
        mockMvc.perform(multipart("/file/fileUploader")
                        .file(mockMultipartTextFile))
                .andExpect(status().isNotFound());
    }

}