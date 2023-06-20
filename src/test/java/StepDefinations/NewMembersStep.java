package StepDefinations;

import Pages.NewMembersPage;
import Utility.Hooks;
import Utility.SmartWait;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.text.StringEscapeUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewMembersStep {
    public  WebDriver driver;
    private Scenario scenario;
    NewMembersPage newMemberPage;

    SmartWait smartWait = new SmartWait();

    public NewMembersStep()
    {
        this.driver= Hooks.getDriver();
        newMemberPage=new NewMembersPage(driver);
    }
    public void waitload(){
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

    @When("topup popup appears")
    public void topup_popup_appears() {
        waitload();
        Assert.assertTrue("No popup apeared ", newMemberPage.topupPopupCheck());
    }
    @And("user inputs topup amount")
    public void user_inputs_topup_amount() throws InterruptedException {
        waitload();
        newMemberPage.entertopupAmount();
        Thread.sleep(3000);
    }
    @And("user click on checkbox")
    public void user_click_on_checkbox() {
        newMemberPage.checkBoxClick();
    }
    @And("click proceed button")
    public void click_proceed_button() {
        waitload();
        newMemberPage.ProceedBtnClick();
        waitload();
    }
    @And("user checks sucess message and press Ok")
    public void user_checks_topup_sucess_message_and_press_ok() throws InterruptedException {
        waitload();
        Assert.assertTrue("Topup unsucessful", newMemberPage.sucessMsgCheck());
        Thread.sleep(2000);
        newMemberPage.okBtnClick();
        waitload();
    }
    @And("user checks success message with loader and press Ok")
    public void user_checks_topup_sucess_message_with_loader_and_press_ok() throws InterruptedException {
        System.out.println("1");
        waitload();
        try {
            Assert.assertTrue("Topup unsucessful", newMemberPage.sucessMsgCheck());
        }
        catch (NoSuchElementException e){
            Assert.assertTrue("Topup unsucessful", newMemberPage.sucessMsgwithLoader());
        }
        System.out.println("2");
        Thread.sleep(2000);
        newMemberPage.okBtnClick();
        System.out.println("3");
        waitload();
    }

    @And("user checks purchase success message and press on back button")
    public void user_checks_purchase_sucess_message_and_press_back() throws InterruptedException {
        waitload();
        Assert.assertTrue("Topup unsucessful", newMemberPage.purchaseSucessMsgCheck());
        Thread.sleep(2000);
        newMemberPage.backBtnClick();
        waitload();
    }
    @And("user checks activation success message and press on back button")
    public void user_checks_activation_sucess_message_and_press_back() throws InterruptedException {
        waitload();
        Assert.assertTrue("Topup unsucessful", newMemberPage.activationSucessMsgCheck());
        Thread.sleep(2000);
        newMemberPage.backBtnClick();
        waitload();
    }
    @And("user checks sucess message and press on back button")
    public void user_checks_topup_sucess_message_and_press_back() throws InterruptedException {
        waitload();
        Assert.assertTrue("Topup unsucessful", newMemberPage.purchaseSucessMsgCheck());
        Thread.sleep(2000);
        newMemberPage.backBtnClick();
        waitload();
    }

    @Then("user should see the Home page")
    public void user_should_see_the_home_page () throws InterruptedException {
        Assert.assertTrue("Dashboard didn't appeard",newMemberPage.dashboardCheck());
        Thread.sleep(2000);
        }

    @And("user clicks on virtual cards tab")
    public void user_clicks_on_virtual_cards_tab() throws InterruptedException {
        waitload();
        newMemberPage.virtualCardsTabClick();
        waitload();
    }
    @And("user clicks on create virtual card button")
    public void user_clicks_on_create_virtual_card_button(){
        waitload();
        newMemberPage.createVcardBtnClick();
        waitload();
    }

    @And("user selects first card")
    public void user_selects_first_card(){
        waitload();
        newMemberPage.firstVcardCreation();
        waitload();
    }
    @Then("virtual card activation page will appear")
    public void virtual_card_activation_page_will_appear(){
        waitload();
        Assert.assertTrue("Virtual card activation page didn't appeared",newMemberPage.vCardActivateFirstMsgCheck());
        Assert.assertTrue("Virtual card activation page didn't appeared",newMemberPage.vCardActivateSecondMsgCheck());

    }
    @And("user selects accounts for topup for activation")
    public void user_selects_accounts_for_topup_for_activation() throws InterruptedException {
        waitload();
        newMemberPage.methodWalletSelect();
        waitload();
        newMemberPage.walletSelect();
        waitload();
    }
    @And("user selects accounts for payment")
    public void user_selects_accounts_for_payment() throws InterruptedException {
        waitload();
        newMemberPage.methodWalletSelect();
        waitload();
        newMemberPage.walletSelect();
        waitload();
    }
    @And("user clicks on continue button")
    public void user_clicks_on_continue_button() throws InterruptedException {
        waitload();
        newMemberPage.continueBtnClick();
        waitload();
    }
    @And("user enters sending amount and click continue button")
    public void user_enters_sending_amount_and_click_continue_button() throws InterruptedException {
        waitload();
        newMemberPage.enterAmout();
        Thread.sleep(500);
        newMemberPage.continueBtnClick();
        waitload();
    }
    @And("user clicks on confirm button")
    public void user_clicks_on_confirm_button() throws InterruptedException {
        waitload();
        newMemberPage.confirmBtnClick();
        waitload();
    }


    @And("user selects debit card for topup for activation")
    public void user_selects_debit_card_for_topup_for_activation() throws InterruptedException {
        waitload();
        newMemberPage.methodCardSelect();
        waitload();
    }

    @And("user enters sending amount and click checkBox")
    public void user_enters_sending_amount_and_click_checkbox() throws InterruptedException {
        newMemberPage.enterAmout();
        Thread.sleep(1000);
        newMemberPage.topupcheckBoxClick();
        Thread.sleep(2000);

    }
    @And("user click on continue button")
    public void user_click_on_continue_button(){
        waitload();
        newMemberPage.continueBtnClick();
        waitload();
    }
    @And("user checks summary and press confirm")
    public void user_checks_summary_and_press_confirm() throws Exception {
        waitload();
        Accounts_Step ac = new Accounts_Step();
        ac.deposit_summary_should_appear();
        Thread.sleep(1000);
        newMemberPage.confirmBtnClick();
        waitload();
    }

    @And("user enter otp and click activate button")
    public void user_enter_otp_and_click_activate_button() throws Exception {
        waitload();
        newMemberPage.enterOtp();
        Thread.sleep(1000);
        newMemberPage.activateBtnClick();
        waitload();
    }

    @And("user clicks on Add virtual card button")
    public void user_clicks_on_add_virtual_card_button(){
        waitload();
        newMemberPage.addVirtualCardTabClick();
        waitload();
    }
    @And("user selects euro card")
    public void user_selects_euro_card(){
        waitload();
        newMemberPage.euroCardClick();
        waitload();

    }
    @And("user selects pound card")
    public void user_selects_pound_card(){
        waitload();
        newMemberPage.gbpCardClick();
        waitload();

    }

    @And("user selects debit card for payment")
    public void user_selects_debit_card_for_payment() throws InterruptedException {
        waitload();
        newMemberPage.methodCardSelect();
        waitload();
    }
    @And("user click checkBox and clicks on continue")
    public void user_click_checkbox_and_clicks_on_continue() throws InterruptedException {
        waitload();
        newMemberPage.aggrementCheckBoxClick();
        Thread.sleep(500);
        newMemberPage.continueBtnClick();
        waitload();
    }
    @And("user enter otp and click purchase button")
    public void user_enter_otp_and_click_purchase_button() throws Exception {
        waitload();
        newMemberPage.enterPurchaseOtp();
        Thread.sleep(500);
        newMemberPage.purchaseBtnClick();
    }

    @And("user selects euro virtual card")
    public void user_selects_euro_virtual_card(){
        waitload();
        newMemberPage.inactiveVirtualCardClick();
        waitload();
    }
    @And("user selects pound sterling virtual card")
    public void user_selects_pound_sterling_virtual_card(){
        waitload();
        newMemberPage.inactiveVirtualCardClick();
        waitload();
    }

    @And("user clicks on transfer to another member wallet")
    public void user_clicks_on_transfer_to_another_member_wallet(){
        waitload();
        newMemberPage.newBeneficiaryCreationClick();
        waitload();
    }
    @And("user input valid wallet number {string}")
    public void user_input_valid_wallet_number(String walletNum){
        waitload();
        newMemberPage.enterWalletNum(walletNum);
        waitload();
    }
    @And("user input reference name {string}")
    public void user_input_reference_name(String name){
        waitload();
        newMemberPage.enterRefName(name);
        waitload();
    }
    @And("user clicks on next button")
    public void user_clicks_on_next_button(){
        waitload();
        newMemberPage.nextBtnClick();
    }
    @Then("saved beneficiary wallet number should appear in summary section")
    public void saved_beneficiary_wallet_number_should_appear_in_summary_section(){
        waitload();
        Assert.assertTrue("Wallet not saved", newMemberPage.addedWalletCheck());
        waitload();
    }
    @And("user clicks activate tab")
    public void user_clicks_activate_tab(){
        waitload();
        newMemberPage.activateTabClick();
        waitload();
    }
    @And("user inputs last four digit {string} of physical card")
    public void user_inputs_last_four_digit_of_physical_card(String digits){
        waitload();
        newMemberPage.enterFourDigit(digits);
    }
    @And("user clicks verify button")
    public void user_clicks_verify_button(){
        waitload();
        newMemberPage.verifyBtnClick();
        waitload();
    }
    @And("user inputs password and clicks on confirm button")
    public void user_inputs_password_and_clicks_on_confirm_button() throws Exception {
        waitload();
        newMemberPage.enterPassword();
        Thread.sleep(500);
        newMemberPage.passConfirmBtnClick();
    }

    @And("user press on back button")
    public void user_press_on_back_button() throws InterruptedException {
        waitload();
        Assert.assertTrue("Card activation not sucessfull", newMemberPage.cardActivationSucessMsgChek());
        Thread.sleep(500);
        newMemberPage.cardActivateBackBtnClick();
        waitload();
    }
    @Then("physical card status should change to active")
    public void physical_card_status_should_change_to_active(){
        driver.navigate().refresh();
        waitload();
        Assert.assertTrue("Status remains inactive", newMemberPage.cardStatusCheck());
        waitload();
    }
}
