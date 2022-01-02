package org.example.lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SearchKeyTest extends AbstractTest{

    @Test
    @Epic("Поиск")
    @Description ("Поиск по ключевому слову")
  void searchKey () {
        new SearchKey(getWebDriver()).inputSearch("фото");
        Assertions.assertTrue(webDriver.findElement(By.id("input-search-key")).getAttribute("value").equals("фото"));
    }
}
