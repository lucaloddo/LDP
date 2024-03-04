package it.unimib.easydefence.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PasswordTest extends SeleniumConfig {
    @Value("${selenium.passwordPage}")
    private String password;

    @Test
    void testPasswordUrl() {
        System.out.println("PASSWORD PAGE:test url");
        driver.get(appUrl + password);

        WebElement requestPassword = driver.findElement(By.id("richiedi"));
        WebElement button = driver.findElement(By.id("addTen"));
        WebElement buttonNumbers = driver.findElement(By.id("isNumbers"));
        WebElement buttonSymbols = driver.findElement(By.id("isSymbols"));

        button.click(); //valore=2
        button.click(); //valore=3

        buttonNumbers.click();
        buttonSymbols.click();

        requestPassword.click();

        String actualUrl = "http://localhost:8080/password/generator?length=3&isNumbers=false&isSymbols=false";
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    void testCheckLengthPassword() {
        System.out.println("PASSWORD PAGE:test length password");
        driver.get(appUrl + password);

        driver.get(appUrl + password);
        WebElement passwordLength = driver.findElement(By.id("length"));
        WebElement button = driver.findElement(By.id("addTen"));
        button.click(); //valore=2
        button.click(); //valore=3

        WebElement requestPassword = driver.findElement(By.id("richiedi"));
        requestPassword.click();
        WebElement passwordOutput = driver.findElement(By.id("textToCopy"));
        String actualValues = passwordOutput.getAttribute("value");
        Integer expectedValue = 3;
        assertEquals(expectedValue, actualValues.replaceAll("\\s+", "").length()); //per rimuovere spazi bianchi a fine riga
    }

    @Test
    void testCheckNumbersPassword() {
        Boolean numbers = null;
        System.out.println("PASSWORD PAGE:test numbers password");
        driver.get(appUrl + password);

        WebElement passwordLength = driver.findElement(By.id("length"));
        WebElement button = driver.findElement(By.id("addTen"));
        WebElement buttonNumbers = driver.findElement(By.id("isNumbers"));
        button.click(); //valore=2
        button.click(); //valore=3
        button.click(); //valore=4
        button.click(); //valore=5
        button.click(); //valore=6
        button.click(); //valore=7
        button.click(); //valore=8
        button.click(); //valore=9
        button.click(); //valore=10
        buttonNumbers.click();

        WebElement requestPassword = driver.findElement(By.id("richiedi"));
        requestPassword.click();
        WebElement passwordOutput = driver.findElement(By.id("textToCopy"));
        String actualValues = passwordOutput.getAttribute("value");

        if (Pattern.compile("[0-9]").matcher(actualValues).find())
            numbers = true;
        else
            numbers = false;
        assertTrue(numbers, "La variabile contiene i numeri.");
    }

}
