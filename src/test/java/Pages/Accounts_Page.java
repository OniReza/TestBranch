package Pages;

import Utility.*;
import io.cucumber.java.af.Maar;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static Utility.API.CurrencyExchangeRate.*;
import static Utility.UserProfile.cardLoad.clRate;


public class Accounts_Page extends CommonPageMethods {
    public static WebDriver driver;
    public double[] moveData = new double[3]; //used for store temp data for conv rate and reciver amt in move
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div[2]/div/div/div/div/div[2]")
    public WebElement graph;
    @FindBy(xpath = "(//span[text()='Accounts'])[1]")
    public WebElement accMenubtn;
    //Accounts Move xpaths
    @FindBy(xpath = "(//p[contains(text(),'Available Balance')])[1]")
    public WebElement usdWallet;
    @FindBy(xpath = "(//span[contains(text(),'Euro')])[1]")
    public WebElement euroWallet;
    @FindBy(xpath = "//span[contains(text(),'Pound Sterling')]")
    public WebElement gbpWallet;
    @FindBy(xpath = "//span[contains(text(),'Yen')]")
    public WebElement jpyWallet;
    @FindBy(xpath = "//span[contains(text(),'Yuan')]")
    public WebElement cnyWallet;
    @FindBy(xpath = "//span[contains(text(),'Peso')]")
    public WebElement phpWallet;
    @FindBy(xpath = "(//span[text()='Move'])")
    public WebElement moveTab;
    @FindBy(xpath = "//div[contains( text(),'Beneficiary')]")
    public WebElement selectBeneficiaryDropdown;
    @FindBy(xpath = "//Span[contains( text(),'$')]")
    public WebElement usdAcc;
    @FindBy(xpath = "//Span[contains( text(),'£')]")
    public WebElement gbpAcc;
    @FindBy(xpath = "//Span[contains( text(),'€')]")
    public WebElement euroAcc;
    @FindBy(xpath = "//span[contains( text(),'円')]")
    public WebElement jpyAcc;
    @FindBy(xpath = "//Span[contains( text(),'¥')]")
    public WebElement cnyAcc;
    @FindBy(xpath = "//Span[contains( text(),'₱')]")
    public WebElement phpAcc;
    @FindBy(xpath = "(//input[@type='number'])[1]")
    public WebElement sendAmount;
    @FindBy(xpath = "(//button[text()='Confirm'])")
    public WebElement confirmBtn;
    @FindBy(xpath = "//button[@role='button' and text()='Cancel' or text()='Cancel' ]")
    public WebElement cancelBtn;
    @FindBy(xpath = "//p[text()='2FA Verification']/../div[2]/div/div/input")
    public WebElement otpInput;
    @FindBy(xpath = "//p[text()='2FA Verification']/../div[3]/div/button[2]")
    public WebElement otpConfirmBtn;
    @FindBy(xpath = "(//span[contains(text(),'successfully')])")
    public WebElement sucessMsg;
    @FindBy(xpath = "(//button[@role='button' and text()='Ok' or text()='OK'])")
    public WebElement okBtn;
    @FindBy(xpath = "(//span[text()='Details'])")
    public WebElement detailsTab;
    //Accounts deposit
    @FindBy(xpath = "(//span[text()='Deposit'])")
    public WebElement depositTab;
    //    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/input")
    @FindBy(xpath = "//p[text()='From']/../div/i")
//    @FindBy(xpath = "//p[text()='From']/../div/input")
    public WebElement fromDropdwn;
    @FindBy(xpath = "//span[contains(text(),'Debit or Credit Card')]")
    public WebElement debitCard;
    @FindBy(xpath = "//input[@name='topUpAmount']")
    public WebElement loadAmount;
    @FindBy(xpath = "//div[@class='CheckboxWithValidation']")
    public WebElement trAggrement;
    @FindBy(xpath = "(//span[text()='Transfer Summary'])")
    public WebElement summary;
    @FindBy(xpath = "(//span[contains(text(),'Expedite Fee')])")
    public WebElement expeditSummary;
    @FindBy(xpath = "//b[contains(text(),'Congratulations')]")
    public WebElement loadSucessMsg;
    @FindBy(xpath = "//span[contains(text(),'Your payment request has been accepted.')]")
    public WebElement sucessMsgUS;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div[1]/div/div/div")
    public WebElement accountsTabUsd;
    @FindBy(xpath = "//span[contains(text(),'Local (US Bank)')]")
    public WebElement localUSBank;
    @FindBy(xpath = "//span[contains(text(),'Local (UK Bank)')]")
    public WebElement localUKBank;
    @FindBy(xpath = "//span[contains(text(),'International')]")
    public WebElement intlNonUKBank;

    @FindBy(xpath = "//p[text()='From']/../../..")
//    @FindBy(xpath = "//div[@class='topup-details']")
    public WebElement benFallBackRef;
    @FindBy(xpath = "//p[text()='Beneficiary']/../p[2]")
    public WebElement depBeneficiary;
    @FindBy(xpath = "//p[text()='Beneficiary Address']/../p[2]")
    public WebElement nonUkBenAddress;
    @FindBy(xpath = "//p[text()='Reference']/../p[2]")
    public WebElement depBenRef;
    @FindBy(xpath = "//p[text()='RTN']/../p[2]")
    public WebElement depRTN;
    @FindBy(xpath = "//p[text()='IBAN']/../p[2]")
    public WebElement nonUkIban;
    @FindBy(xpath = "//p[text()='BIC']/../p[2]")
    public WebElement depUkBic;
    @FindBy(xpath = "//p[text()='Sort Code']/../p[2]")
    public WebElement depSortCode;
    @FindBy(xpath = "//p[text()='Bank']/../p[2]")
    public WebElement depBank;
    @FindBy(xpath = "//p[text()='Bank Address']/../p[2]")
    public WebElement depBankAddress;
    @FindBy(xpath = "(//p[text()='Account Number']/../p[2])[2]")
    public WebElement depAccNumber;
    @FindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-container')]//parent::div[contains(@class,'MuiPaper-root wallet-card-layout')]")
    public WebElement localUSBankBeneficiary;
    @FindBy(xpath = "//span[contains(text(),'Crypto Deposit')]")
    public WebElement crypto;
    @FindBy(xpath = "(//input[@type='number'])[1]")
    public WebElement cryptoSendAmount;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/div/div[3]/div[1]/div/div[2]/div[2]/div/div[1]/label")
    public WebElement checkBox;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/div/div[3]/div[1]/div/div[2]/div[1]/div/div")
    public WebElement cryptoSummary;
    @FindBy(xpath = "(//span[text()='Payments'])")
    public WebElement paymentTabBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div/div[1]/div")
    public WebElement paymentTabPage;
    @FindBy(xpath = "(//span[text()='PAY'])[2]")
    public WebElement memberPayBtn;
//    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/main/div/div/div/div/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[1]")
    @FindBy(xpath = "//input[@class='search']/following::div[2]/div[2]")
    public WebElement beneficiary;
    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement paymentRef;
    @FindBy(xpath = "(//span[text()='Summary'])")
    public WebElement trnsSummary;
    @FindBy(xpath = "(//span[text()='PAY'])[1]")
    public WebElement makePayBtn;
    @FindBy(xpath = "//span[text()='Individual']")
    public WebElement individual;
    @FindBy(xpath = "//span[text()='New']")
    public WebElement newRecipient;
    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement fName;
    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lName;
    @FindBy(xpath = "//*[@id=\"mui-component-select-country\"]")
    public WebElement countryDropdown;
    @FindBy(xpath = "//li[contains(text(),'America')]")
    public WebElement america;
    @FindBy(xpath = "//li[contains(text(),'United Kingdom')]")
    public WebElement uk;
    @FindBy(xpath = "//li[contains(text(),'France')]")
    public WebElement france;
    @FindBy(xpath = "//li[contains(text(),'Bangladesh')]")
    public WebElement bd;

    @FindBy(xpath = "//li[contains(text(),'Philippines')]")
    public WebElement philippines;
    @FindBy(xpath = "//input[@name='addressLine1']")
    public WebElement addressLine;
    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;
    @FindBy(xpath = "//*[@id=\"mui-component-select-state\"]")
    public WebElement stateDropdown;
    @FindBy(xpath = "//span[text()='Arkansas']")
    public WebElement recipientState;
    @FindBy(xpath = "//input[@name='postCode']")
    public WebElement postCode;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;
    @FindBy(xpath = "//div[@class='selected-flag']")
    public WebElement phoneDropdown;
    @FindBy(xpath = "//li[@class='search search-class']/input[@type='search']")
    public WebElement phnSearchBox;
    @FindBy(xpath = "//li[@data-country-code='us']")
    public WebElement phnUS;
    @FindBy(xpath = "//input[@type='tel']")
    public WebElement phone;
    @FindBy(xpath = "//*[@id=\"mui-component-select-currency\"]/div/div[2]")
    public WebElement currencyDropdown;
//    @FindBy(xpath = "//*[@id=\"menu-currency\"]/div[3]/ul/li[1]/div/div[2]")
    @FindBy(xpath = "//li[@role='option' and @data-value='USD']")
    public WebElement usdCurrency;
    @FindBy(xpath = "//li[@role='option' and @data-value='GBP']")
    public WebElement gbpCurrency;
    @FindBy(xpath = "//li[@role='option' and @data-value='EUR']")
    public WebElement euroCurrency;
    @FindBy(xpath = "//li[@role='option' and @data-value='CNY']")
    public WebElement cnyCurrency;
    @FindBy(xpath = "//li[@role='option' and @data-value='JPY']")
    public WebElement jpyCurrency;
    @FindBy(xpath = "//li[@role='option' and @data-value='PHP']")
    public WebElement phpCurrency;
    @FindBy(xpath = "//*[@id=\"mui-component-select-bankCountry\"]")
    public WebElement bankCountryDropdown;
    @FindBy(xpath = "//label[contains(text(), 'Currency')]/../p")
    public WebElement bankCurrencyErrMsg;
    @FindBy(xpath = "//label[contains(text(),'Country of recipient')]/../p")
    public WebElement bankCountryErrMsg;
    @FindBy(xpath = "//label[text()='Amount']/../../div/span")
    public WebElement amountErrMsg;
    @FindBy(xpath = "//input[@name='bankName']")
    public WebElement bankName;
    @FindBy(xpath = "//input[@name='bankAddress']")
    public WebElement bankAddress;
    @FindBy(xpath = "//input[@name='bankCity']")
    public WebElement bankCity;
    @FindBy(xpath = "//*[@id=\"mui-component-select-bankState\"]")
    public WebElement bankStateDropdown;
    @FindBy(xpath = "(//span[text()='Delaware'])")
    public WebElement bankState;
    @FindBy(xpath = "//input[@name='bankPostCode']")
    public WebElement bankPostCode;
    @FindBy(xpath = "//input[@name='bankSortCode']")
    public WebElement bankSortCode;
    //    @FindBy(xpath = "//input[@name='bankIban']")
//    public WebElement bankSortCode;
    @FindBy(xpath = "//input[@name='bankRoutingNumber']")
    public WebElement bankRountingNum;
    @FindBy(xpath = "//input[@name='bankAccountNumber']")
    public WebElement bankAccNum;
    @FindBy(xpath = "//input[@name='bankAccountName']")
    public WebElement bankAccName;
    @FindBy(xpath = "//input[@name='amount']")
    public WebElement payAmount;
    @FindBy(xpath = "//span[text()='Now']")
    public WebElement now;
    @FindBy(xpath = "//input[@name='paymentReference']")
    public WebElement payRef;
    @FindBy(xpath = "//input[@name='reason']")
    public WebElement paymentReson;
    @FindBy(xpath = "//input[@name='note']")
    public WebElement paymentNote;
    @FindBy(xpath = "//span[text()='PAY']/..")
    public WebElement payBtn;
    @FindBy(xpath = "//span[text()='Request accepted']")
    public WebElement reqAcceptmsg;
    @FindBy(xpath = "//span[text()='Business']")
    public WebElement business;
    @FindBy(xpath = "//input[@name='businessName']")
    public WebElement busName;
    @FindBy(xpath = "//input[@name='registrationNumber']")
    public WebElement busRegNum;
    @FindBy(xpath = "//*[@id=\"mui-component-select-country\"]")
    public WebElement busCountry;
    @FindBy(xpath = "//span[text()='Existing']")
    public WebElement existing;
    @FindBy(xpath = "(//span[text()='Select'])[1]")
    public WebElement select;
    @FindBy(xpath = "//span[text()='Transactions']")
    public WebElement transactionsTab;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div[3]/div[2]/div/table/tbody/tr[1]/td[1]/a/span")
    public WebElement firstPTransaction;
    @FindBy(xpath = "(//span[contains(text(),' No records')])[1]")
    public WebElement noTransectionLabel;
    @FindBy(xpath = "(//span[text()='Statements'])")
    public WebElement statementsTabBtn;
    @FindBy(xpath = "(//button[contains(text(),'DOWNLOAD')])[1]")
    public WebElement downloadBtn;
    @FindBy(xpath = "(//a[contains(text(),'Export')])[1]")
    public WebElement exportPdf;
    @FindBy(xpath = "(//a[contains(text(),'Export')])[2]")
    public WebElement exportCsv;
    @FindBy(xpath = "//input[@placeholder=\"End Date\"]")
    public WebElement endDateCal;
    @FindBy(xpath = "(//span[text()='Withdraw'])")
    public WebElement withdrawTab;
    @FindBy(xpath = "(//div[@role=\"option\"])[1]")
    public WebElement withdrawExistingBeneficiary;
    @FindBy(xpath = "(//div[contains(text(),'Add')])")
    public WebElement addPersonalAccBtn;
    @FindBy(xpath = "//option[@value='US']")
    public WebElement countryUS;
    @FindBy(xpath = "//option[@value='USD']")
    public WebElement currencyUSD;
    @FindBy(xpath = "//button[@role='button' and text()='Next']")
    public WebElement nextBtn;
    @FindBy(xpath = "(//option[@value='Colorado'])")
    public WebElement stateColorado;
    @FindBy(xpath = "(//input[@name='beneficiaryReference'])")
    public WebElement beneficiaryReference;
    @FindBy(xpath = "(//input[@name='destinationBankName'])")
    public WebElement destinationBankName;
    @FindBy(xpath = "(//input[@name='addressLine1'])")
    public WebElement address;
    @FindBy(xpath = "(//input[@name='destinationBankCity'])")
    public WebElement destinationBankCity;
    @FindBy(xpath = "(//input[@name='sortCode'])")
    public WebElement sortCode;
    @FindBy(xpath = "(//input[@name='accountNo'])")
    public WebElement accountNo;
    @FindBy(xpath = "(//input[@name='swiftCode' or @name='bankSwiftCode'])")
    public WebElement swiftCode;
    @FindBy(xpath = "(//input[@name='iban' or @name='bankIban'])")
    public WebElement iban;
    @FindBy(xpath = "//span[text()='From']/../../div[2]/div[3]/p[2]")
    public WebElement payFromWalletCurr;
    @FindBy(xpath = "(//span[contains(text(),'Fee')]/../../div)[2]/span[2]")
    public WebElement paymentFee;
    @FindBy(xpath = "(//span[contains(text(),'Debit')]/../../div)[2]/span[2]")
    public WebElement totalDebitAmt;
    @FindBy(xpath = "(//span[contains(text(),'Send')]/../../div)[2]/span[2]")
    public WebElement totalSendAmt;
    @FindBy(xpath = "//span[contains(text(),'Rate')]/../span[2]")
    public WebElement paymentConversionRate;
    @FindBy(xpath = "(//div[@class='ui fitted checkbox Checkbox'])[1]")
    public WebElement expediteFee;
    @FindBy(xpath = "(//div[@class='ui fitted checkbox Checkbox'])[1]")
    public WebElement withdrawTransferAggrement;
    @FindBy(xpath = "(//span[text()='Pay'])")
    public WebElement payTab;
    @FindBy(xpath = "(//span[text()='PAY'])[1]")
    public WebElement ffPayBtn;
    @FindBy(xpath = "(//div[contains(text(),'Pay someone new')])")
    public WebElement paySomeoneNewBtn;
    @FindBy(xpath = "(//input[@name='firstName'])")
    public WebElement firstName;
    @FindBy(xpath = "(//input[@name='lastName'])")
    public WebElement lastName;
    @FindBy(xpath = "(//input[@name='dateOfBirth'])")
    public WebElement dob;
    // @FindBy(xpath = "(//input[@type='text']//parent::div[@class='ui input'])[1]")
    @FindBy(xpath = "(//div[@class='ui input']//child::input[@type='text'])[1]")
    public WebElement paymentReason;
    @FindBy(xpath = "(//div[@class='ui input']//child::input[@type='text'])[2]")
    public WebElement paymentReference;
    @FindBy(xpath = "(//span[text()='PAY'])[2]")
    public WebElement businessPayBtn;
    @FindBy(xpath = "(//div[contains(text(),'Pay to new business')])")
    public WebElement paynewBusinessBtn;
    @FindBy(xpath = "(//input[@name='businessName'])")
    public WebElement businessName;
    @FindBy(xpath = "(//input[@name='registrationNumber'])")
    public WebElement busRegNumber;
    @FindBy(xpath = "(//span[text()='PAY'])[3]")
    public WebElement anotherMemberPayBtn;
    //FEE  Calculation
    @FindBy(xpath = "//span[contains(text(),'Sending amount')]")
    public WebElement sendingAmount;
    @FindBy(xpath = "//span[contains(text(),'To Account')]")
    public WebElement moveAccNum;
    @FindBy(xpath = "//span[contains(text(),'Beneficiary Name:')]")
    public WebElement moveBeneficiary;
    @FindBy(xpath = "//span[contains(text(),'Fee amount')]")
    public WebElement feeAmount;
    @FindBy(xpath = "//span[contains(text(),'Total Amount')]")
    public WebElement totalAmount;
    @FindBy(xpath = "//span[contains(text(),'Receiving amount')]")
    public WebElement recivingAmount;
    @FindBy(xpath = "//span[contains(text(),'Dollar') or contains(text(),'Yen') or contains(text(),'Sterling')or contains(text(),'Euro') or contains(text(),'Yuan')]")
    public WebElement walletCurrency;
    @FindBy(xpath = "//p[text()='Account Number']/../p[2]")
    public WebElement walletAccNum;
    @FindBy(xpath = "//span[contains(text(),'1 ')][1]")
    public WebElement convRate;
    @FindBy(xpath = "//span[contains(text(),'Sending Amount')]")
    public WebElement sendAmt;
    @FindBy(xpath = "//span[contains(text(),'Transfer Fee')]")
    public WebElement transferFee;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div[16]/span")
    public WebElement receiveAmount;
    @FindBy(xpath = "(//input[@type='number'])[2]")
    public WebElement recAmtBox;
    //Transaction Assertion
    @FindBy(xpath = "(//table)[2]/tbody/tr[1]/th")
    public WebElement transDate;
    @FindBy(xpath = "(//table)[2]/tbody/tr[1]/td[1]")
    public WebElement transtype;
    @FindBy(xpath = "(//table)[2]/tbody/tr[1]/td[2]")
    public WebElement transRef;
    // @FindBy(xpath = "(//table)[2]/tbody/tr[1]/td[3]")
    @FindBy(xpath = "(//table)[2]/tbody/tr[1]/td[3]/span")
    public WebElement transAmt;
    @FindBy(xpath = "(((//table)[2]/tbody/tr)[1]/td/span/span)[2]")
    public WebElement refMoreBtn;
    @FindBy(xpath = "((//td/span/span/../../..)[1]/td/span/span)[3]")
    public WebElement descMoreBtn;
    @FindBy(xpath = "((//td/span/span/../../..)[1]/td/button/span)[1]")
    public WebElement transactionExpendBtn;
    @FindBy(xpath = "(//table)[2]/tbody/tr[1]/td[3]/div")
    public WebElement reciverdetails;
    @FindBy(xpath = "(//table)[2]/tbody/tr[1]/td[4]")
    public WebElement postTransBalance;
    @FindBy(xpath = "(//table)[2]/tbody/tr[1]/td[5]")
    public WebElement transDescription;
    @FindBy(xpath = "(//table)[2]/tbody/tr[1]/td[6]")
    public WebElement fee;
    @FindBy(xpath = "//span[text()='TRANSACTION FEE DETAILS']/../../table/tbody/tr/th/span")
    public WebElement feeTransDate;
    @FindBy(xpath = "(//span[text()='TRANSACTION FEE DETAILS']/../../table/tbody/tr/td/span)[1]")
    public WebElement feeTranstype;
    @FindBy(xpath = "(//span[text()='TRANSACTION FEE DETAILS']/../../table/tbody/tr/td/span)[2]")
    public WebElement transFeeRef;
    @FindBy(xpath = "//span[text()='TRANSACTION FEE DETAILS']/../../table/tbody/tr/td[3]/span")
    public WebElement transFeeAmt;
    @FindBy(xpath = "//span[text()='TRANSACTION FEE DETAILS']/../../table/tbody/tr/td[4]/span")
    public WebElement feeTransDescription;
    String memberName, depNonUkBenIban;
    @FindBy(xpath = "//div[1]/*[local-name() = 'svg']/../../div/p[1]")
    WebElement mName;
    API.CurrencyExchangeRate cr = new API.CurrencyExchangeRate();
    String receivingAmount = null;//used to temp store w2w feature
    String moveAmount = "300";
    int paymentAmt;
    String bankAccNumber, payFee, payReciveCurrency;
    String depositAmount = "";//used to temp store deposit amt
    String senderCurrency = ""; //used to temp store w2w sender's wallet currency
    String[] moveBenDetails = new String[3]; // used to temp store w2w beneficiary name,acc number & currency
    @FindBy(xpath = "(//div/p/..)[1]/p")
    WebElement CurrentwalletCurrency;
    @FindBy(xpath = "(//div/p/..)[1]/p")
    WebElement findWorkingWallet;
    @FindBy(xpath = "//div/p[contains(text(), \"Available Balance\")]/../p[2]")
    WebElement currentWalletBalance;
    int count = 0;

