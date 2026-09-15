package org.example.automation.utils;

import org.example.automation.config.ConfigReader;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Abstract base class for test classes in the automation framework.
 * Provides common setup and teardown methods using TestNG annotations.
 */
public abstract class BaseTest {

    /**
     * Sets up the test environment before each method execution.
     * Validates the application configuration and initializes the WebDriver.
     * Throws a SkipException if the application path is not configured.
     *
     * @throws org.testng.SkipException if the application is not configured in config.properties
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String appPath = ConfigReader.getProperty("app", "").trim();
        if (appPath.isEmpty()) {
            throw new SkipException("No se configuró la app en src/test/resources/config.properties");
        }
        DriverManager.getDriver();
    }

    /**
     * Tears down the test environment after each method execution.
     * Quits the WebDriver instance to release resources.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
