package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    //Page Objects
    private final By btnMyAccount = By.id("myAccount");
    private final By btnLogin = By.id("login");
    private final By btnLogout = By.xpath("//a[text()='Çıkış Yap']");
    private final By btnUserInfo = By.xpath("//a[text()='Kullanıcı Bilgilerim']");
    private final By fldSearch = By.xpath("//input[@type='text']");
    private final By btnSearch = By.xpath("//div[text()='ARA']");
    private final By btnAcceptCookies = By.cssSelector("button[id='onetrust-accept-btn-handler']");
    private final By btnBasket = By.xpath("//span[@id='shoppingCart']");
    private final By btnHomepageIcon = By.xpath("//a[@title='Hepsiburada']");



    //Page Methods

    public void clickLoginButtonInMainPage() {

        waitUntilPageLoad();
        mouseHover(btnMyAccount);
        waitAndClick(btnLogin);

    }


    public void fillSearchField(String searchText) {

        waitUntilPageLoad();
        click(fldSearch);
        sendText(fldSearch,searchText);

    }

    public void clickSearchButton() {

        click(btnSearch);

    }

    public void acceptCookies() {
        waitUntilPageLoad();
        waitAndClick(btnAcceptCookies);

    }

    public void clickBasketButton() {

        waitAndClick(btnBasket);
        waitUntilPageLoad();
    }

    public void goToHomePage(){

        waitAndClick(btnHomepageIcon);
        waitUntilPageLoad();
    }

    public void userLogout() {

        waitUntilPageLoad();
        mouseHover(btnMyAccount);
        waitAndClick(btnLogout);
        waitUntilPageLoad();

    }

    public void goToUserInfoPage() {

        waitUntilPageLoad();
        mouseHover(btnMyAccount);
        waitAndClick(btnUserInfo);
        waitUntilPageLoad();

    }

}
