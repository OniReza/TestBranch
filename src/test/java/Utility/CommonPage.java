package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonPage {
    public WebDriver driver;

    public WebDriver GetChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        return new ChromeDriver();

    }

}
