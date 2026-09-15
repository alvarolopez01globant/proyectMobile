package org.example.automation.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.automation.utils.BasePage;
import org.openqa.selenium.WebElement;

/**
 * Page object representing the swipe/cards screen in the mobile application.
 * Contains elements for interacting with carousel and hidden text features.
 */
public class SwipePage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='Carousel']")
    public WebElement carousel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You found me!!!']")
    public WebElement hiddenText;

    // Logo al final de la pantalla (útil para verificar el scroll)
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='WebdriverIO logo']")
    public WebElement logo;

    public SwipePage(AndroidDriver driver) {
        super(driver);
    }
}
