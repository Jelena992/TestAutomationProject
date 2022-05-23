package pages;

import ba.mistral.qa.util.FunctionsPage;
import io.cucumber.gherkin.Func;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class ElectronicsPage extends FunctionsPage {

    public ElectronicsPage(WebDriver driver) {
        super(driver);
        locatorsMap();
    }

    HashMap<String, By> mapOfElectronicsPage = new HashMap<>();

    public void locatorsMap() {
        mapOfElectronicsPage.put("productName", By.className("product-title"));
        mapOfElectronicsPage.put("addToCartButton", By.className("product-box-add-to-cart-button"));
        mapOfElectronicsPage.put("shoppingCart", By.className("ico-cart"));
    }

    public void validateProduct(String expectedProduct){
        isTextEqual(mapOfElectronicsPage.get("productName"),expectedProduct,"productName");
    }

    public void clickAddToCart(){
        clickOnElement(mapOfElectronicsPage.get("addToCartButton"),"addToCartButton");

    } public CartPage clickToShoppingCart(){
        clickOnElement(mapOfElectronicsPage.get("shoppingCart"),"shoppingCart");
        return new CartPage(driver);
    }
}
