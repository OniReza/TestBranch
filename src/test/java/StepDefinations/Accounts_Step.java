package StepDefinations;

import Pages.Accounts_Page;
import Utility.Hooks;
import Utility.SmartWait;
import Utility.UserProfile;
import com.aventstack.extentreports.markuputils.ExtentColor;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.text.StringEscapeUtils;



public class Accounts_Step {
    public WebDriver driver;
    private Scenario scenario;
    Accounts_Page accpage;
    SmartWait smartWait = new SmartWait();
    String senderWallet = null;
    String receiverWallet = null;
    String receivingAmount = null;
    String moveWalletNum = null;

    public Accounts_Step() {
        this.driver = Hooks.getDriver();
        accpage = new Accounts_Page(driver);
    }

    public void waitload() {
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    public void writeInReport(String reportPrint)
    {
        String consoleOutput = reportPrint;
        String escapedOutput = StringEscapeUtils.escapeHtml4(consoleOutput);

        // Add the string in red color to the report using Markup
        String redColorMarkup = "<span style='color: red; font-style: italic; font-weight: bold;'>" +"<--- Note ---> "+  escapedOutput + "</span>";
        Markup customColor = MarkupHelper.createLabel(redColorMarkup, ExtentColor.TRANSPARENT);
        scenario.log(customColor.getMarkup());
    }
    //Details Tab
    @When("user clicks on account button")
    public void user_clicks_on_account() throws InterruptedException {
        waitload();
        accpage.getMemberName();
        accpage.accMenuClick();
        System.out.println("Account menu clicked");
        Thread.sleep(2000);
        waitload();
    }

    @When("user clicks on accounts menu")
    public void user_clicks_on_accounts_menu() throws InterruptedException {
        waitload();
        accpage.accMenuClick();
        System.out.println("Account menu clicked");
        Thread.sleep(2000);
        waitload();
    }

    @And("user clicks on USD wallet")
    public void user_clicks_on_usd_wallet() throws InterruptedException {
        waitload();
        user_clicks_on_account();
        accpage.usdWalletClick();
        System.out.println("USD Wallet Clicked");
        waitload();
    }

    @And("user clicks on EURO wallet")
    public void user_clicks_on_euro_wallet() throws InterruptedException {
        waitload();
        user_clicks_on_account();
        accpage.euroWalletClick();
        System.out.println("USD Wallet Clicked");
        waitload();
    }

    @And("user clicks on GBP wallet")
    public void user_clicks_on_gbp_wallet() throws InterruptedException {
        waitload();
        user_clicks_on_account();
        Thread.sleep(1000);
        accpage.gbpWalletClick();
        System.out.println("GBP Wallet Clicked");
        waitload();
    }

    @And("user clicks on JPY wallet")
    public void user_clicks_on_jpy_wallet() throws InterruptedException {
        waitload();
        user_clicks_on_account();
        accpage.jpyWalletClick();
        System.out.println("JPY Wallet Clicked");
        waitload();
    }

    @And("user clicks on CNY wallet")
    public void user_clicks_on_cny_wallet() throws InterruptedException {
        waitload();
        user_clicks_on_account();
        accpage.cnyWalletClick();
        System.out.println("CNY Wallet Clicked");
        waitload();
    }

    @And("user clicks on PHP wallet")
    public void user_clicks_on_php_wallet() throws InterruptedException {
        waitload();
        user_clicks_on_account();
        accpage.phpWalletClick();
        System.out.println("PHP Wallet Clicked");
        waitload();
    }


    @Then("user should see a graph")
    public void user_should_see_a_graph() throws InterruptedException {
        waitload();
        Assert.assertTrue("Graph is not Displayed", accpage.checkGraph());
        waitload();
    }

    //Move Feature
    @And("user clicks on move tab")
    public void user_clicks_on_move_tab() throws InterruptedException {
        waitload();
        System.out.println("User is in USD Wallet");
        accpage.moveTabClick();
        senderWallet = accpage.findSenderWallet();
        System.out.println("Move Page clicked");
        waitload();
    }

    @When("user clicks on select beneficiary dropdown")
    public void user_clicks_on_select_beneficiary_dropdown() throws InterruptedException {
        waitload();
        accpage.benDropdownClick();
        System.out.println("Select Beneficiary Dropdown expended ");
        Thread.sleep(50);
        waitload();
    }

//    @And("user selects beneficiary")
//    public void user_selects_beneficiary() throws InterruptedException {
//        waitload();
//        accpage.beneficiaryCLick();
//        waitload();
//    }

    @And("user selects CNY wallet")
    public void user_selects_usd_wallet() throws InterruptedException {
        waitload();
        accpage.cnyAccClick();
        Thread.sleep(3000);
        System.out.println("CNY Account Selected");
        waitload();
    }

    @And("user selects EUR wallet")
    public void user_selects_eur_wallet() throws InterruptedException {
        waitload();
        accpage.euroAccClick();
        Thread.sleep(3000);
        System.out.println("Euro Account Selected");
        waitload();
    }

    @And("user selects PHP wallet")
    public void user_selects_php_wallet() throws InterruptedException {
        waitload();
        accpage.phpAccClick();
        Thread.sleep(3000);
        System.out.println("PHP Account Selected");
        waitload();
    }

    @And("user selects JPY wallet")
    public void user_selects_jpy_wallet() throws InterruptedException {
        waitload();
        accpage.jpyAccClick();
        Thread.sleep(3000);
        System.out.println("JPY Account Selected");
        waitload();
    }

    @And("user selects USD wallet")
    public void user_selects_cny_wallet() throws InterruptedException {
        waitload();
        accpage.usdAccClick();
        Thread.sleep(3000);
        System.out.println("CNY Account Selected");
        waitload();
    }

    @And("user selects GBP wallet")
    public void user_selects_gbp_wallet() throws InterruptedException {
        waitload();
        accpage.gbpAccClick();
        Thread.sleep(3000);
        System.out.println("GBP Account Selected");
        waitload();
    }

    @And("enter amount on sending amount box {string}")
    public void enter_amount_on_sending_amount_in_usd(String amount) throws InterruptedException {
        smartWait.waitUntilPageIsLoaded(10);
        accpage.getMoveAccountDetails();
        receiverWallet = accpage.findRecieverWallet();
        accpage.enterSendingAmount(amount);
        waitload();
        System.out.println("Amount Entered");
        smartWait.waitUntilPageIsLoaded(10);
    }

    @And("user clicks confirm")
    public void user_clicks_confirm() throws InterruptedException {
        smartWait.waitUntilPageIsLoaded(10);
        accpage.confirmBtnClick();
        System.out.println("Confirm Button Clicked");
        waitload();
    }

//    @And("user enters secret code")
//    public void user_enters_secret_code() throws Exception {
//        waitload();
//        accpage.enterSecretCode();
//        Thread.sleep(50);
//    }
//
//    @And("user clicks confirm again")
//    public void user_clicks_confirm_again() throws Exception {
//        waitload();
//        accpage.confirmBtnClick();
//        System.out.println("Confirm Button Clicked again");
//        waitload();
//    }

    @And("transfer successfully completed message is shown")
    public void transfer_successfully_completed_message_is_shown() throws Exception {
        waitload();
        try {
            Assert.assertTrue("Transfer Unsuccessful.", accpage.checkSuccessMsg());
        } catch (NoSuchElementException e) {
            accpage.cancelBtnClick();
            Thread.sleep(1000);
            accpage.confirmBtnClick();
            accpage.enterSecretCode();
            Thread.sleep(300);
            accpage.confirmBtnClick();
            waitload();
            Assert.assertTrue("Transfer Unsuccessful.", accpage.checkSuccessMsg());
        }
        System.out.println("Transfer Done");
        waitload();
    }

    @And("transfer successfully completed message should appear")
    public void transfer_successfully_completed_message_should_appear() throws Exception {
        waitload();
        try {
            Assert.assertTrue("Transfer Unsuccessful.", accpage.checkSuccessMsg());
        } catch (NoSuchElementException e) {
            accpage.cancelBtnClick();
            Thread.sleep(1000);
            accpage.confirmBtnClick();
            accpage.enterSecretCode();
            Thread.sleep(300);
            accpage.confirmBtnClick();
            waitload();
            Assert.assertTrue("Transfer Unsuccessful.", accpage.checkSuccessMsg());
        }
        System.out.println("Transfer Done");
        waitload();
    }

    @And("user clicks on ok")
    public void user_clicks_on_ok() throws InterruptedException {
        waitload();
        accpage.okBtnClick();
        System.out.println("Clicked on OK");
        Thread.sleep(5000);
        waitload();
    }

    @Then("user should redirect to wallet details tab")
    public void user_should_redirect_to_usd_wallet_details_tab() throws InterruptedException {
        waitload();
        Assert.assertTrue("User is not in Details Tab", accpage.checkDetailsTab());
        Thread.sleep(1000);
        System.out.println("User is in Details Tab");
        waitload();

    }

    // Deposit Feature
    @And("user clicks on deposit")
    public void user_clicks_on_deposit() throws InterruptedException {
        waitload();
        accpage.depositTabClick();
        senderWallet = accpage.findSenderWallet();
        System.out.println("Deposit clicked");
        Thread.sleep(3000);
        waitload();
    }

    @And("user expend from dropdown")
    public void user_expend_from_dropdown() throws InterruptedException {
        waitload();
        accpage.fromDropdwnClick();
        System.out.println("From dropdown Expended");
        Thread.sleep(1000);
    }

    @And("user expend from dropdown again")
    public void user_expend_from_dropdown_again() throws InterruptedException {
        waitload();
        accpage.fromDropdwnClick();
        System.out.println("From dropdown Expended");
        Thread.sleep(1000);
    }

    @And("user selects debit or credit card")
    public void user_selects_debit_or_credit_card() throws InterruptedException {
        waitload();
        accpage.debitCardClick();
        waitload();
    }

    @And("user enters amount to deposit {string}")
    public void user_enters_amount_to_deposit(String amt) throws InterruptedException {
        waitload();
        accpage.enterLoadAmount(amt);
        System.out.println("Load amount Entered");
        waitload();
        Thread.sleep(500);
    }

    @And("user clicks agreement")
    public void user_clicks_agreement() throws InterruptedException {
        waitload();
        accpage.aggrementClick();
        System.out.println("Agreed transfer Aggrement");
        waitload();
    }

    @And("deposit summary should appear")
    public void deposit_summary_should_appear() throws Exception {
        waitload();
        Assert.assertTrue("Summary didn't appear as expected", accpage.checkDepositSummary());
        System.out.println("Summary appeared");
        Thread.sleep(500);
    }

    @And("move summary should appear")
    public void move_summary_should_appear() throws InterruptedException {
        waitload();
        Assert.assertTrue("Summary didn't appear as expected", accpage.checkMoveSummary());
        System.out.println("Summary appeared");
        accpage.getRecieverAmount();
        Thread.sleep(500);
    }

    @And("expedite fee should add in summary")
    public void expedite_fee_should_add_in_summary() throws InterruptedException {
        accpage = new Accounts_Page(driver);
        waitload();
        Thread.sleep(1000);
        Assert.assertTrue("Expedite fee didn't added in summary", accpage.checkExpeditSummary());
        waitload();
    }

    @And("clicks confirm")
    public void clicks_confirm() throws InterruptedException {
        waitload();
        accpage.confirmBtnClick();
        System.out.println("Confirm button clicked");
        waitload();
    }

    @And("user checks confirmation message and press ok")
    public void user_checks_confirmation_message() throws InterruptedException {
        smartWait.waitUntilPageIsLoaded(10);
        waitload();

        try {
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            Assert.assertTrue("Topup unsucessful", accpage.checkLoadSuccessMsg());
        } catch (NoSuchElementException e) {
            Assert.assertTrue("Topup unsucessful", accpage.sucessMsgwithLoader());
        }
        Thread.sleep(2000);
        accpage.clickOKbtn();
        waitload();
        Thread.sleep(3000);
    }

    @And("user clicks ok")
    public void user_clicks_ok() throws InterruptedException {
        waitload();
        accpage.clickOKbtn();
        System.out.println("Ok Button Clicked");
        waitload();
    }

    @Then("user should see post transaction balance is equal to available balance")
    public void user_should_see_post_transaction_balance_is_equal_to_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);

        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        }else if (senderWallet.contains("PHP")) {
            accpage.phpWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2000);
        accpage.transactionsTabClick();
        waitload();
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data didn't match as expected!", accpage.depositTransectionCheck());
        waitload();
    }

    @Then("user should see sender post transaction balance after move is equal to available balance")
    public void user_should_see_sender_post_transaction_balance_after_move_is_equal_to_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);
        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        } else if (senderWallet.contains("PHP")) {
            accpage.phpWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data didn't match as expected!", accpage.moveSenderTransactionCheck());
        waitload();
    }

    @Then("user should see receiver post transaction balance after move is equal to available balance")
    public void user_should_see_receiver_post_transaction_balance_after_move_is_equal_to_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Receiver Wallet:  " + receiverWallet);
        if (receiverWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (receiverWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (receiverWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (receiverWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (receiverWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        }else if (receiverWallet.contains("PHP")) {
            accpage.phpWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + receiverWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data didn't match as expected!", accpage.moveRecieverTransectionCheck());
        waitload();
    }

    // Deposit local us bank
    @And("user selects local\\(US Bank)")
    public void user_selects_local_us_bank() {
        waitload();
        accpage.localUSBankClick();
        waitload();
    }

    @And("user selects local\\(UK Bank)")
    public void user_selects_local_uk_bank() {
        waitload();
        accpage.localUKBankClick();
        waitload();
    }

    @And("user selects International\\(non UK Bank)")
    public void user_selects_international_non_uk_bank() {
        waitload();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        accpage.intlNonUKBankClick();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        waitload();
    }

    @Then("user should see details of bank")
    public void user_should_see_details_of_bank() throws InterruptedException {
        smartWait.waitUntilPageIsLoaded(10);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Assert.assertTrue("Local US Bank details didn't appears as expected!!", accpage.localUSBankBeneficiaryCheck());
        waitload();
    }
    @Then("user should see details of local us bank of usd wallet")
    public void user_should_see_details_of_local_us_bank_of_usd_wallet() throws InterruptedException {
        smartWait.waitUntilPageIsLoaded(10);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Assert.assertTrue("Virtual account details didn't match as expected!!", accpage.localUSBankCreatedBeneficiaryCheck());
        writeInReport("Virtual account is created!!");
        waitload();
    }

    @Then("user should see details of local us bank")
    public void user_should_see_details_of_local_us_bank() throws InterruptedException {
        smartWait.waitUntilPageIsLoaded(10);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Assert.assertTrue("Fallback data didn't appear as expected!!", accpage.localUSBankFallBackBeneficiaryCheck());
        writeInReport("Fallback data is showing.");
        waitload();
    }
    @Then("user should see details of International non UK Bank")
    public void user_should_see_details_of_international_no_uk_bank() {
        smartWait.waitUntilPageIsLoaded(10);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        try {
            Assert.assertTrue("Virtual account didn't create!!!Fall back data is showing.", accpage.intlNonUKBankCreatedBeneficiaryCheck());
        } catch (AssertionError e) {
            System.err.println(e.getMessage());
            Assert.assertTrue("Fallback data didn't match as expected!!", accpage.intlNonUKBankFallBackBeneficiaryCheck());
            writeInReport(e.getMessage());
        }
        waitload();
    }

//    @Then("user should see details of International non UK Bank of GBP wallet")
//    public void user_should_see_details_of_international_no_uk_bank_of_gbp_wallet() {
//        smartWait.waitUntilPageIsLoaded(10);
//        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//        Assert.assertTrue("International non UK Bank details didn't appears for GBP wallet as expected!!", accpage.intlNonUKBankGbpBeneficiaryCheck());
//        waitload();
//    }

    @Then("user should see details of local UK bank")
    public void user_should_see_details_of_local_uk_bank() throws InterruptedException {
        smartWait.waitUntilPageIsLoaded(10);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        try {
            Assert.assertTrue("Virtual account didn't create!!!Fall back data is showing.", accpage.localUKBankCreatedBeneficiaryCheck());
        } catch (AssertionError e) {
            System.err.println(e.getMessage());
            Assert.assertTrue("Fallback data didn't match as expected!!", accpage.localUKBankFallBackBeneficiaryCheck());
            writeInReport(e.getMessage());
        }
        waitload();
    }

//    @Then("user should see details of local UK bank of GBP wallet")
//    public void user_should_see_details_of_local_uk_bank_gbp() throws InterruptedException {
//        smartWait.waitUntilPageIsLoaded(10);
//        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//        Assert.assertTrue("Local UK Bank details didn't appears for GBP wallet as expected!!", accpage.localUKBankGbpBeneficiaryCheck());
//        waitload();
//    }

    // Crypto Deposit
    @When("user selects crypto deposit")
    public void user_selects_crypto_deposit() throws InterruptedException {
        waitload();
        accpage.cryptoClick();
        waitload();
    }

    @When("user enters sending amount in TBTC")
    public void user_enters_sending_amount_in_tbtc() throws InterruptedException {
        waitload();
        accpage.enterCryptoSendAmount();
        waitload();
    }

    @When("user clicks on terms and condition check box")
    public void user_clicks_on_terms_and_condition_check_box() throws InterruptedException {
        waitload();
        accpage.checkBoxClick();
        Thread.sleep(1000);
    }

    @Then("user should see a summary")
    public void user_should_see_a_summary() throws InterruptedException {
        waitload();
        Assert.assertTrue("Crypto Deposit Summary didn't appears", accpage.cryptoSummaryCheck());
        waitload();
    }

    // Transfer to new member
    @And("user clicks on transfer to a member pay")
    public void user_clicks_on_pay() throws InterruptedException {
        waitload();
        accpage.memberPayBtnClick();
        waitload();
    }

    @And("user selects existing beneficiary")
    public void user_clicks_transfer_to_another_member_wallet() throws InterruptedException {
        waitload();
        accpage.benDropdownClick();
        Thread.sleep(300);
        waitload();
        accpage.beneficiarySelect();
        waitload();
        System.out.println("Transfer Beneficiary Selected");
        waitload();
    }

    @And("user enters sending amount {string} and payment reference")
    public void user_enters_wallet_number_and_reference_name(String amount) throws InterruptedException {
        waitload();
        accpage.enterm2mAmount(amount);
        waitload();
        accpage.enterPaymentRef();
        waitload();
    }

    @And("user checks summary of transfer amount")
    public void user_checks_summary_of_transfer_amount() throws InterruptedException {
        waitload();
        smartWait.waitUntilPageIsLoaded(10);
        Assert.assertTrue("No summary", accpage.checkTransferSummary());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitload();
        Thread.sleep(500);
    }

    @And("clicks confirm button")
    public void clicks_confirm_button() throws InterruptedException {
        waitload();
        clicks_confirm();
        waitload();
    }

//    @And("enter otp for transfer")
//    public void enter_otp_for_transfer() throws Exception {
//        waitload();
//        accpage.enterSecretCode();
//        Thread.sleep(50);
//        waitload();
//    }

//    @And("user clicks confirm button again")
//    public void user_clicks_confirm_button_again() throws InterruptedException {
//        waitload();
//        clicks_confirm_button();
//        smartWait.waitUntilPageIsLoaded(10);
//    }

    @And("user inputs otp and press confirm button")
    public void user_inputs_otp_and_press_confirm_button() throws Exception {
        waitload();
        accpage.enterOtpCode();
        waitload();
    }

    @And("user checks success message")
    public void user_checks_success_message() throws InterruptedException {
        waitload();
        Assert.assertTrue("Transfer Not Successful", accpage.checkSuccessMsg());
        waitload();
    }

    @And("press ok")
    public void press_ok() throws InterruptedException {
        waitload();
        user_clicks_ok();
        waitload();
    }

    @And("user should redirect to details")
    public void user_should_redirect_to_details() throws InterruptedException {
        waitload();
        user_should_see_a_graph();
        waitload();
    }

    // Make payment to new individual
    @When("user clicks payments tab")
    public void user_clicks_payments_tab() throws Exception {
        waitload();
        accpage.paymentTabClick();
        senderWallet = accpage.findSenderWallet();
        waitload();
    }

    @And("clicks on make payment pay button")
    public void clicks_on_make_payment_pay_button() throws InterruptedException {
        waitload();
        accpage.makePaymentClick();
        waitload();
    }

    @And("user clicks on individual")
    public void user_clicks_on_individual() {
        waitload();
        accpage.toIndividual();
        waitload();
    }

    @And("user clicks on new")
    public void user_clicks_on_new() throws Exception {
        waitload();
        accpage.newBtnClick();
    }

    @And("user enters other recipient details for new individual")
    public void user_enters_other_recipient_details_for_new_individual() throws InterruptedException {
        waitload();
        accpage.recipientDetails();
        waitload();
    }

    @And("user enters bank details")
    public void user_enters_bank_details() throws InterruptedException {
        waitload();
        accpage.bankDetails();
        waitload();
    }

    @And("user enters bank details for FP")
    public void user_enters_bank_details_for_fp() throws InterruptedException {
        waitload();
        accpage.bankDetailsFP();
        waitload();
    }

    @And("user enters bank details for SEPA")
    public void user_enters_bank_details_for_sepa() throws InterruptedException {
        waitload();
        accpage.bankDetailsSepa();
        waitload();
    }

    @And("user enters bank details for ACH")
    public void user_enters_bank_details_for_ach() throws InterruptedException {
        waitload();
        accpage.bankDetailsAch();
        waitload();
    }

    @And("user enters bank details for WIR")
    public void user_enters_bank_details_for_wir() throws InterruptedException {
        waitload();
        accpage.bankDetailsWir();
        waitload();
    }

    @And("user enters bank details for that accepts php payment {string}")
    public void user_enters_bank_details_for_that_accepts_php_payment( String currency) throws InterruptedException {
        waitload();
        if (currency.equals("PHP")){
            accpage.bankDetailsPhptoPhp();
        } else if (currency.equals("USD")){
            accpage.bankDetailsPhptoUsd();
        }else {
            writeInReport("Invalid receiver currency set for Php wallet.");
        }


        waitload();
    }

    @And("user enters wrong bank details for payment")
    public void user_enters_wrong_bank_details_for_payment() throws InterruptedException {
        waitload();
        Assert.assertTrue("Country: Philippines; Currency: Euro combination failed!!",accpage.phpWrongBankCurrCheck1());
        Assert.assertTrue("Country: Philippines; Currency: GBP combination failed!!",accpage.phpWrongBankCurrCheck2());
        Assert.assertTrue("Country: Philippines; Currency: JPY combination failed!!",accpage.phpWrongBankCurrCheck3());
        Assert.assertTrue("Country: Philippines; Currency: CNY combination failed!!",accpage.phpWrongBankCurrCheck4());
        Assert.assertTrue("Country: Bangladesh; Currency: PHP combination failed!!",accpage.phpWrongBankCurrCheck5());
        Assert.assertTrue("Country: US; Currency: USD combination failed!!",accpage.phpWrongBankCurrCheck6());
        Assert.assertTrue("Country: UK; Currency: PHP combination failed!!",accpage.phpWrongBankCurrCheck7());
        Assert.assertTrue("Country: bd; Currency: EURO combination failed!!",accpage.phpWrongBankCurrCheck8());
        Assert.assertTrue("Country: Uk; Currency: GBP combination failed!!",accpage.phpWrongBankCurrCheck9());

    }

    @And("user enters amount")
    public void user_enters_amount() throws Exception {
        waitload();
        accpage.amount();
        waitload();
    }

    @And("user enters amount {int}")
    public void user_enters_amount(int amt) throws Exception {
        waitload();
        accpage.amount(amt);
        waitload();
    }

    @And("user checks total debit amount with FP fee as per rate")
    public void user_checks_total_debit_amount_with_minimum_fp_fee_rate() {
        if (UserProfile.FP.fpFlat!=0)
            Assert.assertTrue("FP fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtFPFlat());
        else
            Assert.assertTrue("FP fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtFPRate());
    }

    @And("user checks total debit amount with minimum FP fee")
    public void user_checks_total_debit_amount_with_minimum_fp_fee() throws InterruptedException {
        if (UserProfile.FP.fpFlat!=0)
            Assert.assertTrue("FP fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtFPFlat());
        else
            Assert.assertTrue("FP minimum fee amount didn't match as expected", accpage.checkTotalDebitAmtFPMin());
    }

    @And("user checks total debit amount with SEPA fee as per rate")
    public void user_checks_total_debit_amount_with_sepa_fee_rate() throws InterruptedException {
        if(UserProfile.SEPA.sepaFlat!=0)
            Assert.assertTrue("SEPA fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtSepaFlat());
        else
            Assert.assertTrue("SEPA fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtSepaRate());
    }
    @And("user checks total debit amount with minimum SEPA fee")
    public void user_checks_total_debit_amount_with_minimum_sepa_fee() throws InterruptedException {
        if(UserProfile.SEPA.sepaFlat!=0)
            Assert.assertTrue("SEPA fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtSepaFlat());
        else
            Assert.assertTrue("SEPA minimum fee amount didn't match as expected", accpage.checkTotalDebitAmtSepaMin());
    }

    @And("user checks total debit amount with ACH fee as per rate")
    public void user_checks_total_debit_amount_with_ach_fee_rate() {
        if(UserProfile.ACH.achFlat!=0)
            Assert.assertTrue("ACH fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtAchFlat());
        else
            Assert.assertTrue("ACH fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtAchRate());
    }

    @And("user checks total debit amount with minimum ACH fee")
    public void user_checks_total_debit_amount_with_minimum_ach_fee() throws InterruptedException {
        if(UserProfile.ACH.achFlat!=0)
            Assert.assertTrue("ACH fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtAchFlat());
        else
            Assert.assertTrue("ACH minimum fee amount didn't match as expected", accpage.checkTotalDebitAmtAchMin());
    }

    @And("user checks total debit amount with WIR fee as per rate")
    public void user_checks_total_debit_amount_with_wir_fee_rate() {
        if (UserProfile.WIR.wirFlat!=0)
            Assert.assertTrue("WIR fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtWirFlat());
        else
            Assert.assertTrue("WIR fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtWirRate());
    }

    @And("user checks total debit amount with minimum WIR fee")
    public void user_checks_total_debit_amount_with_minimum_wir_fee() throws InterruptedException {
        if (UserProfile.WIR.wirFlat!=0)
            Assert.assertTrue("WIR fee amount as per rate didn't match as expected", accpage.checkTotalDebitAmtWirFlat());
        else
        Assert.assertTrue("WIR minimum fee amount didn't match as expected", accpage.checkTotalDebitAmtWirMin());
    }

    @And("user selects timing\\(now)")
    public void user_selects_when_now() {
        waitload();
        accpage.whenToPay();
        waitload();
    }

    @And("user enter references")
    public void user_enter_references() throws InterruptedException {
        waitload();
        accpage.references();
        Thread.sleep(1000);
    }

    @And("user enter references for FP")
    public void user_enter_references_fp() throws InterruptedException {
        waitload();
        accpage.referencesFP();
        Thread.sleep(1000);
    }

    @And("user enter references for SEPA")
    public void user_enter_references_sepa() throws InterruptedException {
        waitload();
        accpage.referencesSepa();
        Thread.sleep(1000);
    }

    @And("user enter references for ACH")
    public void user_enter_references_ach() throws InterruptedException {
        waitload();
        accpage.referencesAch();
        Thread.sleep(1000);
    }

    @And("user enter references for WIR")
    public void user_enter_references_wir() throws InterruptedException {
        waitload();
        accpage.referencesWir();
        Thread.sleep(1000);
    }

    @And("user clicks on pay for payment")
    public void user_clicks_on_pay_for_payment() throws InterruptedException {
        waitload();
        accpage.payClick();
        waitload();
    }

    @And("check request success message and press ok")
    public void check_success_message_and_press_ok() throws InterruptedException {
        waitload();
        Assert.assertTrue("Success message didn't appears!!", accpage.checkReqAcceptMsg());
        waitload();
    }
    @Then("pay button should remain disable and error message should be visible below amount box")
    public void pay_button_should_remain_disable_and_error_message_should_be_visible_below_amount_box()  {
        Assert.assertTrue("Error message below amount box didn't appears!!!",accpage.amountErrMsgCheck());
        Assert.assertFalse("Pay button enabled!!!",accpage.payBtnEnableCheck());
    }


    @And("user should see sender post transaction balance after FP is equal to available balance")
    public void user_should_see_sender_post_transaction_balance_after_FP_is_equal_to_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);
        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        } else {
            System.out.println("Wallet doesn't match!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data doesn't matched as expected", accpage.transectionCheckFP());
        Assert.assertTrue("Latest transaction Fee data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transFeeDateCheck());
        Assert.assertTrue("Transaction Fee doesn't matched as expected", accpage.paymentTransactionFeeCheckFP());
        waitload();
    }

    @And("user should see sender post transaction balance after FP is equal to GBP wallets to available balance")
    public void user_should_see_sender_post_transaction_balance_after_FP_is_equal_gbp_wallets_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);
        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data doesn't matched as expected", accpage.transectionCheckFPGBP());
        Assert.assertTrue("Latest transaction Fee data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transFeeDateCheck());
        Assert.assertTrue("Transaction Fee doesn't matched as expected", accpage.paymentTransactionFeeCheckFP());
        waitload();
    }

    @And("user should see sender post transaction balance after SEPA is equal to available balance")
    public void user_should_see_sender_post_transaction_balance_after_sepa_is_equal_to_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);
        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data doesn't matched as expected", accpage.transectionCheckSEPA());
        Assert.assertTrue("Latest transaction Fee data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transFeeDateCheck());
        Assert.assertTrue("Transaction Fee doesn't matched as expected", accpage.paymentTransactionFeeCheckSepa());
        waitload();
    }

    @And("user should see sender post transaction balance after SEPA is equal to Euro wallets available balance")
    public void user_should_see_sender_post_transaction_balance_after_sepa_is_equal_to_euro_wallets_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);
        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data doesn't matched as expected", accpage.transactionCheckSEPAEUR());
        Assert.assertTrue("Latest transaction Fee data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transFeeDateCheck());
        Assert.assertTrue("Transaction Fee doesn't matched as expected", accpage.paymentTransactionFeeCheckSepa());
        waitload();
    }

    @And("user should see sender post transaction balance after ACH payment is equal to available balance")
    public void user_should_see_sender_post_transaction_balance_after_ach_payment_is_equal_to_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);
        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data doesn't matched as expected", accpage.transactionCheckACH());
        Assert.assertTrue("Latest transaction Fee data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transFeeDateCheck());
        Assert.assertTrue("Transaction Fee doesn't matched as expected", accpage.paymentTransactionFeeCheckACH());
        waitload();
    }

    @And("user should see sender post transaction balance after ACH is equal to USD wallets to available balance")
    public void user_should_see_sender_post_transaction_balance_after_ach_is_equal_usd_wallets_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);
        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data doesn't matched as expected", accpage.transactionCheckUSDACH());
        Assert.assertTrue("Latest transaction Fee data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transFeeDateCheck());
        Assert.assertTrue("Transaction Fee doesn't matched as expected", accpage.paymentTransactionFeeCheckACH());
        waitload();
    }


    @And("user should see sender post transaction balance after WIR payment is equal to wallet's available balance")
    public void user_should_see_sender_post_transaction_balance_after_WIR_is_equal_to_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);
        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        }else if (senderWallet.contains("PHP")) {
            accpage.phpWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data doesn't matched as expected", accpage.transactionCheckWIR());
        Assert.assertTrue("Latest transaction Fee data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transFeeDateCheck());
        Assert.assertTrue("Transaction Fee doesn't matched as expected", accpage.paymentTransactionFeeCheckWIR());
        waitload();
    }

    @And("user should see sender post transaction balance after WIR is equal to CNY wallets available balance")
    public void user_should_see_sender_post_transaction_balance_after_ach_is_equal_cny_wallets_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);
        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data doesn't matched as expected", accpage.transactionCheckWIRCNY());
        Assert.assertTrue("Latest transaction Fee data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transFeeDateCheck());
        Assert.assertTrue("Transaction Fee doesn't matched as expected", accpage.paymentTransactionFeeCheckWIR());
        waitload();
    }

    @And("user should see sender post transaction balance after WIR is equal to PHP wallets available balance")
    public void user_should_see_sender_post_transaction_balance_after_ach_is_equal_php_wallets_available_balance() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Working Wallet:  " + senderWallet);
        if (senderWallet.contains("USD")) {
            accpage.usdWalletClick();
        } else if (senderWallet.contains("EUR")) {
            accpage.euroWalletClick();
        } else if (senderWallet.contains("GBP")) {
            accpage.gbpWalletClick();
        } else if (senderWallet.contains("JPY")) {
            accpage.jpyWalletClick();
        } else if (senderWallet.contains("CNY")) {
            accpage.cnyWalletClick();
        }else if (senderWallet.contains("PHP")) {
            accpage.phpWalletClick();
        } else {
            System.out.println("Wallet doesn't matched!!");
        }
        waitload();
        Thread.sleep(2500);
        accpage.transactionsTabClick();
        waitload();
        Thread.sleep(2500);
        Assert.assertTrue("Latest transaction data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transDateCheck());
        Assert.assertTrue("Transaction data doesn't matched as expected", accpage.transactionCheckWIRPhp());
        Assert.assertTrue("Latest transaction Fee data is not available in " + senderWallet + " wallet transaction of tab! ", accpage.transFeeDateCheck());
        Assert.assertTrue("Transaction Fee doesn't matched as expected", accpage.paymentTransactionFeeCheckWIR());
        waitload();
    }

    @Then("if payment is complete user should redirect to payments tab")
    public void user_should_redirect_to_payments_tab() throws InterruptedException {
        waitload();
        Assert.assertTrue("User redirected to payment page", accpage.paymentPage());
        waitload();
    }
    // Make payment to new individual ends

    // Make payment to new Business
    @When("user clicks on business")
    public void user_clicks_on_Business() throws InterruptedException {
        waitload();
        accpage.businessClick();
        waitload();
    }

    @And("user enters other recipient details for new business")
    public void user_enters_other_recipient_details_for_new_business() throws InterruptedException {
        waitload();
        accpage.recipientBusinessDetails();
        waitload();
    }

    // Make payment to Existing Individual
    @And("user clicks on existing")
    public void user_clicks_on_Existing_Individual() throws InterruptedException {
        waitload();
        accpage.clickExisting();
        waitload();
    }

    @And("user selects existing recipient from recipient details")
    public void user_selects_existing_beneficiary_from_recipient_details() {
        waitload();
        accpage.selectRecipients();
        waitload();
    }

    //Make payment to Existing Business
    @When("user is in payments tab and makes payment for existing business")
    public void user_is_in_payments_tab_and_makes_payment_for_existing_business() throws InterruptedException {
        waitload();
        clicks_on_make_payment_pay_button();
        waitload();
    }

    @And("user clicks on existing business")
    public void user_clicks_on_existing_business() throws InterruptedException {
        waitload();
        accpage.businessClick();
        Thread.sleep(1000);
        accpage.clickExisting();
        waitload();
    }

    @When("user clicks on statements tab")
    public void user_is_in_statements_tab() throws InterruptedException {
        waitload();
        accpage.statementsTabBtnClick();
    }

    @And("if any statement available user clicks on download button")
    public void if_any_statement_available_user_clicks_on_download_button() {
        waitload();
        try {
            if (accpage.downloadBtnCheck())
                accpage.downloadBtnClick();
            writeInReport("Statement available to download for this year.");
            waitload();
        } catch (Exception e) {
            accpage.accMenuClick();
            writeInReport("No Statement available to download for this year!!!");
            waitload();
        }
    }

    @Then("statement should be downloaded")
    public void statement_should_be_downloaded() {
        System.out.println("Statement downloaded");
    }

    // Withdraw
//    @When("user is in withdraw tab")
//    public void user_is_in_withdraw_tab() throws InterruptedException {
//        user_clicks_on_account();
//        user_clicks_on_usd_wallet();
//        waitload();
//        accpage.withdrawTabClick();
//        waitload();
//    }

//    @And("user add personal account")
//    public void user_add_personal_account() throws InterruptedException {
//        waitload();
//        accpage.addPersonalAccClick();
//        waitload();
//    }

//    @And("user selects destination bank country and currency")
//    public void user_selects_destination_bank_country() throws InterruptedException {
//        waitload();
//        accpage.destinationBankCountry();
//        Thread.sleep(500);
//        accpage.beneficiaryCurrencyClick();
//        Thread.sleep(500);
//        accpage.nextBtnClick();
//        waitload();
//    }

//    @And("press next button")
//    public void press_next_button() throws InterruptedException {
//        waitload();
//        accpage.nextBtnClick();
//        waitload();
//    }

//    @And("user input withdraw beneficiary details and press next")
//    public void user_enter_withdraw_beneficiary_details_and_press_next() throws InterruptedException {
//        waitload();
//        accpage.withdrawBeneficiaryDetails();
//        Thread.sleep(1000);
//        accpage.nextBtnClick();
//        waitload();
//    }

//    @And("input sending amount in usd")
//    public void input_sending_amount_in_usd() throws InterruptedException {
//        waitload();
//        accpage.enterSendingAmount();
//        waitload();
//    }

//    @And("click on expedite fee and outbound transfer agreement")
//    public void click_on_expedite_fee_and_outbound_transfer_agreement() throws InterruptedException {
//        waitload();
//        accpage.withdrawCheckBox();
//        waitload();
//    }

    //Pay Family
//    @When("user is in pay tab")
//    public void user_is_in_pay_tab() throws InterruptedException {
//        user_clicks_on_account();
//        user_clicks_on_usd_wallet();
//        waitload();
//        accpage.payTabClick();
//        waitload();
//    }

//    @And("user clicks pay button of friends or family")
//    public void user_clicks_pay_button_of_friends_or_family() throws InterruptedException {
//        waitload();
//        accpage.ffPayBtnClick();
//        waitload();
//    }

//    @And("user clicks on pay someone new")
//    public void user_clicks_on_pay_someone_new() throws InterruptedException {
//        waitload();
//        accpage.paySomeoneNewBtnClick();
//        waitload();
//    }

//    @And("user input pay\\(individual) beneficiary details and press next")
//    public void user_input_pay_individual_beneficiary_details_and_press_next() throws InterruptedException {
//        waitload();
//        accpage.payFriendorFamilyDetails();
//        Thread.sleep(1000);
//        accpage.nextBtnClick();
//        waitload();
//    }

//    @And("input payment reference and reason")
//    public void input_payment_reference_and_reason() throws InterruptedException {
//        waitload();
//        accpage.paymentReason();
//        Thread.sleep(500);
//        accpage.paymentRef();
//        waitload();
//    }

//    //Pay business
//    @And("user clicks pay button a business or invoice")
//    public void user_clicks_pay_button_a_business_or_invoice() throws InterruptedException {
//        waitload();
//        accpage.businessPayBtnClick();
//        waitload();
//    }

//    @And("user clicks on pay to new business button")
//    public void user_clicks_on_pay_to_new_business_button() throws InterruptedException {
//        waitload();
//        accpage.payNewBusinessClick();
//        waitload();
//    }

//    @And("user input business beneficiary details and press next")
//    public void user_input_business_beneficiary_details_and_press_next() throws InterruptedException {
//        waitload();
//        accpage.payBusinessDetails();
//        waitload();
//        accpage.nextBtnClick();
//        waitload();
//    }

    //Another member pay

//    @And("user clicks pay button of another member")
//    public void user_clicks_pay_button_of_another_member() throws InterruptedException {
//        waitload();
//        accpage.anotherMemberPayBtnClick();
//        waitload();
//    }

//    @And("input payment reference")
//    public void input_payment_reference() throws InterruptedException {
//        waitload();
//        accpage.paymentReason();
//        Thread.sleep(500);
//        waitload();
//    }

//    public void DepositAmt() throws Exception {
//        PaymentGatewayStep paymentGatewayStep = new PaymentGatewayStep();
//        user_clicks_on_usd_wallet();
//        user_clicks_on_deposit();
//        user_expend_from_dropdown();
//        user_selects_debit_or_credit_card();
//        user_enters_amount_to_deposit("50000");
//        user_clicks_agreement();
//        deposit_summary_should_appear();
//        clicks_confirm();
//        paymentGatewayStep.enter_card_details_in_apexx_and_clicks_on_pay();
//        user_checks_confirmation_message();
//    }
}
