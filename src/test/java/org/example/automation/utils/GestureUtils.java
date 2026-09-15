package org.example.automation.utils;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

/**
 * Utility class for performing gesture actions on mobile elements using Appium and Selenium.
 */
public class GestureUtils {
    /**
     * The Android driver instance used to perform gestures.
     */
    private final AndroidDriver driver;

    /**
     * Constructs a new GestureUtils with the specified Android driver.
     *
     * @param driver the Android driver instance
     */
    public GestureUtils(AndroidDriver driver) {
        this.driver = driver;
    }

    /**
     * Performs a horizontal swipe gesture from right to left on the specified mobile element.
     *
     * @param element the web element to perform the swipe action on
     */
    public void swipeLeftOnElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", com.google.common.collect.ImmutableMap.of(
                "elementId", ((org.openqa.selenium.remote.RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.95 // Arrastra el 95% del ancho total del carrusel
        ));
    }

    /**
     * Realiza un Scroll Vertical hacia abajo (arrastra de abajo hacia arriba).
     */
    public void scrollDown() {
        org.openqa.selenium.Dimension screenSize = driver.manage().window().getSize();

        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", com.google.common.collect.ImmutableMap.of(
                "left", 100,
                "top", (int) (screenSize.getHeight() * 0.20),
                "width", (int) (screenSize.getWidth() * 0.80),
                "height", (int) (screenSize.getHeight() * 0.60),
                "direction", "down", // 'down' desplaza el contenido hacia abajo
                "percent", 0.8
        ));
    }

    /**
     * Scrolls the screen until the element with the specified text is visible.
     *
     * @param text the text to scroll into view
     * @return the web element containing the specified text once found
     */
    public WebElement scrollToText(String text) {
        String scrollQuery = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text + "\"))";
        return driver.findElement(AppiumBy.androidUIAutomator(scrollQuery));
    }
}
