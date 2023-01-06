package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    //Initialise Pages
    protected CheckoutPage checkoutPage;
    protected MainPage mainPage;
    protected UserInfoPage userInfoPage;
    protected SearchPage searchPage;
    protected LoginPage loginPage;

    public void initPages(WebDriver driver) {
        checkoutPage = new CheckoutPage(driver);
        mainPage = new MainPage(driver);
        userInfoPage = new UserInfoPage(driver);
        searchPage = new SearchPage(driver);
        loginPage = new LoginPage(driver);
    }



}
