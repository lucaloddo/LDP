package it.unimib.easydefence.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;

import java.io.File;

@TestPropertySource("classpath:application.yaml")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumConfig {

    protected static WebDriver driver;

    // CHANGE THE VALUE OF THIS PROPERTY BASED ON THE OS YOU ARE USING
    @Value("${selenium.url}")
    public String appUrl;

    @Value("${selenium.chromedriver}")
    private String chromeDriverPath;

    @BeforeAll
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        String userDir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", userDir + File.separator + "chromedriver" + File.separator + chromeDriverPath);
        driver = new ChromeDriver(options);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
