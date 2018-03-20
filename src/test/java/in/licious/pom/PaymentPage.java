package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	@FindBy(xpath="//a[.='Net Banking']")
	private WebElement netBanking;
	
	@FindBy(xpath="//input[@id='citrusNetbankingButton']")
	private WebElement payNowBtn;
	
	
	public PaymentPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getNetBanking(){
		return netBanking;
	}
	
	
	public WebElement getPayNowBtn(){
		return payNowBtn;
	}
}
