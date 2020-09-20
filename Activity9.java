package testngpractice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\PrasanthiChippidi\\Documents\\Personel\\SDET\\geckodriver-v0.27.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        Reporter.log("Starting Test |");
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened Browser |");
        Reporter.log("Page title is " + driver.getTitle() + " |");
    }
    
    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }

    @Test(priority = 0)
    public void simpleAlertTestCase() {
        Reporter.log("simpleAlertTestCase() started |");
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened |");
        
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
        Reporter.log("Alert text is: " + simpleAlert.getText() + " |");
        
        Assert.assertEquals("This is a JavaScript Alert!", simpleAlert.getText());

        simpleAlert.accept();
        Reporter.log("Alert closed");

        Reporter.log("Test case ended |");
    }

    @Test(priority = 1)
    public void confirmAlertTestCase() {
        Reporter.log("confirmAlertTestCase() started |");
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Confirm Alert opened |");

        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
        
        Reporter.log("Alert text is: " + confirmAlert.getText() + " |");
        
        Assert.assertEquals("This is a JavaScript Confirmation!", confirmAlert.getText());

        confirmAlert.accept();
        Reporter.log("Alert closed |");

        Reporter.log("Test case ended |");
    }

    @Test(priority = 2)
    public void promptAlertTestCase() {
        Reporter.log("promptAlertTestCase() started |");
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened |");

        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");

        Reporter.log("Alert text is: " + promptAlert.getText() + " |");

        promptAlert.sendKeys("Hello!");
        Reporter.log("Text entered in prompt alert |");
        
        Assert.assertEquals("This is a JavaScript Prompt!", promptAlert.getText());

        promptAlert.accept();
        Reporter.log("Alert closed |");

        Reporter.log("Test case ended |");
    }

    @AfterClass
    public void tearDown() {
        Reporter.log("Ending Test |");
        driver.close();
    }
}