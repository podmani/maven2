package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchKey extends AbstractPage{

    @FindBy(id = "input-search-key")
    private WebElement search;

    public SearchKey(WebDriver driver) {
        super(driver);
    }

    public SearchKey inputSearch (String keyWord) {
        Actions input = new Actions(getDriver());
        input.moveToElement(this.search);
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(this.search));
        input.click(this.search).sendKeys(this.search).click().build().perform();
        return this;
    }



}


