package in.licious.test;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.ChickenPage;
import in.licious.pom.HomePage;
import in.licious.pom.NewAddressPage;
import in.licious.pom.NewCheckoutPage;
import in.licious.pom.NewDeliverySummaryPage;
import in.licious.pom.NewLoginFlow;
import in.licious.pom.NewPaymentPage;
import in.licious.pom.RayzorpayPage;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class TC_03 extends BaseTest {

	@Test (priority=2)
	public void testChicken() throws ClassNotFoundException, SQLException 
	{
		NewAddressPage newAddressPage = new NewAddressPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		// Sign In with New Login Flow
		NewLoginFlow newlogin = new NewLoginFlow(driver);
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
		helper.highlightElement(driver, newlogin.getLoactionTxtBox());
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
		Helper.customWait(2);
				
		
		// Click on OTP Login
		// Reading OTP  from DB
		DataBaseCCC db1=new DataBaseCCC();
		System.out.println("Pass1");
		String s1=db1.otp1;
		System.out.println("otp1");
		System.out.println("pass2");
		System.out.println(s1);
		System.out.println("pass3");
		
		// Click on Login Button
		//helper.highlightElement(driver, newlogin.getpasswordloginBtn());
		helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
		Helper.customWait(5);
		
		
		
		// Click on Chicken category
		HomePage home=new HomePage(driver);
		home.getChickenCat().click();
		Helper.customWait(5);
		try
		{
		// Add Chicken_Thigh to cart
		ChickenPage chickenPage = new ChickenPage(driver);
		//helper.highlightElement(driver, chickenPage.getAddToCartBtn1());
		WebElement addTocart=	driver.findElement(By.xpath("//button[@class='add-to-cart addCartBtn-home']"));
		helper.highlightElement(driver, addTocart);
		js.executeScript("arguments[0].click();",addTocart);
		//helper.scrollBar(driver, addtocart );
		Helper.customWait(4);
		System.out.println("pass");
		
		// New Checkout flow
		
		// New Cart Page
		NewCheckoutPage cartloaded = new NewCheckoutPage(driver);
		helper.highlightElement(driver, cartloaded.getcartBtn());
		cartloaded.getcartBtn().click();
		Helper.customWait(2);
		helper.highlightElement(driver, cartloaded.getCheckoutBtn());
		cartloaded.getCheckoutBtn().click();
		Helper.customWait(2);
		
		// New Address Summary Page
		
		/*newAddressPage.getInd().click();*/
		//driver.findElement(By.xpath("//button[@class='li-add-address']")).clear();
		driver.findElement(By.xpath("//button[@class='li-add-address']")).click();
		driver.findElement(By.xpath("//input[@id='addr-location']")).clear();
		driver.findElement(By.xpath("//input[@id='addr-location']")).sendKeys("Licious ");
		driver.findElement(By.xpath("//input[@id='addr-location']")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		//newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.xpath("//input[@class='addr-flat']")).sendKeys("379,100 ft road");
		//driver.findElement(By.xpath("//input[@class='addr-city']")).sendKeys("Indira Nagar");
		driver.findElement(By.xpath("//input[@class='addr-mobile']")).sendKeys("8884948076");
		Helper.customWait(2);
		driver.findElement(By.xpath("//p[@class='form-cta']")).click();
		driver.findElement(By.xpath("//button[@class='complete-address']")).click();
		}catch(Exception e)
		{
			System.out.println(e);
		}	
		
		WebElement slot=driver.findElement(By.xpath("(//div[@class='slots-selector'])[1]"));

		String slot1="//div[@data-ship_id='1']/following-sibling::div[2]/div/ul/li[1]";
		String slot2="//div[@data-ship_id='1']/following-sibling::div[2]/div/ul/li[2]";
		String slot3="//div[@data-ship_id='1']/following-sibling::div[2]/div/ul/li[3]";
		String slot4="//div[@data-ship_id='1']/following-sibling::div[2]/div/ul/li[4]";
		String slot5="//div[@data-ship_id='1']/following-sibling::div[2]/div/ul/li[5]";
		WebElement slot1wb=driver.findElement(By.xpath(slot1));
		WebElement slot2wb=driver.findElement(By.xpath(slot2));
		WebElement slot3wb=driver.findElement(By.xpath(slot3));
		WebElement slot4wb=driver.findElement(By.xpath(slot4));
		WebElement slot5wb=driver.findElement(By.xpath(slot5));
		try {
		helper.highlightElement(driver, slot);
		slot.click();
		Helper.customWait(5);

		//List slots=driver.findElements(By.xpath("//div[@class='slot-day']/following-sibling::ul"));
		}catch(Exception e)
		{
		}
		try
		{
			slot1wb.click();
		Helper.customWait(8);
		slot2wb.click();
		Helper.customWait(5);
		slot3wb.click();
		Helper.customWait(5);
		slot4wb.click();
		Helper.customWait(5);
		slot5wb.click();
		Helper.customWait(5);
		}catch(Exception e)
		{

		}


		WebElement slotd=driver.findElement(By.xpath("(//div[@class='slots-selector'])[2]"));
		String slotd1="(//ul[@class='slot-time'])[2]/li[1]";
		String slotd2="(//ul[@class='slot-time'])[2]/li[2]";
		String slotd3="(//ul[@class='slot-time'])[2]/li[3]";
		String slotd4="(//ul[@class='slot-time'])[2]/li[4]";
		String slotd5="(//ul[@class='slot-time'])[2]/li[5]";
		WebElement slotd1wb=driver.findElement(By.xpath(slotd1));
		WebElement slotd2wb=driver.findElement(By.xpath(slotd2));
		WebElement slotd3wb=driver.findElement(By.xpath(slotd3));
		WebElement slotd4wb=driver.findElement(By.xpath(slotd4));
		WebElement slotd5wb=driver.findElement(By.xpath(slotd5));
		try {
			helper.highlightElement(driver, slotd);
			slotd.click();
			Helper.customWait(5);
		}catch (Exception e2) {
			// TODO: handle exception
		}
			try
			{
			slotd1wb.click();
			Helper.customWait(8);
			slotd2wb.click();
			Helper.customWait(5);
			slotd3wb.click();
			Helper.customWait(5);
			slotd4wb.click();
			Helper.customWait(5);
			slotd5wb.click();
			Helper.customWait(5);
			}catch(Exception e1)
			{
			
			}
		// New Delivery Summary page
		
		Helper.customWait(2);
		newAddressPage.getContinueBtn().click();
		Helper.customWait(2);
		NewDeliverySummaryPage  newDeliverySummary = new NewDeliverySummaryPage(driver);
		newDeliverySummary.getProceedToPaymentBtn().click();
		Helper.customWait(2);
		
		// New Payment Page
		NewPaymentPage newPaymentPage = new NewPaymentPage(driver);
		
		// Credit and Debit card payments 
		newPaymentPage.getCreditAndDebitCard().click();
		Helper.customWait(2);
		//helper.enterText(driver, newlogin.getMobileNumber(), userName);
		helper.enterText(driver, newPaymentPage.getenterCardNo(), "4111111111111111");
		Helper.customWait(2);
		helper.enterText(driver, newPaymentPage.getenterMonth(), "04");
		Helper.customWait(2);
		helper.enterText(driver, newPaymentPage.getenterYear(), "2020");
		Helper.customWait(2);
		helper.enterText(driver, newPaymentPage.getenterCvv(), "111");
		Helper.customWait(2);
		helper.enterText(driver, newPaymentPage.getenterName(), "Vishwa");
		Helper.customWait(2);
		newPaymentPage.getpayCreditAndDebitCardButton().click();
		Helper.customWait(5);
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) 
		{
			driver.switchTo().window(winHandle);
		}
		RayzorpayPage success = new RayzorpayPage(driver);
		driver.manage().window().maximize();
		System.out.println("maximized");
		success.getRayzorpayPage().click();
		Helper.customWait(5);
		System.out.println("Credit and Debit card Order Placed Sucessfully from Chicken Category");
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
			
		
					
	}
}
