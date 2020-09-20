package testngpractice;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	WebDriver driver;
	
	@BeforeMethod
	public void f() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\PrasanthiChippidi\\Documents\\Personel\\SDET\\geckodriver-v0.27.0-win64\\geckodriver.exe");  
		driver=new FirefoxDriver();
		driver.get("https://www.training-support.net");
	}
	  
	@Test
	public void beforeMethod() {
		String title=driver.getTitle();
		System.out.println("The title of the page: "+title);
		Assert.assertEquals("Training Support", title);
		title=driver.getTitle();
		driver.findElement(By.id("about-link")).click();
		System.out.println("The title of the new page: "+title);
		Assert.assertEquals("Training Support", title);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
