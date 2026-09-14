package org.example.automation.tests;

import org.example.automation.pages.NavigationBarPage;
import org.example.automation.utils.BaseTest;
import org.example.automation.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

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
