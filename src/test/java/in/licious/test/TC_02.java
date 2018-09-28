package in.licious.test;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.HomePage;
import in.licious.pom.NewLoginFlow;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;
import in.licious.util.ReadData;

public class TC_02 extends BaseTest{
	String excelPath="C:\\Users\\Deepa\\git\\SeleniumWebDriver\\ExcelData\\loginCredentials11.xls";
	@SuppressWarnings("static-access")
	@Test()
	public void AddToCartTest() throws ClassNotFoundException, SQLException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
	NewLoginFlow newlogin = new NewLoginFlow(driver);
	DataBaseCCC db1=new DataBaseCCC();
	HomePage hp=new HomePage(driver);
	Helper helper = new Helper();
	helper.clickOnElement(driver, newlogin.getSelectLocation());
	Helper.customWait(2);
	helper.clickOnElement(driver, newlogin.getbengaluruDeliveryLocation());
	Helper.customWait(2);
	helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
	Helper.customWait(2);
	newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	Helper.customWait(2);
	etest.log(LogStatus.PASS,"Location is selected");
	
	// Click on Login in HomePage
	newlogin.getLogin().click();
	Helper.customWait(2);
	// Enter valid UserName and Password
	String phnNum=	ReadData.readDataFromExcel(excelPath, "loginData", 1, 2);
	/*helper.enterText(driver, newlogin.getMobileNumber(), phnNum);
	Helper.customWait(2);
	
	// Click on Proceed button
	helper.clickOnElement(driver, newlogin.getProceedBtn());
	helper.clickOnElement(driver, newlogin.getOTPlogin());
	Helper.customWait(2);
	String otp=db1.dataBaseCCC(driver);	
	System.out.println(otp);
	newlogin.enterLoginOTP().sendKeys(otp);
	
	
	Helper.customWait(10); 
	WebElement otpBtn=driver.findElement(By.xpath("//button[@class='btns otp-login enabled']"));
	
	
	js.executeScript("arguments[0].click();",otpBtn);
	//newlogin.getotploginbtn().click();
*/
	// Enter valid UserName and Password
			helper.enterText(driver, newlogin.getMobileNumber(), userName);
			Helper.customWait(2);
			
			// Click on Proceed button
			helper.clickOnElement(driver, newlogin.getProceedBtn());
			Helper.customWait(2);
					
			// Click on Password login 
			helper.clickOnElement(driver, newlogin.getpasswordLogin());
			Helper.customWait(2);
					
			// Enter the password
			helper.enterText(driver, newlogin.getenterpassword(), passWord);
			Helper.customWait(5);
			helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
	Helper.customWait(10); 
		 driver.findElement(By.xpath("//ul[@class='parent']/li[2]")).click();
		 Helper.customWait(5);
	//driver.findElement(By.xpath("(//div[@class='item-details'])[2]")).click();
	
WebElement addTocart=	driver.findElement(By.xpath("//button[@class='add-to-cart addCartBtn-home']"));
	js.executeScript("arguments[0].click();",addTocart);
	//driver.findElement(By.xpath("(//div[@class='item-details'])[3]")).click();
//	driver.findElement(By.xpath("//button[@class='add-to-cart addCartBtn-home']")).click();
	helper.clickOnElement(driver, hp.getCartButtonClick());
WebElement proceedBTN=	driver.findElement(By.xpath("//button[@class='btn-proceed']"));
if(proceedBTN.isDisplayed())
{
	System.out.println("pass");
	proceedBTN.click();
	}
else
	{
		System.out.println("fail");
	}
Helper.customWait(2);
driver.findElement(By.xpath("//button[@class='complete-address']")).click();
Helper.customWait(2);
driver.findElement(By.xpath("(//div[@class='slots-selector'])[1]")).click();
Helper.customWait(2);
List slots=driver.findElements(By.xpath("//div[@class='slot-day']/following-sibling::ul"));
String slot1="//div[@class='slot-day']/following-sibling::ul[1]/li[1]";
String slot2="//div[@class='slot-day']/following-sibling::ul[1]/li[2]";
String slot3="//div[@class='slot-day']/following-sibling::ul[1]/li[3]";
String slot4="//div[@class='slot-day']/following-sibling::ul[1]/li[4]";
String slot5="//div[@class='slot-day']/following-sibling::ul[1]/li[5]";
WebElement slot1wb=driver.findElement(By.xpath(slot1));
WebElement slot2wb=driver.findElement(By.xpath(slot2));
WebElement slot3wb=driver.findElement(By.xpath(slot3));
WebElement slot4wb=driver.findElement(By.xpath(slot4));
WebElement slot5wb=driver.findElement(By.xpath(slot5));
/*if(slot1wb.isSelected())
{
	slot1wb.click();
}else if(slot2wb.isSelected())
{
	slot2wb.click();
}else if(slot3wb.isSelected())
{	
slot3wb.click();
}else if(slot4wb.isSelected())
{
slot4wb.click();
	}else if(slot5wb.isSelected())
	{
	slot5wb.click();	
	}*/
slot1wb.click();
Helper.customWait(2);
slot2wb.click();
Helper.customWait(2);
slot3wb.click();
Helper.customWait(2);
slot4wb.click();
Helper.customWait(2);
slot5wb.click();
Helper.customWait(2);
driver.findElement(By.xpath("//button[@class='complete-shipments']")).click();
helper.customWait(2);
helper.clickOnElement(driver, hp.getCartButtonClick());	
String value=driver.findElement(By.xpath("(//span[@class='number prd-pr_574f256be6c0a'])[1]")).getText();
helper.customWait(2);
driver.findElement(By.xpath("(//span[@class='plus-one'])[1]")).click();
helper.customWait(2);
driver.findElement(By.xpath("(//span[@class='plus-one'])[1]")).click();
helper.customWait(2);
String value1=driver.findElement(By.xpath("(//span[@class='number prd-pr_574f256be6c0a'])[1]")).getText();
if(value.equals(value1))
{
	System.out.println("Product not get added "+value);
}else
{
	System.out.println("Product get added "+value1);
}
	}	
}
