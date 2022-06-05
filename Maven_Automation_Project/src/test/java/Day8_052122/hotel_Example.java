package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

    public class hotel_Example {

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

            //declare destinations array
            ArrayList<String> destinations = new ArrayList<>();
            destinations.add("New York");
            destinations.add("Las Vegas");
            destinations.add("New Jersey");

            //declare number of adults array
            ArrayList<Integer> adultNum = new ArrayList<>();
            adultNum.add(4);
            adultNum.add(5);
            adultNum.add(6);

            //declare check in date array
            ArrayList<String> checkInDateArr = new ArrayList<>();
            checkInDateArr.add("Jun 15, 2022");
            checkInDateArr.add("Jun 16, 2022");
            checkInDateArr.add("Jun 17, 2022");

            //declare check out date array
            ArrayList<String> checkOutDateArr = new ArrayList<>();
            checkOutDateArr.add("Jun 18, 2022");
            checkOutDateArr.add("Jun 19, 2022");
            checkOutDateArr.add("Jun 20, 2022");

            for (int i = 0; i < destinations.size(); i++) {
                //Navigate to mortgage calculator website
                driver.navigate().to("https://www.Hotels.com");
                //wait for web page to load, 3 seconds
                Thread.sleep(1000);

                //click on going to
                try {
                    driver.findElement(By.xpath("//*[@aria-label = 'Going to']")).click();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Can not locate going to element " + e);
                }

                //clear and enter location
                try {
                    WebElement searchInput = driver.findElement(By.xpath("//*[@id = 'location-field-destination']"));
                    searchInput.clear();
                    searchInput.sendKeys(destinations.get(i));
                    Thread.sleep(1000);
                    driver.findElements(By.xpath("//*[@class = 'is-subText truncate']")).get(0).click();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Can not locate search input element " + e);
                }

                //enter check in date
                try {
                    driver.findElement(By.xpath("//*[@id = 'd1-btn']")).click();
                    Thread.sleep(1000);
                    String checkInDate = checkInDateArr.get(i);
                    driver.findElement(By.xpath("//*[@aria-label = '" + checkInDate + "']")).click();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Can not locate check in date element " + e);
                }

                //enter check out date
                try {
                    String checkOutDate = checkOutDateArr.get(i);
                    driver.findElement(By.xpath("//*[@aria-label = '" + checkOutDate + "']")).click();
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
                }

                //increase travelers x4
                try {
                    for (int j = 2; j < adultNum.get(i); j++) {
                        WebElement increaseTravelers = driver.findElement(By.xpath("//*[@aria-label = 'Increase adults in room 1']"));
                        increaseTravelers.click();
                        Thread.sleep(2000);
                    }
                } catch (Exception e) {
                    System.out.println("Error detected " + e);
                }

                //click guest done
                try {
                    driver.findElement(By.xpath("//*[@data-testid = 'guests-done-button']")).click();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Can not locate element " + e);
                }

                //click submit
                try {
                    driver.findElement(By.xpath("//*[@data-testid = 'submit-button']")).click();
                    Thread.sleep(2000);

                } catch (Exception e) {
                    System.out.println("Can not locate element " + e);
                }

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
                }

                //get tabs
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                Thread.sleep(3000);

                //get resort name
                try {
                    String resortName = driver.findElement(By.xpath("//*[@class = 'uitk-heading-3']")).getText();
                    System.out.println("Resort Name is " + resortName);
                } catch (Exception e) {
                    System.out.println("Can not resort name element " + e);
                }

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

