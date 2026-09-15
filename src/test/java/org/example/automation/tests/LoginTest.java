package org.example.automation.tests;

import org.example.automation.pages.LoginPage;
import org.example.automation.pages.NavigationBarPage;
import org.example.automation.utils.BaseTest;
import org.example.automation.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

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
