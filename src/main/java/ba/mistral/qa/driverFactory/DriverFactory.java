package ba.mistral.qa.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> t1Driver = new ThreadLocal<>();

    public WebDriver createDriver(String browser) {
        // Create driver

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                t1Driver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                t1Driver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                t1Driver.set(new EdgeDriver());
                break;
            case "headless":
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                WebDriverManager.chromedriver().setup();
                t1Driver.set(new ChromeDriver(options));
                break;
            default:
                System.out.println("Default browser is Chrome.");
                WebDriverManager.chromedriver().setup();
                t1Driver.set(new ChromeDriver());
                break;
        }

        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return t1Driver.get();
    }
}
