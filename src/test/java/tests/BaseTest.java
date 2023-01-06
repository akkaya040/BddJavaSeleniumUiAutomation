package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.DriverManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.prefs.Preferences;

public class BaseTest {

    @BeforeMethod
    @Parameters({"deviceName", "browserType"})
    public void setup(String deviceName, String browserType) throws IOException {


        switch (browserType) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                chromeOptions.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");

                //To Solve Login Problem Via BraveBrowser
                chromeOptions.setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");

                DriverManager.setDriver(new ChromeDriver(chromeOptions));
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/drivers/geckodriver");
                DriverManager.setDriver(new FirefoxDriver());
                break;
            case "Safari":
                DriverManager.setDriver(new SafariDriver());
        }


    }

    @AfterMethod
    public synchronized void teardown() {

        DriverManager.killDriver();

    }
}
