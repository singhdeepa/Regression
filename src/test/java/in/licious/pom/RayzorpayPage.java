package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RayzorpayPage extends BasePage {
	
	@FindBy(xpath="//button[.='Success']")
	private WebElement success;
	
	public RayzorpayPage(WebDriver driver) {
		
		super (driver);
		
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getRayzorpayPage() {
		return success;
	}
	

}
