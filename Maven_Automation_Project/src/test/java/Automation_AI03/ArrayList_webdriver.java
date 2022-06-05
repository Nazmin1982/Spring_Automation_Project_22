package Automation_AI03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

import static java.lang.Thread.sleep;


public class ArrayList_webdriver {
    public static void main(String[] args) throws InterruptedException {

        //set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //set chrome option arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-fullscreen");
        //set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //define the web driver I am going to use
        WebDriver driver = new ChromeDriver(options);

        //capture search number and print for following hobbies using arraylist and for loop
        ArrayList<String> hobbies = new ArrayList<>();

        hobbies.add("traveling");
        hobbies.add("baking");
        hobbies.add("cycling");
        hobbies.add("swimming");
        hobbies.add("crafting");
        for(int i= 0; i <hobbies.size();i ++) {

            //go to bing homepage
            driver.navigate().to("https://www.bing.com/");
            Thread.sleep(3000);
            //maximize the driver
            driver.manage().window().fullscreen();
            //locate element for search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobbies.get(i));
            //submit on the bing platform
            driver.findElement(By.xpath("//*[@id='sb_form_go']")).submit();
            Thread.sleep(3000);
            //capture the bing search and print it
            String searchResult = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //System.out.println("Results is " + searchResult")
            //extract out the number and print the search number only
            String[] arrayResult = searchResult.split(" ");
            System.out.println("My search number for hobby  " + hobbies.get(i) + " is " + arrayResult[0]);


        }//end of for loop

        // quit the driver
        driver.quit();
    }//end of main

}// end of class
