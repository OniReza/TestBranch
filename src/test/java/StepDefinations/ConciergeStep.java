package StepDefinations;

import Pages.ConciergePage;
import Pages.LoginPage;
import Utility.Hooks;
import Utility.SmartWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ConciergeStep{

    public WebDriver driver;
    ConciergePage conciergePage;
    LoginPage loginPage;
    SmartWait smartWait = new SmartWait();

    public ConciergeStep()
    {
        this.driver= Hooks.getDriver();
        conciergePage=new ConciergePage(driver);
        loginPage=new LoginPage(driver);
    }

    @When("user click on concierge button")
    public void user_click_on_concierge_button()throws InterruptedException{

        try {
            if (conciergePage.IsPopup()) {
                conciergePage.buttonCancel();
                conciergePage.ConciergeButton();
            }
        }
        catch(Exception e) {
            conciergePage.ConciergeButton();
        }
        smartWait.waitUntilPageIsLoaded(1);

    }
    @And("input a message on chat area")
    public void input_a_message_on_chat_area()throws InterruptedException{
        conciergePage.MessageInput();
        smartWait.waitUntilPageIsLoaded(5);
    }

    @And("user hit the send button")
    public void user_hit_the_send_button()throws InterruptedException{
        conciergePage.SendButton();
        smartWait.waitUntilPageIsLoaded(5);
    }
    @Then("user should see the message on concierge board")
    public void user_should_see_the_message_on_concierge_board(){
        Assert.assertTrue("Type your message",conciergePage.isConciergeAvailable());
        smartWait.waitUntilPageIsLoaded(5);

    }

}
