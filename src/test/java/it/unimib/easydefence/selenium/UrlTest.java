package it.unimib.easydefence.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UrlTest extends SeleniumConfig {

    @Value("${selenium.urlPage}")
    private String url;

    @Test
    void testURLUrl() {
        System.out.println("URL PAGE:test url");
        driver.get(appUrl + url);
        WebElement dominio = driver.findElement(By.id("dominio"));
        WebElement send = driver.findElement(By.id("richiedi"));

        dominio.sendKeys("www.ftaitalia.it");
        send.click();
        String actualUrl = "http://localhost:8080/url/urlReputation?dominio=www.ftaitalia.it";
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    void testUrlValue() {
        System.out.println("URL PAGE:test url value");
        driver.get(appUrl + url);
        WebElement dominio = driver.findElement(By.id("dominio"));
        WebElement send = driver.findElement(By.id("richiedi"));

        dominio.sendKeys("www.apple.com");
        send.click();
        String actualUrl = "";

        WebElement malicious = driver.findElement(By.id("malicious-level"));
        WebElement harmless = driver.findElement(By.id("harmless-level"));
        String maliciousValue = malicious.getAttribute("value");
        String harmlessValue = harmless.getAttribute("value");
        assertEquals(maliciousValue, harmlessValue);
    }

}