    public Accounts_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void getMemberName() {
        memberName = mName.getText();
    }

    public void withdrawTabClick() {
        withdrawTab.click();
    }

    public void addPersonalAccClick() {
        addPersonalAccBtn.click();
    }

    public void destinationBankCountry() throws InterruptedException {
        countryUS.click();
    }

    public void beneficiaryCurrencyClick() {
        currencyUSD.click();
    }

    public void nextBtnClick() {
        nextBtn.click();
    }

    public void withdrawBeneficiaryDetails() throws InterruptedException {
        countryUS.click();
        Thread.sleep(200);
        stateColorado.click();
        Thread.sleep(200);
        beneficiaryReference.sendKeys(Random_data.fullName());
        Thread.sleep(200);
        destinationBankName.sendKeys(Random_data.bankName());
        Thread.sleep(200);
        address.sendKeys(Random_data.address());
        Thread.sleep(200);
        destinationBankCity.sendKeys("Cansas");
        Thread.sleep(200);
        sortCode.sendKeys(Random_data.sortCode());
        Thread.sleep(200);
        accountNo.sendKeys(Random_data.bankAccNum());
        Thread.sleep(200);
        swiftCode.sendKeys("ESSEDE5F100");
        Thread.sleep(200);
        iban.sendKeys("US45154751915535805484966893");
    }

    public void beneficiaryCLick() {
        click(withdrawExistingBeneficiary);
    }

    public void withdrawCheckBox() throws InterruptedException {
        expediteFee.click();
        Thread.sleep(3000);
        withdrawTransferAggrement.click();
    }

    public void payTabClick() {
        payTab.click();
    }

    public void ffPayBtnClick() {
        ffPayBtn.click();
    }

    public void paySomeoneNewBtnClick() {
        paySomeoneNewBtn.click();
    }

    public void payFriendorFamilyDetails() throws InterruptedException {
        firstName.sendKeys(Random_data.firstName());
        Thread.sleep(200);
        lastName.sendKeys(Random_data.lastName());
        Thread.sleep(200);
        click(dob);
        Thread.sleep(200);
        dob.sendKeys("02052000");
        Thread.sleep(200);
        click(countryUS);
        Thread.sleep(500);
        click(stateColorado);
        Thread.sleep(200);
        beneficiaryReference.sendKeys(Random_data.fullName());
        Thread.sleep(200);
        destinationBankName.sendKeys(Random_data.bankName());
        Thread.sleep(200);
        address.sendKeys(Random_data.address());
        Thread.sleep(200);
        destinationBankCity.sendKeys("Cansas");
        Thread.sleep(200);
        sortCode.sendKeys(Random_data.sortCode());
        Thread.sleep(200);
        accountNo.sendKeys(Random_data.bankAccNum());
        Thread.sleep(200);
        swiftCode.sendKeys("ESSEDE5F100");
        Thread.sleep(200);
        iban.sendKeys("US45154751915535805484966893");
    }

    public void paymentReason() {
        paymentReason.sendKeys("Automation portal");
    }

    public void paymentRef() {
        paymentReference.sendKeys("Automation");

    }

    public void businessPayBtnClick() {
        businessPayBtn.click();
    }

    public void payNewBusinessClick() {
        paynewBusinessBtn.click();
    }

    public void payBusinessDetails() throws InterruptedException {
        businessName.sendKeys(Random_data.firstName());
        Thread.sleep(200);
        busRegNumber.sendKeys(Random_data.businessRegNum());
        Thread.sleep(200);
        click(countryUS);
        Thread.sleep(500);
        click(stateColorado);
        Thread.sleep(200);
        beneficiaryReference.sendKeys(Random_data.fullName());
        Thread.sleep(200);
        destinationBankName.sendKeys(Random_data.bankName());
        Thread.sleep(200);
        address.sendKeys(Random_data.address());
        Thread.sleep(200);
        destinationBankCity.sendKeys("Cansas");
        Thread.sleep(200);
        sortCode.sendKeys(Random_data.sortCode());
        Thread.sleep(200);
        accountNo.sendKeys(Random_data.bankAccNum());
        Thread.sleep(200);
        swiftCode.sendKeys("ESSEDE5F100");
        Thread.sleep(200);
        iban.sendKeys("US45154751915535805484966893");
    }

    public void anotherMemberPayBtnClick() {
        anotherMemberPayBtn.click();
    }

    public Boolean checkGraph() {
        return graph.isDisplayed();
    }

    public void localUSBankClick() {
        localUSBank.click();
    }

    public void intlNonUKBankClick() {
        intlNonUKBank.click();
        depNonUkBenIban = nonUkIban.getText();
    }

    public void localUKBankClick() {
        localUKBank.click();
    }

    public boolean fallBackDataCheck() {
       if (benFallBackRef.getText().contains("Reference\n" + "Please ensure you put your account number in the reference"))
           return true;
       else
           return false;
    }

    public boolean localUSBankBeneficiaryCheck() {
        if (walletCurrency.getText().contains("Pound Sterling") || (walletCurrency.getText().contains("Euro")) || (walletCurrency.getText().contains("Japanese Yen")) || (walletCurrency.getText().contains("Chinese Yuan"))) {
            System.out.println("Beneficiary match: " + depBeneficiary.getText().equals("CoinX"));
            System.out.println("Reference Match: " + depBenRef.getText().equals(walletAccNum.getText()));
            System.out.println("RTN Match: " + depRTN.getText().trim().equals("026013356"));
            System.out.println("Ref Number Match: " + depBenRef.getText().equals(walletAccNum.getText()));
            System.out.println("Bank ACc match: " + depAccNumber.getText().trim().equals("0299007499"));

            if (depBeneficiary.getText().equals("CoinX") && depBenRef.getText().equals(walletAccNum.getText()) && depRTN.getText().trim().equals("026013356")
                    && depAccNumber.getText().trim().equals("0299007499") && depBank.getText().equals("Metropolitan Commercial Bank"))
                return true;
            else
                return false;
        } else if (walletCurrency.getText().contains("US Dollar")) {
            System.out.println("Beneficiary match: " + depBeneficiary.getText().equals(memberName));
            System.out.println("RTN match: " + depRTN.getText().trim().equals("026013356"));
            System.out.println("Bank name match: " + depBank.getText().trim().equals("Metropolitan Commercial Bank"));
            System.out.println("Bank address match: " + depBankAddress.getText().trim().equals("99 Park Ave, 4th Fl, New York City, NY, 10016, United States"));

            if (depBeneficiary.getText().equals(memberName) && depRTN.getText().trim().equals("026013356") && depBank.getText().trim().equals("Metropolitan Commercial Bank") &&
                    depBankAddress.getText().trim().equals("99 Park Ave, 4th Fl, New York City, NY, 10016, United States"))
                return true;
            else
                return false;
        } else {
            return false;
        }
    }


    public boolean localUSBankCreatedBeneficiaryCheck() {
        System.out.println("Beneficiary match: " + depBeneficiary.getText().equals(memberName));
        System.out.println("RTN match: " + depRTN.getText().trim().equals("026013356"));
        System.out.println("Bank name match: " + depBank.getText().trim().equals("Metropolitan Commercial Bank"));
        System.out.println("Bank address match: " + depBankAddress.getText().trim().equals("99 Park Ave, 4th Fl, New York City, NY, 10016, United States"));
        System.out.println( "Fallback indication :"+fallBackDataCheck());

        if (fallBackDataCheck()==false && depBeneficiary.getText().equals(memberName) && depRTN.getText().trim().equals("026013356") && depBank.getText().trim().equals("Metropolitan Commercial Bank") &&
                depBankAddress.getText().trim().equals("99 Park Ave, 4th Fl, New York City, NY, 10016, United States"))
            return true;
        else
            return false;
    }

