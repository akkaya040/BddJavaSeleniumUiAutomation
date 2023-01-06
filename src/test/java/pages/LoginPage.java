package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Page Objects

    private final By txtUsername = By.id("txtUserName");
    private final By txtPassword = By.id("txtPassword");
    private final By btnLogin1 = By.id("btnLogin");
    private final By btnLogin2 = By.id("btnEmailSelect");



    //Page Methods
    public void clickFirstLoginButton() {
        driver.manage().deleteAllCookies();
        click(btnLogin1);
        wait(3);

    }
    public void clickSecondLoginButton() {


        click(btnLogin2);
        wait(3);

    }

    public void fillPasswordAs(String password) {

        slowSendText(txtPassword, password);
        wait(1);

    }

    public void fillUsernameAs(String username) {

        slowSendText(txtUsername, username);
        wait(1);
    }



    public void confirmLoginPage() {

        waitUntilPageLoad();
        controlIsElementExist(txtUsername);

    }

}
