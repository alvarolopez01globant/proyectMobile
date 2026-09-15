package org.example.automation.tests;

import org.example.automation.pages.LoginPage;
import org.example.automation.pages.NavigationBarPage;
import org.example.automation.utils.BaseTest;
import org.example.automation.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class SignUpTest extends BaseTest {

    @Test
    public void shouldSignUpSuccessfully() {
        NavigationBarPage navigationBarPage = new NavigationBarPage(DriverManager.getDriver());
        navigationBarPage.loginIcon.click();

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String email = "user." + UUID.randomUUID() + "@mail.com";

        loginPage.signUp(email, "Password123");

        Assert.assertTrue(loginPage.isSuccessPopupVisible(), "Signup should complete successfully");
    }
}
