package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_MortgageCalc {
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


        //navigate to mortgage calculator site
        driver.navigate().to("http://www.mortgagecalculator.org");
        //wait for page to load, 3 seconds
        Thread.sleep(3000);

        //declare javascript-executor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //scroll to pixel 400 on mortgage calc website
  //           jse.executeScript("0,800)");
        //wait a bit for browser to perform scroll in
   //     Thread.sleep(3000);

        //declare a web element variable that we want to scroll into
        WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));

        //scroll into share this calculation button
        jse.executeScript("arguments[0].scrollIntoView(true);",shareButton);
        Thread.sleep(2000);

        //click on this share this calculation button
        shareButton.click();
        Thread.sleep(2000);

        //scroll back up
        jse.executeScript("scroll(0,-400)");
        Thread.sleep(2000);

        //quit the chrome driver
        driver.quit();


    }//end of main
}//end of class