    public boolean localUSBankFallBackBeneficiaryCheck() {
        if (walletCurrency.getText().contains("Pound Sterling") || (walletCurrency.getText().contains("Euro")) || (walletCurrency.getText().contains("Japanese Yen")) || (walletCurrency.getText().contains("Chinese Yuan"))) {
            System.out.println("Beneficiary match: " + depBeneficiary.getText().equals("CoinX"));
            System.out.println("Reference Match: " + depBenRef.getText().equals(walletAccNum.getText()));
            System.out.println("RTN Match: " + depRTN.getText().trim().equals("026013356"));
            System.out.println("Ref Number Match: " + depBenRef.getText().equals(walletAccNum.getText()));
            System.out.println("Bank ACc match: " + depAccNumber.getText().trim().equals("0299007499"));
            System.out.println( "Fallback indication :"+fallBackDataCheck());
            if (fallBackDataCheck()==true && depBeneficiary.getText().equals("CoinX") && depBenRef.getText().equals(walletAccNum.getText()) && depRTN.getText().trim().equals("026013356")
                    && depAccNumber.getText().trim().equals("0299007499") && depBank.getText().equals("Metropolitan Commercial Bank"))
                return true;
            else
                return false;
        }else
            return false;
    }


    public boolean intlNonUKBankCreatedBeneficiaryCheck() {
        if (walletCurrency.getText().contains("US Dollar") || (walletCurrency.getText().contains("Euro"))) {
            System.out.println("Beneficiary match: " + depBeneficiary.getText().equals(memberName));
            System.out.println("BIC Code Match: " + depUkBic.getText().equals("CLRBGB22"));
            System.out.println("Bank name match: " + depBank.getText().equals("Nvayo Ltd"));
            System.out.println("Bank address match: " + depBankAddress.getText().equals("1 King William Street, EC4N 7AF, London"));
            System.out.println( "Fallback indication :"+fallBackDataCheck());
            if (fallBackDataCheck()==false && depBeneficiary.getText().equals(memberName) && depUkBic.getText().equals("CLRBGB22") && depBank.getText().equals("Nvayo Ltd") && depBankAddress.getText().equals("1 King William Street, EC4N 7AF, London"))
                return true;
            else
                return false;
        } else if (walletCurrency.getText().contains("Pound Sterling")) {
            System.out.println("Virtual account created for GBP");
            System.out.println("Beneficiary match: " + depBeneficiary.getText().equals(memberName));
            System.out.println("BIC Code Match: " + depUkBic.getText().equals("NVAYGB"));
            System.out.println("Bank name match: " + depBank.getText().equals("Nvayo Ltd"));
            System.out.println("Bank address match: " + depBankAddress.getText().equals("1 King William Street, EC4N 7AF, London"));
            System.out.println( "Fallback indication :"+fallBackDataCheck());

            if (fallBackDataCheck()==false && depBeneficiary.getText().equals(memberName) && depUkBic.getText().equals("NVAYGB") && depBank.getText().equals("Nvayo Ltd")
                    && depBankAddress.getText().equals("1 King William Street, EC4N 7AF, London"))
                return true;
            else
                return false;
        } else
            return false;
    }

    public boolean intlNonUKBankFallBackBeneficiaryCheck() {
        System.out.println("Fall back data reference indication: " + benFallBackRef.isDisplayed());
        System.out.println("Beneficiary match: " + depBeneficiary.getText().equals("Nvayo Limited Segregated USD"));
        System.out.println("Beneficiary Address match: " + nonUkBenAddress.getText().equals("1 King William Street, London, EC4N 7AF, UK"));
        System.out.println("Reference  match: " + depBenRef.getText().equals(walletAccNum.getText()));
        System.out.println("BIC Code Match: " + depUkBic.getText().equals("BARCGB22"));
        System.out.println("Bank name match: " + depBank.getText().equals("Barclays Bank"));
        System.out.println("Bank address match: " + depBankAddress.getText().equals("1 Churchill Place, Leicester, England, LE87 2BB, UK"));
        System.out.println( "Fallback indication :"+fallBackDataCheck());

        if (fallBackDataCheck()==true && benFallBackRef.isDisplayed() && depBeneficiary.getText().equals("Nvayo Limited Segregated USD") && nonUkBenAddress.getText().equals("1 King William Street, London, EC4N 7AF, UK") &&
                depBenRef.getText().equals(walletAccNum.getText()) && depUkBic.getText().equals("BARCGB22") && depBank.getText().equals("Barclays Bank")
                && depBankAddress.getText().equals("1 Churchill Place, Leicester, England, LE87 2BB, UK"))
            return true;
        else
            return false;

    }

