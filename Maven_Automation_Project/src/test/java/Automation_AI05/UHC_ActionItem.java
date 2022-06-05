package Automation_AI05;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class UHC_ActionItem {
    public static void main(String[] args) throws InterruptedException {
        //setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //declare first name array
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Zaihan");
        firstName.add("Nabeeha");
        firstName.add("Amaira");

        //declare last name array
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Jahan");
        lastName.add("Ali");
        lastName.add("Maleka");

        //declare check in date array
        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("March");
        birthMonth.add("April");
        birthMonth.add("May");

        //declare birthday array
        ArrayList<String> birthday = new ArrayList<>();
        birthday.add("18");
        birthday.add("19");
        birthday.add("20");

        //declare birth year
        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("2010");
        birthYear.add("2015");
        birthYear.add("2008");

        //declare zip code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11784");
        zipCode.add("10462");
        zipCode.add("11763");

        //declare member id
        ArrayList<String> memberId = new ArrayList<>();
        memberId.add("n1256914");
        memberId.add("a3378712");
        memberId.add("z4539607");

        for (int i = 0; i < firstName.size(); i++) {



            //navigate to UHC webiste
            driver.navigate().to("https://www.uhc.com/");

            //verifytitle of united healthcare homepage
            Reusable_Actions.verifyTitle(driver, "Health insurance plans");

            //click on find a doctor element
            Reusable_Actions.clickAction(driver, "//*[@aria-label='Find a doctor']", "Find a doctor");
            Thread.sleep(1000);

            //click on sign in
            Reusable_Actions.clickAction(driver, "//*[@aria-label='Sign in menu']", "Sign in");

            //click on medicare
            Reusable_Actions.clickAction(driver, "//*[text()='Medicare plan?']", "Medicare plans?");

            //switch to tabs
            Reusable_Actions.switchToTabByIndex(driver,1);

            //click on register now
            Reusable_Actions.clickAction(driver, "//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "Register Now");
            Thread.sleep(1000);

            //enter first name
            Reusable_Actions.sendKeysAction(driver, "//*[@autocomplete='given-name']", firstName.get(i), "First Name");


            //enter last name
            Reusable_Actions.sendKeysAction(driver, "//*[@autocomplete='family-name']", lastName.get(i), "Last Name");


            //enter birth month using selectByText
            Reusable_Actions.selectByText(driver, "//*[@id='dob_month_input']",birthMonth.get(i),"month drop down");


            //enter birth day
            Reusable_Actions.sendKeysAction(driver,"//*[@id='dob_day']",birthday.get(i),"birth day");


            //enter birth year
            Reusable_Actions.sendKeysAction(driver,"//*[@id='dob_year']",birthYear.get(i),"birth year");


            //enter zipcode
            Reusable_Actions.sendKeysAction(driver,"//*[@id='zipCode']",zipCode.get(i),"ZIP Code");

            //enter memberid
            Reusable_Actions.sendKeysAction(driver,"//*[@id='memberId']",memberId.get(i),"Member ID");

            //click on continue
            Reusable_Actions.clickAction(driver, "//*[@id='submitBtn']", "Continue");


            //capture error text
            String result = Reusable_Actions.getTextAction(driver, "//*[@class='SummaryError_ErrorContent__1j0LP']", "Error code");
            System.out.println("Error Message" + result);

            driver.close();

            //switch to tabs
            Reusable_Actions.switchToTabByIndex(driver,0);


        }//END OF FOR LOOP

        driver.quit();



    }//END OF MAIN
    }//END OF CLASS

