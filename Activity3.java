package testngpractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	WebDriver driver;
  @Test
  public void f() {
      driver.findElement(By.id("username")).sendKeys("admin");
      driver.findElement(By.id("password")).sendKeys("password");
      
      driver.findElement(By.xpath("//button[text()='Log in']")).click();
      
      Assert.assertEquals("Welcome Back, admin", driver.findElement(By.id("action-confirmation")).getText());
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
