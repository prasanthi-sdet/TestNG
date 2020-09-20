package testngpractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity7 {
	WebDriver driver;
	
  @Test (dataProvider="Authentication")
  public void f(String username, String password) {
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.cssSelector("button[type='submit']")).click();
	  Assert.assertEquals(driver.findElement(By.id("action-confirmation")).getText(),"Welcome Back, admin");	  
  }
  
  @DataProvider(name="Authentication")
  public static Object[][] credentials(){
	  return new Object[][] { { "admin", "password" }};
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\PrasanthiChippidi\\Documents\\Personel\\SDET\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/login-form");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
