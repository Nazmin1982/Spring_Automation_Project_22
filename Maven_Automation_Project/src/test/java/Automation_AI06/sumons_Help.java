package Automation_AI06;

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

import java.util.List;

public class sumons_Help {

    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions_Loggers.setDriver();
        reports = new ExtentReports("src/main/resources/HTML_Report/AutomationReport.html", true);
    }//end of before suite annotation

    //test case 1: navigate to BNYMellon homepage
//As an Investor, I want access to the ‘Regulatory Filings’, so that I can learn more about BNY Mellon.
    @Test(priority = 1)
    public void HealthAndWellnessLinks() throws InterruptedException {
        //set test name
        logger = reports.startTest("Investor Relation Homepage");
        //navigate to the home page
        driver.navigate().to("https://www.harvardpilgrim.org/public/home");

        //don't use property that has long values or form of ids. If you look at Health & wellness it's text link, so you can literally use the text property
        Reusable_Actions_Loggers.clickAction(driver,"//button[text()='Health & wellness']",logger,"Health & Wellness");

        WebDriverWait wait = new WebDriverWait(driver,10);
        //get the list count since they all have same class value
        List<WebElement> listCount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='toggle-dropdown menu-level-2']")));
        System.out.println("List count is " + listCount.size());
        logger.log(LogStatus.INFO,"List count is " + listCount.size());
        //after doing control + F and writing xpath on inspector, I see there are 18 matching with that class and Aging is the 3rd link which is index of 2 so
        //set i = 2 then i <= 9
        //iterate through the list count and click on each one
        for(int i = 2; i <= 9; i++){
            //put few seconds so automation can pause orelse you will get element is not interactable
            Thread.sleep(1500);
            //click on each link from the list
            listCount.get(i).click();
            System.out.println("Current link index " + i + " and link name is " + listCount.get(i).getText());
            logger.log(LogStatus.INFO, "Current link index " + i + " and link name is " + listCount.get(i).getText());
        }//end of loop

        //end logger
        reports.endTest(logger);
    }//end of test 1

    @Test (priority = 2)
    public void shopplans() throws InterruptedException {
        //set test name
        logger = reports.startTest("Investor Relation Homepage");
        //navigate to the home page
        driver.navigate().to("https://www.harvardpilgrim.org/public/home");
        //CLICK ON SHOP PLANS
        Reusable_Actions_Loggers.clickAction(driver, "//button[text()='Shop plans']", logger, "Shop plans");
        //CLICK ON INDIVIDUAL AND FAMILY PLANS
        Reusable_Actions_Loggers.clickAction(driver, "//button[text()='Individual & family plans']", logger, "Individual and family plans");
        Reusable_Actions_Loggers.clickAction(driver, "//*[text()='Massachusetts plans']", logger, "Massachusetts plans");
        String result1 = Reusable_Actions_Loggers.getTextAction(driver, "//h1[@class='entry-title']", logger, "Massachusetts individual and family plans");
        System.out.println("The header title for Massachusetts reads " + result1);
        logger.log(LogStatus.INFO, "The title is " + result1);
        //end logger
        reports.endTest(logger);


    }

    @AfterSuite
    public void quitSession() {
        //driver.quit();
        reports.flush();
    }//end of after suite
}
