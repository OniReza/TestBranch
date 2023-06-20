package StepDefinations;

import Pages.UpgradePlan_Page;
import Utility.Hooks;
import Utility.SmartWait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utility.UserProfile.UpgradePlan_Page;

/**
 * @author Nahid
 */
public class UpgradePlan_Step {
    public WebDriver driver;
    UpgradePlan_Page upgPlanPage;
    SmartWait smartWait = new SmartWait();

    public UpgradePlan_Step() {
        this.driver = Hooks.getDriver();
        upgPlanPage = new UpgradePlan_Page(driver);
    }

    public void waitload() {
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    @When("user clicks on Upgrade from side bar")
    public void user_clicks_on_upgrade_from_side_bar() {
        waitload();
        upgPlanPage.upgradeMenuClick();
        waitload();
    }
    @When("user go to upgrade page")
    public void user_go_to_upgrade_page() {
        waitload();
        Assert.assertTrue("Didn't redirected to upgrade page", upgPlanPage.checkCurrentPackage());
        System.out.println("Redirected to upgrade page");
        waitload();

    }
    @When("user click on UPGRADE text link")
    public void user_click_on_upgrade_text_link() {
        waitload();
        upgPlanPage.upgradeTextlinkClick();
        waitload();
    }
    @When("user go to Voucher code page")
    public void user_go_to_voucher_code_page() {
        waitload();
        Assert.assertTrue("Didn't redirected to Voucher code page", upgPlanPage.checkvCodeTitle());
        System.out.println("Redirected to Voucher code page");
        waitload();
    }
    @When("user click on cross icon")
    public void user_click_on_cross_icon() {
        waitload();
        upgPlanPage.crossIconClick();
        waitload();
    }
    @When("user click on UPGRADE button")
    public void user_click_on_upgrade_button() {
        waitload();
        upgPlanPage.upgradeBtnClick();
        waitload();
    }
    @When("user enter voucher code")
    public void user_enter_voucher_code() {
        waitload();
        Assert.assertTrue("Voucher code title doesn't present", upgPlanPage.checkvCodeTitle());
        //System.out.println("Redirected to Voucher code page");
        waitload();
        Assert.assertTrue("Voucher code text doesn't present", upgPlanPage.checkvCodeText());
        waitload();
        System.out.println(UpgradePlan_Page);
        upgPlanPage.entervCode(UpgradePlan_Page);

    }
    @When("user click on Confirm button")
    public void user_click_on_Confirm_button() {
        waitload();
        upgPlanPage.confirmBtnClick();
        waitload();
        Assert.assertTrue("Upgrade Package title doesn't present", upgPlanPage.checkpcTitle());
        System.out.println("Redirected to Upgrade Package page");
        waitload();
    }
    @When("user go to plan details page")
    public void user_go_to_plan_details_page() {
        waitload();
        Assert.assertTrue("Package name doesn't present", upgPlanPage.checkpcName());
        waitload();
        Assert.assertTrue("Package card name doesn't present", upgPlanPage.checkpcCard());
        //System.out.println("Redirected to Voucher code page");
        waitload();
        Assert.assertTrue("Package Wallet title doesn't present", upgPlanPage.checkpcWallet());
        waitload();
        Assert.assertTrue("Package Wallet EUR doesn't present", upgPlanPage.checkpcEURWlt());
        waitload();
        Assert.assertTrue("Package Wallet GBP doesn't present", upgPlanPage.checkpcGBPWlt());
        //System.out.println("Redirected to Voucher code page");
        waitload();
        Assert.assertTrue("Package Wallet USD doesn't present", upgPlanPage.checkpcUSDWlt());
        //System.out.println("Redirected to Voucher code page");
        waitload();
        Assert.assertTrue("Package Wallet JPY doesn't present", upgPlanPage.checkpcJPYWlt());
        //System.out.println("Redirected to Voucher code page");
        waitload();
        Assert.assertTrue("Package Wallet CNY doesn't present", upgPlanPage.checkpcCNYWlt());
        waitload();
        Assert.assertTrue("Package Crypto title doesn't present", upgPlanPage.checkpcCrypto());
        waitload();
        Assert.assertTrue("Package Crypto Bitcoin doesn't present", upgPlanPage.checkpcBTCCry());
        waitload();

    }
    @When("user click on CONFIRM button")
    public void user_click_on_confirm_button() throws InterruptedException {
        waitload();
        upgPlanPage.confirmTextlinkClick();
        waitload();
        Assert.assertTrue("Card price doesn't match", upgPlanPage.checkCardPrice());
        waitload();
        driver.navigate().back();
        waitload();
        upgPlanPage.entervCode(UpgradePlan_Page);
        waitload();
        user_click_on_Confirm_button();
        waitload();
        upgPlanPage.pcConfirmBtnClick();

    }
    @When("user go to card selection page")
    public void user_go_to_card_selection_page() {
        waitload();
        Assert.assertTrue("Card currency text doesn't present", upgPlanPage.checkcardCurText());
        //System.out.println("Redirected to Voucher code page");
        waitload();
        Assert.assertTrue("Wallet for payment doesn't present", upgPlanPage.checkcardCur());
        waitload();
        Assert.assertTrue("Shipping text doesn't present", upgPlanPage.checkshipText());
        waitload();
        Assert.assertTrue("Shipping method doesn't present", upgPlanPage.checkshipMethod());
        waitload();

    }
    @When("user click on card CONFIRM button")
    public void user_click_on_card_CONFIRM_button() throws InterruptedException {
        waitload();
        upgPlanPage.cardConfirmBtn();
        waitload();
    }
    @When("user go to payment confirmation page")
    public void user_go_to_payment_confirmation_page() throws InterruptedException {
        waitload();
        user_go_to_plan_details_page();
        waitload();
        Assert.assertTrue("Shipping method name doesn't match", upgPlanPage.shippingName());
        waitload();
        Assert.assertTrue("Shipping card price doesn't match", upgPlanPage.verifyCardPrice());
        waitload();
        waitload();
        Assert.assertTrue("Plan details count doesn't match", upgPlanPage.planDetailsConunt());
        waitload();
        Assert.assertTrue("Upgrade plan name doesn't match", upgPlanPage.CheckplanName());
        waitload();
        waitload();
        Assert.assertTrue("Upgrade plan card doesn't match", upgPlanPage.CheckPlanCard());
        waitload();

    }
    @When("user click on back button")
    public void user_click_on_back_button() {
        waitload();
        driver.navigate().back();
        waitload();
    }
    @When("select Expedited shipping methods")
    public void select_expedited_shipping_methods() throws InterruptedException {
        waitload();
        upgPlanPage.selectExpedited();
        waitload();
        Assert.assertTrue("Expedited Card price doesn't match", upgPlanPage.checkCardPayPrice());
        waitload();

    }
    @When("select payment method")
    public void select_payment_method() {
        waitload();
        upgPlanPage.selectPayment();
        waitload();
    }

    @Then("check plan upgrade plan name")
    public void check_plan_upgrade_plan_name() {
        user_go_to_plan_details_page();
    }


    @Then("verify confirmation message")
    public void verifyConfirmationMessage() throws InterruptedException {
        waitload();
        Thread.sleep(15000);
        Assert.assertTrue("User didn't redirect to dashboard", upgPlanPage.checkConMessage());
        waitload();
        Thread.sleep(30000);
    }
}
