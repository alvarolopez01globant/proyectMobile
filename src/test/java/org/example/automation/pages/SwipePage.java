package org.example.automation.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.automation.utils.BasePage;
import org.openqa.selenium.WebElement;

public class SwipePage extends BasePage {

    @AndroidFindBy(accessibility = "Carousel")
    public WebElement carousel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You found me!!!\"]")
    public WebElement hiddenText;

    public SwipePage(AndroidDriver driver) {
        super(driver);
    }
}
