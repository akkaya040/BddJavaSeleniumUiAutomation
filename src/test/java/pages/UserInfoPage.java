package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserInfoPage extends BasePage {
    public UserInfoPage(WebDriver driver) {
        super(driver);
    }

    //Page Objects
    private final By txtBirthDay = By.id("txtBirthDay']");
    private final By btnUpdate = By.xpath("//button[text()='Güncelle']");

    //Page Methods

    public void confirmUserInfoPage() {

        controlIsElementExist(txtBirthDay);

    }

    public void updateUserInfo() {

        click(btnUpdate);
        waitUntilPageLoad();

    }

    public void changeBirthDate() {

        String newDate = generateRandomDateInRange("1990-01-01 00:00:00", "2000-12-31 00:00:00");
        sendText(txtBirthDay, newDate);
        wait(2);

    }


}
