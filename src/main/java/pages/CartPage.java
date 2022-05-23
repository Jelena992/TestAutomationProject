package pages;

import ba.mistral.qa.util.FunctionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class CartPage extends FunctionsPage {

    public CartPage(WebDriver driver) {
        super(driver);
        locatorsMap();
    }

    HashMap<String, By> mapOfCartPage = new HashMap<>();

    public void locatorsMap() {
        mapOfCartPage.put("productName", By.className("product-name"));
        mapOfCartPage.put("termsAndServiceCheckBox", By.id("termsofservice"));
        mapOfCartPage.put("checkOutButton", By.className("checkout-button"));
    }

    public void validateProduct(String expectedProduct){
        isTextEqual(mapOfCartPage.get("productName"),expectedProduct,"productName");
    }

    public BillingAddressPage acceptTermsAndCheckout() {
        clickOnElement(mapOfCartPage.get("termsAndServiceCheckBox"), "termsAndServiceCheckBox");
        clickOnElement(mapOfCartPage.get("checkOutButton"), "checkOutButton");
        return new BillingAddressPage(driver);
    }
}
