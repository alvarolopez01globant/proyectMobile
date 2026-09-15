package org.example.automation.tests;

import org.example.automation.pages.NavigationBarPage;
import org.example.automation.pages.SwipePage;
import org.example.automation.utils.BaseTest;
import org.example.automation.utils.DriverManager;
import org.example.automation.utils.GestureUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    @Test
    public void shouldSwipeCardsAndFindHiddenCard() throws InterruptedException {
        // a. Precondición: Estar en la sección Swipe
        NavigationBarPage navigationBarPage = new NavigationBarPage(DriverManager.getDriver());
        navigationBarPage.swipeIcon.click();

        SwipePage swipePage = new SwipePage(DriverManager.getDriver());
        GestureUtils gestureUtils = new GestureUtils(DriverManager.getDriver());

        swipePage.waitForVisibility(swipePage.carousel);

        // b. Deslizar la primera tarjeta y verificar que la tarjeta vieja quede oculta/desplazada
        WebElement firstCard = DriverManager.getDriver().findElement(By.xpath("//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_0__']"));
        Assert.assertTrue(firstCard.isDisplayed(), "La primera tarjeta debería ser visible al inicio");

        gestureUtils.swipeLeftOnElement(swipePage.carousel);
        Thread.sleep(500); // Pausa breve para que la animación del carrusel finalice

        // c. Avanzar por las tarjetas restantes hasta la última (__CAROUSEL_ITEM_5__)
        for (int i = 1; i < 5; i++) {
            gestureUtils.swipeLeftOnElement(swipePage.carousel);
            Thread.sleep(500);
        }

        // Validar que la última tarjeta está visible
        WebElement lastCard = DriverManager.getDriver().findElement(By.xpath("//android.view.ViewGroup[@resource-id='__CAROUSEL_ITEM_5__']"));
        Assert.assertTrue(lastCard.isDisplayed(), "La última tarjeta debería ser visible al final del carrusel");

        // d. Hacer scroll vertical continuo hasta encontrar el texto "You found me!!!"
        boolean isFound = false;
        int maxAttempts = 6;
        int attempts = 0;

        while (!isFound && attempts < maxAttempts) {
            try {
                if (swipePage.hiddenText.isDisplayed()) {
                    isFound = true;
                    break;
                }
            } catch (Exception ignored) {
                // El elemento aún no entra en el encuadre visible
            }
            gestureUtils.scrollDown();
            attempts++;
        }

        Assert.assertTrue(isFound, "El texto 'You found me!!!' no apareció en pantalla tras hacer scroll.");
    }
}