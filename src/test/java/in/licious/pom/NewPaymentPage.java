package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPaymentPage {

	@FindBy(xpath="//li[@data-payname='cod']")
	private WebElement cashOnDelivery;
	
	
	@FindBy(xpath="//button[.='Place Order']")
	private WebElement placeOrder;
	
	
	@FindBy(xpath="//li[@data-payname='netbanking']")
	private WebElement netBanking;
	
	@FindBy(xpath="//li[@data-bc='HDFC']")
	private WebElement hdfc;
	
	@FindBy(xpath="//button[@data-mode='netbanking']")
	private WebElement pay;
	
	public NewPaymentPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getCashOnDelivery(){
		return cashOnDelivery;
	}
	
	public WebElement getPlaceOrder(){
		return placeOrder;
	}
	
	public WebElement getNetBanking(){
		return netBanking;
	}
	
	public WebElement getHDFC(){
		return hdfc;
	}
	
	public WebElement getPayButton(){
		return pay;
	}
}
