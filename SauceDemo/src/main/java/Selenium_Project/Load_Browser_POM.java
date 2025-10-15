package Selenium_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Load_Browser_POM {

	String url;
	WebDriver dr;
	public Load_Browser_POM(String url) {
		super();
		this.url = url;
	}
	public WebDriver load_the_Page()
	{

		dr=new EdgeDriver();
		dr.manage().window().maximize();
		dr.get(url);
		return dr;
	}
}