    public boolean localUKBankCreatedBeneficiaryCheck() {
        if (walletCurrency.getText().contains("US Dollar") || (walletCurrency.getText().contains("Euro"))) {
            System.out.println("Beneficiary match: " + depBeneficiary.getText().equals(memberName));
            System.out.println("Sort Code Match: " + depSortCode.getText().equals("042729"));
            System.out.println("Account number match: " + depAccNumber.getText().equals(depNonUkBenIban.substring(14)));
            System.out.println( "Fallback indication :"+fallBackDataCheck());

            if (fallBackDataCheck()==false && depBeneficiary.getText().equals(memberName) && depSortCode.getText().equals("042729") &&
                    depAccNumber.getText().trim().equals(depNonUkBenIban.trim().substring(14)))
                return true;
            else
                return false;
        } else if (walletCurrency.getText().contains("Pound Sterling")) {
            System.out.println("Virtual account created for GBP wallet");
            System.out.println("Beneficiary match: " + depBeneficiary.getText().equals(memberName));
            System.out.println("Sort Code Match: " + depSortCode.getText().equals(depNonUkBenIban.substring(8, 14)));
            System.out.println("Account number match: " + depAccNumber.getText().equals(depNonUkBenIban.substring(14)));
            System.out.println( "Fallback indication :"+fallBackDataCheck());

            if (fallBackDataCheck()==false && depBeneficiary.getText().equals(memberName) && depSortCode.getText().equals(depNonUkBenIban.substring(8, 14)) && depAccNumber.getText().equals(depNonUkBenIban.substring(14)))
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    public boolean localUKBankFallBackBeneficiaryCheck() {
        System.out.println("Fallback data reference indication: " + benFallBackRef.isDisplayed());
        System.out.println("Beneficiary match: " + depBeneficiary.getText().equals("Nvayo"));
        System.out.println("Reference match: " + depBenRef.getText().equals(walletAccNum.getText()));
        System.out.println("Sort Code Match: " + depSortCode.getText().equals("200000"));
        System.out.println("Account number match: " + depAccNumber.getText().equals(depNonUkBenIban.substring(14)));
        System.out.println( "Fallback indication :"+fallBackDataCheck());

        if (fallBackDataCheck()==true && benFallBackRef.isDisplayed() && depBeneficiary.getText().equals("Nvayo") && depBenRef.getText().equals(walletAccNum.getText()) && depSortCode.getText().equals("200000") &&
                depAccNumber.getText().equals(depNonUkBenIban.trim().substring(14)))
            return true;
        else
            return false;
    }

    public void cryptoClick() {
        crypto.click();
    }

    public void enterCryptoSendAmount() {
        cryptoSendAmount.sendKeys(".1");
    }

    public void checkBoxClick() throws InterruptedException {
        checkBox.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(5000);
        checkBox.click();
    }

    public boolean cryptoSummaryCheck() {
        return cryptoSummary.isDisplayed();
    }

    public void accMenuClick() {
        accMenubtn.click();
    }

    public void usdWalletClick() {
        usdWallet.click();
    }

    public void euroAccClick() {
        euroAcc.click();
    }
    public void phpAccClick() {
        phpAcc.click();
    }

    public void euroWalletClick() {
        euroWallet.click();
    }

    public void gbpWalletClick() {
        gbpWallet.click();
    }

    public void jpyWalletClick() {
        jpyWallet.click();
    }

    public void cnyWalletClick() {
        cnyWallet.click();
    }

    public void phpWalletClick() {
        phpWallet.click();
    }

    public void moveTabClick() {
        moveTab.click();
    }

    public void benDropdownClick() {
        selectBeneficiaryDropdown.click();
    }

    public void jpyAccClick() {
        jpyAcc.click();
    }

    public void cnyAccClick() {
        cnyAcc.click();
    }

    public void usdAccClick() {
        usdAcc.click();
    }

    public void gbpAccClick() {
        gbpAcc.click();
    }

    public void enterm2mAmount(String amt) {
        sendAmount.sendKeys(amt);
    }

    public void enterSendingAmount(String amt) {
        moveAmount = amt;
        sendAmount.sendKeys(moveAmount);
    }

    public void confirmBtnClick() {
        confirmBtn.sendKeys(Keys.PAGE_DOWN);
        confirmBtn.click();
    }

    public void cancelBtnClick() {
        cancelBtn.click();
    }

    public void enterSecretCode() throws Exception {
        String Otp = BaseData.BaseOtp();
        Thread.sleep(2000);
        otpInput.sendKeys(Otp);
    }

    public void enterOtpCode() throws Exception {
        String Otp = BaseData.BaseOtp();
        otpInput.sendKeys(Otp);
        otpConfirmBtn.click();
    }

    public boolean checkSuccessMsg() {
        okBtn.sendKeys(Keys.PAGE_DOWN);
        return sucessMsg.isDisplayed();
    }

    public void okBtnClick() {
        okBtn.click();
    }

    public boolean checkDetailsTab() {
        return detailsTab.isDisplayed();
    }

    public void depositTabClick() {
        depositTab.click();
    }

    public void fromDropdwnClick() {
        fromDropdwn.click();
    }

    public void debitCardClick() {
        debitCard.click();
    }

    public void enterLoadAmount(String amount) {
        depositAmount = amount;
        loadAmount.sendKeys(amount);
    }

    public void aggrementClick() {
        trAggrement.click();
    }

    public boolean checkDepositSummary() throws Exception {
        if (clRate != 0) {
            cr.getRate();
        }
        confirmBtn.sendKeys(Keys.PAGE_DOWN);
        DecimalFormat df = new DecimalFormat("#.##");
        String sAmt = sendingAmount.getText();
        String fAmt = feeAmount.getText();
        String tAmt = totalAmount.getText();
        String rAmt = recivingAmount.getText();
//      System.out.println("Given " + sAmt);
        System.out.println("Given Fee :" + fAmt);
        System.out.println("Given Total :" + tAmt);
//      System.out.println("Given " + rAmt);
        String[] p1 = {sAmt.replaceAll("[\\s,]+", "").substring(15), fAmt.replaceAll("[\\s,]+", "").substring(12), tAmt.replaceAll("[\\s,]+", "").substring(13), rAmt.replaceAll("[\\s,]+", "").substring(17)};
        String loadWalletCurrency = sAmt.replaceAll("[\\s,]+", "").substring(14, 15);
        double sendingAmount = Double.valueOf(p1[0]);
        double givenFee = Double.valueOf(p1[1]);
        double givenTotal = Double.valueOf(p1[2]);
        double givenReceiveAmount = Double.valueOf(p1[3]);
        if (loadWalletCurrency.contains("$")) {
            System.out.println("In USD Wallet");
            double calculatedFee = Double.valueOf(df.format(sendingAmount * clRate * ToUSD));
            double calculatedTotal = Double.valueOf(sendingAmount + calculatedFee);
            System.out.println("Calculated Fee: " + calculatedFee);
            System.out.println("Calculated Total Amount: " + calculatedTotal);
//          System.out.println("Diff Given and Calculated Fee: " + Math.abs(Double.valueOf(df.format(calculatedFee - givenFee))));
            System.out.println("Diff Given and Calculated Total: " + Math.abs(Double.valueOf(df.format(givenTotal - calculatedTotal))));
            System.out.println();

            if ((Math.abs(calculatedFee - givenFee)) <= 1 && (Math.abs(givenTotal - calculatedTotal)) <= 1 && sendingAmount == givenReceiveAmount) {
                return recivingAmount.isDisplayed();
            } else {
                return false;
            }
        } else if (loadWalletCurrency.contains("€")) {
            System.out.println("In EURO Wallet");
            double calculatedFee = Double.valueOf(df.format(sendingAmount * clRate * ToEuro));
            double calculatedTotal = Double.valueOf(sendingAmount + calculatedFee);
            System.out.println("Calculated Fee: " + calculatedFee);
            System.out.println("Calculated Total Amount: " + calculatedTotal);
            System.out.println("Diff Given and Calculated Fee: " + Math.abs(Double.valueOf(df.format(calculatedFee - givenFee))));
            System.out.println("Diff Given and Calculated Total: " + Math.abs(Double.valueOf(df.format(givenTotal - calculatedTotal))));
            System.out.println();

            if ((Math.abs(calculatedFee - givenFee)) <= 1 && (Math.abs(givenTotal - calculatedTotal)) <= 1 && sendingAmount == givenReceiveAmount) {
                return recivingAmount.isDisplayed();
            } else {
                return false;
            }
        } else if (loadWalletCurrency.contains("£")) {
            System.out.println("In GBP Wallet");
            double calculatedFee = Double.valueOf(df.format(sendingAmount * clRate * ToGBP));
            double calculatedTotal = Double.valueOf(sendingAmount + calculatedFee);
            System.out.println("Calculated Fee: " + calculatedFee);
            System.out.println("Calculated Total Amount: " + calculatedTotal);
            System.out.println("Diff Given and Calculated Fee: " + Math.abs(Double.valueOf(df.format(calculatedFee - givenFee))));
            System.out.println("Diff Given and Calculated Total: " + Math.abs(Double.valueOf(df.format(givenTotal - calculatedTotal))));
            System.out.println();

            if ((Math.abs(calculatedFee - givenFee)) <= 1 && (Math.abs(givenTotal - calculatedTotal)) <= 1 && sendingAmount == givenReceiveAmount) {
                return recivingAmount.isDisplayed();
            } else {
                return false;
            }
        } else if (loadWalletCurrency.contains("¥") && walletCurrency.getText().contains("Yuan")) {
            System.out.println("In CNY Wallet");
            double calculatedFee = Double.valueOf(df.format(sendingAmount * clRate * ToCNY));
            double calculatedTotal = Double.valueOf(sendingAmount + calculatedFee);
            System.out.println("Calculated Fee: " + calculatedFee);
            System.out.println("Calculated Total Amount: " + calculatedTotal);
            System.out.println("Diff Given and Calculated Fee: " + Math.abs(Double.valueOf(df.format(calculatedFee - givenFee))));
            System.out.println("Diff Given and Calculated Total: " + Math.abs(Double.valueOf(df.format(givenTotal - calculatedTotal))));
            System.out.println();

            if ((Math.abs(calculatedFee - givenFee)) <= 7 && (Math.abs(givenTotal - calculatedTotal)) <= 7 && sendingAmount == givenReceiveAmount) {
                return recivingAmount.isDisplayed();
            } else {
                return false;
            }
        } else if (loadWalletCurrency.contains("¥") && walletCurrency.getText().contains("Yen")) {
            System.out.println("In JPY Wallet");
            double calculatedFee = Double.valueOf(df.format(sendingAmount * clRate * ToJPY));
            double calculatedTotal = Double.valueOf(sendingAmount + calculatedFee);
            System.out.println("Calculated Fee: " + calculatedFee);
            System.out.println("Calculated Total Amount: " + calculatedTotal);
            System.out.println("Diff Given and Calculated Fee: " + Math.abs(Double.valueOf(df.format(calculatedFee - givenFee))));
            System.out.println("Diff Given and Calculated Total: " + Math.abs(Double.valueOf(df.format(givenTotal - calculatedTotal))));
            System.out.println();

            if ((Math.abs(calculatedFee - givenFee)) <= 15 && (Math.abs(givenTotal - calculatedTotal)) <= 15 && sendingAmount == givenReceiveAmount) {
                return recivingAmount.isDisplayed();
            } else {
                return false;
            }
        } else return false;
    }

    public void getMoveAccountDetails() {
        String mA = moveAccNum.getText();
        String mB = moveBeneficiary.getText();
        String[] mA1 = mA.split(":");
        String[] mB1 = mB.split(":");
        moveBenDetails[0] = mA1[1].replaceAll("[^0-9]", "").trim();// To move acc number
        moveBenDetails[1] = mA1[1].replaceAll("[0-9()]", "").trim(); // To move Currency
        moveBenDetails[2] = mB1[1].replaceAll("[0-9()]", "").trim();// Move Beneficiary Name
    }

    public boolean checkMoveSummary() {
        String rate = convRate.getText();
        String sAmt = sendAmt.getText();
        String rAmt = receiveAmount.getText();
        String tAmt = totalAmount.getText();
        double conversionRate = Double.valueOf(rate.replaceAll("\\s", "").substring(5).replaceAll("[a-zA-Z]", ""));
        moveData[0] = conversionRate;
        double sendingAmount = Math.floor(Double.valueOf(sAmt.replaceAll("[\\s,]+", "").substring(15)));
        double amountoReceive = Math.floor(Double.valueOf(rAmt.replaceAll("[\\s,]+", "").substring(1)));
        moveData[1] = amountoReceive;
        double totalAmount = Math.floor(Double.valueOf(tAmt.replaceAll("[\\s,]+", "").substring(13)));
        System.out.println("Summary Rate: " + rate);
        System.out.println("Summary Sending Amount: " + sendingAmount);
        System.out.println("Summary Receiving Amount: " + amountoReceive);
        System.out.println("Summary Total Amount: " + totalAmount);
        System.out.println("Calculated Receiving Amount: " + Double.valueOf(moveAmount) * conversionRate);
        System.out.println("Diff of Receiving Amounts: " + Math.abs(Double.valueOf(moveAmount) * conversionRate - amountoReceive));

        if (Math.abs(Double.valueOf(moveAmount) * conversionRate - amountoReceive) <= 1.5 && Double.valueOf(totalAmount) == totalAmount) {
            return true;
        } else {
            return false;
        }
    }

    public String findSenderWallet() {
        senderCurrency = findWorkingWallet.getText();
        return findWorkingWallet.getText();
    }

    public String findRecieverWallet() {
        return moveBenDetails[1];
    }

    public void getRecieverAmount() {
        receivingAmount = receiveAmount.getText();
    }

    //Transection Assertion move
    public boolean moveSenderTransactionCheck() throws InterruptedException {
        refMoreBtn.click();
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String reciverDetails = reciverdetails.getText();
        String[] tr = reciverdetails.getText().replaceAll("[\\s,]", "").split("@");
        double rate = Double.valueOf(tr[1]);
        String[] reciverAmt = reciverDetails.replaceAll("[,]", "").split(" ");
        double reciverAmount = Double.valueOf(reciverAmt[1]);
        double reciveAmt = rate * (Double.parseDouble(moveAmount));

        int decimalPlaces = 2;
        DecimalFormat df = new DecimalFormat("#." + new String(new char[decimalPlaces]).replace("\0", "0"));
        double calReciveAmount = Double.parseDouble(df.format(reciveAmt));
        if (CurrentwalletCurrency.getText().contains("USD")) {
            boolean a = type.contains("Sent");
            boolean b = reference.contains("CCX - Wallet Transfer");
            boolean c = tAmount.contains("$");
            boolean d = tAmount.contains(String.valueOf(moveAmount));
            boolean e = reciverDetails.contains("GBP");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean h = reference.contains(moveBenDetails[2]);
            boolean i = reference.contains(moveBenDetails[1]);
            boolean j = description.contains(moveBenDetails[0]);
            boolean k = reciverDetails.contains("@");
            boolean l = feeAmt.contains("_");

            System.out.println("Type: " + a);
            System.out.println("Ref Static: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("Move Beneficiary Name: " + h);
            System.out.println("Move Beneficiary Currency: " + i);
            System.out.println("Move Beneficiary Acc Num: " + j);
            System.out.println("'@' is Present: " + k);
            System.out.println("Fee matched: " + l);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("CCX - Wallet Transfer") && reference.contains(moveBenDetails[2])
                    && reference.contains(moveBenDetails[1]) && tAmount.contains("$") && tAmount.contains(String.valueOf(moveAmount)) &&
                    reciverDetails.contains("GBP") && reciverDetails.contains("@") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    description.contains("USD wallet to wallet") && description.contains(moveBenDetails[0]) && feeAmt.contains("_"))

                return true;
            else
                return false;
        } else if (CurrentwalletCurrency.getText().contains("EUR")) {
            boolean a = type.contains("Sent");
            boolean b = reference.contains("CCX - Wallet Transfer");
            boolean c = tAmount.contains("€");
            boolean d = tAmount.contains(String.valueOf(moveAmount));
            boolean e = reciverDetails.contains("USD");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean h = reference.contains(moveBenDetails[2]);
            boolean i = reference.contains(moveBenDetails[1]);
            boolean j = description.contains(moveBenDetails[0]);
            boolean k = reciverDetails.contains("@");
            boolean l = feeAmt.contains("_");

            System.out.println("Type: " + a);
            System.out.println("Ref Static: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("Move Beneficiary Name: " + h);
            System.out.println("Move Beneficiary Currency: " + i);
            System.out.println("Move Beneficiary Acc Num: " + j);
            System.out.println("'@' is Present: " + k);
            System.out.println("Fee matched: " + l);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("CCX - Wallet Transfer") && reference.contains(moveBenDetails[2])
                    && reference.contains(moveBenDetails[1]) && tAmount.contains("€") && tAmount.contains(String.valueOf(moveAmount)) &&
                    reciverDetails.contains("USD") && reciverDetails.contains("@") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    description.contains("EUR wallet to wallet") && description.contains(moveBenDetails[0]) && feeAmt.contains("_"))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            boolean a = type.contains("Sent");
            boolean b = reference.contains("CCX - Wallet Transfer");
            boolean c = tAmount.contains("£");
            boolean d = tAmount.contains(String.valueOf(moveAmount));
            boolean e = reciverDetails.contains("EUR");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean h = reference.contains(moveBenDetails[2]);
            boolean i = reference.contains(moveBenDetails[1]);
            boolean j = description.contains(moveBenDetails[0]);
            boolean k = reciverDetails.contains("@");
            boolean l = feeAmt.contains("_");

            System.out.println("Type: " + a);
            System.out.println("Ref Static: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("Move Beneficiary Name: " + h);
            System.out.println("Move Beneficiary Currency: " + i);
            System.out.println("Move Beneficiary Acc Num: " + j);
            System.out.println("'@' is Present: " + k);
            System.out.println("Fee matched: " + l);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("CCX - Wallet Transfer") && reference.contains(moveBenDetails[2])
                    && reference.contains(moveBenDetails[1]) && tAmount.contains("£") && tAmount.contains(String.valueOf(moveAmount)) &&
                    reciverDetails.contains("EUR") && reciverDetails.contains("@") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    description.contains("GBP wallet to wallet") && description.contains(moveBenDetails[0]) && feeAmt.contains("_"))
                return true;
            else
                return false;


        } else if (CurrentwalletCurrency.getText().contains("CNY")) {
            boolean a = type.contains("Sent");
            boolean b = reference.contains("CCX - Wallet Transfer");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.contains(String.valueOf(moveAmount));
            boolean e = reciverDetails.contains("USD");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean h = reference.contains(moveBenDetails[2]);
            boolean i = reference.contains(moveBenDetails[1]);
            boolean j = description.contains(moveBenDetails[0]);
            boolean k = reciverDetails.contains("@");
            boolean l = feeAmt.contains("_");

            System.out.println("Type: " + a);
            System.out.println("Ref Static: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("Move Beneficiary Name: " + h);
            System.out.println("Move Beneficiary Currency: " + i);
            System.out.println("Move Beneficiary Acc Num: " + j);
            System.out.println("'@' is Present: " + k);
            System.out.println("Fee matched: " + l);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("CCX - Wallet Transfer") && reference.contains(moveBenDetails[2])
                    && reference.contains(moveBenDetails[1]) && tAmount.contains("¥") && tAmount.contains(String.valueOf(moveAmount)) &&
                    reciverDetails.contains("USD") && reciverDetails.contains("@") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    description.contains("CNY wallet to wallet") && description.contains(moveBenDetails[0]) && feeAmt.contains("_"))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("JPY")) {
            boolean a = type.contains("Sent");
            boolean b = reference.contains("CCX - Wallet Transfer");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.contains(String.valueOf(moveAmount));
            boolean e = reciverDetails.contains("GBP");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean h = reference.contains(moveBenDetails[2]);
            boolean i = reference.contains(moveBenDetails[1]);
            boolean j = description.contains(moveBenDetails[0]);
            boolean k = reciverDetails.contains("@");
            boolean l = feeAmt.contains("_");

            System.out.println("Type: " + a);
            System.out.println("Ref Static: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("JPY calReciveAmount: " + calReciveAmount);
            System.out.println("JPY reciverAmount: " + reciverAmount);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("Move Beneficiary Name: " + h);
            System.out.println("Move Beneficiary Currency: " + i);
            System.out.println("Move Beneficiary Acc Num: " + j);
            System.out.println("'@' is Present: " + k);
            System.out.println("Fee matched: " + l);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("CCX - Wallet Transfer") && reference.contains(moveBenDetails[2])
                    && reference.contains(moveBenDetails[1]) && tAmount.contains("¥") && tAmount.contains(String.valueOf(moveAmount)) &&
                    reciverDetails.contains("GBP") && reciverDetails.contains("@") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    description.contains("JPY wallet to wallet") && description.contains(moveBenDetails[0]) && feeAmt.contains("_"))
                return true;
            else
                return false;

        }else if (CurrentwalletCurrency.getText().contains("PHP")) {

            System.out.println("Type: " + type.contains("Sent"));
            System.out.println("Ref Static: " + reference.contains("CCX - Wallet Transfer"));
            System.out.println("Transfer Amount Currency: " + tAmount.contains("₱"));
            System.out.println("Transfer Amount: " + tAmount.contains(String.valueOf(moveAmount)));
            System.out.println("Receiver Currency: " + reciverDetails.contains("USD"));
            System.out.println("Amount calculation: " + (Math.abs(calReciveAmount - reciverAmount) < 0.1));
            System.out.println("JPY calReciveAmount: " + calReciveAmount);
            System.out.println("JPY reciverAmount: " + reciverAmount);
            System.out.println("Post balance in wallet and Transaction: " + postTAmount.equals(currWalletBalance));
            System.out.println("Move Beneficiary Name: " + reference.contains(moveBenDetails[2]));
            System.out.println("Move Beneficiary Currency: " + reference.contains(moveBenDetails[1]));
            System.out.println("Move Beneficiary Acc Num: " + description.contains(moveBenDetails[0]));
            System.out.println("'@' is Present: " + reciverDetails.contains("@"));
            System.out.println("Fee matched: " + feeAmt.contains("_"));
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("CCX - Wallet Transfer") && reference.contains(moveBenDetails[2])
                    && reference.contains(moveBenDetails[1]) && tAmount.contains("₱") && tAmount.contains(String.valueOf(moveAmount)) &&
                    reciverDetails.contains("USD") && reciverDetails.contains("@") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    description.contains("PHP wallet to wallet") && description.contains(moveBenDetails[0]) && feeAmt.contains("_"))
                return true;
            else
                return false;

        } else {
            System.out.println("Current wallet currency is different");
            return false;
        }
    }

    public boolean moveRecieverTransectionCheck() throws InterruptedException {
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("\\.\\d\\d", "").replaceAll("[\\s,]", "");
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("\\.\\d\\d", "").replaceAll("[\\s,]", "");

        System.out.println("type: " + type);
        System.out.println("reference: " + reference);
        System.out.println("tAmount: " + tAmount);
        System.out.println("postTAmount: " + postTAmount);
        System.out.println("description: " + description);
        System.out.println("feeAmt: " + feeAmt);
        System.out.println("currWalletBalance: " + currWalletBalance);
        System.out.println("receivingAmount: " + receivingAmount);

        if (CurrentwalletCurrency.getText().contains("USD")) {
            boolean a = type.contains("Received");
            boolean b = reference.contains("CCX - Wallet Transfer");
            boolean c = tAmount.contains(receivingAmount);
            boolean d = postTAmount.equals(currWalletBalance);
            boolean e = description.equals("w2w from " + senderCurrency + " wallet");
            boolean f = feeAmt.contains("_");
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transaction and Receive Amt: " + c);
            System.out.println("Post and curr balance: " + d);
            System.out.println("Description: " + e);
            System.out.println("Fee Amount: " + f);
            System.out.println("senderCurrency: " + senderCurrency);

            if (type.contains("Received") && reference.contains("CCX - Wallet Transfer") && tAmount.contains(receivingAmount.replaceAll("[\\s,]", "")) && postTAmount.equals(currWalletBalance) &&
                    description.equals("w2w from " + senderCurrency + " wallet") & feeAmt.contains("_"))
                return true;
            else
                return false;
        } else if (CurrentwalletCurrency.getText().contains("EUR")) {
            boolean a = type.contains("Received");
            boolean b = reference.contains("CCX - Wallet Transfer");
            boolean c = tAmount.contains(receivingAmount);
            boolean d = postTAmount.equals(currWalletBalance);
            boolean e = description.equals("w2w from GBP wallet");
            boolean f = feeAmt.contains("_");
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transaction and Receive Amt: " + c);
            System.out.println("Post and curr balance: " + d);
            System.out.println("Description: " + e);
            System.out.println("Fee Amount: " + f);
            System.out.println("senderCurrency: " + senderCurrency);

            if (type.contains("Received") && reference.contains("CCX - Wallet Transfer") && tAmount.contains(receivingAmount.replaceAll("[\\s,]", "")) && postTAmount.equals(currWalletBalance) &&
                    description.equals("w2w from " + senderCurrency + " wallet") & feeAmt.contains("_"))
                return true;
            else
                return false;
        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            boolean a = type.contains("Received");
            boolean b = reference.contains("CCX - Wallet Transfer");
            boolean c = tAmount.contains(receivingAmount);
            boolean d = postTAmount.equals(currWalletBalance);
            boolean e = description.equals("w2w from USD wallet");
            boolean f = feeAmt.contains("_");
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transaction and Receive Amt: " + c);
            System.out.println("Post and curr balance: " + d);
            System.out.println("Description: " + e);
            System.out.println("Fee Amount: " + f);
            System.out.println("senderCurrency: " + senderCurrency);

            if (type.contains("Received") && reference.contains("CCX - Wallet Transfer") && tAmount.contains(receivingAmount.replaceAll("[\\s,]", "")) && postTAmount.equals(currWalletBalance) &&
                    description.equals("w2w from " + senderCurrency + " wallet") & feeAmt.contains("_"))
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    public boolean checkExpeditSummary() {
        return expeditSummary.isDisplayed();
    }

    public boolean checkLoadSuccessMsg() {
        return loadSucessMsg.isDisplayed();
    }

    public boolean sucessMsgwithLoader() {
        return sucessMsgUS.isDisplayed();
    }

    public void clickOKbtn() {
        okBtn.click();
    }

    public boolean checkAccountsTab() {
        return accountsTabUsd.isDisplayed();
    }

    public void paymentTabClick() throws Exception {
        paymentTabBtn.click();
    }

    public boolean paymentPage() {
        return paymentTabPage.isDisplayed();
    }

    public void memberPayBtnClick() {
        memberPayBtn.click();
    }

    public void beneficiarySelect() {
        beneficiary.click();
    }

    public void enterPaymentRef() {
        paymentRef.sendKeys("Automation");
    }

    public boolean checkTransferSummary() {
        return trnsSummary.isDisplayed();
    }

    public void makePaymentClick() throws InterruptedException {
        makePayBtn.click();
        Thread.sleep(500);
    }

    public void toIndividual() {
        individual.click();
    }

    public void newBtnClick() throws Exception {
        newRecipient.click();
    }

    public void recipientDetails() throws InterruptedException {
        fName.sendKeys(Random_data.firstName());
        lName.sendKeys(Random_data.lastName());
        countryDropdown.click();
        Thread.sleep(300);
        america.click();
        addressLine.sendKeys(Random_data.address());
        city.sendKeys(Random_data.usCity());
        stateDropdown.click();
        Thread.sleep(300);
        recipientState.click();
        postCode.sendKeys(Random_data.postCode());
        email.sendKeys(Random_data.email());
        phoneDropdown.click();
        Thread.sleep(200);
        phnSearchBox.sendKeys("us");
        Thread.sleep(200);
        phnUS.click();
        phone.sendKeys("20255300169");
    }

    public void bankDetails() throws InterruptedException {
        click(currencyDropdown);
        Thread.sleep(300);
        usdCurrency.click();
        click(bankCountryDropdown);
        Thread.sleep(300);
        click(america);
        Thread.sleep(300);
        bankName.sendKeys("Bank of America");
        Thread.sleep(300);
        bankAddress.sendKeys("365 old street");
        Thread.sleep(300);
        bankCity.sendKeys(Random_data.usCity());
        Thread.sleep(300);
        click(bankStateDropdown);
        Thread.sleep(1500);
        click(bankState);
        Thread.sleep(300);
        bankPostCode.sendKeys(Random_data.postCode());
        Thread.sleep(300);
        bankRountingNum.sendKeys("233394133");
        Thread.sleep(300);
        bankAccNum.sendKeys(Random_data.bankAccNum());
        Thread.sleep(300);
        bankAccName.sendKeys(Random_data.fullName());
        Thread.sleep(300);
    }

    public void bankDetailsFP() throws InterruptedException {
        currencyDropdown.click();
        Thread.sleep(300);
        payReciveCurrency = gbpCurrency.getText();
        gbpCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(300);
        uk.click();
        bankName.sendKeys(" Barclays Bank");
        bankAddress.sendKeys("365 old street");
        bankPostCode.sendKeys(Random_data.postCode());
        bankSortCode.sendKeys(Random_data.sortCode());
        bankAccNumber = Random_data.bankAccNum();
        bankAccNum.sendKeys(bankAccNumber);
        bankAccName.sendKeys(Random_data.fullName() + " FP");
    }

    public void bankDetailsSepa() throws InterruptedException {
        currencyDropdown.click();
        Thread.sleep(200);
        payReciveCurrency = euroCurrency.getText();
        euroCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        france.click();
        bankName.sendKeys(" French Bank");
        bankAddress.sendKeys("365 old street");
        bankPostCode.sendKeys(Random_data.postCode());
        iban.sendKeys("FR316438082" + Random_data.postCode() + "493021712985");
        bankAccName.sendKeys(Random_data.fullName() + " SEPA");
    }

    public void bankDetailsAch() throws InterruptedException {
        currencyDropdown.click();
        Thread.sleep(200);
        payReciveCurrency = usdCurrency.getText();
        usdCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        america.click();
        bankName.sendKeys("Bank of America");
        bankAddress.sendKeys("365 old street");
        bankCity.sendKeys(Random_data.usCity());
        bankStateDropdown.click();
        Thread.sleep(200);
        bankState.click();
        bankPostCode.sendKeys(Random_data.postCode());
        bankRountingNum.sendKeys("233394133");
        bankAccNumber = Random_data.bankAccNum();
        bankAccNum.sendKeys(bankAccNumber);
        bankAccName.sendKeys(Random_data.fullName() + " ACH");
    }

    public void bankDetailsWir() throws InterruptedException {
        currencyDropdown.click();
        Thread.sleep(200);
        payReciveCurrency = cnyCurrency.getText();
        cnyCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        bd.click();
        bankName.sendKeys(" Bangladesh Bank");
        bankAddress.sendKeys("Dhaka 1210");
        bankPostCode.sendKeys(Random_data.postCode());
        iban.sendKeys("FR316438082" + Random_data.postCode() + "493021712985");
        swiftCode.sendKeys("ESSEDE5F100");
        bankAccName.sendKeys(Random_data.fullName() + " WIR");
    }

    public void bankDetailsPhptoPhp() throws InterruptedException {
        currencyDropdown.click();
        Thread.sleep(200);
        payReciveCurrency = cnyCurrency.getText();
        phpCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        philippines.click();
        bankName.sendKeys("Philippines Bank");
        bankAddress.sendKeys("Manila 1210");
        bankPostCode.sendKeys(Random_data.postCode());
        iban.sendKeys("FR316438082" + Random_data.postCode() + "493021712985");
        swiftCode.sendKeys("ESSEDE5F100");
        bankAccName.sendKeys(Random_data.fullName() + "WIR");
    }
    public void bankDetailsPhptoUsd() throws InterruptedException {
        currencyDropdown.click();
        Thread.sleep(200);
        payReciveCurrency = cnyCurrency.getText();
        usdCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        philippines.click();
        bankName.sendKeys("Philippines Bank");
        bankAddress.sendKeys("Manila 1210");
        bankPostCode.sendKeys(Random_data.postCode());
        bankAccNumber = Random_data.bankAccNum();
        bankAccNum.sendKeys(bankAccNumber);
        swiftCode.sendKeys("ESSEDE5F100");
        bankAccName.sendKeys(Random_data.fullName() + "WIR");
    }


    //Country: Philippines; Currency: Euro
    public boolean phpWrongBankCurrCheck1() throws InterruptedException {
        System.out.println("in 1");
        currencyDropdown.click();
        Thread.sleep(200);
        euroCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        philippines.click();
        if (bankCurrencyErrMsg.getText().trim().equals("Currency of the recipient must be Philippines Peso or US Dollar."))
            return true;
        else
            return false;

    }
    //Country: Philippines; Currency: GBP
    public boolean phpWrongBankCurrCheck2() throws InterruptedException {
        System.out.println("in 2");
        currencyDropdown.click();
        Thread.sleep(200);
        gbpCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        philippines.click();
        if (bankCurrencyErrMsg.getText().trim().equals("Currency of the recipient must be Philippines Peso or US Dollar."))
            return true;
        else
            return false;
    }
    //Country: Philippines; Currency: JPY
    public boolean phpWrongBankCurrCheck3() throws InterruptedException {
        System.out.println("in 3");
        currencyDropdown.click();
        Thread.sleep(200);
        jpyCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        philippines.click();
        if (bankCurrencyErrMsg.getText().trim().equals("Currency of the recipient must be Philippines Peso or US Dollar."))
            return true;
        else
            return false;
    }

    //Country: Philippines; Currency: CNY
    public boolean phpWrongBankCurrCheck4() throws InterruptedException {
        System.out.println("in 4 ");
        currencyDropdown.click();
        Thread.sleep(200);
        cnyCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        philippines.click();
        if (bankCurrencyErrMsg.getText().trim().equals("Currency of the recipient must be Philippines Peso or US Dollar."))
            return true;
        else
            return false;
    }
    //Country: Bangladesh; Currency: PHP
    public boolean phpWrongBankCurrCheck5() throws InterruptedException {
        System.out.println("in 5");
        currencyDropdown.click();
        Thread.sleep(200);
        cnyCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        bd.click();
        if (bankCountryErrMsg.getText().trim().equals("Country of the recipient's bank must be Philippines."))
            return true;
        else
            return false;
    }
    //Country: US; Currency: USD
    public boolean phpWrongBankCurrCheck6() throws InterruptedException {
        System.out.println("in 6");
        currencyDropdown.click();
        Thread.sleep(200);
        usdCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        america.click();
        if (bankCountryErrMsg.getText().trim().equals("Country of the recipient's bank must be Philippines."))
            return true;
        else
            return false;
    }
    //Country: UK; Currency: PHP
    public boolean phpWrongBankCurrCheck7() throws InterruptedException {
        System.out.println("in 7");
        currencyDropdown.click();
        Thread.sleep(200);
        phpCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        uk.click();
        if (bankCountryErrMsg.getText().trim().equals("Country of the recipient's bank must be Philippines."))
            return true;
        else
            return false;
    }
    //Country: bd; Currency: EURO
    public boolean phpWrongBankCurrCheck8() throws InterruptedException {
        System.out.println("in 8");
        currencyDropdown.click();
        Thread.sleep(200);
        euroCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        bd.click();
        if (bankCountryErrMsg.getText().trim().equals("Country of the recipient's bank must be Philippines.") && bankCurrencyErrMsg.getText().trim().equals("Currency of the recipient must be Philippines Peso or US Dollar."))
            return true;
        else
            return false;
    }
    //Country: Uk; Currency: GBP
    public boolean phpWrongBankCurrCheck9() throws InterruptedException {
        System.out.println("in 9");
        currencyDropdown.click();
        Thread.sleep(200);
        gbpCurrency.click();
        bankCountryDropdown.click();
        Thread.sleep(200);
        uk.click();
        if (bankCountryErrMsg.getText().trim().equals("Country of the recipient's bank must be Philippines.") && bankCurrencyErrMsg.getText().trim().equals("Currency of the recipient must be Philippines Peso or US Dollar."))
            return true;
        else
            return false;
    }
    public boolean amountErrMsgCheck()  {
        if (amountErrMsg.getText().trim().equals("Payment requested for invalid parameters. PHP wallet's payment can only be made in PHP or USD and to Philippines only."))
            return true;
        else
            return false;
    }
    public boolean payBtnEnableCheck(){
        if(payBtn.isEnabled())
            return true;
        else
            return false;
    }



    public void amount() throws InterruptedException {
        payAmount.sendKeys("20");
        Thread.sleep(3000);
    }

    public void amount(int amount) throws Exception {
        payAmount.clear();
        payAmount.clear();
        payAmount.sendKeys("" + amount);
        paymentAmt = amount;
        if (count == 0) {
            cr.getRate();
            count++;
        }
    }

    public boolean checkTotalDebitAmtFPRate() {
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {
            boolean a = Math.abs(paymentAmt * UserProfile.FP.fpRate * ToUSD - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpRate * ToUSD - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.FP.fpRate * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else if (walletCurrency.equals("EUR")) {
            boolean a = Math.abs(paymentAmt * UserProfile.FP.fpRate * ToEuro - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpRate * ToEuro - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.FP.fpRate * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;


        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            boolean a = Math.abs(paymentAmt * UserProfile.FP.fpRate * ToGBP - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpRate * ToGBP - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.FP.fpRate * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;


        } else if (walletCurrency.equals("JPY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.FP.fpRate * ToJPY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpRate * ToJPY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.FP.fpRate * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;


        } else if (walletCurrency.equals("CNY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.FP.fpRate * ToCNY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpRate * ToCNY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.FP.fpRate * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else {
            System.out.println("Wallet have different currency");
        }
        return false;
    }

    public boolean checkTotalDebitAmtFPMin() throws InterruptedException {
        Thread.sleep(6000);
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        payFee = fee;
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {

            if (UserProfile.FP.fpMin > 0) {

                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToUSD)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToUSD)));

                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToUSD))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.FP.fpRate * ToUSD - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpRate * ToUSD - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.FP.fpRate * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else if (walletCurrency.equals("EUR")) {
            if (UserProfile.FP.fpMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToEuro)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToEuro)));
                if (Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToEuro)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.FP.fpRate * ToEuro - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpRate * ToEuro - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.FP.fpRate * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            if (UserProfile.FP.fpMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToGBP)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToGBP)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToGBP))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.FP.fpRate * ToGBP - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpRate * ToGBP - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.FP.fpRate * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else if (walletCurrency.equals("JPY")) {
            if (UserProfile.FP.fpMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToJPY)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToJPY)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToJPY))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.FP.fpRate * ToJPY - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpRate * ToJPY - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.FP.fpRate * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else if (walletCurrency.equals("CNY")) {
            if (UserProfile.FP.fpMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToCNY)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToCNY)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.FP.fpMin * ToCNY))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.FP.fpRate * ToCNY - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpRate * ToCNY - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.FP.fpRate * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else {
            System.out.println("Wallet have different currency");
        }
        return false;
    }

    public boolean checkTotalDebitAmtFPFlat() {
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {
            boolean a = Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToUSD - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToUSD - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else if (walletCurrency.equals("EUR")) {
            boolean a = Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToEuro - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToEuro - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;


        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            boolean a = Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToGBP - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToGBP - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;


        } else if (walletCurrency.equals("JPY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToJPY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToJPY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;


        } else if (walletCurrency.equals("CNY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToCNY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToCNY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.FP.fpFlat * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else {
            System.out.println("Wallet have different currency");
        }
        return false;
    }

    public boolean checkTotalDebitAmtSepaRate() {
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {

            boolean a = Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToUSD - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToUSD - Double.parseDouble(fee)));

            if (Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else if (walletCurrency.equals("EUR")) {
            boolean a = Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToEuro - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToEuro - Double.parseDouble(fee)));

            if (Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else if (walletCurrency.equals("GBP")) {
            boolean a = Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToGBP - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToGBP - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else if (walletCurrency.equals("JPY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToJPY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToJPY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else if (walletCurrency.equals("CNY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToCNY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToCNY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else {
            System.out.println("Wallet have different currency");
        }
        return false;
    }

    public boolean checkTotalDebitAmtSepaMin() throws InterruptedException {
        Thread.sleep(10000);
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        payFee = fee;
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {

            if (UserProfile.SEPA.sepaMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToUSD)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToUSD)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToUSD))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToUSD - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToUSD - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }
        } else if (walletCurrency.equals("EUR")) {
            if (UserProfile.SEPA.sepaMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToEuro)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToEuro)));
                if (Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToEuro)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToEuro - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToEuro - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }
        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            if (UserProfile.SEPA.sepaMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToGBP)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToGBP)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToGBP))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToGBP - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToGBP - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }
        } else if (walletCurrency.equals("JPY")) {
            if (UserProfile.SEPA.sepaMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToJPY)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToJPY)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToJPY))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToJPY - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToJPY - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }
        } else if (walletCurrency.equals("CNY")) {
            if (UserProfile.SEPA.sepaMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToCNY)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToCNY)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaMin * ToCNY))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToCNY - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToCNY - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.SEPA.sepaRate * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }
        } else {
            System.out.println("Wallet have different currency");
        }
        return false;
    }

    public boolean checkTotalDebitAmtSepaFlat() throws InterruptedException {
        Thread.sleep(10000);
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        payFee = fee;
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {
            boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToUSD)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToUSD)));
            if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToUSD))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else if (walletCurrency.equals("EUR")) {

            boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToEuro)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToEuro)));
            if (Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToEuro)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToGBP)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToGBP)));
            if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToGBP))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else if (walletCurrency.equals("JPY")) {
            boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToJPY)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToJPY)));
            if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToJPY))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else if (walletCurrency.equals("CNY")) {
            boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToCNY)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToCNY)));
            if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.SEPA.sepaFlat * ToCNY))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;

        } else {
            System.out.println("Wallet have different currency");
        }
        return false;
    }


    public boolean checkTotalDebitAmtAchRate() {
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {
            boolean a = Math.abs(paymentAmt * UserProfile.ACH.achRate * ToUSD - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achRate * ToUSD - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.ACH.achRate * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("EUR")) {
            boolean a = Math.abs(paymentAmt * UserProfile.ACH.achRate * ToEuro - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achRate * ToEuro - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.ACH.achRate * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            boolean a = Math.abs(paymentAmt * UserProfile.ACH.achRate * ToGBP - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achRate * ToGBP - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.ACH.achRate * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("JPY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.ACH.achRate * ToJPY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achRate * ToJPY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.ACH.achRate * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("CNY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.ACH.achRate * ToCNY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achRate * ToCNY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.ACH.achRate * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else {
            System.out.println("Wallet have different currency");
        }
        return false;

    }

    public boolean checkTotalDebitAmtAchMin() throws InterruptedException {
        Thread.sleep(10000);
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        payFee = fee;
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {

            if (UserProfile.ACH.achMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToUSD)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToUSD)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToUSD))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.ACH.achRate * ToUSD - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achRate * ToUSD - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.ACH.achRate * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }


        } else if (walletCurrency.equals("EUR")) {
            if (UserProfile.ACH.achMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToEuro)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToEuro)));
                if (Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToEuro)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.ACH.achRate * ToEuro - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achRate * ToEuro - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.ACH.achRate * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }
        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            if (UserProfile.ACH.achMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToGBP)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToGBP)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToGBP))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.ACH.achRate * ToGBP - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achRate * ToGBP - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.ACH.achRate * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else if (walletCurrency.equals("JPY")) {
            if (UserProfile.ACH.achMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToJPY)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToJPY)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToJPY))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.ACH.achRate * ToJPY - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achRate * ToJPY - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.ACH.achRate * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else if (walletCurrency.equals("CNY")) {
            if (UserProfile.ACH.achMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToCNY)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToCNY)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.ACH.achMin * ToCNY))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.ACH.achRate * ToCNY - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achRate * ToCNY - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.ACH.achRate * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else {
            System.out.println("Wallet have different currency");
        }

        return false;

    }

    public boolean checkTotalDebitAmtAchFlat() {
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {
            boolean a = Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToUSD - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToUSD - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("EUR")) {
            boolean a = Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToEuro - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToEuro - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            boolean a = Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToGBP - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToGBP - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("JPY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToJPY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToJPY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("CNY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToCNY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToCNY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.ACH.achFlat * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else {
            System.out.println("Wallet have different currency");
        }
        return false;

    }

    public boolean checkTotalDebitAmtWirRate() {
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToUSD - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToUSD - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("EUR")) {
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToEuro - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToEuro - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToGBP - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToGBP - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("JPY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToJPY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToJPY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("CNY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToCNY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToCNY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        }else if (walletCurrency.equals("PHP")) {
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToPHP - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToPHP - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToPHP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else {
            System.out.println("Wallet have different currency");
        }
        return false;

    }

    public boolean checkTotalDebitAmtWirMin() throws InterruptedException {
        Thread.sleep(10000);
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        payFee = fee;
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {

            if (UserProfile.WIR.wirMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToUSD)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToUSD)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToUSD))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToUSD - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToUSD - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }


        } else if (walletCurrency.equals("EUR")) {
            if (UserProfile.WIR.wirMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToEuro)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToEuro)));
                if (Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToEuro)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToEuro - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToEuro - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }
        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            if (UserProfile.WIR.wirMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToGBP)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToGBP)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToGBP))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToGBP - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToGBP - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else if (walletCurrency.equals("JPY")) {
            if (UserProfile.WIR.wirMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToJPY)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToJPY)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToJPY))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToJPY - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToJPY - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else if (walletCurrency.equals("CNY")) {
            if (UserProfile.WIR.wirMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToCNY)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToCNY)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToCNY))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToCNY - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToCNY - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else if (walletCurrency.equals("PHP")) {
            if (UserProfile.WIR.wirMin > 0) {
                boolean a = Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToPHP)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToPHP)));
                if ((Math.abs((Double.parseDouble(fee)) - (UserProfile.WIR.wirMin * ToPHP))) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            } else {
                boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToPHP - Double.parseDouble(fee)) < .5;
                boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
                boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
                System.out.println("FEE Check: " + a);
                System.out.println("Total Debit Check: " + b);
                System.out.println("Send Amount: " + c);
                System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToPHP - Double.parseDouble(fee)));
                if (Math.abs(paymentAmt * UserProfile.WIR.wirRate * ToPHP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                    return true;
                else return false;
            }

        } else {
            System.out.println("Wallet have different currency");
        }

        return false;

    }

    public boolean checkTotalDebitAmtWirFlat() {
        String walletCurrency = payFromWalletCurr.getText();
        String fee = paymentFee.getText();
        String debitAmt = totalDebitAmt.getText();
        String sendAmt = totalSendAmt.getText();
        double convRate = Double.valueOf(paymentConversionRate.getText().replaceAll("[A-Za-z\\s]", "").substring(2));

        if (walletCurrency.equals("USD")) {
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToUSD - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToUSD - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToUSD - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("EUR")) {
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToEuro - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToEuro - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToEuro - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("GBP")) {
            System.out.println("In GBP");
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToGBP - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToGBP - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToGBP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("JPY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToJPY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToJPY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToJPY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else if (walletCurrency.equals("CNY")) {
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToCNY - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToCNY - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToCNY - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        }else if (walletCurrency.equals("PHP")) {
            boolean a = Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToPHP - Double.parseDouble(fee)) < .5;
            boolean b = Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5;
            boolean c = Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5;
            System.out.println("FEE Check: " + a);
            System.out.println("Total Debit Check: " + b);
            System.out.println("Send Amount: " + c);
            System.out.println("FEE diff: " + Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToPHP - Double.parseDouble(fee)));
            if (Math.abs(paymentAmt * UserProfile.WIR.wirFlat * ToPHP - Double.parseDouble(fee)) < .5 && Math.abs((Double.parseDouble(fee) + paymentAmt) - Double.parseDouble(debitAmt)) < .5 && Math.abs((paymentAmt * convRate) - (Double.parseDouble(sendAmt))) < .5)
                return true;
            else return false;
        } else {
            System.out.println("Wallet have different currency");
        }
        return false;

    }


    //transection tab
    public boolean transectionCheckFP() throws InterruptedException {
        refMoreBtn.click();
        int decimalPlaces = 2;
        DecimalFormat df = new DecimalFormat("#." + new String(new char[decimalPlaces]).replace("\0", "0"));
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        descMoreBtn.click();
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String reciverDetails = reciverdetails.getText();
        String[] tr = reciverdetails.getText().replaceAll("[\\s,]", "").split("@");
        double rate = Double.valueOf(tr[1]);
        String[] reciverAmt = reciverDetails.replaceAll("[,]", "").split(" ");
        double reciverAmount = Double.valueOf(reciverAmt[1]);
        double reciveAmt = rate * paymentAmt;
        double calReciveAmount = Double.parseDouble(df.format(reciveAmt));

        String[] pf = payFee.split("\\.");
        String paymentFee = pf[0];
        String[] str = payReciveCurrency.replaceAll("[)\\s]", "").split("\\(");
        String recieverCurrency = str[1];

        if (CurrentwalletCurrency.getText().contains("USD")) {
            System.out.println("In USD payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - FP Minimum Fee");
            boolean c = tAmount.contains("$");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("GBP");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - FP Minimum Fee") && tAmount.contains("$") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("GBP") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;


        } else if (CurrentwalletCurrency.getText().contains("EUR")) {
            System.out.println("In USD payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - FP Minimum Fee");
            boolean c = tAmount.contains("€");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("GBP");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - FP Minimum Fee") && tAmount.contains("€") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("GBP") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            System.out.println("In GBP payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - FP Minimum Fee");
            boolean c = tAmount.contains("£");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("GBP");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - FP Minimum Fee") && tAmount.contains("£") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("GBP") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("CNY")) {
            System.out.println("In CNY payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - FP Minimum Fee");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("GBP");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - FP Minimum Fee") && tAmount.contains("¥") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("GBP") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("JPY")) {
            System.out.println("In USD payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - FP Minimum Fee");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("GBP");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - FP Minimum Fee") && tAmount.contains("¥") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("GBP") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else {
            System.out.println("Curent wallet currency is diffrent");
            return false;
        }
    }

    public boolean transectionCheckFPGBP() throws InterruptedException {
        refMoreBtn.click();
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        descMoreBtn.click();
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String[] pf = payFee.split("\\.");
        String paymentFee = pf[0];

        System.out.println("In GBP FP payment");
        System.out.println("Wallet currency and Send currency is same");
        boolean a = type.contains("Sent");
        boolean b = reference.contains("WTT - Transfer - FP Minimum Fee");
        boolean c = tAmount.contains("£");
        boolean d = tAmount.contains(String.valueOf(paymentAmt));
        boolean g = postTAmount.equals(currWalletBalance);
        boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
        boolean m = feeAmt.contains(paymentFee);
        System.out.println("Type: " + a);
        System.out.println("Reference: " + b);
        System.out.println("Transfer Amount Currency: " + c);
        System.out.println("Transfer Amount: " + d);
        System.out.println("Post balance in wallet and Transaction: " + g);
        System.out.println("Description matched: " + l);
        System.out.println("FEE matched: " + m);
        System.out.println("postTAmount: " + postTAmount);
        System.out.println("currWalletBalance: " + currWalletBalance);


        if (type.contains("Sent") && reference.contains("WTT - Transfer - FP Minimum Fee") && tAmount.contains("£") && tAmount.contains(String.valueOf(paymentAmt))
                && postTAmount.equals(currWalletBalance) && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
            return true;
        else
            System.out.println("Current wallet currency is different");
        return false;

    }

    public boolean transectionCheckSEPA() throws InterruptedException {
        refMoreBtn.click();
        int decimalPlaces = 2;
        DecimalFormat df = new DecimalFormat("#." + new String(new char[decimalPlaces]).replace("\0", "0"));
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        descMoreBtn.click();
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String reciverDetails = reciverdetails.getText();
        String[] tr = reciverdetails.getText().replaceAll("[\\s,]", "").split("@");
        double rate = Double.valueOf(tr[1]);
        String[] reciverAmt = reciverDetails.replaceAll("[,]", "").split(" ");
        double reciverAmount = Double.valueOf(reciverAmt[1]);
        double reciveAmt = rate * paymentAmt;
        double calReciveAmount = Double.parseDouble(df.format(reciveAmt));

        String[] pf = payFee.split("\\.");
        String paymentFee = pf[0];
        String[] str = payReciveCurrency.replaceAll("[)\\s]", "").split("\\(");
        String recieverCurrency = str[1];

        if (CurrentwalletCurrency.getText().contains("USD")) {
            System.out.println("In USD payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - SEPA Minimum Fee");
            boolean c = tAmount.contains("$");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("EUR");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - SEPA Minimum Fee") && tAmount.contains("$") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("EUR") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
                return true;
            else
                return false;


        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            System.out.println("In GBP payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - SEPA Minimum Fee");
            boolean c = tAmount.contains("£");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("EUR");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - SEPA Minimum Fee") && tAmount.contains("£") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("EUR") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("CNY")) {
            System.out.println("In CNY payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - SEPA Minimum Fee");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("EUR");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - SEPA Minimum Fee") && tAmount.contains("¥") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("EUR") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("JPY")) {
            System.out.println("In USD payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - SEPA Minimum Fee");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("EUR");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - SEPA Minimum Fee") && tAmount.contains("¥") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("EUR") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else {
            System.out.println("Current wallet currency is different");
            return false;
        }
    }

    public boolean transactionCheckSEPAEUR() throws InterruptedException {
        refMoreBtn.click();
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        descMoreBtn.click();
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String[] pf = payFee.split("\\.");
        String paymentFee = pf[0];

        System.out.println("In EUR SEPA payment");
        System.out.println("Wallet currency and Send currency is same");
        boolean a = type.contains("Sent");
        boolean b = reference.contains("WTT - Transfer - SEPA Minimum Fee");
        boolean c = tAmount.contains("€");
        boolean d = tAmount.contains(String.valueOf(paymentAmt));
        boolean g = postTAmount.equals(currWalletBalance);
        boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
        boolean m = feeAmt.contains(paymentFee);
        System.out.println("Type: " + a);
        System.out.println("Reference: " + b);
        System.out.println("Transfer Amount Currency: " + c);
        System.out.println("Transfer Amount: " + d);
        System.out.println("Post balance in wallet and Transaction: " + g);
        System.out.println("Description matched: " + l);
        System.out.println("FEE matched: " + m);
        System.out.println("postTAmount: " + postTAmount);
        System.out.println("currWalletBalance: " + currWalletBalance);


        if (type.contains("Sent") && reference.contains("WTT - Transfer - SEPA Minimum Fee") && tAmount.contains("€") && tAmount.contains(String.valueOf(paymentAmt))
                && postTAmount.equals(currWalletBalance) && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
            return true;
        else
            System.out.println("Current wallet currency is different");
        return false;

    }


    public boolean transactionCheckACH() throws InterruptedException {
        refMoreBtn.click();
        int decimalPlaces = 2;
        DecimalFormat df = new DecimalFormat("#." + new String(new char[decimalPlaces]).replace("\0", "0"));
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        descMoreBtn.click();
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String reciverDetails = reciverdetails.getText();
        String[] tr = reciverdetails.getText().replaceAll("[\\s,]", "").split("@");
        double rate = Double.valueOf(tr[1]);
        String[] reciverAmt = reciverDetails.replaceAll("[,]", "").split(" ");
        double reciverAmount = Double.valueOf(reciverAmt[1]);
        double reciveAmt = rate * paymentAmt;
        double calReciveAmount = Double.parseDouble(df.format(reciveAmt));

        String[] pf = payFee.split("\\.");
        String paymentFee = pf[0];
        String[] str = payReciveCurrency.replaceAll("[)\\s]", "").split("\\(");
        String recieverCurrency = str[1];

        if (CurrentwalletCurrency.getText().contains("USD")) {
            System.out.println("In USD payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - ACH Minimum Fee");
            boolean c = tAmount.contains("$");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("USD");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - ACH Minimum Fee") && tAmount.contains("$") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("USD") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;


        } else if (CurrentwalletCurrency.getText().contains("EUR")) {
            System.out.println("In USD payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - ACH Minimum Fee");
            boolean c = tAmount.contains("€");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("USD");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - ACH Minimum Fee") && tAmount.contains("€") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("USD") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            System.out.println("In USD payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - ACH Minimum Fee");
            boolean c = tAmount.contains("£");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("USD");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - ACH Minimum Fee") && tAmount.contains("£") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("USD") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("CNY")) {
            System.out.println("In CNY payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - ACH Minimum Fee");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("USD");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - ACH Minimum Fee") && tAmount.contains("¥") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("USD") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("JPY")) {
            System.out.println("In USD payment");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - ACH Minimum Fee");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("USD");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - ACH Minimum Fee") && tAmount.contains("¥") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("USD") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else {
            System.out.println("Current wallet currency is diffrent");
            return false;
        }
    }

    public boolean transactionCheckUSDACH() throws InterruptedException {
        refMoreBtn.click();
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        descMoreBtn.click();
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String[] pf = payFee.split("\\.");
        String paymentFee = pf[0];

        System.out.println("In USD ACH payment");
        System.out.println("Wallet currency and Send currency is same");
        boolean a = type.contains("Sent");
        boolean b = reference.contains("WTT - Transfer - ACH Minimum Fee");
        boolean c = tAmount.contains("$");
        boolean d = tAmount.contains(String.valueOf(paymentAmt));
        boolean g = postTAmount.equals(currWalletBalance);
        boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
        boolean m = feeAmt.contains(paymentFee);
        System.out.println("Type: " + a);
        System.out.println("Reference: " + b);
        System.out.println("Transfer Amount Currency: " + c);
        System.out.println("Transfer Amount: " + d);
        System.out.println("Post balance in wallet and Transaction: " + g);
        System.out.println("Description matched: " + l);
        System.out.println(description.replaceAll("\\s", ""));
        System.out.println((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", ""));
        System.out.println("FEE matched: " + m);
        System.out.println("postTAmount: " + postTAmount);
        System.out.println("currWalletBalance: " + currWalletBalance);


        if (type.contains("Sent") && reference.contains("WTT - Transfer - ACH Minimum Fee") && tAmount.contains("$") && tAmount.contains(String.valueOf(paymentAmt))
                && postTAmount.equals(currWalletBalance) && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
            return true;
        else
            System.out.println("Current wallet currency is different");
        return false;

    }


    public boolean transactionCheckWIR() throws InterruptedException {
        refMoreBtn.click();
        int decimalPlaces = 2;
        DecimalFormat df = new DecimalFormat("#." + new String(new char[decimalPlaces]).replace("\0", "0"));
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        descMoreBtn.click();
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String reciverDetails = reciverdetails.getText();
        String[] tr = reciverdetails.getText().replaceAll("[\\s,]", "").split("@");
        double rate = Double.valueOf(tr[1]);
        String[] reciverAmt = reciverDetails.replaceAll("[,]", "").split(" ");
        double reciverAmount = Double.valueOf(reciverAmt[1]);
        double reciveAmt = rate * paymentAmt;
        double calReciveAmount = Double.parseDouble(df.format(reciveAmt));

        String[] pf = payFee.split("\\.");
        String paymentFee = pf[0];
        String[] str = payReciveCurrency.replaceAll("[)\\s]", "").split("\\(");
        String recieverCurrency = str[1];

        if (CurrentwalletCurrency.getText().contains("USD")) {
            System.out.println("In USD wallet for WIR transaction Check");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - WIR Minimum Fee");
            boolean c = tAmount.contains("$");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("CNY");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - WIR Minimum Fee") && tAmount.contains("$") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("CNY") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
                return true;
            else
                return false;


        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            System.out.println("In GBP wallet for WIR transaction Check");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - WIR Minimum Fee");
            boolean c = tAmount.contains("£");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("CNY");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - WIR Minimum Fee") && tAmount.contains("£") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("CNY") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("EUR")) {
            System.out.println("In EUR wallet for WIR transaction Check");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - WIR Minimum Fee");
            boolean c = tAmount.contains("€");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("CNY");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - WIR Minimum Fee") && tAmount.contains("€") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("CNY") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("JPY")) {
            System.out.println("In JPY wallet for WIR transaction Check");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - WIR Minimum Fee");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("CNY");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - WIR Minimum Fee") && tAmount.contains("¥") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("CNY") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
                return true;
            else
                return false;

        }else if (CurrentwalletCurrency.getText().contains("PHP")) {
            System.out.println("In PHP wallet for WIR transaction Check");
            boolean a = type.contains("Sent");
            boolean b = reference.contains("WTT - Transfer - WIR Minimum Fee");
            boolean c = tAmount.contains("₱");
            boolean d = tAmount.contains(String.valueOf(paymentAmt));
            boolean e = reciverDetails.contains("USD");
            boolean f = Math.abs(calReciveAmount - reciverAmount) < 0.1;
            boolean g = postTAmount.equals(currWalletBalance);
            boolean k = reciverDetails.contains("@");
            boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
            boolean m = feeAmt.contains(paymentFee);
            System.out.println("Type: " + a);
            System.out.println("Reference: " + b);
            System.out.println("Transfer Amount Currency: " + c);
            System.out.println("Transfer Amount: " + d);
            System.out.println("Receiver Currency: " + e);
            System.out.println("Amount calculation: " + f);
            System.out.println("Post balance in wallet and Transaction: " + g);
            System.out.println("'@' is Present: " + k);
            System.out.println("Description matched: " + l);
            System.out.println("FEE matched: " + m);
            System.out.println("Calculated receiver Amt: " + calReciveAmount);
            System.out.println("Given receiver Amt: " + reciverAmount);
            System.out.println("postTAmount: " + postTAmount);
            System.out.println("currWalletBalance: " + currWalletBalance);

            if (type.contains("Sent") && reference.contains("WTT - Transfer - WIR Minimum Fee") && tAmount.contains("₱") && tAmount.contains(String.valueOf(paymentAmt))
                    && reciverDetails.contains("USD") && Math.abs(calReciveAmount - reciverAmount) < 0.1 && postTAmount.equals(currWalletBalance) &&
                    reciverDetails.contains("@") && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual " + bankAccNumber).replaceAll("\\s", "")))
                return true;
            else
                return false;

        } else {
            System.out.println("Current wallet currency is different");
            return false;
        }
    }

    public boolean transactionCheckWIRCNY() throws InterruptedException {
        refMoreBtn.click();
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        descMoreBtn.click();
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String[] pf = payFee.split("\\.");
        String paymentFee = pf[0];

        System.out.println("In CNY WIR payment");
        System.out.println("Wallet currency and Send currency is same");
        boolean a = type.contains("Sent");
        boolean b = reference.contains("WTT - Transfer - WIR Minimum Fee");
        boolean c = tAmount.contains("¥");
        boolean d = tAmount.contains(String.valueOf(paymentAmt));
        boolean g = postTAmount.equals(currWalletBalance);
        boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
        boolean m = feeAmt.contains(paymentFee);
        System.out.println("Type: " + a);
        System.out.println("Reference: " + b);
        System.out.println("Transfer Amount Currency: " + c);
        System.out.println("Transfer Amount: " + d);
        System.out.println("Post balance in wallet and Transaction: " + g);
        System.out.println("Description matched: " + l);
        System.out.println(description.replaceAll("\\s", ""));
        System.out.println((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
        System.out.println("FEE matched: " + m);
        System.out.println("postTAmount: " + postTAmount);
        System.out.println("currWalletBalance: " + currWalletBalance);


        if (type.contains("Sent") && reference.contains("WTT - Transfer - WIR Minimum Fee") && tAmount.contains("¥") && tAmount.contains(String.valueOf(paymentAmt))
                && postTAmount.equals(currWalletBalance) && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
            return true;
        else
            System.out.println("Current wallet currency is different");
        return false;

    }

    public boolean transactionCheckWIRPhp() throws InterruptedException {
        refMoreBtn.click();
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        descMoreBtn.click();
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim().replaceAll("[^\\d.]+", "").replaceAll("\\.\\d+", "");
        String[] pf = payFee.split("\\.");
        String paymentFee = pf[0];

        System.out.println("In PHP WIR payment");
        System.out.println("Wallet currency and Send currency is same");
        boolean a = type.contains("Sent");
        boolean b = reference.contains("WTT - Transfer - WIR Minimum Fee");
        boolean c = tAmount.contains("₱");
        boolean d = tAmount.contains(String.valueOf(paymentAmt));
        boolean g = postTAmount.equals(currWalletBalance);
        boolean l = description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
        boolean m = feeAmt.contains(paymentFee);
        System.out.println("Type: " + a);
        System.out.println("Reference: " + b);
        System.out.println("Transfer Amount Currency: " + c);
        System.out.println("Transfer Amount: " + d);
        System.out.println("Post balance in wallet and Transaction: " + g);
        System.out.println("Description matched: " + l);
        System.out.println(description.replaceAll("\\s", ""));
        System.out.println((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", ""));
        System.out.println("FEE matched: " + m);
        System.out.println("postTAmount: " + postTAmount);
        System.out.println("currWalletBalance: " + currWalletBalance);


        if (type.contains("Sent") && reference.contains("WTT - Transfer - WIR Minimum Fee") && tAmount.contains("₱") && tAmount.contains(String.valueOf(paymentAmt))
                && postTAmount.equals(currWalletBalance) && description.replaceAll("\\s", "").equals((CurrentwalletCurrency.getText().trim() + " wallet to Individual undefined").replaceAll("\\s", "")))
            return true;
        else
            System.out.println("Current wallet currency is different");
        return false;

    }


    public boolean paymentTransactionFeeCheckFP() throws InterruptedException {
        String type = feeTranstype.getText().trim();
        String reference = transFeeRef.getText().trim();
        String feeAmt = transFeeAmt.getText().trim();
        String description = feeTransDescription.getText().trim();
        System.out.println();
        System.out.println();
        System.out.println(type);
        System.out.println(reference);
        System.out.println(feeAmt);
        System.out.println(description);
        System.out.println();
        System.out.println();

        if (CurrentwalletCurrency.getText().contains("USD")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - FP Minimum Fee");
            boolean c = feeAmt.contains("$");
            boolean d = description.equals("WTF - Fee - FP Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - FP Minimum Fee") && feeAmt.contains("$") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - FP Minimum Fee"))
                return true;
            else
                return false;
            //return true;
        } else if (CurrentwalletCurrency.getText().contains("EUR")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - FP Minimum Fee");
            boolean c = feeAmt.contains("€");
            boolean d = description.equals("WTF - Fee - FP Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - FP Minimum Fee") && feeAmt.contains("€") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - FP Minimum Fee"))
                return true;
            else
                return false;


        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - FP Minimum Fee");
            boolean c = feeAmt.contains("£");
            boolean d = description.equals("WTF - Fee - FP Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - FP Minimum Fee") && feeAmt.contains("£") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - FP Minimum Fee"))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("CNY")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - FP Minimum Fee");
            boolean c = feeAmt.contains("¥");
            boolean d = description.equals("WTF - Fee - FP Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - FP Minimum Fee") && feeAmt.contains("¥") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - FP Minimum Fee"))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("JPY")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - FP Minimum Fee");
            boolean c = feeAmt.contains("¥");
            boolean d = description.equals("WTF - Fee - FP Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - FP Minimum Fee") && feeAmt.contains("¥") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - FP Minimum Fee"))
                return true;
            else
                return false;

        } else {
            System.out.println("Current wallet currency is different");
            return false;
        }

    }

    public boolean paymentTransactionFeeCheckSepa() throws InterruptedException {
        String type = feeTranstype.getText().trim();
        String reference = transFeeRef.getText().trim();
        String feeAmt = transFeeAmt.getText().trim();
        String description = feeTransDescription.getText().trim();
        System.out.println();
        System.out.println();
        System.out.println(type);
        System.out.println(reference);
        System.out.println(feeAmt);
        System.out.println(description);
        System.out.println();
        System.out.println();

        if (CurrentwalletCurrency.getText().contains("USD")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - SEPA Minimum Fee");
            boolean c = feeAmt.contains("$");
            boolean d = description.equals("WTF - Fee - SEPA Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - SEPA Minimum Fee") && feeAmt.contains("$") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - SEPA Minimum Fee"))
                return true;
            else
                return false;
            //return true;
        } else if (CurrentwalletCurrency.getText().contains("EUR")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - SEPA Minimum Fee");
            boolean c = feeAmt.contains("€");
            boolean d = description.equals("WTF - Fee - SEPA Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - SEPA Minimum Fee") && feeAmt.contains("€") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - SEPA Minimum Fee"))
                return true;
            else
                return false;


        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - SEPA Minimum Fee");
            boolean c = feeAmt.contains("£");
            boolean d = description.equals("WTF - Fee - SEPA Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - SEPA Minimum Fee") && feeAmt.contains("£") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - SEPA Minimum Fee"))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("CNY")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - SEPA Minimum Fee");
            boolean c = feeAmt.contains("¥");
            boolean d = description.equals("WTF - Fee - SEPA Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - SEPA Minimum Fee") && feeAmt.contains("¥") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - SEPA Minimum Fee"))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("JPY")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - SEPA Minimum Fee");
            boolean c = feeAmt.contains("¥");
            boolean d = description.equals("WTF - Fee - SEPA Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - SEPA Minimum Fee") && feeAmt.contains("¥") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - SEPA Minimum Fee"))
                return true;
            else
                return false;

        } else {
            System.out.println("Current wallet currency is different");
            return false;
        }

    }

    public boolean paymentTransactionFeeCheckACH() throws InterruptedException {
        String type = feeTranstype.getText().trim();
        String reference = transFeeRef.getText().trim();
        String feeAmt = transFeeAmt.getText().trim();
        String description = feeTransDescription.getText().trim();
        System.out.println();
        System.out.println();
        System.out.println(type);
        System.out.println(reference);
        System.out.println(feeAmt);
        System.out.println(description);
        System.out.println();
        System.out.println();

        if (CurrentwalletCurrency.getText().contains("USD")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - ACH Minimum Fee");
            boolean c = feeAmt.contains("$");
            boolean d = description.equals("WTF - Fee - ACH Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - ACH Minimum Fee") && feeAmt.contains("$") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - ACH Minimum Fee"))
                return true;
            else
                return false;
            //return true;
        } else if (CurrentwalletCurrency.getText().contains("EUR")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - ACH Minimum Fee");
            boolean c = feeAmt.contains("€");
            boolean d = description.equals("WTF - Fee - ACH Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - ACH Minimum Fee") && feeAmt.contains("€") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - ACH Minimum Fee"))
                return true;
            else
                return false;


        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - ACH Minimum Fee");
            boolean c = feeAmt.contains("£");
            boolean d = description.equals("WTF - Fee - ACH Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - ACH Minimum Fee") && feeAmt.contains("£") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - ACH Minimum Fee"))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("CNY")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - ACH Minimum Fee");
            boolean c = feeAmt.contains("¥");
            boolean d = description.equals("WTF - Fee - ACH Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - ACH Minimum Fee") && feeAmt.contains("¥") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - ACH Minimum Fee"))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("JPY")) {
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - ACH Minimum Fee");
            boolean c = feeAmt.contains("¥");
            boolean d = description.equals("WTF - Fee - ACH Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - ACH Minimum Fee") && feeAmt.contains("¥") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - ACH Minimum Fee"))
                return true;
            else
                return false;

        } else {
            System.out.println("Current wallet currency is different");
            return false;
        }

    }

    public boolean paymentTransactionFeeCheckWIR() throws InterruptedException {
        String type = feeTranstype.getText().trim();
        String reference = transFeeRef.getText().trim();
        String feeAmt = transFeeAmt.getText().trim();
        String description = feeTransDescription.getText().trim();
        System.out.println();
        System.out.println();
        System.out.println(type);
        System.out.println(reference);
        System.out.println(feeAmt);
        System.out.println(description);
        System.out.println();
        System.out.println();

        if (CurrentwalletCurrency.getText().contains("USD")) {
            System.out.println("In USD wallet for WIR transaction fee Check");
            System.out.println("");
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - WIR Minimum Fee");
            boolean c = feeAmt.contains("$");
            boolean d = description.equals("WTF - Fee - WIR Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - WIR Minimum Fee") && feeAmt.contains("$")
                    && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - WIR Minimum Fee"))
                return true;
            else
                return false;
            //return true;
        } else if (CurrentwalletCurrency.getText().contains("EUR")) {
            System.out.println("In EUR wallet for WIR transaction fee Check");
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - WIR Minimum Fee");
            boolean c = feeAmt.contains("€");
            boolean d = description.equals("WTF - Fee - WIR Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - WIR Minimum Fee") &&
                    feeAmt.contains("€") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - WIR Minimum Fee"))
                return true;
            else
                return false;


        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            System.out.println("In GBP wallet for WIR transaction fee Check");
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - WIR Minimum Fee");
            boolean c = feeAmt.contains("£");
            boolean d = description.equals("WTF - Fee - WIR Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - WIR Minimum Fee") &&
                    feeAmt.contains("£") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - WIR Minimum Fee"))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("CNY")) {
            System.out.println("In CNY wallet for WIR transaction fee Check");
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - WIR Minimum Fee");
            boolean c = feeAmt.contains("¥");
            boolean d = description.equals("WTF - Fee - WIR Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - WIR Minimum Fee") &&
                    feeAmt.contains("¥") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - WIR Minimum Fee"))
                return true;
            else
                return false;

        } else if (CurrentwalletCurrency.getText().contains("JPY")) {
            System.out.println("In JPY wallet for WIR transaction fee Check");
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - WIR Minimum Fee");
            boolean c = feeAmt.contains("¥");
            boolean d = description.equals("WTF - Fee - WIR Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - WIR Minimum Fee") &&
                    feeAmt.contains("¥") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - WIR Minimum Fee"))
                return true;
            else
                return false;

        }else if (CurrentwalletCurrency.getText().contains("PHP")) {
            System.out.println("In PHP wallet for WIR transaction fee Check");
            boolean a = type.contains("Sent");
            boolean b = reference.trim().equals("WTF - Fee - WIR Minimum Fee");
            boolean c = feeAmt.contains("₱");
            boolean d = description.equals("WTF - Fee - WIR Minimum Fee");
            boolean e = Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5;
            System.out.println();
            System.out.println();
            System.out.println("Fee Type a: " + a);
            System.out.println("Fee Reference b: " + b);
            System.out.println("Fee Amt c: " + c);
            System.out.println(("Fee Description d: " + d));
            System.out.println(("Fee Description d: " + e));
            System.out.println();
            System.out.println();

            if (type.contains("Sent") && reference.trim().equals("WTF - Fee - WIR Minimum Fee") &&
                    feeAmt.contains("₱") && Math.abs(Double.valueOf(payFee) - Double.valueOf(feeAmt.replaceAll("[^0-9.]", ""))) < .5 && description.equals("WTF - Fee - WIR Minimum Fee"))
                return true;
            else
                return false;

        } else {
            System.out.println("Current wallet currency is different");
            return false;
        }

    }


    public void whenToPay() {
        now.click();
    }

    public void references() throws InterruptedException {
        payRef.sendKeys("Test Automation");
        paymentReson.sendKeys("Payment Automation");
        paymentNote.sendKeys("Make Payment Automation Note");
    }

    public void referencesFP() throws InterruptedException {
        payRef.sendKeys("FP Minimum Fee");
        paymentReson.sendKeys("Payment Automation");
        paymentNote.sendKeys("FP Automation Note");
    }

    public void referencesSepa() throws InterruptedException {
        payRef.sendKeys("SEPA Minimum Fee");
        paymentReson.sendKeys("Payment Automation");
        paymentNote.sendKeys("SEPA Automation Note");
    }

    public void referencesAch() throws InterruptedException {
        payRef.sendKeys("ACH Minimum Fee");
        paymentReson.sendKeys("Payment Automation");
        paymentNote.sendKeys("ACH Automation Note");
    }

    public void referencesWir() throws InterruptedException {
        payRef.sendKeys("WIR Minimum Fee");
        paymentReson.sendKeys("Payment Automation");
        paymentNote.sendKeys("WIR Automation Note");
    }

    public void payClick() throws InterruptedException {
        payBtn.click();
        Thread.sleep(5000);
    }

    public boolean checkReqAcceptMsg() throws InterruptedException {
        boolean msg = reqAcceptmsg.isDisplayed();
        Thread.sleep(300);
        okBtn.click();
        return msg;
    }


    public void businessClick() {
        business.click();
    }

    public void recipientBusinessDetails() throws InterruptedException {
        busName.sendKeys(Random_data.businessName());
        Thread.sleep(300);
        busRegNum.sendKeys(Random_data.businessRegNum());
        Thread.sleep(300);
        click(busCountry);
        Thread.sleep(1500);
        click(america);
        Thread.sleep(300);
        addressLine.sendKeys(Random_data.address());
        Thread.sleep(300);
        city.sendKeys("Anchorage");
        Thread.sleep(300);
        click(stateDropdown);
        Thread.sleep(1500);
        click(recipientState);
        Thread.sleep(300);
        postCode.sendKeys(Random_data.postCode());
        Thread.sleep(300);
        email.sendKeys(Random_data.email());
        Thread.sleep(300);
        phoneDropdown.click();
        Thread.sleep(500);
        phnSearchBox.sendKeys("us");
        Thread.sleep(500);
        phnUS.click();
        phone.sendKeys("20255300169");
        Thread.sleep(300);
    }

    public void clickExisting() {
        existing.click();
    }

    public void selectRecipients() {
        select.click();
    }

    public void transactionsTabClick() {
        transactionsTab.click();
    }

    public boolean pendingTransection() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar cal = Calendar.getInstance();
        String dt = dateFormat.format(cal.getTime());
        String str = firstPTransaction.getText();
        System.out.println("get text: " + str);
        System.out.println("date: " + dt);
        if (firstPTransaction.getText().trim().equals(dt.trim())) {
            return firstPTransaction.isDisplayed();
        }
        return false;
    }

    public boolean noTranscetionLabelCheck() {
        return noTransectionLabel.isDisplayed();
    }

    public void statementsTabBtnClick() {
        statementsTabBtn.click();
    }

    public boolean downloadBtnCheck() {
        return downloadBtn.isDisplayed();
    }

    public void downloadBtnClick() {
        downloadBtn.click();
    }

    //Transection Assertion Date
    public boolean transDateCheck() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
        Calendar cal = Calendar.getInstance();
        String dt = dateFormat.format(cal.getTime());
        String str = transDate.getText();
        System.out.println("Given date: " + str);
        System.out.println("Today's date: " + dt);
        if (transDate.getText().trim().equals(dt.trim())) {
            return transDate.isDisplayed();
        }
        return false;
    }

    public boolean transFeeDateCheck() throws InterruptedException {
        transactionExpendBtn.click();
        Thread.sleep(500);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
        Calendar cal = Calendar.getInstance();
        String dt = dateFormat.format(cal.getTime());
        String str = feeTransDate.getText();
        System.out.println("Given date: " + str);
        System.out.println("Today's date: " + dt);
        if (feeTransDate.getText().trim().equals(dt.trim())) {
            return feeTransDate.isDisplayed();
        }
        return false;
    }

    public boolean depositTransectionCheck() {
        String type = transtype.getText().trim();
        String reference = transRef.getText().trim();
        String tAmount = transAmt.getText().replaceAll("[\\s,]", "");
        String postTAmount = postTransBalance.getText().trim();
        String description = transDescription.getText().trim();
        String feeAmt = fee.getText().trim();
        String currWalletBalance = currentWalletBalance.getText().trim();
        double postBalDiff = Double.valueOf(postTAmount.replaceAll("[^0-9.]", "")) - Double.valueOf(currWalletBalance.replaceAll("[^0-9.]", ""));

        if (CurrentwalletCurrency.getText().contains("USD")) {
            boolean a = type.contains("Received");
            boolean b = reference.contains("TOPUP - Wallet Load from Card");
            boolean c = tAmount.contains("$");
            boolean d = tAmount.replaceAll("[,]", "").contains(depositAmount);
            boolean e = postBalDiff < 0.2;
            boolean f = description.equals("debit or credit card load");
            boolean g = feeAmt.contains("_");
            System.out.println("Type: " + a);
            System.out.println("Reference " + b);
            System.out.println("Amount Currency: " + c);
            System.out.println("Deposit Amount: " + d);
            System.out.println("Post transaction Balance: " + e);
            System.out.println("Description: " + f);
            System.out.println("Fee Amount: " + g);

            if (type.contains("Received") && reference.contains("TOPUP - Wallet Load from Card") && tAmount.contains("$") && tAmount.replaceAll("[,]", "").contains(depositAmount) && postBalDiff < 0.02 && description.equals("debit or credit card load") & feeAmt.contains("_"))
                return true;
            else
                return false;
        } else if (CurrentwalletCurrency.getText().contains("EUR")) {
            boolean a = type.contains("Received");
            boolean b = reference.contains("TOPUP - Wallet Load from Card");
            boolean c = tAmount.contains("€");
            boolean d = tAmount.replaceAll("[,]", "").contains(depositAmount);
            boolean e = postBalDiff < 0.02;
            boolean f = description.equals("debit or credit card load");
            boolean g = feeAmt.contains("_");
            System.out.println("Type: " + a);
            System.out.println("Reference " + b);
            System.out.println("Amount Currency: " + c);
            System.out.println("Deposit Amount: " + d);
            System.out.println("Post transaction Balance: " + e);
            System.out.println("Description: " + f);
            System.out.println("Fee Amount: " + g);

            if (type.contains("Received") && reference.contains("TOPUP - Wallet Load from Card") && tAmount.contains("€") && tAmount.replaceAll("[,]", "").contains(depositAmount) && postBalDiff < 0.02 && description.equals("debit or credit card load") & feeAmt.contains("_"))
                return true;
            else
                return false;
        } else if (CurrentwalletCurrency.getText().contains("GBP")) {
            boolean a = type.contains("Received");
            boolean b = reference.contains("TOPUP - Wallet Load from Card");
            boolean c = tAmount.contains("£");
            boolean d = tAmount.replaceAll("[,]", "").contains(depositAmount);
            boolean e = postBalDiff < 0.02;
            boolean f = description.equals("debit or credit card load");
            boolean g = feeAmt.contains("_");
            System.out.println("Type: " + a);
            System.out.println("Reference " + b);
            System.out.println("Amount Currency: " + c);
            System.out.println("Deposit Amount: " + d);
            System.out.println("Post transaction Balance: " + e);
            System.out.println("Description: " + f);
            System.out.println("Fee Amount: " + g);

            if (type.contains("Received") && reference.contains("TOPUP - Wallet Load from Card") && tAmount.contains("£") && tAmount.replaceAll("[,]", "").contains(depositAmount) && postBalDiff < 0.02 && description.equals("debit or credit card load") & feeAmt.contains("_"))
                return true;
            else
                return false;
        } else if (CurrentwalletCurrency.getText().contains("CNY")) {
            boolean a = type.contains("Received");
            boolean b = reference.contains("TOPUP - Wallet Load from Card");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.replaceAll("[,]", "").contains(depositAmount);
            boolean e = postBalDiff < 0.02;
            boolean f = description.equals("debit or credit card load");
            boolean g = feeAmt.contains("_");
            System.out.println("Type: " + a);
            System.out.println("Reference " + b);
            System.out.println("Amount Currency: " + c);
            System.out.println("Deposit Amount: " + d);
            System.out.println("Post transaction Balance: " + e);
            System.out.println("Description: " + f);
            System.out.println("Fee Amount: " + g);

            if (type.contains("Received") && reference.contains("TOPUP - Wallet Load from Card") && tAmount.contains("¥") && tAmount.replaceAll("[,]", "").contains(depositAmount) && postBalDiff < 0.02 && description.equals("debit or credit card load") & feeAmt.contains("_"))
                return true;
            else
                return false;
        } else if (CurrentwalletCurrency.getText().contains("JPY")) {
            boolean a = type.contains("Received");
            boolean b = reference.contains("TOPUP - Wallet Load from Card");
            boolean c = tAmount.contains("¥");
            boolean d = tAmount.replaceAll("[,]", "").contains(depositAmount);
            boolean e = postBalDiff < 0.02;
            boolean f = description.equals("debit or credit card load");
            boolean g = feeAmt.contains("_");
            System.out.println("Type: " + a);
            System.out.println("Reference " + b);
            System.out.println("Amount Currency: " + c);
            System.out.println("Deposit Amount: " + d);
            System.out.println("Post transaction Balance: " + e);
            System.out.println("JPY postTAmount: " + postTAmount);
            System.out.println("JPY Curr wall balance: " + currWalletBalance);
            System.out.println("Description: " + f);
            System.out.println("Fee Amount: " + g);

            if (type.contains("Received") && reference.contains("TOPUP - Wallet Load from Card") && tAmount.contains("¥") && tAmount.replaceAll("[,]", "").contains(depositAmount) && postBalDiff < 0.02 && description.equals("debit or credit card load") & feeAmt.contains("_"))
                return true;
            else
                return false;
        } else {
            System.out.println("Current wallet currency is different");
            return false;
        }
    }

}
