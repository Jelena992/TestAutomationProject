package pages;

import ba.mistral.qa.util.FunctionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class ShippingMethodPage extends FunctionsPage {

    public ShippingMethodPage(WebDriver driver) {
        super(driver);
        locatorsMap();
    }

    HashMap<String, By> mapOfShippingMethodPage = new HashMap<>();

    public void locatorsMap() {
        mapOfShippingMethodPage.put("shippingMethod", By.xpath("//div[@class='method-name']/input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));
        mapOfShippingMethodPage.put("continue", By.className("shipping-method-next-step-button"));
    }

    public PaymentMethodPage selectShippingMethod(){
        clickOnElement(mapOfShippingMethodPage.get("shippingMethod"),"shippingMethod");
        clickOnElement(mapOfShippingMethodPage.get("continue"),"continue");
        return new PaymentMethodPage(driver);
    }
}
