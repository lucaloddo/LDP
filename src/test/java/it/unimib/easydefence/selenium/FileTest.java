package it.unimib.easydefence.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FileTest extends SeleniumConfig {
    @Value("${selenium.filePage}")
    private String file;

    @Test
    void testFileValue() {
        System.out.println("FILE PAGE:test file value");
        driver.get(appUrl + file);

        File uploadFile = new File("./src/main/resources/test/eicar_com.zip");
        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(By.id("richiedi")).click();

        WebElement malicious = driver.findElement(By.id("malicious-level"));
        WebElement harmless = driver.findElement(By.id("harmless-level"));
        String maliciousValue = malicious.getAttribute("value");
        String harmlessValue = harmless.getAttribute("value");
        assertEquals(maliciousValue, harmlessValue);
    }

}
