package Selenium_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_Page_POM {
	WebDriver dr;
	@FindBy(xpath="//*[@id='first-name']") WebElement fname;
	@FindBy(xpath="//*[@id='last-name']") WebElement lname;
	@FindBy(xpath="//*[@id='postal-code']") WebElement zipcode;
	@FindBy(xpath="//*[@id='continue']")WebElement continueBtn;
	public CheckOut_Page_POM(WebDriver dr) {
		super();
		this.dr = dr;
		PageFactory.initElements(dr,this);
	}
	public void firstname()
	{
		fname.click();
		fname.sendKeys("standard");
	}
	public void lastname()
	{
		lname.click();
		lname.sendKeys("user");
	}
	public void zipCode()
	{
		zipcode.click();
		zipcode.sendKeys("123456");
	}
	public void click_ContinueBtn()
	{
		continueBtn.click();
	}
}
