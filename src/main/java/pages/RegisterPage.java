package pages;

import ba.mistral.qa.util.FunctionsPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class RegisterPage extends FunctionsPage {

    public RegisterPage(WebDriver driver) {
        super(driver);
        locatorsMap();
    }

    HashMap<String, By> mapOfRegisterPage = new HashMap<>();

    public void locatorsMap() {
        mapOfRegisterPage.put("firstNameInput", By.id("FirstName"));
        mapOfRegisterPage.put("lastNameInput", By.id("LastName"));
        mapOfRegisterPage.put("emailInput", By.xpath("//input[@id='Email']"));
        mapOfRegisterPage.put("passwordInput", By.id("Password"));
        mapOfRegisterPage.put("confirmPasswordInput", By.id("ConfirmPassword"));
        mapOfRegisterPage.put("registerButton", By.id("register-button"));
    }

    public void checkElementsOnRegisterPage() {
        checkElementsOnPage(mapOfRegisterPage);
    }

    public String firstName = "FirstName" + RandomStringUtils.randomAlphabetic(5);
    public String lastName = "LastName" + RandomStringUtils.randomAlphabetic(5);
    public String email = RandomStringUtils.randomAlphanumeric(10)+"@mailinator.com";
    public String password = "Start123!";

    public void fillInRegistrationForm() {
        inputText(mapOfRegisterPage.get("firstNameInput"),firstName,"firstNameInput");
        inputText(mapOfRegisterPage.get("lastNameInput"),lastName,"lastNameInput");
        inputText(mapOfRegisterPage.get("emailInput"),email,"email");
        inputText(mapOfRegisterPage.get("passwordInput"),password,"passwordInput");
        inputText(mapOfRegisterPage.get("confirmPasswordInput"),password,"confirmPasswordInput");
        clickOnElement(mapOfRegisterPage.get("registerButton"), "registerButton");
    }

    private By registrationSuccessfulMessage = By.className("result");
    private By continueButton = By.className("register-continue-button");

    private String expectedRegistrationSuccessfulMessage = "Your registration completed";

    public void validateRegistration(){
        isTextEqual(registrationSuccessfulMessage,expectedRegistrationSuccessfulMessage,"registrationSuccessfulMessage");
    }

    public HomePage clickContinue(){
        clickOnElement(continueButton,"registrationSuccessfulMessage");
        return new HomePage(driver);
    }
}
