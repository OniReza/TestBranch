package Pages;

import Utility.CommonPageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


/**
 * @author Nahid
 */
public class UpgradePlan_Page extends CommonPageMethods {
    public static WebDriver driver;
    public UpgradePlan_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[text()='Upgrade'])")
    public WebElement upgradeMenu;
    @FindBy(xpath = "(//p[text()='Your Current Package'])")
    public WebElement upgradePageTitle;
    @FindBy(xpath = "//div/p")
    public WebElement confirmationMessage;

    @FindBy(xpath = "(//span[@class='MuiButton-label'])")
    public WebElement upgradeTextlink;
    @FindBy(xpath = "(//span[@class='MuiButton-label'])[2]")
    public WebElement upgradeBtn;
    @FindBy(xpath = "(//div/label)[1]/../div")
    public WebElement vCrossIcon;
    @FindBy(xpath = "(//*[text()='Upgrade'])[2]")
    public WebElement vCodeTitle;
    @FindBy(xpath = "(//label[text()='Enter voucher code'])")
    public WebElement vCodeText;
    @FindBy(xpath = "(//input[@id='code'])")
    public WebElement vCode;
    @FindBy(xpath = "(//span[text()='CONFIRM'])")
    public WebElement confirmBtn;
    @FindBy(xpath = "(//div[@class='jss191'])")
    public WebElement pcCrossIcon;
    @FindBy(xpath = "(//*[text()='Your Upgrade Package'])")
    public WebElement pcTitle;

    @FindBy(xpath = "(//h4/.)")
    public List<WebElement> planDetailsCount;
    @FindBy(xpath = "(//h4/.)[1]")
    public WebElement pcName;
    @FindBy(xpath = "(//h4/.)[2]")
    public WebElement pcCard;
    @FindBy(xpath = "(//h4/.)[3]")
    public WebElement pcWallet;
    @FindBy(xpath = "(//h4/.)[4]")
    public WebElement pcEURWlt;
    @FindBy(xpath = "(//h4/.)[5]")
    public WebElement pcGBPWlt;
    @FindBy(xpath = "(//h4/.)[6]")
    public WebElement pcUSDWlt;
    @FindBy(xpath = "(//h4/.)[7]")
    public WebElement pcJPYWlt;
    @FindBy(xpath = "(//h4/.)[8]")
    public WebElement pcCNYWlt;
    @FindBy(xpath = "(//h4/.)[9]")
    public WebElement pcCrypto;
    @FindBy(xpath = "(//h4/.)[10]")
    public WebElement pcBTCCry;
    @FindBy(xpath = "(//h4/.)[11]")
    public WebElement shippingMethod;

    @FindBy(xpath = "(//span[text()='CONFIRM'])")
    public WebElement confirmTextlink;

    @FindBy(xpath = "(//span[text()='CONFIRM'])[2]")
    public WebElement pcConfirmBtn;

    @FindBy(xpath = "(//p)[1]")
    public WebElement cardPrice;

    @FindBy(xpath = "//p[text()='Card currency']")
    public WebElement cardCurText;

    @FindBy(xpath = "(//h4/.)[1]")
    public WebElement cardCur;
    @FindBy(xpath = "(//label/.)[2]")
    public WebElement shipText;
    @FindBy(xpath = "//div[@id='payment-method']")
    public WebElement shipMethod;
    @FindBy(xpath = "//li[text()='Expedited - (tracked)']")
    public WebElement expeditedShipping;

    @FindBy(xpath = "(//span[text()='CONFIRM'])")
    public WebElement cardConfirmBtn;

    @FindBy(xpath = "//li[@data-value='card']")
    public WebElement card;

    @FindBy(xpath = "//a[@href='/dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "(//button[@role='button' and text()='Ok' or text()='OK'])")
    public WebElement sucessfullOkBtn;




    public void upgradeMenuClick() {
        upgradeMenu.click();
    }
    public boolean checkCurrentPackage() {
        return upgradePageTitle.isDisplayed();
    }

    public void upgradeTextlinkClick(){
        upgradeTextlink.click();
    }

    public boolean checkvCodeTitle() {
        return vCodeTitle.isDisplayed();
    }
    public void crossIconClick(){
        vCrossIcon.click();
    }

    public void upgradeBtnClick(){
        upgradeBtn.click();
    }

    public boolean checkvCodeText() {
        return vCodeText.isDisplayed();
    }
    public void entervCode(String Code){
        vCode.sendKeys(Code);
    }
    public void confirmBtnClick(){
        confirmBtn.click();
    }

    public boolean checkpcTitle() {
        return pcTitle.isDisplayed();
    }

    int trigger=0;
    String planName="";
    String planName1="";

    public boolean checkpcName() {
        if(trigger==0){
            trigger++;
            planName=pcName.getText();
        }
        else
            planName1=pcName.getText();
        return pcName.isDisplayed();
    }
    public boolean CheckplanName(){
//        System.out.println(planName);
//        System.out.println(planName1);
        if (planName.contains(planName1))return true;
        else return false;
    }
    int cardTrig=0;
    String planCard="";
    String planCard1="";

    public boolean checkpcCard() {
        if(cardTrig==0){
            cardTrig++;
            planCard=pcCard.getText();

        }
        else
            planCard1=pcCard.getText();
        return pcCard.isDisplayed();
    }

    public boolean CheckPlanCard(){
//        System.out.println(planCard);
//        System.out.println(planCard1);
        if (planCard.contains(planCard1))return true;
        else return false;
    }

    public boolean planDetailsConunt()throws InterruptedException{
        int size=planDetailsCount.size();
        System.out.println(size);
        if(size==11)return true;
        else return false;
    }
    public boolean checkpcWallet() {
        return pcWallet.isDisplayed();
    }


    public boolean checkpcUSDWlt() {
        return pcUSDWlt.isDisplayed();
    }


    public boolean checkpcEURWlt() {
        return pcEURWlt.isDisplayed();
    }


    public boolean checkpcGBPWlt() {
        return pcGBPWlt.isDisplayed();
    }


    public boolean checkpcCNYWlt() {
        return pcCNYWlt.isDisplayed();
    }


    public boolean checkpcJPYWlt() {
        return pcJPYWlt.isDisplayed();
    }


    public boolean checkpcCrypto() {
        return pcCrypto.isDisplayed();
    }


    public boolean checkpcBTCCry() {
        return pcBTCCry.isDisplayed();
    }

    public void confirmTextlinkClick(){
        confirmTextlink.click();
    }

    public void pcConfirmBtnClick(){
        pcConfirmBtn.click();
    }

    String cardPy="";
    public boolean checkCardPrice() throws InterruptedException {
        Thread.sleep(5000);
        String cardPr= cardPrice.getText();
        System.out.println(cardPr);
        cardPy = cardPr.replaceAll("[\\s,]+", "").substring(1, 2);
        System.out.println(cardPy);
        if (cardPy.equals("0"))return true;
        else return false;


    }


    public boolean verifyCardPrice() throws InterruptedException {
        Thread.sleep(5000);
        String cardPr= cardPrice.getText();
        String cardpri = cardPr.replaceAll("[\\s,]+", "").substring(1);
        if (cardpri.equals(cardPy))return true;
        else return false;

    }

    public boolean checkcardCurText() {
        return cardCurText.isDisplayed();
    }


    public boolean checkcardCur() {
        return cardCur.isDisplayed();
    }

    public boolean checkshipText(){
        return shipText.isDisplayed();
    }

    String shipMethodName="";
    public boolean checkshipMethod(){
        shipMethodName=shipMethod.getText().substring(0, 29);;
        System.out.println(shipMethodName);
        return shipMethod.isDisplayed();
    }


    public void cardConfirmBtn() throws InterruptedException {
        Thread.sleep(5000);
        cardConfirmBtn.click();
    }
    public boolean shippingName(){
        String shippingMth=shippingMethod.getText();
        if (shippingMth.equals(shipMethodName))return true;
        else return false;
    }
    public void selectExpedited()throws InterruptedException {
        Thread.sleep(1000);
        shipMethod.click();
        Thread.sleep(1000);
        shipMethodName=expeditedShipping.getText().substring(0,21);
        System.out.println(shipMethodName);
        Thread.sleep(1000);
        expeditedShipping.click();
    }

    public boolean checkCardPayPrice() throws InterruptedException {
        Thread.sleep(5000);
        String cardPr= cardPrice.getText();
        cardPy = cardPr.replaceAll("[\\s,]+", "").substring(1, 4);
        if (cardPy.equals("107"))return true;
        else return false;

    }
    public void selectPayment(){
        shipMethod.click();
        card.click();
    }

    public boolean checkConMessage() {
        return confirmationMessage.isDisplayed();
    }


}
