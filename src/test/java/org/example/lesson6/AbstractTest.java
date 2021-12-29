package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class AbstractTest {

    static WebDriver webDriver;

    @BeforeAll
    static void setDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach

    void initMainPage() {
        Assertions.assertDoesNotThrow(() -> webDriver.navigate().to("https://www.fotosklad.ru/catalog/sale/"),
                "Страница не доступна");
    }

    @AfterAll
    static void exit() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() { return this.webDriver; }
}
