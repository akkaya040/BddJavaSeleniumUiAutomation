package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //Page Objects
     private final By imgProduct = By.xpath("//li[@id='i0']");

    private By imgProduct(int id ){return By.xpath("//li[@id='i"+id+"']");}
    private By btnAddProduct(int id ){return By.xpath("//li[@id='i"+id+"']//button[@data-test-id='product-info-button']");}


    //Page Methods
    public void addProductWithGivenLine(int i) {

        mouseHover(imgProduct(i));
        waitUntilAppear(btnAddProduct(i));
        click(btnAddProduct(i));
        wait(10);

    }

    public void confirmSearchPage() {
    }
}
