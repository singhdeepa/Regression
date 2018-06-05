package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPaymentPage {

	@FindBy(xpath="//li[.='Cash on delivery']")
	private WebElement cashOnDelivery;
	
	
	@FindBy(xpath="//button[.='Place Order']")
	private WebElement placeOrder;
	
	
	@FindBy(xpath="//input[@id='citrusNetbankingButton']")
	private WebElement payNowBtn;
	
	
	public NewPaymentPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getCashOnDelivery(){
		return cashOnDelivery;
	}
	
	public WebElement getPlaceOrder(){
		return placeOrder;
	}
	
	public WebElement getPayNowBtn(){
		return payNowBtn;
	}
}
