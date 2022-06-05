package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.*;


import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class inClass_actionItem {
    public static void main(String[] args) throws InterruptedException {

        //set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //set chrome option arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        // set up your chromedriver with web driver manager
        WebDriverManager.chromedriver().setup();
        //define the web driver I am going to use
        WebDriver driver = new ChromeDriver(options);


        ArrayList<String> location = new ArrayList<>();
        location.add("Vegas");
        location.add("New York");
        location.add("Texas");

        ArrayList<String> checkInDate = new ArrayList<>();
        checkInDate.add("Jun 15, 2022");
        checkInDate.add("Jul 11, 2022");
        checkInDate.add("Jul 21, 2022");

        ArrayList<String> checkOutDate = new ArrayList<>();
        checkOutDate.add("Jun 18, 2022");
        checkOutDate.add("Jul 15, 2022");
        checkOutDate.add("Jul 25, 2022");

        ArrayList<Integer> travelers = new ArrayList<>();
        travelers.add(4);
        travelers.add(5);
        travelers.add(6);


        for (int i = 0; i < location.size(); i++) {
            //navigate to mortgage calculator site
            driver.navigate().to("https://www.hotels.com/");
            //wait for page to load, 3 seconds
            sleep(1000);


            //click on going to
            try {
                driver.findElement(By.xpath("//*[@aria-label = 'Going to']")).click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Can not locate going to element " + e);
            }//end of exception for going to


            //clear and enter location
            try {
                WebElement searchInput = driver.findElement(By.xpath("//*[@id = 'location-field-destination']"));
                searchInput.clear();
                searchInput.sendKeys(location.get(i));
                Thread.sleep(1000);
                driver.findElements(By.xpath("//*[@class = 'is-subText truncate']")).get(0).click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Can not locate search input element " + e);
            }//end of exception for enter location

            //enter check in date
            try {
                driver.findElement(By.xpath("//*[@id = 'd1-btn']")).click();
                Thread.sleep(1000);
                String checkIn = checkInDate.get(i);
                driver.findElement(By.xpath("//*[@aria-label = '" + checkIn + "']")).click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Can not locate check in date element " + e);
            }

            //enter check out date
            try {
                String checkOut = checkOutDate.get(i);
                driver.findElement(By.xpath("//*[@aria-label = '" + checkOut + "']")).click();
                Thread.sleep(1000);
                //click done
                driver.findElement(By.xpath("//*[@data-stid = 'apply-date-picker']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Can not locate check out date element " + e);
            }

            //click travelers button
            try {
                driver.findElement(By.xpath("//*[@data-testid = 'travelers-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Can not locate travelers element " + e);
            }//end of exception travelers button

            //increase travelers x4
            try {
                for (int j = 2; j < travelers.get(i); j++) {
                    WebElement increaseTravelers = driver.findElement(By.xpath("//*[@aria-label = 'Increase adults in room 1']"));
                    increaseTravelers.click();
                    Thread.sleep(2000);
                }//END OF FOR LOOP for travelers
            } catch (Exception e) {
                System.out.println("Error detected " + e);
            }//end of exception increase of travelers

            //click on guests done button
            try {
                driver.findElement(By.xpath("//*[@data-testid = 'guests-done-button']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
            System.out.println("Unable to click done" + e);
            }//end of exception for guest done button

            //click on search button to submit
            try {
                driver.findElement(By.xpath("//*[@data-testid='submit-button']")).click();
            }catch (Exception e){
                System.out.println("Unable to click search to submit" + e);
            }//end of exception to search to submit

            //click on resort
            try {
                ArrayList<WebElement> resortList = new ArrayList<>(driver.findElements(By.xpath(" //*[@data-stid = 'open-hotel-information']")));
                if (i == 0) {
                    resortList.get(0).click();
                } else if (i == 1) {
                    resortList.get(2).click();
                } else if (i == 2) {
                    resortList.get(1).click();
                }
            } catch (Exception e) {
                System.out.println("Can not click on resort link " + e);
            }//end of exception to click on hotel

            //store tabs in array list to Switch tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(3000);

            //Capture Resort Name
            try {
                String resortName = driver.findElement(By.xpath("//*[@class = 'uitk-heading-3']")).getText();
                System.out.println("Resort Name is " + resortName);
            } catch (Exception e) {
                System.out.println("Can not resort name element " + e);
            }//end of exception for resort name

            //scroll a bit
            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("scroll(0,1300)");
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("Failed to scroll " + e);
            }

            //price per night
            try {
                String pricePerNight = driver.findElements(By.xpath("//*[@class = 'uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0).getText();
                System.out.println("First price per night " + pricePerNight);
            } catch (Exception e) {
                System.out.println("Can not locate price per night element " + e);
            }

            //click on reserve button
            try {
                WebElement reserveButton1 = driver.findElements(By.xpath("//*[@data-stid = 'submit-hotel-reserve']")).get(1);
                reserveButton1.click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Can not locate reserve button element " + e);
            }

            //click on pay now
            try {
                WebElement reserveButton1 = driver.findElements(By.xpath("//span[text() = 'Pay now']")).get(1);
                reserveButton1.click();
            } catch (Exception e) {
                System.out.println("Can not locate pay now button element " + e);
            }

            //print included in your unit text
            try {
                String includedText = driver.findElement(By.xpath("//*[@class = ' with-small-icon icon-thin-tick']")).getText();
                System.out.println("Included Text is: " + includedText);
            } catch (Exception e) {
                System.out.println("Can not locate included text element " + e);
            }

            //close tab
            driver.close();
            //switch to parent tab
            driver.switchTo().window(tabs.get(0));

        }//END OF FOR LOOP

        //quit chrome driver
        driver.quit();

    }//END OF MAIN
}//END OF CLASS



















