package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPaymentPage {

	@FindBy(xpath="//li[@data-payname='cod']")
	private WebElement cashOnDelivery;
	
	@FindBy(xpath="//li[@data-payname='pod']")
	private WebElement payOnDelivery;
	
	@FindBy(xpath="//button[.='Place Order']")
	private WebElement placeOrder;
	
	
	@FindBy(xpath="//li[@data-payname='netbanking']")
	private WebElement netBanking;
	
	@FindBy(xpath="//li[@data-bc='HDFC']")
	private WebElement hdfc;
	
	@FindBy(xpath="//button[@data-mode='netbanking']")
	private WebElement payNetBanking;
	
	@FindBy(xpath="//li[@data-payname='saved_payments']")
	private WebElement savedPayments;
	
	@FindBy(xpath="//li[@class='selected']")
	private WebElement savedCard1;
	
	@FindBy(xpath="//button[@data-mode='saved_payments']")
	private WebElement paySavedCard;
	
	
	
	
	public NewPaymentPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getCashOnDelivery(){
		return cashOnDelivery;
	}
	
	public WebElement getPayOnDelivery(){
		return payOnDelivery;
	}
	
	public WebElement getPlaceOrder(){
		return placeOrder;
	}
	
	public WebElement getNetBanking(){
		return netBanking;
	}
	
	public WebElement getSavedPayments(){
		return savedPayments;
	}
	public WebElement getHDFC(){
		return hdfc;
	}
	
	public WebElement getPayNetBankingButton(){
		return payNetBanking;
	}
	
	public WebElement getSavedCardButton(){
		return paySavedCard;
	}
}
