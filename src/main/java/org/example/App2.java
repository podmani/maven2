package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App2
{
    public static void main( String[] args )
    {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.fotosklad.ru/catalog/sale/");
        WebElement webElement = driver.findElement(By.cssSelector(".box_catalog_prof > span"));
        Actions builder = new Actions(driver);
        builder.moveToElement(webElement).perform();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));


        driver.findElement(By.id("login_menu")).click();
        driver.findElement(By.cssSelector(".fancybox-overlay")).click();
        driver.findElement(By.name("USER_LOGIN")).sendKeys("maxim@f1.nnov.ru");
        driver.findElement(By.name("USER_PASSWORD")).click();
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("856506");
        driver.findElement(By.name("Login")).click();




        driver.quit();

    }
}
