package pages;

import ba.mistral.qa.util.FunctionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class HomePage extends FunctionsPage {

    public HomePage(WebDriver driver) {
        super(driver);
        locatorsMap();
        locatorsLoggedMap();
        locatorsUnLoggedMap();
    }

    HashMap<String, By> mapOfLoggedHomePage = new HashMap<>();
    HashMap<String, By> mapOfUnLoggedHomePage = new HashMap<>();
    HashMap<String, By> mapOfHomePage = new HashMap<>();

    public void locatorsLoggedMap() {
        mapOfLoggedHomePage.put("myAccountButton", By.className("ico-account"));
        mapOfLoggedHomePage.put("logoutButton", By.className("ico-logout"));
    }

    public void locatorsUnLoggedMap() {
        mapOfUnLoggedHomePage.put("registerButton", By.className("ico-register"));
    }

    public void locatorsMap() {
        mapOfHomePage.put("searchInput", By.id("small-searchterms"));
        mapOfHomePage.put("searchButton", By.className("search-box-button"));
    }

    public void validateUnLoggedHomePage() {
        checkElementsOnPage(mapOfUnLoggedHomePage);
    }

    public void validateLoggedHomePage() {
        checkElementsOnPage(mapOfLoggedHomePage);
    }

    public RegisterPage clickRegister() {
        clickOnElement(mapOfUnLoggedHomePage.get("registerButton"), "registerButton");
        return new RegisterPage(driver);
    }

public ElectronicsPage searchItem(String item){
        inputText(mapOfHomePage.get("searchInput"),item ,"searchInput");
        clickOnElement(mapOfHomePage.get("searchButton"),"searchButton");
        return new ElectronicsPage(driver);
    }

}
