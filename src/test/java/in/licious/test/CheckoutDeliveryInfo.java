package in.licious.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import in.licious.pom.BasePage;
import in.licious.pom.CheckoutDelivery;
import in.licious.util.Helper;


public class CheckoutDeliveryInfo extends CheckOut{



	@Test
	public void checkOutDelivery()
	{
		CheckOut checkOut=new CheckOut();
		CheckoutDelivery checkOutDelivery=new CheckoutDelivery(driver);
		Helper helper=new Helper();
		
		checkOut.clickCartBtn();
		checkOutDelivery.getSelectDeliverySlot();
		
		String windowId=driver.getWindowHandle();
		driver.switchTo().window(windowId);
		checkOutDelivery.getTimeSlot().click();
		checkOutDelivery.getContinueBtn().click();
	WebElement proceedtoPay=checkOutDelivery.getProceedtoPaybtn();
		helper.scrollBar(driver, proceedtoPay);
	
		
	}

}
