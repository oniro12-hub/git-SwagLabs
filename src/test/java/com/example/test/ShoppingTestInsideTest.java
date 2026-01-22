package com.example.test;
import com.example.base.BaseSauceDemo;
import com.example.saucedemo.LoginSteps;
import com.example.saucedemo.SwagLabsPageSteps;
import io.qameta.allure.Link;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.sleep;

public class ShoppingTestInsideTest extends BaseSauceDemo {

    String userName = "standard_user";
    String password = "secret_sauce";
    String productName = "Sauce Labs Backpack";
    LoginSteps loginSteps = new LoginSteps();
    SwagLabsPageSteps swagLabsPageSteps = new SwagLabsPageSteps();

    @Tag("Test-005")
    @Link("https://www.saucedemo.com/")
    @Test(description = "Проверка добавления товара в корзину из внутренней карточки товара")
    void shoppingTestInside() {
        loginSteps
                .avtorizationSwag(userName, password);
        swagLabsPageSteps
                //.clickOk()
                .shoppingCartPlus(productName);
        sleep(2000);
    }
}
