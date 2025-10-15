package Selenium_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Add_POM {
     WebDriver dr;
     @FindBy(xpath="//*[@id='add-to-cart']")WebElement addBtn;
     @FindBy(xpath="//*[@id='shopping_cart_container']/a")WebElement cartBtn;
	public Product_Add_POM(WebDriver dr) {
		super();
		this.dr = dr;
		PageFactory.initElements(dr,this);
	}
     public void add_to_cart_click()
     {
    	 addBtn.click();
    	 cartBtn.click();
     }
}
