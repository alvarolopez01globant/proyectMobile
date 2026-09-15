package org.example.automation.utils;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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
        int startX = element.getRect().getX() + (int) (element.getRect().getWidth() * 0.8);
        int endX = element.getRect().getX() + (int) (element.getRect().getWidth() * 0.2);
        int centerY = element.getRect().getY() + (element.getRect().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, centerY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
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
