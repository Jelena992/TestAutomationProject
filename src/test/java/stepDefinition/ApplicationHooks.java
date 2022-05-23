package stepDefinition;

import ba.mistral.qa.driverFactory.DriverFactory;
import ba.mistral.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    public WebDriver driver;
    Properties prop;


    @Before(order=1)
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        prop = ConfigReader.getProperty();
        String browserName = prop.getProperty("browser");
        String url = prop.getProperty("url");
        driver = driverFactory.createDriver(browserName);
        driver.get(url);
    }

    @After(order=1)
    public void takeScreenshot(Scenario scenario) {
        //   if (scenario.isFailed()) {
        String screenshotName = scenario.getName();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", screenshotName);
        //   }
    }

    @After(order=0)
    public void tearDown() {
        driver.quit();
    }

}
