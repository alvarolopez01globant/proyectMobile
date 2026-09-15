package org.example.automation.pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.automation.utils.BasePage;
import org.openqa.selenium.WebElement;

public class NavigationBarPage extends BasePage {

    @AndroidFindBy(accessibility = "Home")
    public WebElement homeIcon;

    @AndroidFindBy(accessibility = "Webview")
    public WebElement webviewIcon;

    @AndroidFindBy(accessibility = "Login")
    public WebElement loginIcon;

    @AndroidFindBy(accessibility = "Forms")
    public WebElement formsIcon;

    @AndroidFindBy(accessibility = "Swipe")
    public WebElement swipeIcon;

    public NavigationBarPage(AndroidDriver driver) {
        super(driver);
    }
}