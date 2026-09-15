package org.example.automation.utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for Page Object models in the automation framework.
 * Provides common WebDriver utilities and initialization for page objects.
 */
public class BasePage {
    /**
     * The Android driver instance used for interacting with mobile elements.
     */
    protected AndroidDriver driver;
    /**
     * The WebDriverWait instance used to wait for element conditions.
     */
    protected WebDriverWait wait;

    /**
     * Constructs a new BasePage with the specified Android driver.
     * Initializes the wait time and page factory for element detection.
     *
     * @param driver the AndroidDriver instance
     */
    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }
}
