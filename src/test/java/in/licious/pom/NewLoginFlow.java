package in.licious.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLoginFlow extends BasePage{
	
	@FindBy(xpath="//a[@class='login-user']")
	private WebElement login;
	
	@FindBy(xpath="//input[@class='user-id']")
	private WebElement mobilenumber;
	
	@FindBy(xpath="//button[.='Proceed']")
	private WebElement proceedbtn;
	
	
	@FindBy(xpath="//input[@class='signup-otp']")
	private WebElement enterotp;
	
	@FindBy(xpath="//div[@class='cta-block']")
	private WebElement otploginBtn;

	@FindBy(xpath="//li[.='Password Login']")
	private WebElement passwordlogin;
	
	@FindBy(xpath="//input[@class='login-pass']")
	private WebElement enterpassword;
	
	@FindBy(xpath="//button[@class='btns password-login enabled']")
	private WebElement passwordloginBtn;
	
	@FindBy(xpath="//li[@class='gp']")
	private WebElement googleButton;
	
	public NewLoginFlow(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogin(){
		return login;
	}
	
	public WebElement getMobileNumber(){
		return mobilenumber;
	}
	
	public WebElement getProceedBtn(){
		return proceedbtn;
	}
	
	public WebElement getEnterOtp(){
		return enterotp;
	}
	
	public WebElement getotploginbtn(){
		return otploginBtn;
	}
	
	public WebElement getpasswordLogin(){
		return passwordlogin;
	}
	
	public WebElement getenterpassword(){
		return enterpassword;
	}
	
	public WebElement getpasswordloginBtn(){
		return passwordloginBtn;
	}
	
	@FindBy(xpath="//div[@class='minimize']")
	private WebElement subscribe;
	
	public WebElement getSubscribe()
	{
		return subscribe;
	}
	
	public WebElement getGoogleLink()
	{
		return googleButton;
	}
	@FindBy(xpath="//span[@class='fb-login']")
	private WebElement FacebookLink;
	public WebElement getFaceBookLink()
	{
		return FacebookLink;
	}
	@FindBy(xpath="//input[@type='email']")
	private WebElement emailText;
	public WebElement getEmail()
	{
		return emailText;
	}
	@FindBy(xpath="//span[text()='Next']")
	private WebElement nextButton;
	public WebElement getnextButton()
	{
		return nextButton;
	}

    @FindBy(xpath="//input[@type='password']")
    private WebElement passwordText;
    public WebElement getPassword()
    {
    	return passwordText;
    }
    @FindBy(xpath="//input[@name='email']")
    private WebElement emailTextBoxFB;
    public WebElement getEmailtextFB()
    {
    	return emailTextBoxFB;
    }
    @FindBy(xpath="//input[@name='pass']")
    private WebElement passwordTextFB;
    public WebElement getpasswordTextFB()
    {
    	return passwordTextFB;
    }
    @FindBy(xpath="//input[@value='Log In']")
    private WebElement loginButton;
    public WebElement getLoginButton()
    {
    	return loginButton;
    }
    @FindBy(xpath="//li[@class='option selected']")
    private  WebElement OTPLogin;
    public WebElement getOTPlogin()
    {
    	return OTPLogin;
    }
    @FindBy(xpath="//input[@class='signup-otp']")
    private WebElement enterOTP;
    public WebElement getOTP()
    {
    	return enterOTP;
    }
    @FindBy(xpath="//input[@class='signup-pass-otp']")
    private WebElement enterPassOTP;
    public WebElement getPassOTP()
    {
    	return enterPassOTP;
    }
    @FindBy(xpath="//input[@class='new-pass']")
    private WebElement enterNewpassword;
    public WebElement getEnterNewPassword()
    {
    	return enterNewpassword;
    }
    @FindBy(xpath="//input[@class='confirm-pass']")
    private WebElement confirmPassword;
    public WebElement getEnterconfirmPassword()
    {
    	return confirmPassword;
    }
    @FindBy(xpath="//button[@class='btns otp-signup enabled']")
    private WebElement loginwithOTP;
    public WebElement getclickOTP()
    {
    	return loginwithOTP;
    }
    @FindBy(xpath="//button[@class='btns password-signup enabled']")
    private WebElement loginBtn;
    public WebElement getloginBTN()
    {
    	return loginBtn;
    }
    @FindBy(xpath="//input[@class='login-otp']")
    private WebElement loginOTP;
    public WebElement enterLoginOTP()
    {
    	return loginOTP;
    }
}  
