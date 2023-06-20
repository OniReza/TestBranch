package Pages;

import Utility.CommonPageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstanceRewardsPage extends CommonPageMethods {


    @FindBy(xpath = "//span[text()='Instant Rewards']")
    public WebElement btnInstanceRewards;

   // @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div/div/div[1]/div[1]/div/div")
    @FindBy(xpath = "(//span[text()='SEARCH' or text()='Search']/../../../div)[1]")
    public WebElement cardDropList;

       ///@FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[2]")
       @FindBy(xpath = "(//li)[2]")
    public WebElement cardSelectEUR;

    //@FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[1]")
    @FindBy(xpath = "(//li)[1]")
    public WebElement cardSelectUSD;

//    @FindBy(xpath = "//*[@id=\"enhanced-table-checkbox-0\"]/div/div[4]/button")
    @FindBy(xpath = "((//th/div/.)[1]/div)[4]/button")
    public WebElement selectCardBtn;

   // @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div/div[2]/div[1]/div[2]/div[1]/h3")
    @FindBy(xpath = "//div/h3[text()='Payment Method']")
    public WebElement AssertRewardPage;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/main/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[7]/textarea[1]")
    public WebElement inputMsgBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[1]/div")
    public WebElement selectWallet;

    @FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[3]")
    public WebElement walletOptionsGBP;

    @FindBy(xpath = "/html/body/div[3]/div[3]/ul/li[1]")
    public WebElement walletOptionsUSD;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div/div[2]/div[1]/div[2]/div[4]/button")
    public WebElement btnRedeem;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div/div[2]/div/div/button")
    public WebElement btnOrderButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div/div[2]")
    public WebElement AssertPaymentPage;

    @FindBy( css = "#root > div > div > div > div > main > div > div > div > div > div > div > div > div.MuiGrid-root.header-container > div.MuiGrid-root.close-button.MuiGrid-item.MuiGrid-grid-xs-12 > svg")
    public WebElement RewardsCloseBtn;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/header/div/div[2]/div/a[2]")
    public WebElement RewardsTabs;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div/div/div/div[1]/img")
    public WebElement RewardsAssert;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/span[1]")
    public WebElement popup;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/div/button[1]")
    public WebElement btnCancel;

    public InstanceRewardsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void ClickInstanceBtn()
    {
       btnInstanceRewards.click();
    }

    public void SelectCard()throws InterruptedException
    {
        cardDropList.click();
        Thread.sleep(2000);
        cardSelectEUR.click();
        Thread.sleep(3000);
        cardDropList.click();
        Thread.sleep(2000);
        cardSelectUSD.click();
    }
    public void selectCardFromList()
    {
        selectCardBtn.click();
    }
    public Boolean isPaymentMethodAvailable() {
        return AssertRewardPage.isDisplayed();
    }
    public void msgBox(){
        inputMsgBox.sendKeys("This is a automation testing.\n Thank you.");
    }

    public void btnWallet()throws InterruptedException{
        selectWallet.click();
        Thread.sleep(2000);
        walletOptionsGBP.click();
        Thread.sleep(3000);
        selectWallet.click();
        Thread.sleep(2000);
        walletOptionsUSD.click();
    }

    public void clickRedeemBtn() {
        btnRedeem.click();
    }

    public void clickOrderBtn() {
        btnOrderButton.click();
    }
    public Boolean isPaymentMethodSuccessfully() {
        return AssertPaymentPage.isDisplayed();
    }

    public void closeBtn(){
        RewardsCloseBtn.click();
    }

    public void tabsRewards(){
        RewardsTabs.click();
    }
    public Boolean isRewardsSuccessfully(){
        return RewardsAssert.isDisplayed();

    }

    public Boolean IsPopup()
    {
        return popup.isDisplayed();
    }
    public void buttonCancel()
    {
        btnCancel.click();
    }
}
