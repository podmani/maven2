package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginWindowTest extends AbstractTest{

    @Test
void loginWindow () {
        new Login(getWebDriver()).inputInWindowAccount();
    new WindowAccount(getWebDriver()).inputLogin("maxim@f1.nnov.ru");
            Assertions.assertTrue(webDriver.findElement(By.name("USER_LOGIN"))
                    .getAttribute("value").equals("maxim@f1.nnov.ru"));
}
}
