# FRAMEWORK STRUCTURE!

## First separation:

* main
    * main should contain everything regarding the structure of the project and all page object models that reflect
      pages of the project.
* test
    * test should contain all data regarding test cases such as feature files, step classes, runner class...etc.

## Secondary separation:

### main/java:

* ba.mistral.qa -> this package should contain all custom classes that we are bringing from company to another
  company
    * ex:
        * FunctionsPage
        * etc...

* pages -> should contain structure of packages/classes that reflect structure of the application that you are working
  on. Each page should contain HashMap of all elements present on the given page.

### test/java:

* stepDefinition package -> This package should contain:
    * steps for UI test cases -> contains mapped steps from cucumber feature files for UI test.
    * Application Hooks class -> which handles everything that we be done before and after test.
    * TestRunner class -> which is used to target specific tests and set plugins that you wish to use for report.

### test/resources:

* ui package -> which will contain subpackages that match structure of UI from application side which will contain
      feature files for UI tests

* config -> config.properties -> data used across project 


# WRITING,RUNNING AND REPORTING!

### STEPS:

**Each feature file test that you create for UI must carry annotation @ UI in order to trigger desired functions from
class**

1. Create feature file for desired tests in:
    1. `src/test/resources/ui`
2. Fill the feature file with:
    1. `Scenario `
 
3. Create steps that will map those scenarios/steps in:
    1. `src/test/java/stepDefinition/uiSteps`
4. Create page class for the page you wish to test in: `src/main/java/pages`
5. Fill the page class with the elements of that page using `HashMap<String, By> mapOfPageElements = new HashMap<>();`
6. Initiate that map in constructor of the page class
7. Use functions created in page class in the steps by creating object of the page class.`

### EXECUTION:

**There are multiple ways to execute test cases**

1. Directly from feature file by **right-clicking** on specific Scenario and then choosing **Run**.
   That way you will run desired test in single thread.
2. From Runner class in our case **TestRunner**. Right-click on the class and choose **Run**. If you choose to run tests
   like this, the tests will run in multithreading creating 10 instances and will target tests that carry annotation set
   inside the class under **@CucumberOptions** -> **tags**
3. From XLM files `src/main/java/ba.mistral.xmlExecution` -> those xml files will target runner class in our case
   TestRunner and in them, you can set number of threads for execution.

### REPORTING:

**We are currently generating allure report for our tests**

* `project/target/allure-report` -> this package contains **HTML** report for tests that are executed through either **Runner class** or **
       XML file**.
   


