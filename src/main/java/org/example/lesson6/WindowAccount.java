package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WindowAccount extends AbstractPage{

        @FindBy(css =".fancybox-overlay")
        private WebElement window;

        @FindBy (name = "USER_LOGIN")
        private WebElement userLogin;

        @FindBy (name = "USER_PASSWORD")
        private WebElement userPassword;

        @FindBy (name = "Login")
        private WebElement loginBtn;

        public WindowAccount (WebDriver driver) {
            super(driver);
        }

        //метод для ввода логина

        public WindowAccount inputLogin(String login) {
                Actions input = new Actions(getDriver());
                input.click(this.window).sendKeys(this.userLogin)
                        .sendKeys(this.userPassword).click(this.loginBtn).build().perform();
        return this;
        }



}

