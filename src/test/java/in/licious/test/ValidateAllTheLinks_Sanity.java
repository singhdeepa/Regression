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
import in.licious.util.ReadData;

public class ValidateAllTheLinks_Sanity extends BaseTest {
	
	
	@Test()
	public void validateAllTheLinksTest() throws Exception,Throwable
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
			WebElement weekendTreat=driver.findElement(By.xpath("//a[@href='/delicious-deals']"));
	        String actWeekendsTreatLink=weekendTreat.getText();
	        helper.highlightElement(driver, weekendTreat);
	        Helper.customWait(5);
			Assert.assertEquals(actWeekendsTreatLink, expWeekendsTreatLink);
			etest.log(LogStatus.PASS,"Weekends Treat link is validated successfully");	
			Helper.customWait(5);
			
			weekendTreat.click();
			Assert.assertTrue(true, "Weekends Treat link is Clicked successfully");
			etest.log(LogStatus.PASS,"Weekends Treat link is Clicked successfully");
				
			Helper.customWait(5);
			WebElement chicken=driver.findElement(By.xpath("//a[@href='/chicken']"));
			String expChickenLink="Chicken";
			 helper.highlightElement(driver, chicken);
			 Helper.customWait(5);
		   String actChickenLink=chicken.getText();
		   Assert.assertEquals(actChickenLink, expChickenLink);
		   etest.log(LogStatus.PASS,"Chicken Link is validated successfully");
		   Helper.customWait(5);
		   chicken.click();
			Assert.assertTrue(true, "Chicken  link is Clicked successfully");
			etest.log(LogStatus.PASS,"Chicken  link is Clicked successfully");
			Helper.customWait(5);
			
			WebElement fishAndSeaFood=driver.findElement(By.xpath("//a[@href='/seafood']"));
		   String expFishAndSeaFoodlink="Fish & Seafood";
		   helper.highlightElement(driver, fishAndSeaFood);
		   Helper.customWait(5);
		   String actFishAndSeaFoodlink=fishAndSeaFood.getText();
		   Assert.assertEquals(actFishAndSeaFoodlink, expFishAndSeaFoodlink);
		   etest.log(LogStatus.PASS,"Fish & Seafood Link is validated successfully");
		   Helper.customWait(5);
		   fishAndSeaFood.click();
			Assert.assertTrue(true, "Fish & Seafood  link is Clicked successfully");
			etest.log(LogStatus.PASS,"Fish & Seafood  link is Clicked successfully");
			Helper.customWait(5);
			
			WebElement todaysDeals=driver.findElement(By.xpath("//a[contains(text(),'Deals-bk')]"));
		   String expTodaysDealsBKLink="Today's Deals-bk";
		   helper.highlightElement(driver, todaysDeals);
		   Helper.customWait(5);
		   String actTodaysDealsBKLink=todaysDeals.getText();
		   Assert.assertEquals(actTodaysDealsBKLink, expTodaysDealsBKLink);
		   etest.log(LogStatus.PASS,"Today's Deals-bk Link is validated successfully");
		   Helper.customWait(5);
		   todaysDeals.click();
			Assert.assertTrue(true, "Today's Deals-bk  link is Clicked successfully");
			etest.log(LogStatus.PASS,"Today's Deals-bk  link is Clicked successfully"); 
			Helper.customWait(5);
			
			WebElement marinades=driver.findElement(By.xpath("//a[@href='/marinades']"));
		   String expMarinadesLink="Marinades";
		   helper.highlightElement(driver, marinades);
		   Helper.customWait(5);
		   String actMarinadesLink=marinades.getText();
		   Assert.assertEquals(actMarinadesLink, expMarinadesLink);
		   etest.log(LogStatus.PASS,"Marinades Link is validated successfully");
		   Helper.customWait(5);
		   marinades.click();
			Assert.assertTrue(true, "Marinades  link is Clicked successfully");
			etest.log(LogStatus.PASS,"Marinades  link is Clicked successfully"); 
			Helper.customWait(5);
			
