package in.licious.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.CheckoutDelivery;
import in.licious.pom.CheckoutPage;
import in.licious.pom.DeliverySummaryPage;
import in.licious.pom.HomePage;
import in.licious.pom.MarinadesPage;
import in.licious.pom.PaymentPage;
import in.licious.pom.RayzorpayPage;
import in.licious.pom.SignInPage;
import in.licious.pom.SignupPage;
import in.licious.util.Helper;

public class MarinadesCOD extends BaseTest {
	
	@Test (priority=2)
	public void testmarinadescod()
	{
		// Click on Bangalore City
		SignInPage signInpage = new SignInPage(driver);
		Helper helper = new Helper();
		helper.clickOnElement(driver, signInpage.getSelectLocation());
		Helper.customWait(2);
		helper.clickOnElement(driver, signInpage.getbengaluruDeliveryLocation());
		Helper.customWait(2);
		
		// Enter the Delivery Location
		helper.enterText(driver, signInpage.getLoactionTxtBox(), "Indiranagar");
		Helper.customWait(2);
		signInpage.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Helper.customWait(2);
		etest.log(LogStatus.PASS,"Location is selected");
		
		// Click on Login in HomePage
		signInpage.getLogin().click();
		Helper.customWait(2);
		
		// Click on Login in SignUp Page
		SignupPage signuppage = new SignupPage(driver);
		WebElement login= signuppage.getAlreadyHaveAnAccountlogin();
		helper.scrollBar(driver, login);
		
		// Enter valid UserName and Password
		signInpage.getUsernameTxtBox().sendKeys("9880335493");
		signInpage.getPasswordTxtBox().sendKeys("123456");
		Helper.customWait(2);
		
		// Minimizing the News Letter Subscription
		signInpage.getSubscribe().click();
		Helper.customWait(2);
		
		
		// Click on LoginButton
		signInpage.getLoginBtn().click();
		Helper.customWait(2);
		
		
		// Click on Marinades category
		HomePage home=new HomePage(driver);
		home.getmarinadesCat().click();
		Helper.customWait(4);
		
		// Add Peri_Peri_Chicken_Hot to cart
		MarinadesPage marinadesPage =new MarinadesPage(driver);
		WebElement addtocart= marinadesPage.getPeriPeriChickenHot();
		helper.scrollBar(driver, addtocart );
		Helper.customWait(4);
		System.out.println("pass");
		
		
		// Click on Cart icon
		CheckoutPage cartloaded = new CheckoutPage(driver);
		cartloaded.getcartBtn().click();
		Helper.customWait(2);
		
		
		// Click on Checkout Button
		cartloaded.getCheckoutBtn().click();
		Helper.customWait(2);
		
		
		// Click on Continue button 
		CheckoutDelivery checkOutDelivery = new CheckoutDelivery(driver);
		checkOutDelivery.getContinueBtn().click();
		Helper.customWait(2);
		
		
		// Click on Proceed to Payment Button 
		DeliverySummaryPage proceedtopay = new DeliverySummaryPage(driver);
		WebElement proceedtopayment = proceedtopay.getProceedToPaymentBtn();
		helper.scrollBar(driver, proceedtopayment );
		Helper.customWait(2);
		
		
		// Click on NetBanking 
		PaymentPage paynow = new PaymentPage(driver);
		paynow.getNetBanking().click();
		Helper.customWait(2);
		
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
				
		
		// Click on PayNow Button
		paynow.getPayNowBtn().click();
		Helper.customWait(5);
		
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		
		
		// Click on Success Button in RazorPay Page
		RayzorpayPage success = new RayzorpayPage(driver);
		driver.manage().window().maximize();
		System.out.println("maximized");
		success.getRayzorpayPage().click();
		Helper.customWait(5);
		System.out.println("COD order placed with online payment palced successfully");
		
		
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		
	}
	

}
