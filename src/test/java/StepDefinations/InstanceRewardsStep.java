package StepDefinations;

import Pages.InstanceRewardsPage;
import Utility.Hooks;
import Utility.SmartWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InstanceRewardsStep{
    public WebDriver driver;
   InstanceRewardsPage instanceRewardsPage;
    SmartWait smartWait = new SmartWait();

    public InstanceRewardsStep(){
        this.driver= Hooks.getDriver();
        instanceRewardsPage=new InstanceRewardsPage(driver);
    }

    public void waitload(){
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @When("user click on instance rewards options")
    public void user_click_instance_option() throws InterruptedException {

        try {
            instanceRewardsPage.ClickInstanceBtn();
        }
        catch(Exception e) {

            if (instanceRewardsPage.IsPopup()) {
                instanceRewardsPage.buttonCancel();
                instanceRewardsPage.ClickInstanceBtn();
            }
        }

    }
    @And("user will choose card from card option")
    public void user_select_card_for_reward()throws InterruptedException {
        instanceRewardsPage.SelectCard();
        waitload();
    }
    @And("user will click select button from the card list")
    public void user_will_click_select_button(){
        instanceRewardsPage.selectCardFromList();
        waitload();
     }
    @Then("user should see the payment method page")
    public void user_should_see_the_booking_page(){
        Assert.assertTrue("User should see customer list", instanceRewardsPage.isPaymentMethodAvailable());
        waitload();
    }
    @When("user in the payment methode")
    public void user_in_the_payment_methode()throws InterruptedException {
        user_click_instance_option();
        user_select_card_for_reward();
        user_will_click_select_button();
        waitload();
        user_should_see_the_booking_page();
        waitload();
    }
    @And("user input some text if need")
    public void user_input_some_text(){
     instanceRewardsPage.msgBox();
        waitload();
    }

    @And("user select wallet from wallet list")
    public void user_select_wallet() throws InterruptedException{
        instanceRewardsPage.btnWallet();
        waitload();
    }

    @And("user click on redeem button")
    public void user_click_on_redeem_button() throws InterruptedException{
        instanceRewardsPage.clickRedeemBtn();
        waitload();
    }

    @And("user click on see order button")
    public void user_click_on_order_button() throws InterruptedException{
        instanceRewardsPage.clickOrderBtn();
        waitload();
    }

    @Then("user should see the order successful page")
    public void user_should_see_payment_success_page(){
        Assert.assertTrue("User should see customer list", instanceRewardsPage.isPaymentMethodSuccessfully());
        waitload();

    }

    @When("user in successful rewards page")
    public void user_in_successful_rewards_page()throws InterruptedException {

        user_click_instance_option();
        waitload();
        user_select_card_for_reward();
        waitload();
        user_will_click_select_button();
        waitload();
        user_should_see_the_booking_page();
        waitload();
        user_input_some_text();
        waitload();
        user_select_wallet();
        waitload();
        user_click_on_redeem_button();
        waitload();
        user_click_on_order_button();
        waitload();
        user_should_see_payment_success_page();
    }
    @And("user click on close button")
    public void user_click_on_close_button(){
        instanceRewardsPage.closeBtn();
        waitload();
    }
    @And("user click on your rewards tab")
    public void user_click_on_your_rewards_tab(){
        instanceRewardsPage.tabsRewards();
        waitload();
    }
    @Then("user should see his reward cards")
    public void user_should_see_his_reward_cards(){
        Assert.assertTrue("User should see customer list", instanceRewardsPage.isRewardsSuccessfully());
        waitload();
    }

}
