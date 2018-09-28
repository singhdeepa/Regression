package in.licious.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.HomePage;
import in.licious.pom.NewLoginFlow;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class ValidateLiciousHomePage_Sanity extends BaseTest {
@Test
public void LiciousHomePageTest() throws Exception
{
	String liciousHomePageTitle="Buy meat online |Shop for tender and fresh meat online |Licious.in";
	  JavascriptExecutor js = (JavascriptExecutor) driver;
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

	String expLiciousTitle="Buy meat online |Shop for tender and fresh meat online |Licious.in";
	String actLiciousTitle=driver.getTitle();
	Assert.assertEquals(actLiciousTitle, expLiciousTitle);
	etest.log(LogStatus.PASS,"Title is Verified as Expected "+actLiciousTitle);
	WebElement Logo = driver.findElement(By.xpath("//img[@alt='licious']"));
	helper.highlightElement(driver, Logo);
    Boolean logoPresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", Logo);
    if (!logoPresent)
    {
    	etest.log(LogStatus.FAIL,"Licious Logo is Not Verified as Expected ");
    }
    else
    {
    	etest.log(LogStatus.PASS,"Licious Logo is  Verified as Expected"+Logo);
    }
    Helper.customWait(5);
   /* WebElement  newsLetter=driver.findElement(By.xpath("//img[@alt='Licious | News Letter']"));
    helper.highlightElement(driver, newsLetter);
    Boolean newsLetterPresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", newsLetter);
    WebElement phoneNumandMobilenum=driver.findElement(By.xpath("//input[@placeholder='Enter Phone number / Email']"));
    if (!newsLetterPresent)
    {
    	etest.log(LogStatus.FAIL,"Licious | News Letter Image is Not Verified as Expected ");
    }
    else
    {
    	etest.log(LogStatus.PASS,"Licious | News Letter Image is  Verified as Expected"+newsLetter+" and Enter Phone number / Email Text Box is Present as expected");
    }*/
    
  //Verify Usefull Links
    js.executeScript("window.scrollBy(0,100)");
    Helper.customWait(5);
  WebElement  usefullLinks=  driver.findElement(By.xpath("//li[contains(text(),'useful Links')]"));
 // helper.scrollBar1(driver,usefullLinks);

  helper.highlightElement(driver, usefullLinks);
  if(usefullLinks.isDisplayed())
  {
	  etest.log(LogStatus.PASS,"useful Links is  Present as Expected ");
  }else
  {
	  etest.log(LogStatus.FAIL,"useful Links is Not Present as Expected ");  
  }
  
   WebElement whyLiciousLink=driver.findElement(By.xpath("//a[@href='/about-us']"));
   helper.highlightElement(driver, whyLiciousLink);
   if(whyLiciousLink.isDisplayed())
   {
	   
	/*// Store the current window handle
	   String winHandleBefore = driver.getWindowHandle();

	   // Perform the click operation that opens new window
	   whyLiciousLink.click();
	   // Switch to new window opened
	   for(String winHandle : driver.getWindowHandles()){
	       driver.switchTo().window(winHandle);
	   }

	   // Perform the actions on new window

	   // Close the new window, if that window no more required
	   driver.close();

	   // Switch back to original browser (first window)
	   driver.switchTo().window(winHandleBefore);

	   // Continue with original browser (first window)
*/	  
	   Helper.safeJavaScriptClick(driver,whyLiciousLink);
	   Helper.customWait(5);
	   String aboutLiciousTitle="Licious - About us";
	   Helper.switchOnWindowBasedOnTitle(driver,aboutLiciousTitle);
	  // Helper. switchOnWindowBasedOnTitle(driver,"Licious - About us");
	  Helper.customWait(2);
	 //  driver.switchTo().window(currentWindow).getTitle().equals("Buy meat online |Shop for tender and fresh meat online |Licious.in");
 	  etest.log(LogStatus.PASS,"whyLicious Link  is  Present as Expected and Is Clicked Successfully ");
   }else
   {
 	  etest.log(LogStatus.FAIL,"whyLicious Link is Not Present as Expected ");  
   } 
   
   
   WebElement referAndEarnLink=driver.findElement(By.xpath("//a[@href='/refer-earn-tnc']"));
   helper.highlightElement(driver, referAndEarnLink);
   if(referAndEarnLink.isDisplayed())
   {
	   Helper.safeJavaScriptClick(driver,referAndEarnLink);
	   Helper.customWait(5);
	   String referAndearnTitle="Refer and Earn";
	 //  referAndEarnLink.click();
	   Helper.switchOnWindowBasedOnTitle(driver,referAndearnTitle);
	  
 	  etest.log(LogStatus.PASS,"Useful Links - Refer & Earn Link  is  Present as Expected and Is Clicked Successfully ");
   }else
   {
 	  etest.log(LogStatus.FAIL,"Useful Links - Refer & Earn Link is Not Present as Expected ");  
   } 
   Helper.customWait(2);
   
   WebElement liciousCashAndCashPlus=driver.findElement(By.xpath("//a[@href='/licious-cash']"));
   helper.highlightElement(driver, liciousCashAndCashPlus);
  /* if(liciousCashAndCashPlus.isDisplayed())
   {
	 //  Helper.switchOnWindowBasedOnTitle(driver,liciousCashAndCashPlus);
	   Helper.safeJavaScriptClick(driver,liciousCashAndCashPlus);
	   String cashAndCashPlustitle=""
 	  etest.log(LogStatus.PASS,"Useful Links - Licious Cash & Cash+ Link  is  Present as Expected and Is Clicked Successfully");
   }else
   {
 	  etest.log(LogStatus.FAIL,"Useful Links - Licious Cash & Cash+ Link is Not Present as Expected ");  
   } */
   WebElement careerLink=driver.findElement(By.xpath("//a[contains(text(),'Careers')]"));
   helper.highlightElement(driver, careerLink);
   String careerTitle="Jobs – Licious – Careers";
   if(careerLink.isDisplayed())
   {
	   Helper.safeJavaScriptClick(driver,careerLink);
	   Helper.customWait(5);
	   Helper. switchOnWindowBasedOnTitle(driver,careerTitle);
 	  etest.log(LogStatus.PASS,"Careers Links   is  Present as Expected and Is Clicked Successfully");
   }else
   {
 	  etest.log(LogStatus.FAIL,"Careers Links  is Not Present as Expected ");  
   }
   Helper.customWait(2);
   WebElement BLOGLink=driver.findElement(By.xpath("//a[contains(text(),'BLOG')]"));
   String BlogTitle="Licious – Blog – Your Great Meal Begins Here";
   helper.highlightElement(driver, BLOGLink);
   if(BLOGLink.isDisplayed())
   {
	   Helper.safeJavaScriptClick(driver,BLOGLink);
	   Helper.customWait(5);
	   Helper.switchOnWindowBasedOnTitle(driver,BlogTitle);
 	  etest.log(LogStatus.PASS,"Careers Link   is  Present as Expected  and Is Clicked Successfully");
   }else
   {
 	  etest.log(LogStatus.FAIL,"Careers Link  is Not Present as Expected ");  
   } 
   Helper.customWait(2);
   WebElement campaignLink=driver.findElement(By.xpath("//a[contains(text(),'Campaign')]"));
   helper.highlightElement(driver, campaignLink);
   String campaignTitle="Campaign";
   if(campaignLink.isDisplayed())
   {
	   Helper.safeJavaScriptClick(driver,campaignLink);
	   Helper.customWait(5);
	   Helper.switchOnWindowBasedOnTitle(driver,campaignTitle);
 	  etest.log(LogStatus.PASS,"Careers Links   is  Present as Expected and Is Clicked Successfully");
   }else
   {
 	  etest.log(LogStatus.FAIL,"Careers Links  is Not Present as Expected ");  
   } 
   Helper.customWait(2);
   
   WebElement aboutUSLink=driver.findElement(By.xpath("(//a[contains(text(),'About Us')])[2]"));
   helper.highlightElement(driver, aboutUSLink);
   String aboutTitle="Licious - About us";
   if(aboutUSLink.isDisplayed())
   {
	   Helper.safeJavaScriptClick(driver,aboutUSLink);
	   Helper.customWait(5);
	 Helper.switchOnWindowBasedOnTitle(driver,aboutTitle);

 	  etest.log(LogStatus.PASS,"About Us Link   is  Present as Expected and Is Clicked Successfully");
   }else
   {
 	  etest.log(LogStatus.FAIL,"About Us Link  is Not Present as Expected ");  
   }
   Helper.customWait(2);
   
   WebElement CertificationLink=driver.findElement(By.xpath("(//a[contains(text(),'FSSC 22000 Certification')])[2]"));
   helper.highlightElement(driver, CertificationLink);
   String certificationTitle="Licious - How Licious Cash Works";
   if(CertificationLink.isDisplayed())
   {
	   Helper.safeJavaScriptClick(driver,CertificationLink);
	   Helper.customWait(5);
	 Helper.switchOnWindowBasedOnTitle(driver,certificationTitle);

 	  etest.log(LogStatus.PASS,"FSSC 22000 Certification Link   is  Present as Expected and Is Clicked Successfully ");
   }else
   {
 	  etest.log(LogStatus.FAIL,"FSSC 22000 Certification Link  is Not Present as Expected ");  
   } 
   driver.close();
  /* Helper.customWait(8);
   
   WebElement UserLink=driver.findElement(By.xpath("//a[@class='user']"));
	helper.highlightElement(driver, UserLink);
      UserLink.click();
	//UserLink.click();

	Helper.customWait(5);
	WebElement userLogout=driver.findElement(By.xpath("//a[@class='user-logout']"));
	if(UserLink.isDisplayed())
			{
		helper.highlightElement(driver, userLogout);
		userLogout.click();
		 etest.log(LogStatus.PASS,"Logout Button is Clicked successfully"); 
			}else
			{
				 etest.log(LogStatus.FAIL,"Logout Button is Not Clicked successfully"); 
			}
	*/
}
}
