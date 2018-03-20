package in.licious.test;

import org.testng.annotations.Test;

import in.licious.pom.CheckoutPage;

public class CheckOut extends Chicken {
	
	Chicken chicken=new Chicken();
	CheckoutPage checkoutPage=new CheckoutPage(driver);
	
	
	@Test
	public void clickCartBtn() {
	
		chicken.testChicken();
		checkoutPage.getcartBtn().click();
		checkoutPage.getCheckoutBtn().click();
		
		
	}

}
