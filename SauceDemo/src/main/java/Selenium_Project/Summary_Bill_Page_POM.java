package Selenium_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Summary_Bill_Page_POM {
    WebDriver dr;
    @FindBy(xpath="//*[@id='finish']") WebElement fnhbtn;
	public Summary_Bill_Page_POM(WebDriver dr) {
		super();
		this.dr = dr;
		PageFactory.initElements(dr,this);
	}
    public void click_the_finishbtn()
    {
    	Actions act=new Actions(dr);
    	act.scrollByAmount(0,100).perform();
    	fnhbtn.click();
    }
}
