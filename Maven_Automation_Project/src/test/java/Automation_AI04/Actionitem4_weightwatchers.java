package Automation_AI04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.ArrayList;


public class Actionitem4_weightwatchers {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //set chrome option arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-fullscreen");
        // set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //define the web driver I am going to use
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11784");
        zipCode.add("10462");
        zipCode.add("11779");

        for (int i = 0; i < zipCode.size(); i++) {


            //navigate to weight watchers site
            driver.navigate().to("https://www.weightwatchers.com/us/");
            //wait for page to load, 3 seconds
            Thread.sleep(3000);


            //click on attend dropdown
            // handle exception for zipcode
            try {
                WebElement attendButton = driver.findElement(By.xpath("//*[text()='Find a Workshop']"));
                attendButton.click();
                //wait a bit for page to load
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Unable to click on attend dropdown " + e);
            }//end of zipcode exception

            //click on studio link
            try {
                //inspect the studio button
                WebElement studioButton = driver.findElement(By.xpath("//span[text() = 'Studio']"));
                studioButton.click();
                Thread.sleep(1000);
            } catch (Exception e) {
                //printing
                System.out.println("Unable to click on studio" + e);
            }//end of exception


            //locate zipcode in search field and type zipcode
            //handle excpetion for entering zipcode
            try {
                WebElement zipSearch = driver.findElement(By.xpath("//*[@id ='location-search']"));
                zipSearch.clear();
                zipSearch.sendKeys(zipCode.get(i));
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("Unable to type zipcode" + e);
            }//end of exception to type zipcode


            //click on search arrow
            //handle exception to submit each zipcode
            try {
                WebElement searchArrow = driver.findElement(By.xpath("//*[@id ='location-search-cta']"));
                searchArrow.click();
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("unable to click on search button" + e);
            }//end of exception to submit

            //get list of studios, and click on studio link
            try {
                ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkContainer-1NkqM']")));
                System.out.println(" Number of Studios found for zipcode: " + searchResults.size());

                if (i == 0) {
                    searchResults.get(1).click();
                } else if (i == 1) {
                    searchResults.get(2).click();
                } else if (i == 2) {
                    searchResults.get(0).click();
                }
            } catch (Exception e) {
                System.out.println(" Unable to see list of studio locations" + e);
            }//end of exception

            //print studio address
            try {
                String studioAddress = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                Thread.sleep(2000);
                System.out.println(" The address for the studio is " + studioAddress);
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to print studio address" + e);
            }//end of exception

            //scroll to the studio schedule
            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("scroll(0,400)");
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to scroll " + e);
            }//end of scroll to the studio schedule exception

            //print studio schedule
            try {
                String studioSchedule = driver.findElement(By.xpath("//*[@class = 'scheduleContainerMobile-1RfmF']")).getText();
                System.out.println("The schedule of the studio " + studioSchedule);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("The schedule to the studio " + e);
            }//end of exception to print schedule


        }
        driver.quit();


    }//end of for loop

    }//end of main
//end of java clas
