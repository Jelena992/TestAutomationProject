package ba.mistral.qa.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.*;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public abstract class FunctionsPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    SoftAssert softAssert = new SoftAssert();


    public FunctionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    protected WebElement waitIsPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitIsDisplayed(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitIsClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void checkElementsOnPage(HashMap<String, By> mapOfPageElements) {
        for (Map.Entry<String, By> oneLocator : mapOfPageElements.entrySet()) {
            try {
                waitIsPresent(oneLocator.getValue());
            } catch (Exception e) {
                softAssert.fail("Element " + oneLocator.getKey() + " with locator " + oneLocator.getValue() + " is not present");
            }
        }
        softAssert.assertAll();
    }

    protected void clickOnElement(By locator, String elementName) {
        WebElement element;
        try {
            element = waitIsPresent(locator);
            try {
                waitIsClickable(locator);
                element.click();
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                element = waitIsPresent(locator);

                waitIsClickable(locator);
                element.click();
            }
        } catch (NoSuchElementException | TimeoutException | ElementClickInterceptedException e) {
            Assert.fail("Couldn't find or click " + elementName + " with locator: " + locator);
        }
    }

    protected void inputText(By locator, String text, String elementName) {
        try {
            waitIsPresent(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Could not find " + elementName + " with locator " + locator);
        }
    }

    protected void isTextEqual(By by, String expectedText, String elementName) {
        WebElement element;
        element = waitIsPresent(by);
        String actualText = element.getText();
        if (!actualText.equals(expectedText)) {
            Assert.fail("Element:  " + elementName + " actually have text [ " + actualText + " ] but it should have text [ " + expectedText + " ]");
        }
    }

    protected void selectOption( By locator, String text){
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(text);
    }

}
