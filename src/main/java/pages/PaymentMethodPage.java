package pages;

import ba.mistral.qa.util.FunctionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class PaymentMethodPage extends FunctionsPage {

    public PaymentMethodPage(WebDriver driver) {
        super(driver);
        locatorsMap();
    }

    HashMap<String, By> mapOfPaymentMethodPage = new HashMap<>();

    public void locatorsMap() {
        mapOfPaymentMethodPage.put("paymentMethod", By.xpath("//div[@class='payment-details']/input[@value='Payments.Manual']"));
        mapOfPaymentMethodPage.put("continue", By.className("payment-method-next-step-button"));
    }

    public PaymentInformationPage selectPaymentMethod(){
        clickOnElement(mapOfPaymentMethodPage.get("paymentMethod"),"paymentMethod");
        clickOnElement(mapOfPaymentMethodPage.get("continue"),"continue");
        return new PaymentInformationPage(driver);
    }
}
