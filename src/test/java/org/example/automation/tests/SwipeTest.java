package org.example.automation.tests;

import org.example.automation.pages.SwipePage;
import org.example.automation.utils.BaseTest;
import org.example.automation.utils.DriverManager;
import org.example.automation.utils.GestureUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    @Test
    public void shouldSwipeCardsAndFindHiddenCard() {
        SwipePage swipePage = new SwipePage(DriverManager.getDriver());
        GestureUtils gestureUtils = new GestureUtils(DriverManager.getDriver());

        gestureUtils.swipeLeftOnElement(swipePage.carousel);
        Assert.assertTrue(swipePage.carousel.isDisplayed(), "Cards should remain visible after swipe");

        gestureUtils.swipeLeftOnElement(swipePage.carousel);
        swipePage.hiddenText.isDisplayed();
        Assert.assertTrue(swipePage.hiddenText.isDisplayed(), "Expected hidden text to appear after swipe");
    }
}
