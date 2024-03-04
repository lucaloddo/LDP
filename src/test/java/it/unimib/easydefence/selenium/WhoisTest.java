package it.unimib.easydefence.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WhoisTest extends SeleniumConfig {

    @Value("${selenium.domainPage}")
    private String domain;

    @Test
    void testWhoisUrl() {
        System.out.println("WHOIS PAGE:test url");
        driver.get(appUrl + domain);
        WebElement dominio = driver.findElement(By.id("dominio"));
        WebElement send = driver.findElement(By.id("richiedi"));

        dominio.sendKeys("www.ftaitalia.it");
        send.click();
        String actualUrl = "http://localhost:8080/domain/getWhois?dominio=www.ftaitalia.it";
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    void testWhoisValue() {
        System.out.println("WHOIS PAGE:test whois value");
        driver.get(appUrl + domain);
        WebElement dominio = driver.findElement(By.id("dominio"));
        WebElement send = driver.findElement(By.id("richiedi"));

        dominio.sendKeys("www.ftaitalia.it");
        send.click();

        WebElement server = driver.findElement(By.id("serverName"));
        WebElement registrar = driver.findElement(By.id("registrarName"));
        WebElement create = driver.findElement(By.id("created"));
        String serverAttribute = server.getAttribute("value");
        String registrarAttribute = registrar.getAttribute("value");
        String createAttribute = create.getAttribute("value");
        //assertEquals(serverAttribute, "Zeta");
        assertEquals(registrarAttribute, "Aruba s.p.a.");
        assertEquals(createAttribute, "19/10/2020");
    }

}
