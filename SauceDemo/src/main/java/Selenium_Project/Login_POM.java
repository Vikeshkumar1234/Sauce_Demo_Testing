package Selenium_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_POM {
    WebDriver dr;

    @FindBy(xpath="//*[@id='user-name']") WebElement username;
    @FindBy(xpath="//*[@id='password']") WebElement password;
    @FindBy(xpath="//*[@id='login-button']") WebElement button;
	public Login_POM(WebDriver dr) {
		super();
		this.dr = dr;
		PageFactory.initElements(dr,this);
	}
    public void enterUsername(String uname)
    {
    	username.sendKeys(uname);
    }
    public void enterPassword(String pwd)
    {
    	password.sendKeys(pwd);
    }
    public void clickButton()
    {
    	button.click();
    }
    public WebDriver returndriver()
    {
    	return dr;
    }
}
