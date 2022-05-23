package stepDefinition.uiSteps;

import ba.mistral.qa.driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class NopCommerce {

    HomePage homePage;
    RegisterPage registerPage;
    ElectronicsPage electronicsPage;
    CartPage cartPage;
    BillingAddressPage billingAddressPage;
    ShippingMethodPage shippingMethodPage;
    PaymentMethodPage paymentMethodPage;
    PaymentInformationPage paymentInformationPage;
    ConfirmOrderPage confirmOrderPage;

    @Given("that the registered user can access the nopCommerce site")
    public void thatTheRegisteredUserCanAccessTheNopCommerceSite() {
        homePage = new HomePage(DriverFactory.getDriver());
        homePage.validateUnLoggedHomePage();
        registerPage = homePage.clickRegister();
        registerPage.checkElementsOnRegisterPage();
        registerPage.fillInRegistrationForm();
        registerPage.validateRegistration();
        homePage = registerPage.clickContinue();
        homePage.validateLoggedHomePage();
    }

    @When("the user adds the HTC One Mini Blue item to the cart")
    public void theUserAddsTheHTCOneMiniBlueItemToTheCart() {
       electronicsPage = homePage.searchItem("HTC One Mini Blue");
       electronicsPage.validateProduct("HTC One Mini Blue");
       electronicsPage.clickAddToCart();
    }

    @Then("navigates to the Shopping cart")
    public void navigatesToTheShoppingCart() {
       cartPage = electronicsPage.clickToShoppingCart();
        
    }

    @And("does checkout")
    public void doesCheckout() {
        cartPage.validateProduct("HTC One Mini Blue");
        billingAddressPage = cartPage.acceptTermsAndCheckout();
    }

    @And("enters or selects existing Billing address info")
    public void entersOrSelectsExistingBillingAddressInfo() {
       shippingMethodPage = billingAddressPage.fillBillingAddress();
        
    }

    @And("selects Next Day Air Shipping method")
    public void selectsNextDayAirShippingMethod() {
        paymentMethodPage = shippingMethodPage.selectShippingMethod();
    }

    @And("selects Credit card as Payment method")
    public void selectsCreditCardAsPaymentMethod() {
        paymentInformationPage = paymentMethodPage.selectPaymentMethod();
    }

    @And("provides Payment information")
    public void providesPaymentInformation() {
        confirmOrderPage = paymentInformationPage.fillPaymentInformation();
        
    }

    @And("confirm the order")
    public void confirmTheOrder() {
        confirmOrderPage.confirmOrder();
        confirmOrderPage.validateOrder();
    }

}
