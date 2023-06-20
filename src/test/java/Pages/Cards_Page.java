package Pages;

import Utility.BaseData;
import Utility.CommonPageMethods;
import Utility.Random_data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Cards_Page extends CommonPageMethods {
    public static WebDriver driver;
    DecimalFormat df = new DecimalFormat("#.0");
    String masterCardNumber, expMonth,expYear;
    String loadAmt, unloadAmt;
    String senderWalletCurrency, receiverCardCurrency;
    String senderCardCurrency, receiverWalletCurrency;
    String amtDebetLabel, amtReceiveLabel, debtAmt, receiveAmt, conversionRate, calculatedReceiveAmt;
    @FindBy(xpath = "//span[text()='Cards']")
    public WebElement cardsMenuBtn;
    @FindBy(xpath = "//img[@class='cardImage']")
    public WebElement physicalCard;
    @FindBy(xpath = "(//p[contains(text(),'Card Number')]/../p[2])[1]")
    public WebElement phyCardNum;
    @FindBy(xpath = "(//p[contains(text(),'Expiry Date')]/../p[2])[1]")
    public WebElement phyCardExpDate;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div[2]/div")
    public WebElement detailsTab;
    @FindBy(xpath = "//span[contains(text(),'Statements')]")
    public WebElement statementTab;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/table/tbody/tr[1]/td[2]/button")
    public WebElement AssertPageStatement;
    @FindBy(xpath = "(//span[contains(text(),'DOWNLOAD')])[1]")
    public WebElement downloadBtn;
    @FindBy(xpath = "//span[contains(text(),'Load')]")
    public WebElement loadTab;
    @FindBy(xpath = "(//input[contains(@inputmode,'decimal')])[1]")
    public WebElement loadAmount;
    @FindBy(xpath = "(//input[contains(@inputmode,'decimal')])[1]")
    public WebElement unLoadAmount;
    @FindBy(xpath = "//span[contains(text(),'CONFIRM')]")
    public WebElement confirmBtn;
    @FindBy(xpath = "//span[contains(text(),'Overview')]")
    public WebElement overview;
    //@FindBy(xpath = "//input[@id='standard-number']")
    @FindBy(xpath = "//p[text()='2FA Verification']/../div[2]/div/div/input")
    public WebElement otpInput;
    //@FindBy(xpath = "//span[contains(text(),'CONFIRM')]")
    @FindBy(xpath = "//p[text()='2FA Verification']/../div[3]/div/button[2]")
    public WebElement otpConfirmBtn;
    @FindBy(xpath = "//b[contains(text(),'Congratulations')]")
    public WebElement sucessMsgApexxLoad;
    @FindBy(xpath = "//span[contains(text(),'Your payment request has been accepted.')]")
    public WebElement sucessMsgStripeLoad;
    @FindBy(xpath = "//span[contains(text(),'Transfer successfully completed')]")
    public WebElement loadSucessMsg;
    @FindBy(xpath = "//span[@class='MuiButton-label' and text()='Ok']")
    public WebElement okBtn;
    @FindBy(xpath = "//button[@role='button']")
    public WebElement topupOKBtn;
    @FindBy(xpath = "//span[text()='Back']")
    public WebElement topupBackBtn;
    @FindBy(xpath = "//span[contains(text(),'Unload')]")
    public WebElement unloadTab;
    @FindBy(xpath = "//span[contains(text(),'Topup')]")
    public WebElement topupTab;
    @FindBy(xpath = "//div[@role='button' and @aria-haspopup='listbox']")
    public WebElement topupAmountDropdown;
    @FindBy(xpath = "//li[@role='option' and @data-value='100']")
    public WebElement topupAmount;
    @FindBy(xpath = "//span[contains(text(),'TOPUP')]")
    public WebElement topupBtn;
    @FindBy(xpath = "//span[text()='Summary']")
    public WebElement topupSummary;
    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    public WebElement topupConfirmBtn;
    @FindBy(xpath = "//span[contains(text(),'view')]/../../div[2]")
    public WebElement dbtLabel;
    @FindBy(xpath = "//span[contains(text(),'view')]/../../div[4]")
    public WebElement receLabel;
    @FindBy(xpath = "//span[contains(text(),'view')]/../../div[3]")
    public WebElement dbtAmt;
    @FindBy(xpath = "//span[contains(text(),'view')]/../../div[5]")
    public WebElement recAmt;
    @FindBy(xpath = "//span[contains(text(),'Rate')]/../../div[2]")
    public WebElement convRate;
    @FindBy(xpath = "(//div/button/span/span)[2]")
    public WebElement sednerWallCurr;
    @FindBy(xpath = "(//div/button/span/span)[4]")
    public WebElement reciverCardCurr;
    @FindBy(xpath = "(//div/button/span/span)[3]")
    public WebElement reciverWalletCurr;
    @FindBy(xpath = "(//div/input)[2]")
    public WebElement recivingAmt;
    //++++++++++++++++++++++++++++++++++++++PIN+++++++++++++++++++++++++++++++++++++++++
    @FindBy(xpath = "//span[contains(text(),'Pin')]")
    public WebElement pinTab;
    @FindBy(xpath = "//span[contains(text(),'Transactions')]")
    public WebElement transactionsTab;
    @FindBy(xpath = "(//span[@class='Text undefined small undefined thin' and contains(text(),'-')])[1]")
    public WebElement latestTransection;
    @FindBy(xpath = "(//span[@class='fa fa-external-link offset-right-10'])[1]")
    public WebElement exportPdf;
    @FindBy(xpath = "(//span[@class='fa fa-external-link offset-right-10'])[2]")
    public WebElement exportCsv;
    @FindBy(xpath = "(//button[@role='button' and text()='Ok' or text()='OK'])")
    public WebElement OKBtn;
    @FindBy(xpath = "//span[text()='Virtual Cards']")
    public WebElement virtualCardTab;
    @FindBy(xpath = "(//p[contains(text(),'Available Balance')])[1]")
    public WebElement firstVCard;
    @FindBy(xpath = "(//p[contains(text(),'Card Number')]/../p[2])[1]")
    public WebElement firstVirtualCardNum , f;
    @FindBy(xpath = "(//p[contains(text(),'Expiry Date')]/../p[2])[1]")
    public WebElement firstVirtualCardExpDate;
    @FindBy(xpath = "(//p[contains(text(),'Available Balance')])[2]")
    public WebElement secondVCard;
    @FindBy(xpath = "(//p[contains(text(),'Card Number')]/../p[2])[2]")
    public WebElement secondVirtualCardNum;
    @FindBy(xpath = "(//p[contains(text(),'Expiry Date')]/../p[2])[2]")
    public WebElement secondVirtualCardExpDate;
    @FindBy(xpath = "(//p[contains(text(),'Available Balance')])[3]")
    public WebElement thirdVCard;
    @FindBy(xpath = "(//p[contains(text(),'Card Number')]/../p[2])[3]")
    public WebElement thirdVirtualCardNum;
    @FindBy(xpath = "(//p[contains(text(),'Expiry Date')]/../p[2])[3]")
    public WebElement thirdVirtualCardExpDate;
    @FindBy(name = "reEnterPassword")
    WebElement pinPassword;
    @FindBy(xpath = "//span[contains(text(),'SUBMIT') or contains(text(),'submit')]")
    WebElement pinSubmit;
    @FindBy(xpath = "//span[contains(text(),'Your pin is')]")
    WebElement viwedPin;
    //++++++++++++++++++++++++++++++++++++++Digital card+++++++++++++++++++++++++++++++++++++++++
    @FindBy(xpath = "//span[contains(text(),'Digital Card')]")
    WebElement digitalCardTab;
    @FindBy(id = "code")
    WebElement otp;
    @FindBy(xpath = "//p[text()='2FA Verification']/../div[3]/div/button")
    WebElement showCardDetailsBtn;

    @FindAll({@FindBy(xpath = "//label[text()='Card Number']/../div//*[local-name()='svg']")})
    public List<WebElement> dgCopyBtn;

    @FindBy(xpath = "(//input[@id='code'])[1]")
    WebElement viewedCardNum;
    @FindBy(xpath = "(//input[@id='code'])[2]")
    WebElement viewedExpDate;
    @FindBy(xpath = "(//input[@id='code'])[3]")
    WebElement viewedCVV;

    public Cards_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void cardsMenuClick() {
        cardsMenuBtn.click();
    }

    public void getPhyCardNumber(){
        masterCardNumber=phyCardNum.getText().substring(15);
        expMonth = ""+Random_data.monthNumber(phyCardExpDate.getText().replaceAll("/\\d{2}",""));
        expYear = phyCardExpDate.getText().replaceAll("[A-Za-z/]","");
        System.out.println("Exp Month: "+Random_data.monthNumber(phyCardExpDate.getText().replaceAll("/\\d{2}","")));

        System.out.println("masterCardNumber: "+masterCardNumber);
    }
    public void getFirstVirtualCardNum(){
        masterCardNumber=firstVirtualCardNum.getText().substring(15);
        expMonth = ""+Random_data.monthNumber(firstVirtualCardExpDate.getText().replaceAll("/\\d{2}",""));
        expYear = firstVirtualCardExpDate.getText().replaceAll("[A-Za-z/]","");
        System.out.println("Exp Month: "+Random_data.monthNumber(firstVirtualCardExpDate.getText().replaceAll("/\\d{2}","")));
//        System.out.println(masterCardNumber);
    }
    public void getSecondVirtualCardNum(){
        masterCardNumber=secondVirtualCardNum.getText().substring(15);
        expMonth = ""+Random_data.monthNumber(secondVirtualCardExpDate.getText().replaceAll("/\\d{2}",""));
        expYear = secondVirtualCardExpDate.getText().replaceAll("[A-Za-z/]","");
        System.out.println("Exp Month: "+Random_data.monthNumber(secondVirtualCardExpDate.getText().replaceAll("/\\d{2}","")));
//        System.out.println(masterCardNumber);
    }
    public void getThirdVirtualCardNum(){
        masterCardNumber=thirdVirtualCardNum.getText().substring(15);
        expMonth = ""+Random_data.monthNumber(thirdVirtualCardExpDate.getText().replaceAll("/\\d{2}",""));
        expYear = thirdVirtualCardExpDate.getText().replaceAll("[A-Za-z/]","");
        System.out.println("Exp Month: "+Random_data.monthNumber(thirdVirtualCardExpDate.getText().replaceAll("/\\d{2}","")));
//        System.out.println(masterCardNumber);
    }

    public boolean physicalCardCheck() {
        return physicalCard.isDisplayed();
    }

    public void physicalCardClick() {
        physicalCard.click();
    }

    public boolean detailsTabCheck() {
        return detailsTab.isDisplayed();
    }

    public void statementTabClick() {
        statementTab.click();
    }

    public Boolean isStatementAvailable() {
        return AssertPageStatement.isDisplayed();
    }

    public void statementDownloadClick() {
        downloadBtn.click();
    }

    public void loadTabClick() {
        loadTab.click();
    }

    public void enterLoadAmount(String amt) {
        loadAmt = amt;
        loadAmount.sendKeys(amt);
    }

    public void enterUnloadAmount(String amt) {
        unloadAmt = amt;
        unLoadAmount.sendKeys(unloadAmt);
    }

    public boolean overviewCheck() {
        return overview.isDisplayed();
    }

    public void confirmBtnClick() {
        confirmBtn.click();
    }

    public void enterOtp() throws Exception {
        otpInput.sendKeys(BaseData.BaseOtp());
    }

    public void otpConfirmBtnClick() {
        otpConfirmBtn.click();
    }

    public boolean loadSucessMsgCheck() {
        return loadSucessMsg.isDisplayed();
    }

    public boolean checksucessMsgApexxLoad() {
        return sucessMsgApexxLoad.isDisplayed();
    }

    public boolean sucessMsgStripeLoad() {
        return sucessMsgStripeLoad.isDisplayed();
    }

    public void okBtnClick() {
        okBtn.click();
    }

    public void topupOKBtnClick() {
        topupOKBtn.click();
    }

    public void topupBackBtnClick() {
        topupBackBtn.click();
    }

    public void unloadTabClick() {
        unloadTab.click();
    }

    public void topUpTabClick() {
        topupTab.click();
    }

    public void topupAmountDropdownClick() {
        topupAmountDropdown.click();
    }

    public void topupAmountClick() {
        topupAmount.click();
    }

    public void topupBtnClick() {
        topupBtn.click();
    }

    public boolean summaryCheck() {
        return topupSummary.isDisplayed();
    }

    public void topupConfirmBtnClick() {
        topupConfirmBtn.click();
    }

    public void OKbtnClick() {
        OKBtn.click();
    }

    //++++++++++++++++++++++++++++++++++++++++++++++PIN+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void pinTabClick() {
        pinTab.click();
    }

    public void enterPinPass() throws Exception {
        pinPassword.sendKeys(BaseData.BasePassword());
    }

    public void pinSubmitClick() {
        pinSubmit.click();
    }

    public boolean viewedPinCheck() {
        return viwedPin.isDisplayed();
    }

    //+++++++++++++++++++++++++++++++++++++PIN+++++++++++++++++++++++++++++++++
    public void digitalCardTabClick() {
        click(digitalCardTab);
    }

    public void enterOtpDigitalCard() throws Exception {
        otpInput.sendKeys(BaseData.BaseOtp());
    }

    public void showCardDetailsBtnClick() {
        showCardDetailsBtn.click();
    }

    public boolean cardDetaisCheck() {
        System.out.println("Last 4 digit Match: "+viewedCardNum.getAttribute("value").substring(15).equals(masterCardNumber));
        System.out.println("Expire Match: "+ viewedExpDate.getAttribute("value").equals(expMonth+"/20"+expYear));
        System.out.println("CVV Match: "+(viewedCVV.getAttribute("value").length()==3));
        System.out.println("Copy btn count Match: "+(dgCopyBtn.size()==3));
        System.out.println("Viewed"+viewedExpDate.getAttribute("value"));
        System.out.println(expMonth+"/20"+expYear);

        if (viewedCardNum.getAttribute("value").substring(15).equals(masterCardNumber) && viewedExpDate.getAttribute("value").equals(expMonth+"/20"+expYear) && viewedCVV.getAttribute("value").length()==3 &&
                dgCopyBtn.size()==3)
            return viewedCardNum.isDisplayed();
        else
            return false;
    }

    public void transactionTabClick() {
        transactionsTab.click();
    }

    public boolean latestTransectionCheck() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
        Calendar cal = Calendar.getInstance();
        String dt = dateFormat.format(cal.getTime());
        String str = latestTransection.getText();

        if (latestTransection.getText().trim().equals(dt)) {
            return latestTransection.isDisplayed();
        } else {
            return false;
        }
    }

    public void exportTransaction() throws InterruptedException {
        exportPdf.click();
        Thread.sleep(1000);
        exportCsv.click();
    }

    public void virtualCardTabClick() {
        virtualCardTab.click();
    }

    public boolean firstVCardCheck() {
        return firstVCard.isDisplayed();
    }

    public void firstVCardClick() {
        firstVCard.click();
    }

    public void secondVCardClick() {
        secondVCard.click();
    }

    public void thirdVCardClick() {
        thirdVCard.click();
    }

    public void getLoadWalletCurrencies() {
        senderWalletCurrency = sednerWallCurr.getText().trim();
        receiverCardCurrency = reciverCardCurr.getText().trim();
        System.out.println("Sender's wallet Currency: " + senderWalletCurrency);
        System.out.println("Receiver card Currency: " + receiverCardCurrency);
    }

    public void getUnloadWalletCurrencies() {
        senderCardCurrency = sednerWallCurr.getText().trim();
        receiverWalletCurrency = reciverWalletCurr.getText().trim();
        System.out.println("Sender's Card Currency: " + senderCardCurrency);
        System.out.println("Receiver wallet Currency: " + receiverWalletCurrency);
    }

    public void getLoadSummaryData() {
        amtDebetLabel = dbtLabel.getText();
        amtReceiveLabel = receLabel.getText();
        debtAmt = dbtAmt.getText();
        receiveAmt = recAmt.getText().replaceAll("\\,", "");
        conversionRate = convRate.getText();
        //calculation
        double calReceiveAmt = Double.valueOf(loadAmt) * Double.valueOf(conversionRate.replaceAll("\\s", "").substring(4));
        df.setRoundingMode(RoundingMode.DOWN);
        double calculatedRecAmount = Double.parseDouble(df.format(calReceiveAmt));
        calculatedReceiveAmt = String.valueOf(calculatedRecAmount);
        System.out.println("Calculated receive amt: " + calculatedRecAmount);
        System.out.println("Send Amt: " + debtAmt);
        System.out.println("Receive Amt: " + receiveAmt);
        System.out.println("Conv Rate: " + conversionRate);

    }

    public void getUnloadSummaryData() {
        amtDebetLabel = dbtLabel.getText();
        amtReceiveLabel = receLabel.getText();
        debtAmt = dbtAmt.getText();
        receiveAmt = recAmt.getText().replaceAll("\\,", "");
        conversionRate = convRate.getText();
        //calculation
        double calReceiveAmt = Double.valueOf(unloadAmt) * Double.valueOf(conversionRate.replaceAll("\\s", "").substring(4));
        df.setRoundingMode(RoundingMode.DOWN);
        double calculatedRecAmount = Double.parseDouble(df.format(calReceiveAmt));
        calculatedReceiveAmt = String.valueOf(calculatedRecAmount);
        System.out.println("Calculated receive amt: " + calculatedRecAmount);
        System.out.println("Send Amt: " + debtAmt);
        System.out.println("Receive Amt: " + receiveAmt);
        System.out.println("Conv Rate: " + conversionRate);

    }

    public boolean loadDebitSummaryCheck() {
        if (senderWalletCurrency.equals("USD")) {
            boolean a = amtDebetLabel.contains("Total to be debited");
            boolean b = debtAmt.contains("$");
            boolean c = debtAmt.contains(loadAmt);
            boolean d = conversionRate.replaceAll("\\s", "").substring(0, 1).contains("$");
            System.out.println("Total to be debited: " + a);
            System.out.println("Total to be debited Currency: " + b);
            System.out.println("Total to be debited Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Debit wallet Currency: " + conversionRate.replaceAll("\\s", "").substring(0, 1));

            if (amtDebetLabel.contains("Total to be debited") && debtAmt.contains("$") && debtAmt.contains(loadAmt) &&
                    conversionRate.replaceAll("\\s", "").substring(0, 1).contains("$"))
                return true;
            else
                return false;

        } else if (senderWalletCurrency.equals("EUR")) {
            boolean a = amtDebetLabel.contains("Total to be debited");
            boolean b = debtAmt.contains("€");
            boolean c = debtAmt.contains(loadAmt);
            boolean d = conversionRate.replaceAll("\\s", "").substring(0, 1).contains("€");
            System.out.println("Total to be debited: " + a);
            System.out.println("Total to be debited Currency: " + b);
            System.out.println("Total to be debited Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Debit wallet Currency: " + conversionRate.replaceAll("\\s", "").substring(0, 1));

            if (amtDebetLabel.contains("Total to be debited") && debtAmt.contains("€") && debtAmt.contains(loadAmt) &&
                    conversionRate.replaceAll("\\s", "").substring(0, 1).contains("€"))
                return true;
            else
                return false;

        } else if (senderWalletCurrency.equals("GBP")) {
            boolean a = amtDebetLabel.contains("Total to be debited");
            boolean b = debtAmt.contains("£");
            boolean c = debtAmt.contains(loadAmt);
            boolean d = conversionRate.replaceAll("\\s", "").substring(0, 1).contains("£");
            System.out.println("Total to be debited: " + a);
            System.out.println("Total to be debited Currency: " + b);
            System.out.println("Total to be debited Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Debit wallet Currency: " + conversionRate.replaceAll("\\s", "").substring(0, 1));

            if (amtDebetLabel.contains("Total to be debited") && debtAmt.contains("£") && debtAmt.contains(loadAmt) &&
                    conversionRate.replaceAll("\\s", "").substring(0, 1).contains("£"))
                return true;
            else
                return false;

        } else if (senderWalletCurrency.equals("JPY")) {
            boolean a = amtDebetLabel.contains("Total to be debited");
            boolean b = debtAmt.contains("¥");
            boolean c = debtAmt.contains(loadAmt);
            boolean d = conversionRate.replaceAll("\\s", "").substring(0, 1).contains("円");
            System.out.println("Total to be debited: " + a);
            System.out.println("Total to be debited Currency: " + b);
            System.out.println("Total to be debited Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Debit wallet Currency: " + conversionRate.replaceAll("\\s", "").substring(0, 1));

            if (amtDebetLabel.contains("Total to be debited") && debtAmt.contains("¥") && debtAmt.contains(loadAmt) &&
                    conversionRate.replaceAll("\\s", "").substring(0, 1).contains("円"))
                return true;
            else
                return false;

        } else if (senderWalletCurrency.equals("CNY")) {
            boolean a = amtDebetLabel.contains("Total to be debited");
            boolean b = debtAmt.contains("¥");
            boolean c = debtAmt.contains(loadAmt);
            boolean d = conversionRate.replaceAll("\\s", "").substring(0, 1).contains("¥");
            System.out.println("Total to be debited: " + a);
            System.out.println("Total to be debited Currency: " + b);
            System.out.println("Total to be debited Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Debit wallet Currency: " + conversionRate.replaceAll("\\s", "").substring(0, 1));

            if (amtDebetLabel.contains("Total to be debited") && debtAmt.contains("¥") && debtAmt.contains(loadAmt) &&
                    conversionRate.replaceAll("\\s", "").substring(0, 1).contains("¥"))
                return true;
            else
                return false;
        }
        return false;
    }

    public boolean loadCreditSummaryCheck() {
        if (receiverCardCurrency.equals("USD")) {
            boolean a = amtReceiveLabel.contains("Total to be received");
            boolean b = receiveAmt.contains("$");
            boolean c = Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5;
            boolean d = conversionRate.replaceAll("\\s", "").substring(3, 4).contains("$");
            System.out.println("Total to be received: " + a);
            System.out.println("Total to be received Currency: " + b);
            System.out.println("Total to be received Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Credit wallet Currency: " + conversionRate.replaceAll("\\s", "").substring(3, 4));
            System.out.println("Calcualtion Difference: " + (Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt)));

            if (amtReceiveLabel.contains("Total to be received") && receiveAmt.contains("$") && Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5 &&
                    conversionRate.replaceAll("\\s", "").substring(3, 4).contains("$"))
                return true;
            else
                return false;

        } else if (receiverCardCurrency.equals("EUR")) {
            boolean a = amtReceiveLabel.contains("Total to be received");
            boolean b = receiveAmt.contains("€");
            boolean c = Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5;
            boolean d = conversionRate.replaceAll("\\s", "").substring(3, 4).contains("€");
            System.out.println("Total to be received: " + a);
            System.out.println("Total to be received Currency: " + b);
            System.out.println("Total to be received Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Credit wallet Currency: " + conversionRate.replaceAll("\\s", "").substring(3, 4));
            System.out.println("Calcualtion Difference: " + (Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt)));

            if (amtReceiveLabel.contains("Total to be received") && receiveAmt.contains("€") && Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5 &&
                    conversionRate.replaceAll("\\s", "").substring(3, 4).contains("€"))
                return true;
            else
                return false;

        } else if (receiverCardCurrency.equals("GBP")) {
            boolean a = amtReceiveLabel.contains("Total to be received");
            boolean b = receiveAmt.contains("£");
            boolean c = Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5;
            boolean d = conversionRate.replaceAll("\\s", "").substring(3, 4).contains("£");
            System.out.println("Total to be received: " + a);
            System.out.println("Total to be received Currency: " + b);
            System.out.println("Total to be received Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Credit wallet Currency: " + conversionRate.replaceAll("\\s", "").substring(3, 4));
            System.out.println("Calcualtion Difference: " + (Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt)));

            if (amtReceiveLabel.contains("Total to be received") && receiveAmt.contains("£") && Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5 &&
                    conversionRate.replaceAll("\\s", "").substring(3, 4).contains("£"))
                return true;
            else
                return false;

        } else if (receiverCardCurrency.equals("JPY")) {
            boolean a = amtReceiveLabel.contains("Total to be received");
            boolean b = receiveAmt.contains("¥");
            boolean c = Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < 1;
            boolean d = conversionRate.replaceAll("\\s", "").substring(3, 4).contains("円");
            System.out.println("Total to be received: " + a);
            System.out.println("Total to be received Currency: " + b);
            System.out.println("Total to be received Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Credit wallet Currency: " + conversionRate.replaceAll("\\s", "").substring(3, 4));

            if (amtReceiveLabel.contains("Total to be received") && receiveAmt.contains("¥") && Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < 1 &&
                    conversionRate.replaceAll("\\s", "").substring(3, 4).contains("円"))
                return true;
            else
                return false;

        } else if (receiverCardCurrency.equals("CNY")) {
            boolean a = amtReceiveLabel.contains("Total to be received");
            boolean b = receiveAmt.contains("¥");
            boolean c = Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5;
            boolean d = conversionRate.replaceAll("\\s", "").substring(3, 4).contains("¥");
            System.out.println("Total to be received: " + a);
            System.out.println("Total to be received Currency: " + b);
            System.out.println("Total to be received Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Credit wallet Currency: " + conversionRate.replaceAll("\\s", "").substring(3, 4));
            System.out.println("Calcualtion Difference: " + (Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt)));

            if (amtReceiveLabel.contains("Total to be received") && receiveAmt.contains("¥") && Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5 &&
                    conversionRate.replaceAll("\\s", "").substring(3, 4).contains("¥"))
                return true;
            else
                return false;
        }
        return false;
    }

    public boolean unloadDebitSummaryCheck() {
        if (senderCardCurrency.equals("USD")) {
            boolean a = amtDebetLabel.contains("Total to be debited");
            boolean b = debtAmt.contains("$");
            boolean c = debtAmt.contains(unloadAmt);
            boolean d = conversionRate.contains("$");
            System.out.println("Total to be debited: " + a);
            System.out.println("Total to be debited Currency: " + b);
            System.out.println("Total to be debited Amount: " + c);
            System.out.println("Conversion Currency: " + d);

            if (amtDebetLabel.contains("Total to be debited") && debtAmt.contains("$") && debtAmt.contains(unloadAmt) &&
                    conversionRate.contains("$"))
                return true;
            else
                return false;

        } else if (senderCardCurrency.equals("EUR")) {
            boolean a = amtDebetLabel.contains("Total to be debited");
            boolean b = debtAmt.contains("€");
            boolean c = debtAmt.contains(unloadAmt);
            boolean d = conversionRate.contains("€");
            System.out.println("Total to be debited: " + a);
            System.out.println("Total to be debited Currency: " + b);
            System.out.println("Total to be debited Amount: " + c);
            System.out.println("Conversion Currency: " + d);

            if (amtDebetLabel.contains("Total to be debited") && debtAmt.contains("€") && debtAmt.contains(unloadAmt) &&
                    conversionRate.contains("€"))
                return true;
            else
                return false;

        } else if (senderCardCurrency.equals("GBP")) {
            boolean a = amtDebetLabel.contains("Total to be debited");
            boolean b = debtAmt.contains("£");
            boolean c = debtAmt.contains(unloadAmt);
            boolean d = conversionRate.contains("£");
            System.out.println("Total to be debited: " + a);
            System.out.println("Total to be debited Currency: " + b);
            System.out.println("Total to be debited Amount: " + c);
            System.out.println("Conversion Currency: " + d);

            if (amtDebetLabel.contains("Total to be debited") && debtAmt.contains("£") && debtAmt.contains(unloadAmt) &&
                    conversionRate.contains("£"))
                return true;
            else
                return false;

        } else if (senderCardCurrency.equals("JPY")) {
            boolean a = amtDebetLabel.contains("Total to be debited");
            boolean b = debtAmt.contains("¥");
            boolean c = debtAmt.contains(unloadAmt);
            boolean d = conversionRate.contains("円");
            System.out.println("Total to be debited: " + a);
            System.out.println("Total to be debited Currency: " + b);
            System.out.println("Total to be debited Amount: " + c);
            System.out.println("Conversion Currency: " + d);

            if (amtDebetLabel.contains("Total to be debited") && debtAmt.contains("¥") && debtAmt.contains(unloadAmt) &&
                    conversionRate.contains("円"))
                return true;
            else
                return false;

        } else if (senderCardCurrency.equals("CNY")) {
            boolean a = amtDebetLabel.contains("Total to be debited");
            boolean b = debtAmt.contains("¥");
            boolean c = debtAmt.contains(unloadAmt);
            boolean d = conversionRate.contains("¥");
            System.out.println("Total to be debited: " + a);
            System.out.println("Total to be debited Currency: " + b);
            System.out.println("Total to be debited Amount: " + c);
            System.out.println("Conversion Currency: " + d);

            if (amtDebetLabel.contains("Total to be debited") && debtAmt.contains("¥") && debtAmt.contains(unloadAmt) &&
                    conversionRate.contains("¥"))
                return true;
            else
                return false;
        }
        return false;
    }

    public boolean unloadCreditSummaryCheck() {
        if (receiverWalletCurrency.equals("USD")) {
            boolean a = amtReceiveLabel.contains("Total to be received");
            boolean b = receiveAmt.contains("$");
            boolean c = Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5;
            boolean d = conversionRate.contains("$");
            System.out.println("Total to be received: " + a);
            System.out.println("Total to be received Currency: " + b);
            System.out.println("Total to be received Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Calcualtion Difference: " + (Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt)));

            if (amtReceiveLabel.contains("Total to be received") && receiveAmt.contains("$") && Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5 &&
                    conversionRate.contains("$"))
                return true;
            else
                return false;

        } else if (receiverWalletCurrency.equals("EUR")) {
            boolean a = amtReceiveLabel.contains("Total to be received");
            boolean b = receiveAmt.contains("€");
            boolean c = Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5;
            boolean d = conversionRate.contains("€");
            System.out.println("Total to be received: " + a);
            System.out.println("Total to be received Currency: " + b);
            System.out.println("Total to be received Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Calcualtion Difference: " + (Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt)));

            if (amtReceiveLabel.contains("Total to be received") && receiveAmt.contains("€") && Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5 &&
                    conversionRate.contains("€"))
                return true;
            else
                return false;

        } else if (receiverWalletCurrency.equals("GBP")) {
            boolean a = amtReceiveLabel.contains("Total to be received");
            boolean b = receiveAmt.contains("£");
            boolean c = Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5;
            boolean d = conversionRate.contains("£");
            System.out.println("Total to be received: " + a);
            System.out.println("Total to be received Currency: " + b);
            System.out.println("Total to be received Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Calcualtion Difference: " + (Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt)));

            if (amtReceiveLabel.contains("Total to be received") && receiveAmt.contains("£") && Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5 &&
                    conversionRate.contains("£"))
                return true;
            else
                return false;

        } else if (receiverWalletCurrency.equals("JPY")) {
            boolean a = amtReceiveLabel.contains("Total to be received");
            boolean b = receiveAmt.contains("¥");
            boolean c = Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5;
            boolean d = conversionRate.contains("円");
            System.out.println("Total to be received: " + a);
            System.out.println("Total to be received Currency: " + b);
            System.out.println("Total to be received Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Calcualtion Difference: " + (Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt)));

            if (amtReceiveLabel.contains("Total to be received") && receiveAmt.contains("¥") &&
                    Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5 &&
                    conversionRate.contains("円"))
                return true;
            else
                return false;

        } else if (receiverWalletCurrency.equals("CNY")) {
            boolean a = amtReceiveLabel.contains("Total to be received");
            boolean b = receiveAmt.contains("¥");
            boolean c = Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5;
            boolean d = conversionRate.contains("¥");
            System.out.println("Total to be received: " + a);
            System.out.println("Total to be received Currency: " + b);
            System.out.println("Total to be received Amount: " + c);
            System.out.println("Conversion Currency: " + d);
            System.out.println("Calcualtion Difference: " + (Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt)));

            if (amtReceiveLabel.contains("Total to be received") && receiveAmt.contains("¥") && Double.valueOf(receiveAmt.replaceAll("[^\\.\\d]", "")) - Double.valueOf(calculatedReceiveAmt) < .5 &&
                    conversionRate.contains("¥"))
                return true;
            else
                return false;
        }
        return false;
    }


}
