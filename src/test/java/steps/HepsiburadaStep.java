package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverManager;

public class HepsiburadaStep extends BaseStep {


    @Before
    public void setupPages() {

        initPages(DriverManager.getDriver());

    }

    @Given("User Navigates To {string}")
    public void userNavigatesTo(String url) {

        DriverManager.getDriver().navigate().to(url);
        mainPage.acceptCookies();
    }


    @Then("The User Should Arrive {string} Page")
    public void theUserShouldArrivePage(String pageName) {

        switch (pageName) {
            case "Login":
                loginPage.confirmLoginPage();
                break;
            case "Account":
                checkoutPage.confirmCheckoutPage();
                break;
            case "Promotions":
                searchPage.confirmSearchPage();
                break;
            case "Personal Info":
                userInfoPage.confirmUserInfoPage();
                break;
        }

    }

    @And("The User Fills Username As {string}")
    public void theUserFillsUsernameAs(String username) {

        loginPage.fillUsernameAs(username);

    }

    @And("The User Fills Password As {string}")
    public void theUserFillsPasswordAs(String password) {

        loginPage.fillPasswordAs(password);

    }



    @Then("User Clicks Login Button In Main Page")
    public void userClicksLoginButtonInMainPage() {

        mainPage.clickLoginButtonInMainPage();

    }

    @And("User Logins With Credentials {string} {string}")
    public void userLoginsWithCredentials(String username, String password) {

        loginPage.fillUsernameAs(username);
        loginPage.clickFirstLoginButton();
        loginPage.fillPasswordAs(password);
        loginPage.clickSecondLoginButton();

    }

    @And("User Search {string} In Main Page")
    public void userSearchInMainPage(String searchText) {

        mainPage.fillSearchField(searchText);
        mainPage.clickSearchButton();

    }

    @Then("User Add Product Which Is On The Line {int}")
    public void userAddProductWhichIsOnTheLine(int lineNum) {

        searchPage.addProductWithGivenLine(lineNum-1);

    }

    @And("User Goes Basket Page")
    public void userGoesBasketPage() {

        mainPage.clickBasketButton();

    }

    @And("User Goes Home Page")
    public void userGoesHomePage() {

        mainPage.goToHomePage();

    }

    @When("User Increases The Count Of Product")
    public void userIncreasesTheCountOfProduct() {

        checkoutPage.countProductsInBasket();
        checkoutPage.increaseCountOfFirstProduct();

    }

    @Then("User Confirms Increment")
    public void userConfirmsIncrement() {

        checkoutPage.confirmProductCountIncrement();

    }

    @Then("User Logouts")
    public void userLogouts() {
        mainPage.userLogout();
    }

    @When("User Clicks User Information Button")
    public void userClicksUserInformationButton() {
        mainPage.goToUserInfoPage();
    }

    @Then("User Should See User Information Page")
    public void userShouldSeeUserInformationPage() {

        userInfoPage.confirmUserInfoPage();

    }

    @When("User Updates Birthday Info")
    public void userUpdatesBirthdayInfo() {

        userInfoPage.changeBirthDate();

    }

    @Then("User Confirm Updated Birthday")
    public void userConfirmUpdatedBirthday() {

        userInfoPage.updateUserInfo();

    }
}
