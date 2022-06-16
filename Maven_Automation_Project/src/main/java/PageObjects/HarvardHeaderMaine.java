package PageObjects;

import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HarvardHeaderMaine extends Reusable_Annotations_Class {


    public HarvardHeaderMaine(WebDriver driver) {
        //page factory function for page object
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor

    ExtentTest logger;
    @FindBy(xpath = "//h1[@class='entry-title']")
    WebElement Header;

    public void captureHeaderresult() {
        String headerresult = Reusable_Actions_POM_Loggers.getTextAction(driver, Header, logger, "Maine individual and family plans");
        //print header
        System.out.println(" The header title for Maine reads " + headerresult);
        logger.log(LogStatus.INFO, "The title is " + headerresult);


    }
}