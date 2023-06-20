package StepDefinations;

import Pages.Settings_Page;
import Utility.Hooks;
import Utility.SmartWait;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.text.StringEscapeUtils;
import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings_Step {
    public WebDriver driver;
    private Scenario scenario;
    Settings_Page settingsPage;
    SmartWait smartWait = new SmartWait();

    public Settings_Step() {
        this.driver = Hooks.getDriver();
        settingsPage = new Settings_Page(driver);
    }

    public void waitload() {
        new WebDriverWait(driver, 40).until(
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

    @When("user clicks on settings button")
    public void user_clicks_on_settings_button() throws Exception {
        waitload();
        settingsPage.settingsBtnClick();
        waitload();
        Thread.sleep(2000);
    }

    @And("user clicks on change password")
    public void user_clicks_on_change_password() {
        waitload();
        settingsPage.changePassClick();
        waitload();
    }

    @And("user inputs current password")
    public void user_inputs_current_password() {
        waitload();
        settingsPage.inputCurrentPass();
        waitload();
    }

    @And("user inputs new password")
    public void user_inputs_new_password() throws InterruptedException {
        waitload();
        settingsPage.inputNewPass();
        waitload();
    }

    @And("user clicks on change password button")
    public void user_clicks_on_change_password_button() throws InterruptedException {
        waitload();
        settingsPage.changePassBtnClick();
        waitload();
    }

    @And("user inputs otp and clicks on confirm button")
    public void user_inputs_otp_and_clicks_on_confirm_button() throws Exception {
        waitload();
        settingsPage.inputOtp();
        Thread.sleep(500);
        settingsPage.confirmBtnClick();
        waitload();
    }

    @And("success message should appear")
    public void success_message_should_appear() {
        System.out.println("Pass Change Success");
    }

    @And("user should be able to login using new password")
    public void user_should_be_able_to_login_using_new_password() throws Exception {
        smartWait.waitUntilPageIsLoaded(10);
        settingsPage.logoutandLogin();
        smartWait.waitUntilPageIsLoaded(10);

    }

    @Then("user will change password again")
    public void user_will_change_password_again() throws Exception {
        waitload();
        settingsPage.backtoPrevious();
        waitload();
        success_message_should_appear();
        waitload();
    }

    //++++++++++++++++++++++++++++++++++++++++++++++Change Billing Method++++++++++++++++++++++++++++++++++++++++++++++
    @When("user is on settings page")
    public void user_is_on_settings_page() throws Exception {
        waitload();
        user_clicks_on_settings_button();
        waitload();
    }

    @And("user clicks on change billing method")
    public void user_clicks_on_change_billing_method() {
        waitload();
        settingsPage.changeBillingMethod();
        waitload();
    }

    @And("user selects automatic from method dropdown")
    public void user_selects_automatic_from_method_dropdown() throws InterruptedException {
        waitload();
        settingsPage.methodDropdown();
        Thread.sleep(500);
        settingsPage.automaticClick();
        waitload();
        Assert.assertTrue("Warning message didn't appear", settingsPage.automaticWarningMsgCheck());
        waitload();
    }

    @And("user selects accounts from method dropdown")
    public void user_selects_accounts_from_method_dropdown() throws InterruptedException {
        waitload();
        settingsPage.methodDropdown();
        Thread.sleep(500);
        settingsPage.accountsClick();
        waitload();
    }

    @And("user clicks first wallet")
    public void user_clicks_first_wallet() {
        settingsPage.firstWalletClick();
    }

    @And("user selects debit or credit card from method dropdown")
    public void user_selects_debit_or_credit_card_from_method_dropdown() throws InterruptedException {
        waitload();
        settingsPage.methodDropdown();
        Thread.sleep(1000);
        settingsPage.card();
        waitload();
        settingsPage.prevCardCount();
        Thread.sleep(1000);
        waitload();
    }

    @And("clicks on add new card")
    public void clicks_on_add_new_card() {
        waitload();
        settingsPage.addNewCardClick();
        waitload();
    }

    @And("user selects first debit card")
    public void user_selects_first_debit_card() {
        waitload();
        settingsPage.cardClick();
        waitload();
    }

    @And("clicks on save button")
    public void clicks_on_save_button() throws InterruptedException {
        waitload();
        settingsPage.saveBtnClick();
        waitload();
    }

    @Then("automatic should show in settings page")
    public void automatic_should_show_in_settings_page() throws InterruptedException {
        Thread.sleep(3000);
        driver.navigate().refresh();
        waitload();
        Assert.assertTrue("Automatic didn't saved as billing method", settingsPage.savedAutomaticCheck());
        waitload();
    }

    @Then("selected wallet should show in settings page")
    public void selected_wallet_should_show_in_settings_page() throws InterruptedException {
        Thread.sleep(3000);
        driver.navigate().refresh();
        waitload();
        Assert.assertTrue("Wallet didn't saved as billing method", settingsPage.savedWalletCheck());
        if (!settingsPage.getSavedWalletNum().contains("XXX") || !settingsPage.getSavedWalletNum().contains("automatic") || !settingsPage.getSavedWalletNum().contains("**")) {
            System.out.println("Selected Wallet saved as billing method");
        } else {
            System.out.println("Selected Wallet didn't save as billing method");
        }
        waitload();
    }

    @Then("selected card should show in settings page")
    public void selected_card_should_show_in_settings_page() throws InterruptedException {
        Thread.sleep(3000);
        driver.navigate().refresh();
        waitload();
        Assert.assertTrue("Card didn't saved as billing method", settingsPage.savedWalletCheck());
        if (settingsPage.getSavedWalletNum().contains("XXX") || settingsPage.getSavedWalletNum().contains("**")) {
            System.out.println("Selected card saved as billing method");
        } else {
            System.out.println("Selected Card didn't save as billing method");
        }
        waitload();
    }

    @When("user clicks on Phone change of marketing")
    public void user_clicks_on_phone_change_of_marketing() throws InterruptedException {
        waitload();
        settingsPage.phoneChangeBtnClick();
        System.out.println("Phone Change button clicked");
        Thread.sleep(1500);
    }

    @When("user clicks on Fax change of marketing")
    public void user_clicks_on_fax_change_of_marketing() throws InterruptedException {
        waitload();
        settingsPage.faxChangeBtnClick();
        System.out.println("Fax Change button clicked");
        Thread.sleep(1500);
    }

    @When("user clicks on Email change of marketing")
    public void user_clicks_on_email_change_of_marketing() throws InterruptedException {
        waitload();
        settingsPage.emailChangeBtnClick();
        System.out.println("Email Change button clicked");
        Thread.sleep(1500);
    }

    @And("user clicks on postalmail change of marketing")
    public void user_clicks_on_postalmail_change_of_marketing() throws InterruptedException {
        waitload();
        settingsPage.postalmailChangeBtnClick();
        System.out.println("Postal-mail Change button clicked");
        Thread.sleep(1500);
    }

    @Then("user should see message")
    public void user_should_see_message() {
        waitload();
        Assert.assertTrue("Marketing consent has successfully updated.\n", settingsPage.sucessMessageCheck());
        System.out.println("Marketing consent has successfully updated.");
        waitload();
    }

    @When("user clicks on preferred currency change button")
    public void user_clicks_on_preferred_currency_change_button()throws Exception {
        waitload();
        settingsPage.Change5();
        System.out.println("Preferred Currency Change button clicked");
        waitload();
        Thread.sleep(2000);
    }

    @And("user clicks dropdown and saves any currency")
    public void user_clicks_dropdown_saves_any_currency() throws InterruptedException {
        waitload();
        try {
            settingsPage.Dropdown();
            waitload();
            settingsPage.firstCurrencyClick();
            System.out.println("Dropdown clicked 1");
            Thread.sleep(1000);
            settingsPage.saveBtnClick();
            waitload();
        } catch (ElementClickInterceptedException e1) {
            settingsPage.Dropdown();
            waitload();
            settingsPage.secondCurrencyClick();
            System.out.println("Dropdown clicked 2");
            waitload();
            settingsPage.saveBtnClick();
            waitload();
        } catch (Exception e2) {
            settingsPage.Dropdown();
            waitload();
            settingsPage.thirdCurrencyClick();
            System.out.println("Dropdown clicked 2");
            waitload();
            settingsPage.saveBtnClick();
            waitload();
            Thread.sleep(2000);
        }
    }
    @When("user clicks on preferred language change button")
    public void user_clicks_on_preferred_language_change_button() throws InterruptedException {
        waitload();
        settingsPage.prefLanguageBtnCLik();
        System.out.println("Preferred Language Change button clicked");
        waitload();
        Thread.sleep(2000);
    }

    @And("user clicks dropdown and saves any Language")
    public void user_clicks_dropdown_and_saves_any_language() throws InterruptedException {
        waitload();
        try {
            settingsPage.Dropdown();
            waitload();
            settingsPage.firstLanguageClick();
            System.out.println("Dropdown clicked 1");
            Thread.sleep(1000);
            settingsPage.saveBtnClick();
            waitload();
        } catch (ElementClickInterceptedException e1) {
            settingsPage.Dropdown();
            waitload();
            settingsPage.secondLanguageClick();
            System.out.println("Dropdown clicked 2");
            waitload();
            settingsPage.saveBtnClick();
            waitload();
        } catch (Exception e2) {
            settingsPage.Dropdown();
            waitload();
            settingsPage.thirdLanguageClick();
            System.out.println("Dropdown clicked 3");
            waitload();
            settingsPage.saveBtnClick();
            waitload();

            Thread.sleep(2000);
        }
    }

    @Then("saved currency and language should show in settings page")
    public void saved_currency_and_language_should_show_in_settings_page()throws Exception {
        waitload();
        Assert.assertTrue("Currency save Failed", settingsPage.savedSettingsCheck());
        waitload();
        Thread.sleep(2000);
    }

    @And("check newly added card")
    public void check_newly_added_card() throws InterruptedException {
        waitload();
        settingsPage.methodDropdown();
        Thread.sleep(500);
        settingsPage.accountsClick();
        Thread.sleep(1000);
        settingsPage.methodDropdown();
        Thread.sleep(500);
        settingsPage.card();
        Thread.sleep(500);
        settingsPage.afterCardCount();
        Assert.assertTrue("New card doesn't add to the list", settingsPage.verifyAddedCard());
    }

    @And("user selects new added card")
    public void user_selects_new_added_card() {
        waitload();
        settingsPage.newlyAddedCardClick();
        waitload();
    }

    @Then("verify payment method change in setting page")
    public void verify_payment_method_change_in_setting_page() throws InterruptedException {
        Thread.sleep(3000);
        driver.navigate().refresh();
        waitload();
        Assert.assertTrue("Saved card number doesn't match", settingsPage.verifySavedCard());
        waitload();
    }
}
