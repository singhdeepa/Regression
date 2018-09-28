
package in.licious.test;



import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.NewLoginFlow;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;
import in.licious.util.ReadData;

public class NewUserLoginFlowRegressionScript extends BaseTest {
	String excelPath="C:\\Users\\Deepa\\git\\SeleniumWebDriver\\ExcelData\\loginCredentials11.xls";
	
	@Test 
	public void testnewloginflowOtp() throws ClassNotFoundException, SQLException
	{
		DataBaseCCC db1=new DataBaseCCC();
		
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
				
			String phnNum=	ReadData.readDataFromExcel(excelPath, "loginData", 2, 2);
			System.out.println(phnNum);
				Helper.customWait(2);
				helper.enterText(driver, newlogin.getMobileNumber(), "8884948076");
				// Click on Proceed button
				helper.clickOnElement(driver, newlogin.getProceedBtn());
				Helper.customWait(2);
						
				// Click on Password login 
				helper.clickOnElement(driver, newlogin.getOTPlogin());
				Helper.customWait(2);
				String otp=db1.dataBaseCCC(driver);	
				System.out.println(otp);
				newlogin.getOTP().sendKeys(otp);
				
				
				Helper.customWait(2); 
				newlogin.getclickOTP().click();
  
}
	@Test
	public void testnewloginflowPasswordOtp() throws ClassNotFoundException, SQLException
	{
		DataBaseCCC db1=new DataBaseCCC();
		NewLoginFlow newlogin = new NewLoginFlow(driver);
		Helper helper = new Helper();
		helper.clickOnElement(driver, newlogin.getSelectLocation());
		Helper.customWait(2);
		helper.clickOnElement(driver, newlogin.getbengaluruDeliveryLocation());
		Helper.customWait(2);
		String location=	ReadData.readDataFromExcel(excelPath, "loginData", 2, 3);
		helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
		Helper.customWait(2);
		newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Helper.customWait(2);
		etest.log(LogStatus.PASS,"Location is selected");
		
		// Click on Login in HomePage
		newlogin.getLogin().click();
		Helper.customWait(2);
		
		// Enter valid UserName and Password
		String phnNum=	ReadData.readDataFromExcel(excelPath, "loginData", 2, 2);
		System.out.println(phnNum);
			Helper.customWait(2);
			helper.enterText(driver, newlogin.getMobileNumber(), "8884948076");
		
		Helper.customWait(2);
		
		// Click on Proceed button
		helper.clickOnElement(driver, newlogin.getProceedBtn());
		Helper.customWait(2);
				
		// Click on Password login 
		helper.clickOnElement(driver, newlogin.getpasswordLogin());
		Helper.customWait(2);
		//driver.findElement(By.xpath("//span[text()='Forgot password']")).click();
		helper.clickOnElement(driver, newlogin.getOTPlogin());
		Helper.customWait(2);
		String otp=db1.dataBaseCCC(driver);	
		System.out.println(otp);
		newlogin.getPassOTP().sendKeys(otp);
		
		Helper.customWait(5);
		String passWord=	ReadData.readDataFromExcel(excelPath, "loginData", 2, 1);
		newlogin.getEnterNewPassword().sendKeys(passWord);
		Helper.customWait(5);
		newlogin.getEnterconfirmPassword().sendKeys(passWord);
		// Click on Login Button
		//helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
		Helper.customWait(5);
		newlogin.getloginBTN().click();
	}
	/*@DataProvider
	public Object[] getData()
	{
		Object obj[][]=new Object[7][3];
		obj[1][2]="8884948076";
		obj[2][2]="8884948078";
		obj[3][2]="8884948079";
		return obj;
		
	}*/
	
