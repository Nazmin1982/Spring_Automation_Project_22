package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HarvardSelectPlan extends Reusable_Annotations_Class {

    //create a constructor for select a plan page
    public HarvardSelectPlan(WebDriver driver) {
        //page factory function for page object
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor

    ExtentTest logger;


    @FindBy(xpath = "//*[@class='hphc-btn_secondary']")
    WebElement shopPlans;


    public void Selecthealthplans() {
        Reusable_Actions_POM_Loggers.clickAction(driver, shopPlans, logger, "Select a Plan");


    }//end of public select a plan

}//end of class