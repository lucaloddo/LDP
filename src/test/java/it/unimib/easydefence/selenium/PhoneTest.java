package it.unimib.easydefence.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PhoneTest extends SeleniumConfig {
    @Value("${selenium.phonePage}")
    private String phone;

    @Test
    void testValidatePhone() {
        System.out.println("PHONE PAGE: validate phone number");
        driver.get(appUrl + phone);
        WebElement phonePrefix = driver.findElement(By.id("prefix"));
        WebElement phoneNumber = driver.findElement(By.id("number"));
        WebElement requestVerify = driver.findElement(By.id("phoneSubmit"));
        phonePrefix.sendKeys("+39");
        phoneNumber.sendKeys("3421268257");
        requestVerify.click();

        WebElement validate = driver.findElement(By.id("valido"));
        String actualValue = validate.getAttribute("value");
        WebElement rating = driver.findElement(By.id("ratingValue"));
        String ratingString = rating.getAttribute("value");

        String expectedValue = "true";
        assertEquals(expectedValue, actualValue);
        assertEquals("possible", ratingString);
    }

    @Test
    void testPhoneUrl() {
        System.out.println("PHONE PAGE:test url");
        driver.get(appUrl + phone);
        WebElement phonePrefix = driver.findElement(By.id("prefix"));
        WebElement phoneNumber = driver.findElement(By.id("number"));
        WebElement requestVerify = driver.findElement(By.id("phoneSubmit"));

        phonePrefix.sendKeys("+39");
        phoneNumber.sendKeys("3421268257");
        requestVerify.click();
        String actualUrl = "http://localhost:8080/phone/phoneCheck?prefix=%2B39&number=3421268257";
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

}
