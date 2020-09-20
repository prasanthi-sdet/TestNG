package testngpractice;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {
	WebDriver driver;
  @Test
  public void f1() {
	  String title=driver.getTitle();
	  System.out.println("The title of the page: "+title);
	  Assert.assertEquals("Target Practice", title);
  }
  @Test
  public void f2() {	
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  Assert.assertTrue(!driver.findElement(By.xpath("//button[@class='ui black button']")).isDisplayed());	  
  }
  
  @Test (enabled=false)
  public void f3() {
  }
  
  @Test
  public void f4() throws SkipException{
	  throw new SkipException("Testing Skipping Exception");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\PrasanthiChippidi\\Documents\\Personel\\SDET\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/target-practice");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
