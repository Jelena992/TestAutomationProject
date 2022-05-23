package pages;

import ba.mistral.qa.util.FunctionsPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class PaymentInformationPage extends FunctionsPage {

    public PaymentInformationPage(WebDriver driver) {
        super(driver);
        locatorsMap();
    }

    HashMap<String, By> mapOfPaymentInformationPage = new HashMap<>();

    public void locatorsMap() {
        mapOfPaymentInformationPage.put("cardholderName", By.id("CardholderName"));
        mapOfPaymentInformationPage.put("cardNumber", By.id("CardNumber"));
        mapOfPaymentInformationPage.put("expirationMonth", By.id("ExpireMonth"));
        mapOfPaymentInformationPage.put("expirationYear", By.id("ExpireYear"));
        mapOfPaymentInformationPage.put("cardCode", By.id("CardCode"));
        mapOfPaymentInformationPage.put("continue", By.className("payment-info-next-step-button"));
    }

    public ConfirmOrderPage fillPaymentInformation() {
        inputText(mapOfPaymentInformationPage.get("cardholderName"), "FirstName", "cardholderName");
        inputText(mapOfPaymentInformationPage.get("cardNumber"), "4242424242424242", "cardNumber");
        selectOption(mapOfPaymentInformationPage.get("expirationMonth"), "05");
        selectOption(mapOfPaymentInformationPage.get("expirationYear"), "2023");
        inputText(mapOfPaymentInformationPage.get("cardCode"), RandomStringUtils.randomNumeric(3), "cardCode");
        clickOnElement(mapOfPaymentInformationPage.get("continue"), "continue");
        return new ConfirmOrderPage(driver);
    }
}
