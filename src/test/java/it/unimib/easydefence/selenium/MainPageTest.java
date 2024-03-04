package it.unimib.easydefence.selenium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MainPageTest extends SeleniumConfig {

    @Test
    void testHomePageTitle() {
        System.out.println("In Home Page");
        driver.get(appUrl);
        assertEquals("ED - Device Checker", driver.getTitle());
    }

}
