package Automation_AI04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class practice {
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
        //now navigate to the website





        //create an ArrayList to store 3 zipCode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11003"); //0
        zipCode.add("11219");//1
        zipCode.add("11233"); //2



        for (int i=0; i< zipCode.size();i++) {


            //navigate to weight watchers
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(3000);

            //click on Attend dropdown
            try {
                driver.findElements(By.xpath("//*[text() = 'Find a Workshop']")).get(0).click();
                Thread.sleep(2000);
            } catch (Exception e){
                System.out.println("Unable to locate attend button" +e);
            }


            //click on Unlimited Workshops from drop down list
            try {
                WebElement UnlimitedWork = driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']"));
                //define select command
                UnlimitedWork.click();
                Thread.sleep(2000);
            } catch (Exception e){
                System.out.println("Unable to locate unlimited workshops" +e);
            }

            //click on studio link
            //we are clicking on index 0 because there are two elements for this xpath
            try {
                driver.findElements(By.xpath("//*[text() = 'Studio']")).get(0).click();
                //wait a bit for page to load
                Thread.sleep(2000);
            } catch (Exception e){
                System.out.println("Unable to locate studio link " +e);
            }

            //clear the field and enter zipcode- click on field, clear, send keys
            try {
                WebElement LocationField = driver.findElement(By.xpath("//*[@id='location-search']"));
                //define select command
                LocationField.clear();
                LocationField.sendKeys(zipCode.get(i));
                Thread.sleep(2000);
            }catch (Exception e) {
                System.out.println("Unable to locate location field " + e);
            }

            //click on search arrow
            try {
                WebElement ArrowButton = driver.findElement(By.xpath("//*[@id='location-search-cta']"));
                ArrowButton.click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to locate arrow button " + e);
            }

            //click on specific link for the studios using findElements with get()
            try {
                WebElement StudioLink1 = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0);
                WebElement StudioLink2 = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1);
                WebElement StudioLink3 = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2);
                if (i == 0) {
                    StudioLink2.click();
                }
                if (i == 1) {
                    StudioLink3.click();
                }
                if (i == 2) {
                    StudioLink1.click();
                }
            } catch (Exception e) {
                System.out.println("Unable to locate studio link " + e);
            }


            //capture the entire address on a variable and print address
            try {
                String getText = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                String[] getAddress = getText.split("Studio");
                System.out.println("Entire address " + getAddress[0]);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to locate address" + e);
            }

            //scroll to bottom using JavaScriptExecutor, capture entire table with days and hours for virtual studio
            //declare javascriptexecutor variable
            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                WebElement virtualClass = driver.findElement(By.xpath("//*[@id='virtualWorkshopSchedule']"));
                jse.executeScript("arguments[0].scrollIntoView(true);", virtualClass);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }


            try {
                WebElement virtSchedule = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(1);
                String virtScheduletext = virtSchedule.getText();
                System.out.println(virtScheduletext);
            } catch (Exception e) {
                System.out.println("Unable to locate virtual schedule " + e);
            }

        }//end of loop
        driver.close();

    }//end of main
}//end of java











