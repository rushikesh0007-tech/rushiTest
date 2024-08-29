package pages;

import base.App;
import base.ExtentReport;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    WebDriver driver;

    /*public LoginPage(){
        //driver = PageDriver.getDriver();
        driver = PageDriver.getCurrentDriver();

        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "user-name")
    public WebElement userName;

    @FindBy(id = "password")
    @CacheLookup
    public WebElement password;

    @FindBy(how = How.ID, using = "login-button")
    public WebElement signIn;*/

    /*@FindBy(how = How.ID, using = "name")
    public List<WebElement> items_name;

    @FindBys( //and operator
            {
                    @FindBy(id="x"),
                    @FindBy(css="y")
            }
    )
    public List<WebElement> items;

    @FindAll( //or operator
            {
                    @FindBy(id="x"),
                    @FindBy(css="y")
            }
    )
    public List<WebElement> itemsList;*/


    By userName = By.id("user-name");
    By password = By.id("password");
    By signIn = By.id("login-button");
    By invalidPasswordError = By.cssSelector("[data-test='error']");

    public void login(String username, String Password){
        /*userName =  driver.findElement(By.id("user-name"));
        password =  driver.findElement(By.id("password"));
        signIn =  driver.findElement(By.id("login-button"));*/
            //driver.findElement(userName).sendKeys(username);
            //driver.findElement(password).sendKeys(Password);
        //userName.sendKeys(username);
        //password.sendKeys(Password);
        //signIn.click();

        type(userName, username);
        ExtentReport.getTest().log(Status.INFO, "entered username");
        type(password, Password);
        click(signIn);
    }

    public void login(){
        type(userName, App.validUserName);
        type(password, App.validPassword);
        click(signIn);
    }

    public WebElement getElementBasedOntext(String text){
        return driver.findElement(By.xpath("//[contains(text(), '"+text+"']"));
    }

    public String getInvalidPasswordErrorText(){
        return getText(invalidPasswordError);
    }

}
