package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static synchronized void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static synchronized WebDriver getDriver() {

        return driver.get();
    }

    public static synchronized void killDriver() {
        driver.get().quit();
    }

}
