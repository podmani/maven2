package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends AbstractPage {

    @FindBy (css =".box_catalog_prof > span")
            private WebElement cabinet;

    @FindBy (id = "login_menu")
            private WebElement loginMenu;

    public Login(WebDriver driver) {
        super(driver);
    }

    public Login inputInWindowAccount () {
        Actions input = new Actions(getDriver());
        input.moveToElement(this.cabinet);
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(this.cabinet));
        input.click(this.loginMenu).build().perform();
        return this;
    }



}
