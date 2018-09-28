package in.licious.pom;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.test.BaseTest;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;


public class LoginPage  {
	
/*public WebDriver driver;
DataBaseCCC data =new DataBaseCCC();
public void loginwithotp() throws ClassNotFoundException, SQLException, Throwable
{
	NewLoginFlow newlogin = new NewLoginFlow(driver);
	Helper helper = new Helper();
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://web.licious.in");
	helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
	Helper.customWait(2);
	newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	Helper.customWait(2);
	//etest.log(LogStatus.PASS,"Location is selected");
	 * 
	 
	WebElement location=driver.findElement(By.xpath("//span[@class='location-name']"));
	location.click();
	driver.findElement(By.xpath("//input[@id='location_pop']")).sendKeys("Indira Nagar Bangalore");
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_DOWN);
	
	//driver.findElement(By.xpath("//div[@class='use-my-loc']")).click();
	if(location.isDisplayed())
	{
		location.click();
		driver.findElement(By.xpath("//input[@id='location_pop']")).sendKeys("Indira Nagar Bangalore");
	//driver.findElement(By.xpath("//div[@class='use-my-loc']")).click();
	}else
	{
		driver.findElement(By.xpath("//div[@class='use-my-loc']")).click();
	}
	driver.manage().window().maximize();
driver.findElement(By.xpath("//a[contains(.,'Login')]")).click();
driver.findElement(By.xpath("//input[@class='user-id']")).sendKeys("8884948076");
driver.findElement(By.xpath("//button[text()='Proceed']")).click();
String otp=data.dataBaseCCC(driver);
driver.findElement(By.xpath("//input[@class='login-otp']")).sendKeys(otp);
driver.findElement(By.xpath("//button[text()='Login']")).click();*/


public void loginWithPassword()
{
	
}
}
