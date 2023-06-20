package Pages;

import Utility.BaseData;
import Utility.CommonPageMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMembersPage extends CommonPageMethods {
    public static WebDriver driver;
    String givenWalletNum=null;
    @FindBy(xpath = "//div[contains(text(),'low')]")
    public WebElement topupPopup;
    @FindBy(xpath = "//input[@name='amount']")
    public WebElement topupAmount;
    @FindBy(xpath = "//input[@name='terms'and @type='checkbox']")
    public WebElement checkBox;
    @FindBy(xpath = "//span[text()='PROCEED']")
    public WebElement proceedBtn;
    @FindBy(xpath = "//b[contains(text(),'Congratulations')]")
    public WebElement sucessMsg;
    @FindBy(xpath = "//span[contains(text(),'Your payment request has been accepted.')]")
    public WebElement sucessMsgUS;
    @FindBy(xpath = "//p[contains(text(),'Your card has been purchased successfully')]")
    public WebElement purhcaseSucessmsg;
    @FindBy(xpath = "//p[contains(text(),'Your card has been activated successfully')]")
    public WebElement activationSucessmsg;
//    @FindBy(xpath = "//p[contains(text(),'successfully')]")
//    public WebElement acativationSucessmsg;
    @FindBy(xpath = "//button[@role='button' and text()='OK']")
    public WebElement okBtn;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement backBtn;
    @FindBy(xpath = "//span[contains(text(),'Quick links')]")
    public WebElement quicklinks;
    @FindBy(xpath = "//span[contains(text(),'Virtual Cards')]")
    public WebElement virtualCardsTab;
    @FindBy(xpath = "//span[contains(text(),'Create Virtual Card')]")
    public WebElement createVcardBtn;
    @FindBy(xpath = "(//p[contains(text(),'US') or contains(text(),'Euro') or contains(text(),'Pound')])[1]")
    public WebElement firstCurrencyCard;

    @FindBy(xpath = "//p[contains(text(),'Before enjoying all the benefits')]")
    public WebElement vCardActivatePagemsg1;
    @FindBy(xpath = "//p[contains(text(),'To activate your Virtual Card')]")
    public WebElement vCardActivatePagemsg2;

    public boolean vCardActivateFirstMsgCheck() {
        return vCardActivatePagemsg1.isDisplayed();
    }
    public boolean vCardActivateSecondMsgCheck() {
        return vCardActivatePagemsg2.isDisplayed();
    }



    @FindBy(xpath = "//div[@role='button' and text()='Selected']")
    public WebElement methodDropdown;
    @FindBy(xpath = "//li[@data-value='card']")
    public WebElement debitCard;
    @FindBy(xpath = "//li[@data-value='account']")
    public WebElement accounts;
    @FindBy(xpath = "(//td[text()>100 and text()<1111111]//parent::tr)[1]")
    public WebElement wallet;

    @FindBy(xpath = "//input[@id='standard-number']")
    public WebElement amountBox;
    @FindBy(xpath = "//div[@class=\"ui fitted checkbox Checkbox\"]")
    public WebElement agreementCheckBox;
    @FindBy(xpath = "//span[text()='Continue']")
    public WebElement contunueBtn;
    @FindBy(xpath = "//span[text()='Summary']")
    public WebElement summary;
    @FindBy(xpath = "//button[text()='Confirm']")
    public WebElement confirmBtn;
    @FindBy(xpath = "//p[text()='2FA Verification']/../div[2]/div/div/input")
    public WebElement otpInput;
    @FindBy(xpath = "//p[text()='2FA Verification']/../div[3]/div/button[2]")
    public WebElement activateBtn;
    @FindBy(xpath = "//span[contains(text(),'Add Virtual')]")
    public WebElement addVirtualCardTab;
    @FindBy(xpath = "//p[contains(text(),'US')]")
    public WebElement usCard;
    @FindBy(xpath = "//p[contains(text(),'Euro')]")
    public WebElement euroCard;
    @FindBy(xpath = "//p[contains(text(),'Pound')]")
    public WebElement gbpCard;
    @FindBy(xpath = "(//input[@id='standard-number'])")
    public WebElement purchaseOtp;
    @FindBy(xpath = "//p[text()='2FA Verification']/../div[3]/div/button[2]")
    public WebElement purchaseBtn;
    @FindBy(xpath = "(//p[text()='Inactive'])[1]")
    public WebElement inactiveVirtualCard;
    @FindBy(xpath = "//div[contains(text(),'Transfer to another')]")
    public WebElement newBeneficiaryCreation;
    @FindBy(name = "walletNo")
    public WebElement walletNum;
    @FindBy(name = "reference")
    public WebElement refName;
    @FindBy(xpath = "//button[@role='button' and text()='Next']")
    public WebElement nextBtn;
    @FindBy(xpath = "//span[contains(text(),'Account')]//parent::div[contains(@class,'wide')]")
    public WebElement addedWallet;

    @FindBy(xpath = "//span[text()='Activate']")
    public WebElement activateTab;
    @FindBy(name = "cardLastFourDigits")
    public WebElement lastFourdigit;
    @FindBy(xpath = "//span[text()='VERIFY']")
    public WebElement verifyBtn;
    @FindBy(name = "reEnterPassword")
    public WebElement password;
    @FindBy(xpath = "//span[text()='CONFIRM']")
    public WebElement passConfirmBtn;
    @FindBy(xpath = "//span[contains(text(),'successfully')]")
    WebElement cardActivateSucessMsg;
    @FindBy(xpath = "//span[text()='Back']")
    WebElement cardActivateBackBtn;
    @FindBy(xpath = "//p[text()='Active']")
    public WebElement cardStatus;



    public void activateTabClick(){
        activateTab.click();
    }
    public void enterFourDigit(String num){
        lastFourdigit.sendKeys(num);
    }
    public void verifyBtnClick(){
        verifyBtn.click();
    }
    public void enterPassword()throws Exception{
        password.sendKeys(BaseData.BasePassword());
    }
    public void passConfirmBtnClick(){
        passConfirmBtn.click();
    }
    public boolean cardActivationSucessMsgChek(){
        return cardActivateSucessMsg.isDisplayed();
    }
    public void cardActivateBackBtnClick(){
        cardActivateBackBtn.click();
    }
    public boolean cardStatusCheck(){
        return cardStatus.isDisplayed();
    }


    public NewMembersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public boolean topupPopupCheck() {
        return topupPopup.isDisplayed();
    }

    public void entertopupAmount() throws InterruptedException {
        topupAmount.sendKeys(Keys.BACK_SPACE);
        topupAmount.sendKeys(Keys.BACK_SPACE);
        topupAmount.sendKeys(Keys.ARROW_LEFT);
        Thread.sleep(2000);
        topupAmount.sendKeys("500");
        Thread.sleep(6000);
    }

    public void checkBoxClick() {
        checkBox.click();
    }

    public void ProceedBtnClick() {
        proceedBtn.click();
    }

    public boolean sucessMsgCheck() {
        return sucessMsg.isDisplayed();
    }
    public boolean sucessMsgwithLoader(){
            return sucessMsgUS.isDisplayed();

    }

    public boolean activationSucessMsgCheck() {
        return activationSucessmsg.isDisplayed();
    }
    public boolean purchaseSucessMsgCheck() {
        return purhcaseSucessmsg.isDisplayed();
    }

    public void okBtnClick() {
        okBtn.click();
    }

    public void backBtnClick() {
        backBtn.click();
    }

    public boolean dashboardCheck() {
        return quicklinks.isDisplayed();
    }

    public void virtualCardsTabClick() {
        virtualCardsTab.click();
    }

    public void createVcardBtnClick() {

            createVcardBtn.click();
    }

    public void firstVcardCreation() {
        firstCurrencyCard.click();
    }


    public void methodWalletSelect() throws InterruptedException {
        methodDropdown.click();
        Thread.sleep(1000);
        accounts.click();
    }
    public void walletSelect(){
        wallet.click();
    }
    public void methodCardSelect() throws InterruptedException {
        methodDropdown.click();
        Thread.sleep(1000);
        debitCard.click();
    }

    public void enterAmout() {
        amountBox.sendKeys("100");
    }

    public void topupcheckBoxClick() {

        agreementCheckBox.click();
    }

    public void continueBtnClick() {
        contunueBtn.click();
    }

    public boolean summaryCheck() {
        return summary.isDisplayed();
    }

    public void confirmBtnClick() {
        confirmBtn.click();
    }

    public void enterOtp()throws Exception {
        otpInput.click();
        otpInput.sendKeys(BaseData.BaseOtp());
    }
    public void inactiveVirtualCardClick() {
        inactiveVirtualCard.click();
    }
    public void activateBtnClick() {
        activateBtn.click();
    }

    public void addVirtualCardTabClick() {
        addVirtualCardTab.click();
    }

    public void euroCardClick() {
        try {
            euroCard.click();
            System.out.println("Euro Card Clicked");
        }
        catch (NoSuchElementException e){
            gbpCard.click();
            System.out.println("Pound Card Clicked");
        }
        catch (Exception e){
            usCard.click();
            System.out.println("USD Card Clicked");
        }

    }

    public void gbpCardClick() {
        try {
            gbpCard.click();
            System.out.println("Pound Card Clicked");
        }
        catch (NoSuchElementException e){
            euroCard.click();
            System.out.println("Euro Card Clicked");
        }
        catch (Exception e){
            usCard.click();
            System.out.println("USD Card Clicked");
        }
    }

    public void aggrementCheckBoxClick() {
        agreementCheckBox.click();
    }

    public void enterPurchaseOtp()throws Exception {
       otpInput.sendKeys(BaseData.BaseOtp());
    }

    public void purchaseBtnClick() {
        purchaseBtn.click();
    }

    public void newBeneficiaryCreationClick() {
        newBeneficiaryCreation.click();
    }

    public void enterWalletNum(String walletnum) {
        walletNum.sendKeys(walletnum);
        givenWalletNum= walletnum;
    }

    public void enterRefName(String name) {
        refName.sendKeys(name);
    }

    public void nextBtnClick() {
        nextBtn.click();
    }

    public boolean addedWalletCheck() {
        System.out.println("Added wallet: " + addedWallet.getText());
        System.out.println("Given wallet num: "+ givenWalletNum);
        if (addedWallet.getText().contains(givenWalletNum)) {
            return addedWallet.isDisplayed();
        } else {
            return !addedWallet.isDisplayed();
        }

    }

}
