package Pages;

import Utility.CommonPageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConciergePage extends CommonPageMethods {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div[1]/div/div/div[2]/ul[1]/div[6]")
    public WebElement btnConcierge;
    @FindBy(xpath = "//textarea[@placeholder='Type your message here...']")
    public WebElement inputConciergeChat;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/span[1]")
    public WebElement popup;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/div/button[1]")
    public WebElement btnCancel;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnSend;
    @FindBy(xpath = "//div[@class='msg']")
    public WebElement conciergeAssert;
    public ConciergePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void ConciergeButton(){
        click(btnConcierge);
    }
    public void MessageInput(){
        inputConciergeChat.sendKeys("Hello this is a test message");
    }
    public void SendButton(){
        click(btnSend);
    }
    public Boolean isConciergeAvailable(){
        return conciergeAssert.isDisplayed();
    }

    public Boolean IsPopup()
    {
        return popup.isDisplayed();
    }
    public void buttonCancel()
    {
        click(btnCancel);
    }

}
