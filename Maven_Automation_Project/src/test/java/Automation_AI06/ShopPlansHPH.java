package Automation_AI06;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableLibraries.Reusable_Actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ShopPlansHPH {

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
    //use case to be able to click for indivdual and family plans
    public void clickShopPlans_Maine() throws InterruptedException {
        logger = reports.startTest("Shop Plans for Maine,Massachusetts,New Hampshire");
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

}
