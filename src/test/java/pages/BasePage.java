package pages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected long pageLoadTimeout = 60;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    protected void waitUntilPageLoad(){
        new WebDriverWait(driver, pageLoadTimeout).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }


    protected void scrollPageDown(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

    }
    protected void jsClick(By by){

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(by));

    }
    protected void mouseHover(By by){

        waitUntilAppear(by);
        WebElement we = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(we).perform();

    }
    protected String getText(By by) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();

    }

    protected void sendText(By by, String text) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);

    }

    protected void slowSendText(By by, String text) {

        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        Random r = new Random();
        for(int i = 0; i < text.length(); i++) {
            try {
                Thread.sleep((int)(r.nextGaussian() * 15 + 100));
            } catch(InterruptedException e) {}
            String s = new StringBuilder().append(text.charAt(i)).toString();
            we.sendKeys(s);
        }
    }
    protected void sendText(WebElement we, String text) {

        we.sendKeys(text);

    }

    protected void waitAndClick(By by) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();

    }

    protected void wait(int sec) {

        try {
            Thread.sleep(sec*1000);
        }catch (Exception ignored) {

        }

    }
    protected void waitUntilAppear(By by) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    protected void controlIsElementExist(By by) {

        WebElement me =  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertTrue(me.isDisplayed());

    }

    protected void click(By by) {

        driver.findElement(by).click();

    }

    protected String generateRandomString(int size){

        return RandomStringUtils.randomAlphanumeric(size);

    }

    protected String generateRandomDateInRange(String startDate,String endDate){

        long beginTime = Timestamp.valueOf(startDate).getTime();
        long endTime = Timestamp.valueOf(endDate).getTime();

        long diff = endTime - beginTime + 1;
        long calculated = beginTime + (long) (Math.random() * diff);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date randomDate = new Date(calculated);

        return dateFormat.format(randomDate);

    }

    protected List<WebElement> waitAndFindElements(By by) {

        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    protected WebElement waitAndFindElement(By by) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

}
