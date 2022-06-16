package Automation_AI07;

import PageObjects.BaseClass;
import ReusableClasses.Reusable_Annotations_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.lang.module.FindException;
import java.time.Instant;
import java.util.ArrayList;

import static org.apache.commons.compress.harmony.unpack200.bytecode.forms.ByteCodeForm.get;

public class HarvardPilgrim_POM extends Reusable_Annotations_Class {

    @Test (priority = 1)
    public void HarvardpilgrimshopPlans() {
        driver.navigate().to("https://www.harvardpilgrim.org/public/home");
        BaseClass.harvardPilgrimHomepage().submitOnShopplan();
        BaseClass.harvardPilgrimHomepage().submitOnFamilyPlan();
        BaseClass.harvardPilgrimHomepage().submitOnMaine();
    }//end of maine(success)

    @Test(dependsOnMethods = "HarvardpilgrimshopPlans")
    public void GrabMaineHeader() {
        BaseClass.harvardHeaderMaine().captureHeaderresult();
    }//end of grab header(success)

    @Test (priority = 2)
    // clicking on member log in with using false username and password

    public void memberLog() {
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
            driver.navigate().to("https://www.harvardpilgrim.org/public/home");

            BaseClass.harvardPilgrimHomepage().Memberlogin();
            BaseClass.harvardPilgrimHomepage().UserName(userName.get(i));
            BaseClass.harvardPilgrimHomepage().Password(passWord.get(i));
        }

    }//END OF MEMBER LOG IN/success

    @Test (dependsOnMethods = "memberLog")
     public void CaptureErrorText (){
        BaseClass.harvardPilgrimHomepage().Login();
    }//end of capture error//success


    @Test (priority = 3)
    //iterating thru the health and wellness links
    public void healthandwellness() throws InterruptedException {
        for(int i = 2; i <= 9; i++) {
            driver.navigate().to("https://www.harvardpilgrim.org/public/home");
            BaseClass.harvardPilgrimHomepage().submitOnHealthandWellness();
            BaseClass.harvardPilgrimHomepage().WellnessLinks.get(i);
        }
        }//end of test

    @Test (priority=4)
    //clicking on find a provider and new page click on select a page then new page check PPO as plan type selected.
    public void Provider() {
        for (int i = 0; i <= 0; i++) {
            driver.navigate().to("https://www.harvardpilgrim.org/public/home");
            BaseClass.harvardPilgrimHomepage().FindaProvider();
            BaseClass.harvardSelectPlan().Selecthealthplans();
            BaseClass.harvardPilgrimPlanType().setShopPlans.get(i);
        }//end of for loop for plan link
        }//end of test

    @Test(priority =5)
    //clicking on resources and clicking on each resource link
    public void ResouceList(){
        for(int i = 10; i <= 17; i++){
            driver.navigate().to("https://www.harvardpilgrim.org/public/home");
            BaseClass.harvardPilgrimHomepage().clickResources();
            BaseClass.harvardPilgrimHomepage().setResources.get(i);
        }//end of for loop for resources
        }//end of test





}//END OF TEST SUITE







