package Day9_052222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {


        //setup your Chrome Driver with Web Driver Manager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //start browser in incognito mode
        options.addArguments("incognito");
        //maximize the browser
        options.addArguments("start-maximized");
        //Define your Chrome Driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to usps home page
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(3000);

        //declare and define mouse actions
        Actions mouseActions =new Actions(driver);

        //hover to send tab
        WebElement sendTab =driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

        //click on tracking using mouse actions
        WebElement tracking =driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseActions.moveToElement(tracking).click().perform();

        Thread.sleep(1000);

        //type a invalid tracking number using sendkeys with mouse actions
        WebElement trackingField =driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackingField).click().perform();
        mouseActions.moveToElement(trackingField).sendKeys("111234243242").perform();



    }//end of main

}//end of class
