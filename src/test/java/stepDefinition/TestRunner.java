package stepDefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/ui",
        glue = "stepDefinition",
        tags = "@UI",
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests{

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
