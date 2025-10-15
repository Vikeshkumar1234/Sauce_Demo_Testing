package Selenium_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_to_Cart_Page_POM {
	WebDriver dr;
	@FindBy(xpath="//*[@id='checkout']") WebElement item;
	public Add_to_Cart_Page_POM(WebDriver dr) {
		super();
		this.dr = dr;
		PageFactory.initElements(dr,this);
	}
	public void checkoutbtn()
	{
		item.click();
	}
}
