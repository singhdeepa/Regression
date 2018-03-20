package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy (xpath="//a[.='Chicken' and @class='active']")
	private WebElement chicken;
	
	@FindBy (xpath="//a[.='Fish & Seafood' and @class='active']")
	private WebElement fishSeafood;
	
	@FindBy (xpath="//a[.='Marinades' and @class='active']")
	private WebElement marinades;
	
	@FindBy (xpath="//a[@data-index='4']")
	private WebElement redmeats;
	
	@FindBy (xpath="//a[.='Eggs' and @class='active']")
	private WebElement eggs;
	
	
	public HomePage (WebDriver driver) 
	{
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getChickenCat(){
		return chicken;
	}
	
	public WebElement getfishSeafoodCat(){
		return fishSeafood;
	}
	
	public WebElement getmarinadesCat(){
		return marinades;
	}
	
	public WebElement getredmeats(){
		return redmeats;
	}
	
	public WebElement geteggsCat(){
		return eggs;
	}
	
	
}
