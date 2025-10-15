package SauceDemo_TestNG;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Selenium_Project.Add_to_Cart_Page_POM;
import Selenium_Project.CheckOut_Page_POM;
import Selenium_Project.ExcelReading_Values_POM;
import Selenium_Project.Load_Browser_POM;
import Selenium_Project.Login_POM;
import Selenium_Project.Product_Add_POM;
import Selenium_Project.Product_Page_POM;
import Selenium_Project.Summary_Bill_Page_POM;
import junit.framework.Assert;

public class test001 {
	static WebDriver driver;
	Login_POM login; 
	Product_Page_POM product;
	Product_Add_POM addProduct;
	Add_to_Cart_Page_POM cartPage;
	CheckOut_Page_POM coutPage;
	Summary_Bill_Page_POM billPage;
	String check;
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
		 addProduct=new Product_Add_POM(driver);
		 cartPage=new Add_to_Cart_Page_POM(driver);
		 coutPage=new CheckOut_Page_POM(driver);
		 billPage=new Summary_Bill_Page_POM(driver);
	}
  @Test(priority = 1)
  public void validating_the_Title(){
	  System.out.println(driver.getTitle());
	  Assert.assertEquals("Swag Labs",driver.getTitle());
  }
  @Test(priority = 2)
  public void validating_the_URL(){
	  System.out.println(driver.getCurrentUrl());
	  Assert.assertEquals("https://www.saucedemo.com/",driver.getCurrentUrl());
  }
  @Test(priority = 3)
  public void read_the_credential() throws Exception{
	  ExcelReading_Values_POM read=new ExcelReading_Values_POM();
	  ArrayList<String>credentials=read.read_the_values();
	  System.out.println(credentials);
//	  driver=Selenium_Project.Operations.entering_the_credentials(credentials.get(0),credentials.get(1));
	  login.enterUsername(credentials.get(0));
	  login.enterPassword(credentials.get(1));
	  login.clickButton();
	  Assert.assertEquals("Products",driver.findElement(By.xpath("//*[@class='title']")).getText());
  }
  @Test(priority = 4)
  public void Validating_the_DropDown(){
	   product.dropDown_click();
	   check=driver.findElement(By.xpath("//div[@class='inventory_container']//div//div[1]/a/div")).getText();
	   Assert.assertEquals("Sauce Labs Onesie",check);
  }
  @Test(priority = 5)
  public void Clicking_the_first_product()
  {
	  product.product_clicking();
  } 
  @Test(priority = 6)
  public void clicking_the_add_to_cart()
  {
	  addProduct.add_to_cart_click();
  }
  @Test(priority = 7)
  public void add_to_cart_page_and_checkout()
  {
	  Assert.assertEquals(check,driver.findElement(By.xpath("//div[@class='cart_list']//div[3]//div[2]//div")).getText());
	  cartPage.checkoutbtn();
  }
  @Test(priority = 8)
  public void checkout_Details()
  {
	  coutPage.firstname();
      coutPage.lastname();
      coutPage.zipCode();
      coutPage.click_ContinueBtn();
  }
  @Test(priority = 9)
  public void summary_Page()
  {
	  billPage.click_the_finishbtn();
  }
  @Test(priority =10)
  public void order_placed_msg()
  {
	  Assert.assertEquals("Thank you for your order!",driver.findElement(By.xpath("//*[@class='complete-header']")).getText());
  }
  @AfterClass
  public void closing_the_Browser()
  {
	  driver.quit();
  }
  }
