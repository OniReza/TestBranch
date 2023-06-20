package Pages;

import Utility.CommonPageMethods;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ShoppingPage extends CommonPageMethods {
    int beforeCount=0;
    int afterCount=0;
    @FindBy(xpath = "//span[text()='Shopping']")
    public WebElement btnShopping;
    @FindBy(xpath = "//span[contains(text(),'not right now')]")
    public WebElement popup;
    @FindBy(xpath = "//input[@name='description']")
    public WebElement inputDescription;
    @FindBy(xpath = "//span[text()='New Request']")
    public WebElement newRequestTab;
    @FindBy(xpath = "//input[@name='brand']")
    public WebElement inputBrand;
    @FindBy(xpath = "//input[@name='style']")
    public WebElement inputStyle;
    @FindBy(xpath = "//input[@name='colour']")
    public WebElement inputColor;
    @FindBy(xpath = "//input[@name='weblink']")
    public WebElement inputWebLink;
    @FindBy(xpath = "(//input[@class='search'])[2]")
    public WebElement statusDropdown;
    @FindBy(xpath = "//span[text()='In Progress']")
    public WebElement inProgressStatus;
    @FindBy(xpath = "//span[text()='Complete']")
    public WebElement completeStatus;
    @FindBy(xpath = "(//span[text()='All'])[2]")
    public WebElement allStatus;
    @FindBy(xpath = "(//td[contains(text(),'progress')])[1]")
    public WebElement reqInprogress;
    @FindBy(xpath = "(//td[contains(text(),'Search complete')])[1]")
    public WebElement reqComplete;
    @FindBy(xpath = "//span[contains(text(),'You have no shopping requests.')]")
    public WebElement noShopReqlabel;
    @FindBy(xpath = "(//i[@class='dropdown icon'])[2]")
    public WebElement reqStatus;
    @FindBy(xpath = "//span[text()='Create Request']")
    public WebElement buttonRequest;
    @FindAll({@FindBy(xpath = "//td[contains(text(),'progress')]")})
    public List<WebElement> inProgressCount;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/main/div/div/div/div[2]/div/div[2]/div[2]/div")
    public WebElement shoppingAssertPage;

    public ShoppingPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void ShoppingBtn(){
        click(btnShopping);
    }
    public void getBeforeCount() throws InterruptedException {
        try{
            beforeCount = inProgressCount.size();
            System.out.println("beforeCount: "+beforeCount);
        }
        catch (NoSuchElementException e){
            beforeCount=0;
            System.out.println("beforeCount: "+beforeCount);
        }

    }
    public void getAfterCount(){
        afterCount = inProgressCount.size();
        System.out.println("afterCount: "+afterCount);
    }
    public boolean newShoppingReqCheck(){
        if (afterCount-beforeCount==1){
            return true;
        }
        else{
            return false;
        }
    }
    public void newRequestTabClick(){
        newRequestTab.click();
    } public void DescriptionInput(){
        inputDescription.sendKeys("This is a test description");
    }
    public void BrandInput(){
        inputBrand.sendKeys("Nike");
    }
    public void StyleInput(){
        inputStyle.sendKeys("Test style");
    }
    public void ColorInput(){
        inputColor.sendKeys("Green");
    }
    public void WebLinkInput(){
        inputWebLink.sendKeys("www.test.com");
    }
    public void popupClick(){popup.click();}
    public void statusDropdown(){statusDropdown.click();}
    public void allStatusClick(){allStatus.click();}
    public void inProgressStatusClick(){inProgressStatus.click();}
    public void completeStatusClick(){completeStatus.click();}
    public boolean noShopReqlabelCheck(){
        System.out.println("You have no shopping requests.");
        return noShopReqlabel.isDisplayed();
    }
    public boolean reqInprogressCheck(){
        return reqInprogress.isDisplayed();
    }
    public boolean reqCompleteCheck(){
        return reqComplete.isDisplayed();
    }
    public boolean reqAllCheck() throws NoSuchElementException{
        try {
            System.out.println("1");
            return reqInprogress.isDisplayed();
        }
        catch (NoSuchElementException ex1){
            System.out.println("2");
            return noShopReqlabel.isDisplayed();

        }
    }
    public boolean reqAllCheck2() throws NoSuchElementException{
        try {
            System.out.println("13");
            return reqComplete.isDisplayed();
        }
        catch (NoSuchElementException ex1){
            System.out.println("23");
            return noShopReqlabel.isDisplayed();
        }
    }
    public void RequestButton(){
        buttonRequest.click();
    }

}
