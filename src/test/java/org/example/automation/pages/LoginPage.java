package org.example.automation.pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.automation.utils.BasePage;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "button-login-container")
    private WebElement loginMenuTab;

    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement signUpMenuTab;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement repeatPasswordInput;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement signUpSubmitButton;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginSubmitButton;

    @AndroidFindBy(id = "android:id/alertTitle")
    public WebElement alertTitle;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement alertOkButton;

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void signUp(String email, String password) {
        click(signUpMenuTab);
        sendKeys(emailInput, email);
        sendKeys(passwordInput, password);
        sendKeys(repeatPasswordInput, password);
        click(signUpSubmitButton);
    }

    public void login(String email, String password) {
        click(loginMenuTab);
        sendKeys(emailInput, email);
        sendKeys(passwordInput, password);
        click(loginSubmitButton);
    }
}
