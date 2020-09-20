package testngpractice;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity5 {
	WebDriver driver;
  @Test
  public void f1() {
	  String title=driver.getTitle();
	  System.out.println("The title of the page: "+title);
	  Assert.assertEquals("Target Practice", title);
  }
  @Test (groups= {"HeaderTests"})
  public void f2() {
	  Assert.assertEquals(driver.findElement(By.id("third-header")).getText(), "Third header");
  }
  
  @Test (groups= {"HeaderTests"})
  public void f5() {
	  Assert.assertEquals("rgb(251, 189, 8)", driver.findElement(By.id("third-header")).getCssValue("color"));
  }
  
  @Test (groups= {"ButtonTests"})
  public void f3() {
	  Assert.assertEquals(driver.findElement(By.cssSelector("button.olive")).getText(), "Olive");
  }
  
  @Test (groups= {"ButtonTests"})
  public void f4(){
	  System.out.println(driver.findElement(By.cssSelector("button.brown")).getCssValue("background-color"));
	  Assert.assertEquals("rgb(165, 103, 63)", driver.findElement(By.cssSelector("button.brown")).getCssValue("background-color"));
  }
  
  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\PrasanthiChippidi\\Documents\\Personel\\SDET\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/target-practice");
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  System.out.println("After class");
	  driver.close();
  }

}
