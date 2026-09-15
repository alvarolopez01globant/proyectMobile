package org.example.automation.utils;

import org.example.automation.config.ConfigReader;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String appPath = ConfigReader.getProperty("app", "").trim();
        if (appPath.isEmpty()) {
            throw new SkipException("No se configuró la app en src/test/resources/config.properties");
        }
        DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
