package Automation_AI04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
public class ww
{

        public static void main(String[] args) throws InterruptedException {

            //setup your chromedriver with webdrivermanager
            WebDriverManager.chromedriver().setup();
            //set chrome options arguments
            ChromeOptions options = new ChromeOptions();
            //set the condition to incognito mode

            options.addArguments("incognito");
            //set the condition to maximize/fullscreen your driver
            options.addArguments("start-maximized");
            //for mac use full screen
            //options.addArguments("start-fullscreen");
            //define the webdriver I am going to use
            WebDriver driver = new ChromeDriver(options);

            ArrayList<String> zipCodes = new ArrayList<String>();
            zipCodes.add("11228");
            zipCodes.add("10168");
            zipCodes.add("10451");
            for (int i = 0; i < zipCodes.size(); i++) {

                //navigate to weight watchers website
                driver.navigate().to("https://www.weightwatchers.com/");
                Thread.sleep(3000);
            /*
            //commented out due to website changes from weightwatchers
            //click on attend dropdown
            try {
                WebElement attendDropDown = driver.findElement(By.xpath("//*[@da-label= 'Attend']"));
                attendDropDown.click();
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to click on attend dropdown " + e);
            }//end of attend dropdown exception

            //click on ultimate workshops
            try {
                WebElement ultimateWkshp = driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']"));
                ultimateWkshp.click();
                Thread.sleep(1000);
            } catch (Exception e) {
                //print out the exception
                System.out.println("Unable to click on ultimate workshop " + e);
            }//end of ultimate workshops exception
             */

                //click on Find a Workshop
                try {
                    WebElement findWkshp = driver.findElement(By.xpath("//*[@data-e2e-name='find_a workshop']"));
                    findWkshp.click();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to click on find a workshop " + e);
                }//end of find a workshop exception

                //click on studio
                try {
                    WebElement studioButton = driver.findElement(By.xpath("//span[text() = 'Studio']"));
                    studioButton.click();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to click on studio " + e);
                }//end of studio exception

                //click on studio
                try {
                    WebElement studioButton = driver.findElement(By.xpath("//span[text() = 'Studio']"));
                    studioButton.click();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to click on studio " + e);
                }//end of studio exception

                //clear and enter zipcode
                try {
                    WebElement zipSearch = driver.findElement(By.xpath("//*[@id = 'location-search']"));
                    zipSearch.clear();
                    zipSearch.sendKeys(zipCodes.get(i));
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to clear and enter zipcode " + e);
                }//end of clear and enter zipcode exception

                //click on search arrow
                try {
                    WebElement searchArrow = driver.findElement(By.xpath("//*[@id = 'location-search-cta']"));
                    searchArrow.click();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to click on search arrow " + e);
                }//end of click on search arrow exception

                //get list of studios, and click on studio link
                try {
                    ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'linkContainer-1NkqM']")));
                    System.out.println("Number of Studios found for zipcode: " + searchResults.size());
                    Thread.sleep(1000);
                    if (i == 0) {
                        searchResults.get(1).click();
                    } else if (i == 1) {
                        searchResults.get(2).click();
                    } else if (i == 2) {
                        searchResults.get(0).click();
                    }
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to get list of studios " + e);
                }//end of get list of studios exception

                //print studio address
                try {
                    String studioAddress = driver.findElement(By.xpath("//*[@class = 'address-2PZwW']")).getText();
                    Thread.sleep(1000);
                    System.out.println("The address for the studio is " + studioAddress);
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to print studio address" + e);
                }//end of click on search arrow exception

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
                    Thread.sleep(1000);
                    System.out.println("The schedule for the studio is " + studioSchedule);
                } catch (Exception e) {
                    //print out the exception
                    System.out.println("Unable to print studio schedule " + e);
                }//end of print studio schedule exception

            }//end of for loop
       driver.quit();
        }//end of main
    }//end of class

