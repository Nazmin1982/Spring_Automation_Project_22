package PageObjects;

import ReusableClasses.Reusable_Annotations_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass extends Reusable_Annotations_Class{
    public BaseClass(WebDriver driver){
        PageFactory.initElements(driver,this);
    }//end of constructor class

    //create static reference for google home page
    public static GoogleHomePage googleHomePage(){
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        return  googleHomePage;
    }//end of googleHomePage method

    //create static reference for google search result page
    public static GoogleSearchResultPage googleSearchResultPage(){
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(driver);
        return  googleSearchResultPage;
    }//end of googleSearchResultPage method



    public static Harvard_Pilgrim_Homepage harvardPilgrimHomepage(){
        Harvard_Pilgrim_Homepage harvardPilgrimHomepage= new Harvard_Pilgrim_Homepage(driver);
        return harvardPilgrimHomepage;
    }//end of harvard pilgrim homepage method

    public static HarvardSelectPlan harvardSelectPlan(){
        HarvardSelectPlan harvardSelectPlan = new HarvardSelectPlan(driver);
        return harvardSelectPlan;
    }//end of harvard select plan

    public static HarvardPilgrimPlanType harvardPilgrimPlanType(){
        HarvardPilgrimPlanType harvardPilgrimPlanType = new HarvardPilgrimPlanType(driver);
        return harvardPilgrimPlanType;
    }

    public static HarvardHeaderMaine harvardHeaderMaine(){
        HarvardHeaderMaine harvardHeaderMaine = new HarvardHeaderMaine(driver);
        return harvardHeaderMaine;
    }//end of harvard header plan




}//end of base class