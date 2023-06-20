package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPage {
    public static WebDriver driver;
//    @Before
   public WebDriver GetChromeDriver()
    {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        return new ChromeDriver();

    }


//    @After
//    public void af()throws InterruptedException
//    {
//        Thread.sleep(4000);
//        driver.quit();
//    }

}
