package StepDefinations;

import Pages.ShoppingPage;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingStep {
    public WebDriver driver;
    private Scenario scenario;
    ShoppingPage shoppingPage;
    SmartWait smartWait = new SmartWait();

    public ShoppingStep() {
        this.driver = Hooks.getDriver();
        shoppingPage = new ShoppingPage(driver);
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

    @When("user click on shopping button")
    public void user_click_on_shopping_button() throws InterruptedException {

        try {
            shoppingPage.ShoppingBtn();
            waitload();
            shoppingPage.getBeforeCount();
        }catch (Exception e) {
            shoppingPage.popupClick();
            shoppingPage.ShoppingBtn();
        }
    }

    @And("user click on new request tab")
    public void user_click_on_new_request_tab() throws InterruptedException {
        shoppingPage.newRequestTabClick();
    }

    @And("user input description")
    public void user_input_description() throws InterruptedException {
        shoppingPage.DescriptionInput();
    }

    @When("user input brand name")
    public void user_input_brand_name() throws InterruptedException {
        shoppingPage.BrandInput();
    }

    @And("user input style")
    public void user_input_style() throws InterruptedException {
        shoppingPage.StyleInput();
    }

    @And("user input color")
    public void user_input_color() throws InterruptedException {
        shoppingPage.ColorInput();
    }

    @And("user input weblink")
    public void user_input_weblink() throws InterruptedException {
        shoppingPage.WebLinkInput();
    }

    @And("user hit the create request button")
    public void user_hit_the_create_request_button() throws InterruptedException {
        shoppingPage.RequestButton();
    }

    @Then("user should see the created shopping request and status should be 'Search in progress'")
    public void user_should_see_the_shopping_request_status() throws InterruptedException {
        shoppingPage.getAfterCount();
        Thread.sleep(1000);
        Assert.assertTrue("User should see customer list", shoppingPage.newShoppingReqCheck());
    }

    @When("user is on shopping tab")
    public void user_is_on_shopping_tab() {
        waitload();
        try {
            shoppingPage.ShoppingBtn();
        } catch (Exception e) {
                shoppingPage.popupClick();
                shoppingPage.ShoppingBtn();
        }
    }

    @And("user selects in progress from status dropdown")
    public void user_selects_in_progress_from_status_dropdown() throws InterruptedException {
        waitload();
        shoppingPage.statusDropdown();
        Thread.sleep(500);
        shoppingPage.inProgressStatusClick();
    }

    @And("shopping requests is in progress status should appear")
    public void shopping_requests_is_in_progress_status_should_appear() {
        waitload();
        try {
            Assert.assertTrue("Request is in progress status not appeard", shoppingPage.reqInprogressCheck());
        } catch (NoSuchElementException e) {
            Assert.assertTrue("You have no shopping requests. not appeard", shoppingPage.noShopReqlabelCheck());
        }
    }

    @And("user selects complete from status dropdown")
    public void user_selects_complete_from_status_dropdown() throws InterruptedException {
        waitload();
        shoppingPage.statusDropdown();
        Thread.sleep(500);
        shoppingPage.completeStatusClick();
    }

    @And("shopping requests is complete status should appear")
    public void shopping_requests_is_complete_status_should_appear() {
        waitload();
        try {
            Assert.assertTrue("Request is in progress status not appeard", shoppingPage.reqCompleteCheck());
        } catch (NoSuchElementException e) {
            Assert.assertTrue("You have no shopping requests. not appeard", shoppingPage.noShopReqlabelCheck());
        }
    }

    @And("user selects all from status dropdown")
    public void user_selects_all_from_status_dropdown() throws InterruptedException {
        waitload();
        shoppingPage.statusDropdown();
        Thread.sleep(500);
        shoppingPage.allStatusClick();
    }

    @Then("all shopping requests should appear")
    public void all_shopping_requests_should_appear() {
        waitload();
        try{
            System.out.println("11");
            Assert.assertTrue("Error in displaying desired data",shoppingPage.reqAllCheck());
        }catch (NoSuchElementException e){
            System.out.println("22");
            Assert.assertTrue("Error in displaying desired data",shoppingPage.reqAllCheck2());

        }


    }


}
