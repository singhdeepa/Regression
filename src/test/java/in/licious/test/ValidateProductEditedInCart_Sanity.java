package in.licious.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.HomePage;
import in.licious.pom.NewLoginFlow;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;
import in.licious.util.ReadData;

public class ValidateProductEditedInCart_Sanity extends BaseTest{
@Test
public void validateProductEditedInCartTest() throws Exception
{
	String excelPath="C:\\Users\\Deepa\\git\\SeleniumWebDriver\\ExcelData\\loginCredentials11.xls";
	NewLoginFlow newlogin = new NewLoginFlow(driver);
	DataBaseCCC db1=new DataBaseCCC();
	HomePage hp=new HomePage(driver);
	Helper helper = new Helper();
helper.highlightElement(driver, newlogin.getSelectLocation());
helper.clickOnElement(driver, newlogin.getSelectLocation());
Helper.customWait(2);
helper.highlightElement(driver, newlogin.getbengaluruDeliveryLocation());
helper.clickOnElement(driver, newlogin.getbengaluruDeliveryLocation());
Helper.customWait(2);
helper.highlightElement(driver, newlogin.getLoactionTxtBox());
helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
Helper.customWait(2);
newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
Helper.customWait(2);
etest.log(LogStatus.PASS,"Location is selected");

// Click on Login in HomePage
newlogin.getLogin().click();
Helper.customWait(2);
// Enter valid UserName and Password
helper.highlightElement(driver, newlogin.getMobileNumber());
helper.enterText(driver, newlogin.getMobileNumber(), userName);
Helper.customWait(2);

// Click on Proceed button
helper.highlightElement(driver, newlogin.getProceedBtn());
helper.clickOnElement(driver, newlogin.getProceedBtn());
Helper.customWait(2);
		
// Click on Password login 
helper.highlightElement(driver, newlogin.getpasswordLogin());
helper.clickOnElement(driver, newlogin.getpasswordLogin());
Helper.customWait(2);
		
// Enter the password
helper.highlightElement(driver, newlogin.getenterpassword());
helper.enterText(driver, newlogin.getenterpassword(), passWord);
Helper.customWait(5);
//helper.highlightElement(driver, newlogin.getpasswordloginBtn());
//helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
Helper.safeJavaScriptClick(driver,newlogin.getpasswordloginBtn());
Helper.customWait(5);
String expWeekendsTreatLink="Weekend Treats";

WebElement WeekendsTreatLink=driver.findElement(By.xpath("//a[@href='/delicious-deals']"));
String actWeekendsTreatLink=WeekendsTreatLink.getText();
 helper.highlightElement(driver, WeekendsTreatLink);
Assert.assertEquals(actWeekendsTreatLink, expWeekendsTreatLink);
etest.log(LogStatus.PASS,"Weekends Treat link is validated successfully");	
Helper.customWait(5);
if(WeekendsTreatLink.isDisplayed())
{
WeekendsTreatLink.click();
//Helper.safeJavaScriptClick(driver,WeekendsTreatLink);
//Assert.assertTrue(true, "Weekends Treat link is Clicked successfully");
etest.log(LogStatus.PASS,"Weekends Treat link is Clicked successfully");
}else
{
	etest.log(LogStatus.PASS,"Weekends Treat link is Not Clicked successfully");
}

WebElement addToCart=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/button"));
WebElement numberOfProductInCart=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/p/span[2]"));
WebElement addTocartByOne=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/p/span[3]"));
WebElement minusTocartByOne=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/p/span[1]"));

helper.highlightElement(driver, addToCart);
if(addToCart.isDisplayed())
{
	Helper.safeJavaScriptClick(driver,addToCart);
//addToCart.click();
}else
{
	/*addTocartByOne.click();
	addTocartByOne.click();
	addTocartByOne.click();*/
	Helper.safeJavaScriptClick(driver,addTocartByOne);
	Helper.customWait(2);
	Helper.safeJavaScriptClick(driver,addTocartByOne);
	Helper.customWait(2);
	Helper.safeJavaScriptClick(driver,addTocartByOne);
	Helper.customWait(2);
}
//WebElement numberOfProductInCart=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/p/span[2]"));
String numberOfProductInCartBeforeadd=numberOfProductInCart.getText();
//WebElement addTocartByOne=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/p/span[3]"));
helper.highlightElement(driver, addTocartByOne);
//addTocartByOne.click();
Helper.safeJavaScriptClick(driver,addTocartByOne);
Helper.customWait(2);
//addTocartByOne.click();
Helper.safeJavaScriptClick(driver,addTocartByOne);
Helper.customWait(2);
//addTocartByOne.click();
Helper.safeJavaScriptClick(driver,addTocartByOne);
Helper.customWait(2);
String numberOfProductInCartAftereadd=numberOfProductInCart.getText();
if(numberOfProductInCartBeforeadd.equals(numberOfProductInCartAftereadd))
{
	etest.log(LogStatus.FAIL,"Product is not added in cart ");	
}else
{
	etest.log(LogStatus.PASS,"Product is  added in cart ");	
}
helper.highlightElement(driver, numberOfProductInCart);
numberOfProductInCart.getText();
String numberOfProductInCartbeforeminus=numberOfProductInCart.getText();
helper.highlightElement(driver, minusTocartByOne);
//minusTocartByOne.click();
Helper.safeJavaScriptClick(driver,minusTocartByOne);
Helper.customWait(2);
Helper.safeJavaScriptClick(driver,minusTocartByOne);
Helper.customWait(2);
String numberOfProductInCartAfterminus=numberOfProductInCart.getText();
if(numberOfProductInCartbeforeminus.equals(numberOfProductInCartAfterminus))
{
	etest.log(LogStatus.FAIL,"Product is  not Deleted in cart");	
}else
{
	etest.log(LogStatus.PASS,"Product is   Deleted in cart");	
}

WebElement UserLink=driver.findElement(By.xpath("//a[@class='user']"));
helper.highlightElement(driver, UserLink);
   UserLink.click();
//UserLink.click();

Helper.customWait(5);
WebElement userLogout=driver.findElement(By.xpath("//a[@class='user-logout']"));
if(userLogout.isDisplayed())
		{
	helper.highlightElement(driver, userLogout);
	Helper.safeJavaScriptClick(driver,userLogout);
	 etest.log(LogStatus.PASS,"Logout Button is Clicked successfully"); 
		}else
		{
			 etest.log(LogStatus.FAIL,"Logout Button is Not Clicked successfully"); 
		}




}
}