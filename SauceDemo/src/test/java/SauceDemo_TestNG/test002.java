package SauceDemo_TestNG;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Selenium_Project.ExcelReading_Values_POM;
import Selenium_Project.Load_Browser_POM;
import Selenium_Project.Login_POM;
import Selenium_Project.Product_Page_POM;
import junit.framework.Assert;

public class test002 {
	static WebDriver driver;
	Login_POM login; 
	Product_Page_POM product;
	@BeforeClass
	public void open_the_browser()
	{
		Load_Browser_POM load=new Load_Browser_POM("https://www.saucedemo.com/");
		driver=load.load_the_Page();
	}
	@BeforeMethod
	public void object_creation()
	{
		login=new Login_POM(driver);
		product=new Product_Page_POM(driver);
	}
	@Test
	public void read_the_credential() throws Exception{
		ExcelReading_Values_POM read=new ExcelReading_Values_POM();
		ArrayList<String>credentials=read.read_the_values();
		System.out.println(credentials);
		//		  driver=Selenium_Project.Operations.entering_the_credentials(credentials.get(0),credentials.get(1));
		login.enterUsername(credentials.get(0));
		login.enterPassword(credentials.get(1));
		login.clickButton();
		Assert.assertEquals("Products",driver.findElement(By.xpath("//*[@class='title']")).getText());
		List<WebElement>links=driver.findElements(By.xpath("//a"));
		for(WebElement ele:links)
		{
			if(ele.getText().length()>0)
			System.out.println(ele.getText());
		}
		driver.quit();
	}
}
