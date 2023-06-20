package StepDefinations;

import Pages.LoginPage;
import Utility.BaseData;
import Utility.SmartWait;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static Utility.BaseCredentials.testEnv;
import static Utility.Hooks.getDriver;


public class LoginStep {
    public WebDriver driver;
    LoginPage loginPage;
    SmartWait smartWait = new SmartWait();
    PaymentGatewayStep paymentGatewayStep;

    public LoginStep() {
        this.driver = getDriver();
        loginPage = new LoginPage(driver);
    }

    public void waitLoad() {
        new WebDriverWait(driver, 40).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @After(order = 1)
    public void takeScraenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

    }

    /*Modify by: Abid Reza
     12-20-2022

    */
    @Given("user has logged into the portal")
    public void a_valid_url() throws Exception {
        String URL = BaseData.BaseUrlMain();
        String PopURL = BaseData.BasePopUpUrl();
        if (testEnv().trim().equals("tst")) {
            driver.get(PopURL);
            driver.get(URL);
        } else if (testEnv().trim().equals("dev")) {
            driver.get(URL);
            driver.get(PopURL);
        } else {
            System.out.println("\n" + "Please check Environment name in config.properties file");
            driver.quit();
        }

        driver.manage().window().maximize();
        waitLoad();
        loginPage.PageClass();
        waitLoad();
        System.out.println("Login Creds are ok");
        try {
            smartWait.waitUntilPageIsLoaded(5);
            Assert.assertTrue("Recent transaction didn't appeared", loginPage.recentTransectionSectionCheck());
            Assert.assertTrue("Total balances didn't appeared", loginPage.totalBalenceSectionCheck());
            System.out.println("Direct in Dashboard");
        } catch (NoSuchElementException e) {
            if (loginPage.addInformationLabelCheck()) {
                System.out.println("In Additional Information page");
                addtionalInformation();
                Thread.sleep(20000);
                try {
                    smartWait.waitUntilPageIsLoaded(5);
                    Assert.assertTrue("Recent transaction didn't appeared", loginPage.recentTransectionSectionCheck());
                    Assert.assertTrue("Total balances didn't appeared", loginPage.totalBalenceSectionCheck());
                    System.out.println("In Dashboard after risk assessment");
                } catch (Exception e1) {
                    System.out.println("Couldn't find dashboard");
                }
            }
        }
    }

//    Additional information page
    public void addtionalInformation() throws InterruptedException {
        if (loginPage.questionCount() == 2) {
            loginPage.risk1();
            loginPage.risk2();
        } else if (loginPage.questionCount() == 3) {
            loginPage.risk1();
            loginPage.risk2();
            loginPage.risk3();
        } else if (loginPage.questionCount() == 4) {
            loginPage.risk1();
            loginPage.risk2();
            loginPage.risk3();
            loginPage.risk4();
        } else if (loginPage.questionCount() == 5) {
            loginPage.risk1();
            loginPage.risk2();
            loginPage.risk3();
            loginPage.risk4();
            loginPage.risk5();
        } else if (loginPage.questionCount() == 6) {
            loginPage.risk1();
            loginPage.risk2();
            loginPage.risk3();
            loginPage.risk4();
            loginPage.risk5();
            loginPage.risk6();
        } else if (loginPage.questionCount() == 7) {
            loginPage.risk1();
            loginPage.risk2();
            loginPage.risk3();
            loginPage.risk4();
            loginPage.risk5();
            loginPage.risk6();
            loginPage.risk7();
        } else if (loginPage.questionCount() == 8) {
            loginPage.risk1();
            loginPage.risk2();
            loginPage.risk3();
            loginPage.risk4();
            loginPage.risk5();
            loginPage.risk6();
            loginPage.risk7();
            loginPage.risk8();
        } else if (loginPage.questionCount() == 9) {
            loginPage.risk1();
            loginPage.risk2();
            loginPage.risk3();
            loginPage.risk4();
            loginPage.risk5();
            loginPage.risk6();
            loginPage.risk7();
            loginPage.risk8();
            loginPage.risk9();
        } else if (loginPage.questionCount() == 10) {
            loginPage.risk1();
            loginPage.risk2();
            loginPage.risk3();
            loginPage.risk4();
            loginPage.risk5();
            loginPage.risk6();
            loginPage.risk7();
            loginPage.risk8();
            loginPage.risk9();
            loginPage.risk10();
        }
        loginPage.continueBtnClick();

    }

    //Resub Using Wallet
    public void reSubByWallet() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Recurring pay");
        Assert.assertTrue("Account suspended page appeared", loginPage.makePaymentChcek());
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Thread.sleep(1000);
        loginPage.Payment();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.payByWallet();
        Assert.assertTrue("Waiting page not appeared", loginPage.loadingCheck());
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        System.out.println("Recurring pay Complete");

    }

    //Resub using Card
    public void reSubByCard() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Recurring pay");
        Assert.assertTrue("Account suspended page appeared", loginPage.makePaymentChcek());
        Thread.sleep(1000);
        loginPage.Payment();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loginPage.payByCard();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        System.out.println("before APex");
        paymentGatewayStep = new PaymentGatewayStep();
        paymentGatewayStep.enter_card_details_in_payment_information();

    }
}










