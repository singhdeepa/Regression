package in.licious.test;

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

public class SuscribeToNewLetter_Sanity extends BaseTest {
@Test
public void suscribeToNewLetterTest() throws Exception
{   
	
	String liciousHomePageTitle="Buy meat online |Shop for tender and fresh meat online |Licious.in";
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
	Helper.customWait(6);
	try
	{
	WebElement  newsLetter=driver.findElement(By.xpath("//img[@alt='Licious | News Letter']"));
    helper.highlightElement(driver, newsLetter);
    Boolean newsLetterPresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", newsLetter);
   
    if (!newsLetterPresent)
    {
    	etest.log(LogStatus.FAIL,"Licious | News Letter Image is Not Verified as Expected ");
    }
    else
    {
    	etest.log(LogStatus.PASS,"Licious | News Letter Image is  Verified as Expected"+newsLetter);
    }
    Helper.customWait(5);
    WebElement phoneNumandMobilenum=driver.findElement(By.xpath("//input[@placeholder='Enter Phone number / Email']")); 
    if(phoneNumandMobilenum.isDisplayed())
    {
    helper.highlightElement(driver, phoneNumandMobilenum);
    phoneNumandMobilenum.sendKeys("8884948678");
    Helper.customWait(5);
    etest.log(LogStatus.PASS,"Mobile Number is entered Successfully");
    }
    else
    {
    	etest.log(LogStatus.FAIL,"Mobile Number is Not entered ");
    }
    
    WebElement submitButton=driver.findElement(By.xpath("//button[@class='nl-btn']"));
    if(submitButton.isDisplayed())
    {
    	
    helper.highlightElement(driver, submitButton);
    Helper.safeJavaScriptClick(driver,submitButton);
    
    Helper.customWait(5);
    etest.log(LogStatus.PASS,"Submit Button is Clicked Successfully");
    }else
    {
    	 etest.log(LogStatus.FAIL,"Submit Button is Not  Clicked ");
    }
	}catch (Exception e) {
	// TODO: handle exception
}
	/* Helper.customWait(5);
    WebElement UserLink=driver.findElement(By.xpath("//a[@class='user']"));
	helper.highlightElement(driver, UserLink);
	Helper.safeJavaScriptClick(driver,UserLink);
       //Helper.customWait(5);
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
				 etest.log(LogStatus.FAIL,"Logout Button is Not Clicked "); 
			}*/
	//Helper.customWait(5);
	//driver.quit();
}
}