			WebElement redMeat=driver.findElement(By.xpath("//a[@href='/red-meat']"));
			String expredMeatLink="Red Meat";
			 helper.highlightElement(driver, redMeat);
			 Helper.customWait(5);
			String actRedMeatLink=redMeat.getText();
			Assert.assertEquals(actRedMeatLink, expredMeatLink);
			etest.log(LogStatus.PASS,"Red Meat Link is validated successfully");
			Helper.customWait(5);
			redMeat.click();
			Assert.assertTrue(true, "Red Meat  link is Clicked successfully");
			etest.log(LogStatus.PASS,"Red Meat  link is Clicked successfully"); 
			Helper.customWait(5);
			
			WebElement exoticMeat=driver.findElement(By.xpath("//a[@href='/exotic']"));
			String expExoticMeatsLink="Exotic Meats";
			 helper.highlightElement(driver, exoticMeat);
			 Helper.customWait(5);
			String actExoticMeatsLink=exoticMeat.getText();
			Assert.assertEquals(actExoticMeatsLink, expExoticMeatsLink);
			etest.log(LogStatus.PASS,"Exotic Meats Link is validated successfully");
			Helper.customWait(5);
			exoticMeat.click();
			Assert.assertTrue(true, "Exotic Meat  link is Clicked successfully");
			etest.log(LogStatus.PASS,"Exotic Meat  link is Clicked successfully"); 
			Helper.customWait(5);
			
			WebElement eggs=driver.findElement(By.xpath("//a[@href='/eggs']"));
			String expEggsLink="Eggs";
			 helper.highlightElement(driver, eggs);
			 Helper.customWait(5);
			String actEEggsLink=eggs.getText();
			Assert.assertEquals(actEEggsLink, expEggsLink);
			etest.log(LogStatus.PASS," Eggs Link is validated successfully");
			Helper.customWait(5);
			eggs.click();
			Assert.assertTrue(true, "Eggs  link is Clicked successfully");
			etest.log(LogStatus.PASS,"Eggs  link is Clicked successfully"); 
			Helper.customWait(5);
			
			WebElement pickels=driver.findElement(By.xpath("//a[@href='/pickles']"));
			String expPickelsLink="Relishes & Pickles";
			 helper.highlightElement(driver, pickels);
			 Helper.customWait(5);
			String actpickelsLink=pickels.getText();
			Assert.assertEquals(actpickelsLink, expPickelsLink);
			etest.log(LogStatus.PASS," Relishes & Pickles Link is validated successfully");
			Helper.customWait(5);
			pickels.click();
			Assert.assertTrue(true, "Relishes & Pickles  link is Clicked successfully");
			Helper.customWait(5);   
			
			WebElement coldAndCuts=driver.findElement(By.xpath("//a[@href='/breakfast']"));
			String expColdCutsLink="Cold Cuts";
			 helper.highlightElement(driver, coldAndCuts);
			 Helper.customWait(5);
			String actColdCutsLink=coldAndCuts.getText();
			Assert.assertEquals(actColdCutsLink, expColdCutsLink);
			etest.log(LogStatus.PASS," Cold Cuts Link is validated successfully");
			Helper.customWait(5);
			Helper.safeJavaScriptClick(driver,coldAndCuts);
			Assert.assertTrue(true, "Cold Cuts  link is Clicked successfully");
			etest.log(LogStatus.PASS,"Cold Cuts  link is Clicked successfully"); 
			Helper.customWait(5);   
			
			WebElement UserLink=driver.findElement(By.xpath("//a[@class='user']"));
			helper.highlightElement(driver, UserLink);
		       UserLink.click();
			//UserLink.click();
       
			Helper.customWait(5);
			WebElement userLogout=driver.findElement(By.xpath("//a[@class='user-logout']"));
			if(userLogout.isDisplayed())
					{
				helper.highlightElement(driver, userLogout);
				userLogout.click();
				 etest.log(LogStatus.PASS,"Logout Button is Clicked successfully"); 
					}else
					{
						 etest.log(LogStatus.FAIL,"Logout Button is Not Clicked "); 
					}
			/*Helper.customWait(5);
			driver.quit();*/
	}
}
