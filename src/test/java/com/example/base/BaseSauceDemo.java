package com.example.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseSauceDemo {

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
        Configuration.reportsFolder = "target/screenshots";
    }

    @BeforeMethod
    public void setUp() {
        open("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                Selenide.screenshot(result.getName() + "_failure");
                takeScreenshotForAllure();
            }
        } catch (Exception e) {
            System.out.println("Ошибка при создании скриншота: " + e.getMessage());
        } finally {
            if (WebDriverRunner.hasWebDriverStarted()) {
                closeWebDriver();
            }
        }
    }

    @Attachment(value = "Скриншот при падении теста", type = "image/png")
    public byte[] takeScreenshotForAllure() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            try {
                return ((TakesScreenshot) WebDriverRunner.getWebDriver())
                        .getScreenshotAs(OutputType.BYTES);
            } catch (Exception e) {
                System.out.println("Не удалось сделать скриншот для Allure: " + e.getMessage());
            }
        }
        return new byte[0];
    }
}