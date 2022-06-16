package PageObjects;

import ReusableClasses.Reusable_Actions_Loggers;
import ReusableClasses.Reusable_Actions_POM_Loggers;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Harvard_Pilgrim_Homepage extends Reusable_Annotations_Class {


    ExtentTest logger;


    //Create a constructor method that will reference the same  name as your class so you can make your
    //page object class methods static when you call it in your test class

    public Harvard_Pilgrim_Homepage(WebDriver driver) {
        //page factory function for page object
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations_Class.logger;
    }//end of constructor

    //define all the web elements using @find by concept
    @FindBy(xpath = "//button[text()='Shop plans']")
    WebElement shopPlan;
    @FindBy(xpath = "//button[text()='Individual & family plans']")
    WebElement familyPlan;
    @FindBy(xpath = "//*[text()='Maine plans']")
    WebElement mainePlan;
    @FindBy(xpath = "//button[text()='Health & wellness']")
    WebElement HealthWellness;
    @FindBy(xpath = "//button[@class='toggle-dropdown menu-level-2']")
    List<WebElement> listWellnessLinks;
    @FindBy(xpath = "//*[text()='Find a provider']")
    WebElement FindProvider;
    @FindBy(xpath = "//button[text()='Resources']")
    WebElement Resources;
    @FindBy(xpath = "//button[@class='toggle-dropdown menu-level-2']")
    List<WebElement> ResourcelistCount;
    @FindBy(xpath = "//*[@class='member-login']")
    WebElement membererror;
    @FindBy(xpath = "//*[@id='Username']")
    WebElement userName;
    @FindBy(xpath = "//*[@name='Password']")
    WebElement passWord;
    @FindBy(xpath = "//*[@class='hphc-btn_primary']")
    WebElement login;


    public void submitOnShopplan() {
        Reusable_Actions_POM_Loggers.clickAction(driver, shopPlan, logger, "Shop Plans");
    }//end of google search button

    public void submitOnFamilyPlan() {
        Reusable_Actions_POM_Loggers.clickAction(driver, familyPlan, logger, "Individual & family plans");
    }//end of submit on individual and family pplans

    public void submitOnMaine() {
        Reusable_Actions_POM_Loggers.clickAction(driver, mainePlan, logger, "Maine plans");
    }//end of submit on maine plans

    public void submitOnHealthandWellness() {
        Reusable_Actions_POM_Loggers.clickAction(driver, HealthWellness, logger, "Health & wellness");
    }
    public void WellnessLinks(int index) {
        Reusable_Actions_POM_Loggers.clickAction(driver, listWellnessLinks.get(index), logger, "Health & wellness");
        System.out.println("List count is " + listWellnessLinks.size());
        logger.log(LogStatus.INFO,"List count is " + listWellnessLinks.size());
        //click on each link from the list
        listWellnessLinks.get(index).click();
        System.out.println("Current link index " + index + " and link name is " + listWellnessLinks.get(index).getText());
        logger.log(LogStatus.INFO, "Current link index " + index + " and link name is " + listWellnessLinks.get(index).getText());
    }//end of click acton for wellness health

    public void FindaProvider() {
        Reusable_Actions_POM_Loggers.clickAction(driver, FindProvider, logger, "Find a provider");
    }//end of find a provider

    public void clickResources() {
        Reusable_Actions_POM_Loggers.clickAction(driver, Resources, logger, "Resources");
    }//end of click reosurces

    public void setResources(int index) throws InterruptedException {
        Reusable_Actions_POM_Loggers.clickAction(driver, ResourcelistCount.get(index), logger, "Resource count");
        Thread.sleep(1500);
        //click on each link from the list
        ResourcelistCount.get(index).click();
        System.out.println("Current index is" + ResourcelistCount.get(index));
        logger.log(LogStatus.INFO, "Current index is " + ResourcelistCount.get(index));
    }//end of loop


    public void Memberlogin() {
        Reusable_Actions_POM_Loggers.clickAction(driver, membererror, logger, "Member login");
    }

    public void UserName(String userData){
        Reusable_Actions_POM_Loggers.sendKeysAction(driver, userName,userData,logger,"Username");
     }
     public void Password (String userData) {
         Reusable_Actions_POM_Loggers.sendKeysAction(driver,passWord,userData, logger, "Password");
     }
     public void Login () {
         Reusable_Actions_POM_Loggers.clickAction(driver, login, logger, "Log in");

         //capture error text
         String ErrorResult = Reusable_Actions_Loggers.getTextAction(driver, "//*[@id='errtext']", logger, "Error message");
         System.out.println("Error message" + ErrorResult);
         logger.log(LogStatus.INFO, "Error message" + ErrorResult);

    }//end of login



}//end of class


