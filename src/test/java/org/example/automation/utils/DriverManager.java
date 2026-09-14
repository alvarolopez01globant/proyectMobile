package org.example.automation.utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.automation.config.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName(ConfigReader.getProperty("platform.name"));
                options.setAutomationName(ConfigReader.getProperty("automation.name"));
                options.setDeviceName(ConfigReader.getProperty("device.name"));

                String appPath = System.getProperty("user.dir") + ConfigReader.getProperty("app.path");
                options.setApp(appPath);

                URL appiumServerUrl = new URL(ConfigReader.getProperty("appium.server.url"));
                driver = new AndroidDriver(appiumServerUrl, options);

                int implicitWait = ConfigReader.getIntProperty("implicit.wait.timeout");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

            } catch (MalformedURLException e) {
                throw new RuntimeException("Error en la URL del servidor de Appium.", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
