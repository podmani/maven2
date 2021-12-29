package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * Unit test for simple App.
 */
public class AppTest


{

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
        Assertions.assertDoesNotThrow( ()-> webDriver.navigate().to("https://www.fotosklad.ru/catalog/sale/"),
                "Страница не доступна");
    }



    @Test
    void TestSearchKey() {

        WebElement webElement = webDriver.findElement(By.id("input-search-key"));
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webElement));


        webElement.click();

        Actions actions = new Actions(webDriver);
        actions.sendKeys(webDriver.findElement(By.id("input-search-key")),"фото").click().build().perform();
        System.out.println(webDriver.findElement(By.id("input-search-key")).getAttribute("value"));
        Assertions.assertTrue(webDriver.findElement(By.id("input-search-key")).getAttribute("value").equals("фото"));


}

    @Test

    void TestPositiveLogin() {
        

    WebElement webElement = webDriver.findElement(By.cssSelector(".box_catalog_prof > span"));
    Actions actions = new Actions(webDriver);
    actions.moveToElement(webDriver.findElement(By.cssSelector(".box_catalog_prof > span")));
    new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webElement));


    webDriver.findElement(By.id("login_menu"));
    actions.click(webDriver.findElement(By.id("login_menu"))).build().perform();

    actions.click(webDriver.findElement(By.cssSelector(".fancybox-overlay")))
            .sendKeys(webDriver.findElement(By.name("USER_LOGIN")),"maxim@f1.nnov.ru")
            .sendKeys(webDriver.findElement(By.name("USER_PASSWORD")),"856506").build().perform();

    actions.click(webDriver.findElement(By.name("Login"))).build().perform();

    Assertions.assertTrue(webDriver.findElement(By.name("USER_LOGIN")).getAttribute("value").equals("maxim@f1.nnov.ru"));
       /* webDriver.findElement(By.cssSelector(".box_catalog_prof > p"));
        Actions actions2 = new Actions(webDriver);
        actions.moveToElement(webElement);
       new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webElement));
       webDriver.findElement(By.id("autorization"));
        webDriver.findElement(By.linkText("[выйти]"));
       actions2.click(webDriver.findElement(By.linkText("[выйти]"))).build().perform();*/

    }

    @Test

    void TestNegativeLogin() {


        WebElement webElement = webDriver.findElement(By.cssSelector(".box_catalog_prof > span"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement);
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(webElement));


        webDriver.findElement(By.id("login_menu"));
        actions.click(webDriver.findElement(By.id("login_menu"))).build().perform();

        actions.click(webDriver.findElement(By.cssSelector(".fancybox-overlay")))
                .sendKeys(webDriver.findElement(By.name("USER_LOGIN")),"maxim@f1.nn.ru")
                .sendKeys(webDriver.findElement(By.name("USER_PASSWORD")),"856506").build().perform();

        actions.click(webDriver.findElement(By.name("Login"))).build().perform();
        //System.out.println(webDriver.findElement(By.name("USER_LOGIN")).getAttribute("value"));
        Assertions.assertFalse(webDriver.findElement(By.name("USER_LOGIN")).getAttribute("value").equals("maxim@f1.nnov.ru"));



    }
    @AfterAll
    static void exit() {
    webDriver.quit();
    }
}