	@Test
	public void loginThroughGoogle() throws ClassNotFoundException, SQLException
	{
		DataBaseCCC db1=new DataBaseCCC();
		NewLoginFlow newlogin = new NewLoginFlow(driver);
		Helper helper = new Helper();
		helper.clickOnElement(driver, newlogin.getSelectLocation());
		Helper.customWait(2);
		helper.clickOnElement(driver, newlogin.getbengaluruDeliveryLocation());
		Helper.customWait(2);
		String location=	ReadData.readDataFromExcel(excelPath, "loginData", 2, 3);
		helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
		Helper.customWait(2);
		newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Helper.customWait(2);
		etest.log(LogStatus.PASS,"Location is selected");
		
		// Click on Login in HomePage
		newlogin.getLogin().click();
		Helper.customWait(2);
		
	
			helper.clickOnElement(driver, newlogin.getGoogleLink());
			Helper.customWait(2);
			String your_title = "Sign in - Google Accounts";
			String currentWindow = driver.getWindowHandle();  //will keep current window to switch back
			for(String winHandle : driver.getWindowHandles()){
			   if (driver.switchTo().window(winHandle).getTitle().equals(your_title)) {
				   //driver.findElement(By.xpath("//p[text()='Use another account']")).click();
					Helper.customWait(2);
					newlogin.getEmail().clear();
					String email=	ReadData.readDataFromExcel(excelPath, "loginData", 2, 4);
					newlogin.getEmail().sendKeys("singhdeepa8555@gmail.com");
					Helper.customWait(2);
					newlogin.getnextButton().click();
					Helper.customWait(2);
					String password=	ReadData.readDataFromExcel(excelPath, "loginData", 2, 5);
					newlogin.getPassword().clear();
					newlogin.getPassword().sendKeys("nilam_63");
					driver.findElement(By.xpath("//input[@class='social-mobile']")).sendKeys("8884948073");
					String otp=db1.dataBaseCCC(driver);	
					driver.findElement(By.xpath("//button[text()='Send OTP']")).click();
					driver.findElement(By.xpath("//p[@class='social-otp-input']/input")).sendKeys("");
					driver.findElement(By.xpath("//button[@class='btns otp-login-social enabled']")).click();
				  // driver.switchTo().window(winHandle);
			     //This is the one you're looking for
			   }
			}
			
			
	}
	@Test
	public void loginThroughFaceBook()
	{
		
		NewLoginFlow newlogin = new NewLoginFlow(driver);
		Helper helper = new Helper();
		helper.clickOnElement(driver, newlogin.getSelectLocation());
		Helper.customWait(2);
		helper.clickOnElement(driver, newlogin.getbengaluruDeliveryLocation());
		Helper.customWait(2);
		String location=	ReadData.readDataFromExcel(excelPath, "loginData", 2, 3);
		helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
		Helper.customWait(2);
		newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Helper.customWait(2);
		etest.log(LogStatus.PASS,"Location is selected");
		
		// Click on Login in HomePage
		newlogin.getLogin().click();
		Helper.customWait(2);
		
	
			helper.clickOnElement(driver, newlogin.getFaceBookLink());
			Helper.customWait(2);
			String your_title = "Facebook";
			String currentWindow = driver.getWindowHandle();  //will keep current window to switch back
			for(String winHandle : driver.getWindowHandles()){
			   if (driver.switchTo().window(winHandle).getTitle().equals(your_title)) {
				   //driver.findElement(By.xpath("//p[text()='Use another account']")).click();
					Helper.customWait(2);
					String email=	ReadData.readDataFromExcel(excelPath, "loginData", 2, 4);
					newlogin.getEmailtextFB().clear();
					newlogin.getEmailtextFB().sendKeys(email);
					Helper.customWait(2);
					String password=	ReadData.readDataFromExcel(excelPath, "loginData", 2, 5);
					newlogin.getpasswordTextFB().clear();
					newlogin.getpasswordTextFB().sendKeys(password);
					Helper.customWait(2);
					newlogin.getLoginButton().click();
				  
			   }
			}
			
			
	}
	}