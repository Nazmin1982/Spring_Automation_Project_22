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

public class HarvardPilgrimPlanType extends Reusable_Annotations_Class {

    //Declare the ExtentTest for each page object class
    ExtentTest logger;



    //create a constructor method that will reference the same name as your class, you can make your
    //page object class methods static when you call it in your test class
    public HarvardPilgrimPlanType(WebDriver driver){
        //page factory function for page object
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor



    //under Plan Type make sure PPO is checked.

    @FindBy(xpath = "//*[@ng-checked='option.IsIncluded']")
    List<WebElement> PlanLinks;

    public void setShopPlans(int index) throws InterruptedException {
        Reusable_Actions_POM_Loggers.clickAction(driver, PlanLinks.get(index), logger, "Plan type");
        PlanLinks.get(index).click();
        System.out.println("Current index is" + PlanLinks.get(index));
        logger.log(LogStatus.INFO, "Current index is " + PlanLinks.get(index));
    }//end of clicking on one plan type PPO




}//end of class
