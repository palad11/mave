package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class WebDriverTest {
    private WebDriver driver;
    private static Logger LOGGER = null;

    @BeforeClass
    public static void setLogger()
    {
        System.setProperty("log4j.configurationFile","src/test/resources/log4j2-test.xml");
        LOGGER = LogManager.getLogger();
    }

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void webdriverTest() {
        LOGGER.info("Entering application.");
        System.out.println("hello world");
        driver.get("https://passport.yandex.ru/auth");
        LOGGER.info("Exiting application.");

    }

}
