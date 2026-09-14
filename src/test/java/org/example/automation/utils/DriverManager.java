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
                options.setPlatformName(ConfigReader.getProperty("platformName", "Android"));
                options.setAutomationName(ConfigReader.getProperty("automationName", "UiAutomator2"));
                options.setDeviceName(ConfigReader.getProperty("deviceName", "Android Emulator"));

                String appPath = ConfigReader.getProperty("app", "").trim();
                if (!appPath.isEmpty()) {
                    options.setApp(appPath);
                }

                options.setAppPackage(ConfigReader.getProperty("appPackage", "com.wdiodemoapp"));
                options.setAppActivity(ConfigReader.getProperty("appActivity", ".MainActivity"));
                options.setAutoGrantPermissions(true);

                URL appiumServerUrl = new URL(ConfigReader.getProperty("appiumServerUrl", "http://127.0.0.1:4723"));
                driver = new AndroidDriver(appiumServerUrl, options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
                        ConfigReader.getIntProperty("implicitWaitTimeout", 10)
                ));
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
