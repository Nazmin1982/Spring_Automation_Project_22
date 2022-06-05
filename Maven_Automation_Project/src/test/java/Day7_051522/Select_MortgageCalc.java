package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_MortgageCalc {
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

        //select start month from dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //define select command
        Select dropDown = new Select(startMonth);
        //select by visible text
        dropDown.selectByVisibleText("Jun");

        //clicking on the dropdown and its value if the dropdown tag is not under select tag
        //startMonth.click();
        //click on the value of the start month
        //driver.findElement(By.xpath("//*[text()='Jun']")).click();


        //Select loan Type from the dropdown
        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));
        //define select command
        Select loanTypeDropdown = new Select(loanType);
        //select by visible text
        loanTypeDropdown.selectByVisibleText("FHA");

    }//end of main
}//end of java class
