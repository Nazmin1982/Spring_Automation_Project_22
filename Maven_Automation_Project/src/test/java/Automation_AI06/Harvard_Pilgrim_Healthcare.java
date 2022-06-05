package Automation_AI06;

import ReusableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Harvard_Pilgrim_Healthcare {

    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setDriver();
        //define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation.html", true);
    }//end of before suite annotation

    @Test(priority = 1)
    public void verifyTitle() {
        logger = reports.startTest("Verify title page");
        driver.navigate().to("https://www.harvardpilgrim.org/public/home");
        Reusable_Actions_Loggers.verifyTitle(driver, logger, "Harvard Pilgrim Health Care");
        logger.log(LogStatus.INFO, "Harvard Piligrim Health Care");
        reports.endTest(logger);
    }//END OF VERIFYING TITLE


    @Test(priority = 2)
    //use case to be able to click for indivdual and family plans
    public void clickShopPlans_Maine() throws InterruptedException {
        logger = reports.startTest("Shop Plan for maine");
        driver.navigate().to("https://www.harvardpilgrim.org/public/home");

        //CLICK ON SHOP PLANS
        Reusable_Actions_Loggers.clickAction(driver, "//button[text()='Shop plans']", logger, "Shop plans");
        //CLICK ON INDIVIDUAL AND FAMILY PLANS
        Reusable_Actions_Loggers.clickAction(driver, "//button[text()='Individual & family plans']", logger, "Individual and family plans");
        //CLICK ON MAINE PLANS
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()='Maine plans']", logger, "Maine plans");
        //Print header for Maine
        String result = Reusable_Actions_Loggers.getTextAction(driver, "//h1[@class='entry-title']", logger, "Maine individual and family plans");
        //print header
        System.out.println(" The header title for Maine reads " + result);
        logger.log(LogStatus.INFO, "The title is " + result);

        reports.endTest(logger);
    }//end of click action for maine


    @Test(priority = 3)
    //use case for member login to capture error
    public void memberLogin() {
        //declare Array list for user name
        ArrayList<String> userName = new ArrayList();
        userName.add("Nali1935");
        userName.add("1112233");
        userName.add("hellomiss");
        //declare Array list for password
        ArrayList<String> passWord = new ArrayList();
        passWord.add("77882");
        passWord.add("84537");
        passWord.add("987732");

        for (int i = 0; i < userName.size(); i++) {
            logger = reports.startTest("Member login");
            driver.navigate().to("https://www.harvardpilgrim.org/public/home");
            //click on Member log in
            Reusable_Actions_Loggers.clickAction(driver, "//*[@class='member-login']", logger, "Member login");
            //input user name
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@id='Username']", userName.get(i), logger, "Username");
            //input password
            Reusable_Actions_Loggers.sendKeysAction(driver, "//*[@name='Password']", passWord.get(i), logger, "Password");
            //click on log in
            Reusable_Actions_Loggers.clickAction(driver, "//*[@class='hphc-btn_primary']", logger, "Log in");
            //capture error text
            String ErrorResult = Reusable_Actions_Loggers.getTextAction(driver, "//*[@id='errtext']", logger, "Error message");
            System.out.println("Error message" + ErrorResult);
            logger.log(LogStatus.INFO,"Error message" + ErrorResult);
            reports.endTest(logger);
        }//end of for loop
    }//end of member log in use case with error code


    @Test(priority = 4)
    //use case for health and wellness dropdown
    public void Health_and_Wellness_links() throws InterruptedException {
        logger = reports.startTest("Health and Wellness Dropdown");
        //navigate to the home page
        driver.navigate().to("https://www.harvardpilgrim.org/public/home");

        //click on Health & wellness
        Reusable_Actions_Loggers.clickAction(driver,"//button[text()='Health & wellness']",logger,"Health & Wellness");

        WebDriverWait wait = new WebDriverWait(driver,10);
        //get the list count since they all have same class value
        List<WebElement> listCount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='toggle-dropdown menu-level-2']")));
        System.out.println("List count is " + listCount.size());
        logger.log(LogStatus.INFO,"List count is " + listCount.size());
        //There are 18 matching with that class and Aging is the 3rd link which is index of 2 so
        //set i = 2 then i <= 9
        //iterate through the list count and click on each one
        for(int i = 2; i <= 9; i++){
            //WAIT TIME
            Thread.sleep(1500);
            //click on each link from the list
            listCount.get(i).click();
            System.out.println("Current link index " + i + " and link name is " + listCount.get(i).getText());
            logger.log(LogStatus.INFO, "Current link index " + i + " and link name is " + listCount.get(i).getText());
        }//end of loop

        //end logger
        reports.endTest(logger);
    }//end of Health and Wellness test


    @Test(priority = 5)
    //use case to be able to click for indivdual and family plans
    public void provider_Plan() throws InterruptedException {
        logger = reports.startTest("provider");
        driver.navigate().to("https://www.harvardpilgrim.org/public/home");

        //CLICK FIND A PROVIDER
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()='Find a provider']", logger, "Find a provider");
        //CLICK ON select a plan
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='hphc-btn_secondary']", logger, "Select a plan");
        WebDriverWait wait = new WebDriverWait(driver,10);
        //get the list count since they all have same class value
        List<WebElement> planType = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@ng-checked='option.IsIncluded']")));
        System.out.println("Filter results " + planType.size());
        logger.log(LogStatus.INFO,"The resource count  is " + planType.size());
        //There are 9 matching with that class and PPO is the  link which is index of 1 so
        //set i = 0 then i <= 9--->if I want all of the ones clicked.
        //iterate through the list count but only click on first one
        for(int i = 0; i <= 0; i++){
            //WAIT TIME
            Thread.sleep(1500);
            //click on each link from the list
            planType.get(i).click();
            System.out.println("Current index is" + planType.get(i));
            logger.log(LogStatus.INFO, "Current index is " + planType.get(i));
        }//end of loop

        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        System.out.println("Is element checked? " + elementState);
        logger.log(LogStatus.INFO,"Is PPO checked?"+ elementState);

        //end logger
        reports.endTest(logger);
    }//end of provider with ppo selected


    @Test(priority =6)
    //use case As a user I want to be able to see all links under resources so I can click on them.
    public void resources_links() throws InterruptedException {
        logger= reports.startTest("resources");
        driver.navigate().to("https://www.harvardpilgrim.org/public/home");
        //Click on resources
        Reusable_Actions_Loggers.clickAction(driver,"//button[text()='Resources']",logger, "Resources");

        WebDriverWait wait = new WebDriverWait(driver,10);
        //get the list count since they all have same class value
        List<WebElement> resourceCount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='toggle-dropdown menu-level-2']")));
        System.out.println("Resource count is " + resourceCount.size());
        logger.log(LogStatus.INFO,"The resource count  is " + resourceCount.size());
        //There are 18 matching with that class and discount&savings is the 11 link which is index of 10 so
        //set i = 10 then i <= 8
        //iterate through the list count and click on each one
        for(int i = 10; i <= 17; i++){
            //WAIT TIME
            Thread.sleep(1500);
            //click on each link from the list
            resourceCount.get(i).click();
            System.out.println("Current resource index " + i + " and link name is " + resourceCount.get(i).getText());
            logger.log(LogStatus.INFO, "Current resource index " + i + " and link name is " + resourceCount.get(i).getText());
        }//end of loop
        //end logger
        reports.endTest(logger);
    }//end of Health and Wellness test


    @AfterSuite
    public void quitSession() {
        driver.quit();
        reports.flush();

    }
}//end of after suite
//end of java class
