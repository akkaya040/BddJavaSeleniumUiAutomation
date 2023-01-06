package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    int productCount=0;
    //Page Objects
    private final By btnIncrease = By.xpath("//a[@aria-label='Ürünü Arttır']");
    private final By txtProductCount = By.xpath("//input[@name='quantity']");

    //Page Methods
    


    public void increaseCountOfFirstProduct() {

        List<WebElement> incButtons= waitAndFindElements(btnIncrease);
        incButtons.get(0).click();

    }


    public void confirmCheckoutPage() {


    }

    public int getProductsCountInBasket(){

        List<WebElement> productsCounts= waitAndFindElements(txtProductCount);
        int totalCount=0;

        for (WebElement product:productsCounts) {

                String value = product.getAttribute("value");
                totalCount += Integer.parseInt(value);

        }

        return totalCount;
    }


    public void countProductsInBasket() {

          this.productCount = getProductsCountInBasket();

    }

    public void confirmProductCountIncrement() {

        boolean control = false;
        waitUntilPageLoad();
        int lastCount = getProductsCountInBasket();
        if (lastCount>productCount){
            control=true;
        }
        Assert.assertTrue(control,"Product count increment can not be confirmed !");

    }
}
