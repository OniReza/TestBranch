package Pages;

import Utility.BaseData;
import Utility.CommonPageMethods;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.PanelUI;
import java.util.List;

public class LoginPage extends CommonPageMethods {
    @FindBy(xpath = "//input[@id='email']")
    WebElement Email;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement Submit;
    @FindBy(xpath = "//input[@id='password']")
    WebElement Password;
//    @FindBy(xpath = "//input[@id='code']")
    @FindBy(xpath = "//input[@id='code' and @type='text']/.")
    WebElement Totp;
    @FindBy(xpath = "//h6")
    WebElement otpExpireMsg;
    public boolean otpExpCheck(){
        try {
            return otpExpireMsg.isDisplayed();
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div[1]/div[2]/p[1]")
    WebElement AssertLandingPage;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/header/div/div/div[2]/div[1]/div/span[2]")
    WebElement AssertBoardRegisterPage;

    @FindBy(xpath = " //span[text()=\"Dashboard\"]")
    WebElement AssertPage;

    @FindBy(xpath = "//h5[text()='Additional Information']")
    WebElement additionalInfo;
    @FindBy(xpath = "//button[text()='Make Payment']")
    WebElement makepayment;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div[1]/div/div[3]/div/div")
    WebElement CardDropdown;
    @FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[2]")
    WebElement accounts;
    @FindBy(xpath = "(//span[contains(text(),'Wallet')]//parent::td)[1]")
    WebElement firstWallet;
    @FindBy(xpath = "//li[@role='option' and contains(text(),'Card')]")
    WebElement debitCard;
    @FindBy(xpath = "//button[@role='button' and text()='PAY']")
    WebElement PAYBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div[1]/div/div[2]/div")
    WebElement loader;
    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[1]")
    WebElement q1;
    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[2]")
    WebElement q2;
    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[3]")
    WebElement q3;
    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[4]")
    WebElement q4;
    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[5]")
    WebElement q5;
    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[6]")
    WebElement q6;
    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[7]")
    WebElement q7;
    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[8]")
    WebElement q8;
    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[9]")
    WebElement q9;
    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[10]")
    WebElement q10;
    @FindAll({@FindBy(xpath = "//div[@role='button' and text()='Please Select']")})
    List<WebElement> risks;

    @FindBy(xpath = "(//li[@role='option'])[4]")
    WebElement answer;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;
    @FindBy(xpath = "//span[text()='Dashboard']")
    WebElement dashBoard;
    @FindBy(xpath = "//span[contains(text(),'Recent transactions') or contains(text(),'Recent Transactions')]")
    WebElement recentTransectionSection;
    @FindBy(xpath = "//p[contains(text(),'Total')]")
    WebElement totalBalenceSection;
    @FindBy(xpath = "//h5[text()='Additional Information']")
    WebElement addInformationLabel;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void emailAddress(String email) {
        Email.sendKeys(Keys.CONTROL+"A");
        Email.sendKeys(Keys.BACK_SPACE);
        Email.sendKeys(email);
    }

    public void Password(String pass) {
        Password.sendKeys(pass);
    }

    public void Totp(String otp) {
        Totp.sendKeys(otp);
    }

    public void Submit() {
        Submit.click();
    }

    public void PageClass() throws Exception {
        String Email = BaseData.BaseEmail();
        String Pass = BaseData.BasePassword();
        String Otp = BaseData.BaseOtp();
        try {
            emailAddress(Email);
        } catch (NoSuchElementException e) {
            System.out.println("No Email input field appeared");
        }
        try {
            Submit();
        } catch (NoSuchElementException e) {
            System.out.println("Continue button not clickable");
        }
        try {
            Password(Pass);
        } catch (NoSuchElementException e) {
            System.out.println("No Password input field appeared");
        }
        try {
            Submit();
        } catch (NoSuchElementException e) {
            System.out.println("Continue button not clickable");
        }
        try {

            Totp(Otp);
        } catch (NoSuchElementException e) {
            System.out.println("No OTP input field appeared");
        }

        try {
            Submit();
            Assert.assertTrue("Dashboard is not Displayed",dashBoard.isDisplayed());
        }
        catch (NoSuchElementException e) {

            if (otpExpCheck()){
                int count = 0;
                do {
                    System.out.println("Otp error, trying again!!!");
                    Totp.sendKeys(Keys.CONTROL + "a");
                    Totp.sendKeys(Keys.BACK_SPACE);
                    Thread.sleep(1500);
                    Totp(Otp);
                    Submit();
                    count++;
                } while ( otpExpCheck() && count < 3);

            }
            else {
                System.out.println("Unknown login error");
            }

        }

    }


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++Resub+++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean makePaymentChcek() {
        return makepayment.isDisplayed();
    }

    public void Payment() throws InterruptedException {
        makepayment.click();
        Thread.sleep(1000);
        CardDropdown.click();
        Thread.sleep(2000);
    }

    public void payByWallet() throws InterruptedException {
        accounts.click();
        Thread.sleep(3000);
        CardDropdown.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(3000);
        firstWallet.click();
        System.out.println("First Wallet");
        Thread.sleep(1000);
        CardDropdown.sendKeys(Keys.PAGE_DOWN);
        System.out.println("First Wallet 2");
        PAYBtn.click();
        Thread.sleep(1000);
    }

    public void payByCard() throws InterruptedException {
        debitCard.click();
        Thread.sleep(500);
        PAYBtn.click();
        Thread.sleep(2000);
    }

    public boolean loadingCheck() {
        return loader.isDisplayed();
    }

    //Additional Information
    public int questionCount() {
        int count = risks.size();
        return count;
    }

    public void risk1() throws InterruptedException {
        q1.click();
        Thread.sleep(300);
        answer.click();
    }

    public void risk2() throws InterruptedException {
        q2.click();
        Thread.sleep(300);
        answer.click();
    }

    public void risk3() throws InterruptedException {
        q3.click();
        Thread.sleep(300);
        answer.click();
    }

    public void risk4() throws InterruptedException {
        q4.click();
        Thread.sleep(300);
        answer.click();
    }

    public void risk5() throws InterruptedException {
        q5.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(300);
        q5.click();
        Thread.sleep(300);
        answer.click();
    }

    public void risk6() throws InterruptedException {
        q6.click();
        Thread.sleep(300);
        answer.click();
    }

    public void risk7() throws InterruptedException {
        q7.click();
        Thread.sleep(300);
        answer.click();
    }

    public void risk8() throws InterruptedException {
        q8.click();
        Thread.sleep(300);
        answer.click();
    }

    public void risk9() throws InterruptedException {
        q9.click();
        Thread.sleep(300);
        answer.click();
    }

    public void risk10() throws InterruptedException {
        q10.click();
        Thread.sleep(300);
        answer.click();
    }

    public void continueBtnClick() {
        submit.click();
    }

    public boolean recentTransectionSectionCheck() {
        return recentTransectionSection.isDisplayed();
    }

    public boolean totalBalenceSectionCheck() {
        return totalBalenceSection.isDisplayed();
    }

    public boolean addInformationLabelCheck() {
        return addInformationLabel.isDisplayed();
    }

}
