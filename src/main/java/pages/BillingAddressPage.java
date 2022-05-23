package pages;

import ba.mistral.qa.util.FunctionsPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class BillingAddressPage extends FunctionsPage {

    public BillingAddressPage(WebDriver driver) {
        super(driver);
        locatorsMap();
    }
    HashMap<String, By> mapOfBillingAddressPage = new HashMap<>();

    public void locatorsMap() {
        mapOfBillingAddressPage.put("country", By.id("BillingNewAddress_CountryId"));
        mapOfBillingAddressPage.put("city", By.id("BillingNewAddress_City"));
        mapOfBillingAddressPage.put("address1", By.id("BillingNewAddress_Address1"));
        mapOfBillingAddressPage.put("postalCode", By.id("BillingNewAddress_ZipPostalCode"));
        mapOfBillingAddressPage.put("phoneNumber", By.id("BillingNewAddress_PhoneNumber"));
        mapOfBillingAddressPage.put("continue", By.className("new-address-next-step-button"));
    }

    public ShippingMethodPage fillBillingAddress(){
        selectOption(mapOfBillingAddressPage.get("country"),"Austria");
        inputText(mapOfBillingAddressPage.get("city"), "Vienna", "city");
        inputText(mapOfBillingAddressPage.get("address1"), "Europaplatz 2", "address1");
        inputText(mapOfBillingAddressPage.get("postalCode"), "1150", "postalCode");
        inputText(mapOfBillingAddressPage.get("phoneNumber"), "+43"+ RandomStringUtils.randomNumeric(11), "phoneNumber");
        clickOnElement(mapOfBillingAddressPage.get("continue"), "continue");
        return new ShippingMethodPage(driver);
    }

}
