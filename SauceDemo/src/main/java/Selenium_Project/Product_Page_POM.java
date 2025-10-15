package Selenium_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Product_Page_POM {
     WebDriver dr;
     @FindBy(xpath="//*[@class='product_sort_container']") WebElement dropdown;
     @FindBy(xpath="//div[@class='inventory_container']//div//div[1]/a/div") WebElement product_click;
	public Product_Page_POM(WebDriver dr) {
		super();
		this.dr = dr;
		PageFactory.initElements(dr,this);
	}
   
	public void dropDown_click()
	{
		dropdown.click();
        Select opt=new Select(dropdown);
        opt.selectByIndex(2);
	}
	public void product_clicking()
	{
		product_click.click();
	}
}
