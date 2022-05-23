package pages;

import ba.mistral.qa.util.FunctionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class ConfirmOrderPage extends FunctionsPage {

    public ConfirmOrderPage(WebDriver driver) {
        super(driver);
        locatorsMap();
    }

    HashMap<String, By> mapOfConfirmOrderPage = new HashMap<>();

    public void locatorsMap() {
        mapOfConfirmOrderPage.put("confirm", By.className("confirm-order-next-step-button"));
    }

    public void confirmOrder() {
        clickOnElement(mapOfConfirmOrderPage.get("confirm"), "confirm");
    }

    private By messageOrder = By.xpath("//div[@class='section order-completed']/div[@class='title']");
    private String successfulOrder = "Your order has been successfully processed!";

    public void validateOrder(){
        isTextEqual(messageOrder,successfulOrder,"messageOrder");
    }
}
