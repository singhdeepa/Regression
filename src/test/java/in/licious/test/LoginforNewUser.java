package in.licious.test;

import java.sql.SQLException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.NewLoginFlow;
import in.licious.util.Helper;
import in.licious.util.ReadData;



public class LoginforNewUser extends BaseTest {
	
@Test
public void loginwithPhoneNum() throws Throwable, SQLException
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
			ReadData rd=new ReadData();
			String path="C:\\Users\\Deepa\\git\\SeleniumWebDriver\\ExcelData\\loginCredentials11.xls";
		     String value=rd.readDataFromExcel(path, "loginData", 1, 2);
			System.out.println(value);

}

	

}
