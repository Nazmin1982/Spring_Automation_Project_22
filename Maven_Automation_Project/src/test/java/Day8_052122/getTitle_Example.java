package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_Example {
    public static void main(String[] args) {


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

        //navigate to google
        driver.navigate().to("https://www.google.com");
        //capture the title of the page and compare it with your expected title 'GOOGLE'
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("Google")) {
            System.out.println("My title matches");
        }else {
            System.out.println("Title doesnt match. Actual Title is " + actualTitle);
        }









    }//end of main
}//end of class
