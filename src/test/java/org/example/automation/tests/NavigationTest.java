package org.example.automation.tests;

import org.example.automation.pages.NavigationBarPage;
import org.example.automation.utils.BaseTest;
import org.example.automation.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for verifying navigation through the bottom menu in the mobile application.
 * Contains tests for navigating between different screens using the navigation bar.
 */
public class NavigationTest extends BaseTest {

    /**
     * Tests navigation through the bottom menu options.
     * Verifies that each icon in the navigation bar is displayed when selected.
     */
    @Test
    public void shouldNavigateThroughBottomMenu() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(DriverManager.getDriver());

        navigationBarPage.homeIcon.click();
        Assert.assertTrue(navigationBarPage.homeIcon.isDisplayed(), "Home screen should be visible");

        navigationBarPage.loginIcon.click();
        Assert.assertTrue(navigationBarPage.loginIcon.isDisplayed(), "Login screen should be visible");

        navigationBarPage.formsIcon.click();
        Assert.assertTrue(navigationBarPage.formsIcon.isDisplayed(), "Forms screen should be visible");

        navigationBarPage.swipeIcon.click();
        Assert.assertTrue(navigationBarPage.swipeIcon.isDisplayed(), "Swipe screen should be visible");
    }
}
