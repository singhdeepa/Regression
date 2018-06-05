package in.licious.test;

import java.sql.SQLException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.NewLoginFlow;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class ColdCutsCOD extends BaseTest {
	
	@Test (priority=4)
	public void testfishandseafood() throws ClassNotFoundException, SQLException
	{
	
	// Sign In with New Login Flow
	NewLoginFlow newlogin = new NewLoginFlow(driver);
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
	Helper.customWait(2);
			
	
	// Click on OTP Login
	// Reading OTP  from DB
	DataBaseCCC db1=new DataBaseCCC(driver);
	System.out.println("Pass1");
	String s1=db1.otp1;
	System.out.println("otp1");
	System.out.println("pass2");
	System.out.println(s1);
	System.out.println("pass3");
	
	// Click on Login Button
	helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
	Helper.customWait(5);

}
	
}
