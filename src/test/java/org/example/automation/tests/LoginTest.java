package org.example.automation.tests;

import org.example.automation.pages.LoginPage;
import org.example.automation.pages.NavigationBarPage;
import org.example.automation.utils.BaseTest;
import org.example.automation.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for verifying login functionality in the mobile application.
 * Contains tests for successful login and related scenarios.
 */
public class LoginTest extends BaseTest {

    /**
     * Tests successful login with valid credentials.
     * Verifies that the login popup becomes visible after providing correct email and password.
     */
    @Test
    public void shouldLoginSuccessfully() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(DriverManager.getDriver());
        navigationBarPage.loginIcon.click();

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String email = "user.test@mail.com";
        String password = "Password123";

        loginPage.login(email, password);

        Assert.assertTrue(loginPage.isSuccessPopupVisible(), "Login should complete successfully");
    }
}
