package Day8_052122;


import java.util.ArrayList;




import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class inClassTry {
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
        location.add("Colardo");
        location.add("California");

        ArrayList<String> checkInDate = new ArrayList<>();
        checkInDate.add("Jun 10, 2022");
        checkInDate.add("Jul 1, 2022");
        checkInDate.add("Jul 20, 2022");

        ArrayList<String> checkOutDate = new ArrayList<>();
        checkOutDate.add("Jun 14, 2022");
        checkOutDate.add("Jul 5, 2022");
        checkOutDate.add("Jul 27, 2022");

        ArrayList<String> travelers = new ArrayList<>();
        travelers.add("3");
        travelers.add("4");
        travelers.add("5");

        for (int i = 0; i < location.size(); i++) {

            driver.navigate().to("https://www.hotels.com/");
            Thread.sleep(2000);

            //web element for location search box
            try {
                WebElement searchBox = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
                searchBox.click();
                Thread.sleep(2000);
                WebElement searchInput = driver.findElement(By.xpath("//*[@id='location-field-destination']"));
                searchInput.sendKeys(location.get(i));
                //searchInput.sendKeys("New York");
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(" line57" + e);
            }


            try {
                WebElement searchOption1 = driver.findElements(By.xpath("//*[@class='uitk-typeahead-button-label truncate']")).get(0);
                searchOption1.click();
            } catch (Exception e) {
                System.out.println("64" + e);
            }

            // select check in date
            try {
                driver.findElement(By.id("d1-btn")).click();
                //   driver.findElement(By.xpath("//*[@aria-label='"+checkInDate.get(i)+"']")).click();
                driver.findElement(By.xpath("//*[@aria-label='Jun 14, 2022']")).click();

            } catch (Exception e) {
                System.out.println("line74" + e);
            }
            // select check out date
            try {
                //     driver.findElement(By.xpath("//*[@aria-label='"+checkOutDate.get(i)+"']")).click();
                driver.findElement(By.xpath("//*[@aria-label='Jun 20, 2022']")).click();
                Thread.sleep(1000);
                //click done
                driver.findElement(By.xpath("//*[@class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary uitk-layout-flex-item uitk-layout-flex-item-flex-shrink-0 dialog-done']")).click();
            } catch (Exception e) {
                System.out.println("line 84" + e);
            }

            // add travelers
            try {
                driver.findElements(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).get(1).click();
                Thread.sleep(1000);
                WebElement addTraveler = driver.findElements(By.xpath("//*[@class='uitk-layout-flex-item uitk-step-input-touch-target']")).get(1);
                addTraveler.click();

            } catch (Exception e) {
                System.out.println("line 95" + e);
            }

            try {
                //click done for travelers
                driver.findElement(By.xpath("//*[@class='uitk-button uitk-button-large uitk-button-fullWidth uitk-button-has-text uitk-button-primary uitk-button-floating-full-width']")).click();
            } catch (Exception e) {
                System.out.println("line 101" + e);
            }

            try {
                // click search button
                driver.findElement(By.xpath("//*[@data-testid='submit-button']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("line 108" + e);
            }

            //click on first link
            try {
                driver.findElements(By.xpath("//*[@class='listing__link uitk-card-link']")).get(0).click();
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                //within the second tab
                driver.switchTo().window(tabs.get(1));

                String resortName = driver.findElement(By.xpath("//*[@class='uitk-heading-3']")).getText();
                System.out.println("My resort name is " + resortName);
            } catch (Exception e) {

            }


            //scroll down the page and capture price
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement price = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0);
            jse.executeScript("0, 600");


            //   }// end of for loop
            // driver.quit();
        }//end of main method


    }
}