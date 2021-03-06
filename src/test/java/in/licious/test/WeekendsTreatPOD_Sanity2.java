package in.licious.test;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.HomePage;
import in.licious.pom.NewLoginFlow;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;
import in.licious.util.ReadData;

public class WeekendsTreatPOD_Sanity2 extends BaseTest{
	String excelPath="C:\\Users\\Deepa\\git\\SeleniumWebDriver\\ExcelData\\loginCredentials11.xls";
	@Test()
	public void weekendsTreatPODTest() throws Exception
	{
		WebElement slot=null;
		WebElement slotd=null;
		JavascriptExecutor js=(JavascriptExecutor)driver;
	NewLoginFlow newlogin = new NewLoginFlow(driver);
	DataBaseCCC db1=new DataBaseCCC();
	HomePage hp=new HomePage(driver);
	Helper helper = new Helper();
	helper.highlightElement(driver, newlogin.getSelectLocation());
	helper.clickOnElement(driver, newlogin.getSelectLocation());
	Helper.customWait(2);
	helper.highlightElement(driver, newlogin.getbengaluruDeliveryLocation());
	helper.clickOnElement(driver, newlogin.getbengaluruDeliveryLocation());
	Helper.customWait(2);
	helper.highlightElement(driver, newlogin.getLoactionTxtBox());
	helper.enterText(driver, newlogin.getLoactionTxtBox(), location);
	Helper.customWait(2);
	newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	Helper.customWait(2);
	etest.log(LogStatus.PASS,"Location is selected");
	
	// Click on Login in HomePage
	newlogin.getLogin().click();
	Helper.customWait(2);
	// Enter valid UserName and Password
	String phnNum=	ReadData.readDataFromExcel(excelPath, "loginData", 1, 2);
	/*helper.enterText(driver, newlogin.getMobileNumber(), phnNum);
	Helper.customWait(2);
	
	// Click on Proceed button
	helper.clickOnElement(driver, newlogin.getProceedBtn());
	helper.clickOnElement(driver, newlogin.getOTPlogin());
	Helper.customWait(2);
	String otp=db1.dataBaseCCC(driver);	
	System.out.println(otp);
	newlogin.enterLoginOTP().sendKeys(otp);
	
	
	Helper.customWait(10); 
	WebElement otpBtn=driver.findElement(By.xpath("//button[@class='btns otp-login enabled']"));
	
	
	js.executeScript("arguments[0].click();",otpBtn);
	//newlogin.getotploginbtn().click();
*/
	// Enter valid UserName and Password
	helper.highlightElement(driver, newlogin.getMobileNumber());
			helper.enterText(driver, newlogin.getMobileNumber(), userName);
			Helper.customWait(2);
			
			// Click on Proceed button
			helper.highlightElement(driver, newlogin.getProceedBtn());
			helper.clickOnElement(driver, newlogin.getProceedBtn());
			Helper.customWait(2);
					
			// Click on Password login 
			helper.highlightElement(driver, newlogin.getpasswordLogin());
			helper.clickOnElement(driver, newlogin.getpasswordLogin());
			Helper.customWait(2);
					
			// Enter the password
			helper.highlightElement(driver, newlogin.getenterpassword());
			helper.enterText(driver, newlogin.getenterpassword(), passWord);
			Helper.customWait(5);
			//helper.highlightElement(driver, newlogin.getpasswordloginBtn());
			Helper.safeJavaScriptClick(driver,newlogin.getpasswordloginBtn());
			//helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
	Helper.customWait(10); 
/*WebElement items=		 driver.findElement(By.xpath("//ul[@class='parent']/li[2]"));
Helper.customWait(5);
helper.highlightElement(driver, items);
items.click();
		 Helper.customWait(5);
		 helper.highlightElement(driver, hp.getCartButtonClick());
		 Helper.customWait(5);
		 helper.clickOnElement(driver, hp.getCartButtonClick());
	
    //    WebElement close=driver.findElement(By.xpath("(//span[@class='close'])[1]"));
	//driver.findElement(By.xpath("(//div[@class='item-details'])[2]")).click();
//System.out.println(close.size());

//WebElement move=driver.findElement(By.xpath("(//div[@class='ps__thumb-y'])[1]"));

for(int i=1;i<=close.size();i++)
{
	//js.executeScript("arguments[i].click();",close);
	System.out.println(close.get(i));
	close.get(i).click();
	System.out.println(close.size());
	 Helper.customWait(2);
	//helper.scrollBar(driver, move );
}


WebElement addTocart=	driver.findElement(By.xpath("//button[@class='add-to-cart addCartBtn-home']"));
helper.highlightElement(driver, addTocart);
	js.executeScript("arguments[0].click();",addTocart);
	//driver.findElement(By.xpath("(//div[@class='item-details'])[3]")).click();
//	driver.findElement(By.xpath("//button[@class='add-to-cart addCartBtn-home']")).click();
//	helper.clickOnElement(driver, hp.getCartButtonClick());
*/
	//Helper.customWait(5);
	
	String expWeekendsTreatLink="Weekend Treats";

	WebElement WeekendsTreatLink=driver.findElement(By.xpath("//a[@href='/delicious-deals']"));
	String actWeekendsTreatLink=WeekendsTreatLink.getText();
	 helper.highlightElement(driver, WeekendsTreatLink);
	Assert.assertEquals(actWeekendsTreatLink, expWeekendsTreatLink);
	etest.log(LogStatus.PASS,"Weekends Treat link is validated successfully");	
	Helper.customWait(5);
	if(WeekendsTreatLink.isDisplayed())
	{
	WeekendsTreatLink.click();
	//Helper.safeJavaScriptClick(driver,WeekendsTreatLink);
	//Assert.assertTrue(true, "Weekends Treat link is Clicked successfully");
	etest.log(LogStatus.PASS,"Weekends Treat link is Clicked successfully");
	}else
	{
		etest.log(LogStatus.PASS,"Weekends Treat link is Not Clicked successfully");
	}
	Helper.customWait(5);
	WebElement cart=driver.findElement(By.xpath("//span[text()='Cart']"));
//	helper.highlightElement(driver, cart);
	Helper.safeJavaScriptClick(driver,cart);
	Helper.customWait(5);
	List<WebElement> closeItem=driver.findElements(By.xpath("//span[@class='close']"));
	System.out.println(closeItem.size());
	try {
		for (int i = 0; i <= closeItem.size()-1; i++) {
			 closeItem=driver.findElements(By.xpath("//span[@class='close']"));
			System.out.println(closeItem.size());
			Helper.customWait(5);
			closeItem.get(0).click();
			Helper.customWait(5);	
		}
		
	//	Helper.customWait(5);
		WebElement mainclose=driver.findElement(By.xpath("//div[@class='close']"));
		helper.highlightElement(driver, mainclose);
		Helper.safeJavaScriptClick(driver,mainclose);
		Helper.customWait(5);
		}catch (Exception e) {
			// TODO: handle exception
		}
	helper.highlightElement(driver, cart);
	
	Helper.safeJavaScriptClick(driver,cart);
	Helper.customWait(5);
//driver.findElement(By.xpath("(//div[@class='item-desc']/span[2])[1]")).click()
	try
	{
	for (int i = 0; i <= closeItem.size()-1; i++) {
		 closeItem=driver.findElements(By.xpath("//span[@class='close']"));
		System.out.println(closeItem.size());
		Helper.customWait(5);;
		closeItem.get(0).click();
		Helper.customWait(5);	
	}
	}catch(Exception e)
	{
		
	}
	try
	{
		WebElement mainclose=driver.findElement(By.xpath("//div[@class='close']"));
	Helper.customWait(5);
	helper.highlightElement(driver, mainclose);
	Helper.safeJavaScriptClick(driver,mainclose);
	}catch (Exception e) {
		// TODO: handle exception
	}
	/*WebElement weekendsTreat=driver.findElement(By.xpath("//a[@href='/delicious-deals']"));
	helper.highlightElement(driver, weekendsTreat);
	weekendsTreat.click();*/
	Helper.customWait(5);
	WebElement addToCartProduct1=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/button"));
	WebElement addToCartProduct2=driver.findElement(By.xpath("//div[contains(text(),'Creamy Malai Prawns')]/following-sibling::div/div[2]/div/button"));
//	WebElement numberOfProductInCart=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/p/span[2]"));
	WebElement addTocartByOne=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/p/span[3]"));
	WebElement addTocartByOne1=driver.findElement(By.xpath("//div[contains(text(),'Creamy Malai Prawns')]/following-sibling::div/div[2]/div/p/span[3]"));
//	WebElement minusTocartByOne=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/p/span[1]"));
	Helper.customWait(2);
	//helper.highlightElement(driver, addToCartProduct1);
	if(addToCartProduct1.isDisplayed())
	{
		//addToCartProduct1.click();
		Helper.safeJavaScriptClick(driver,addToCartProduct1);
		etest.log(LogStatus.PASS,"Add To Cart Button is Clicked successfully");
	}else
	{
		//addTocartByOne.click();
		Helper.safeJavaScriptClick(driver,addTocartByOne);
		
		//Helper.customWait(2);
		//addTocartByOne.click();
		//Helper.safeJavaScriptClick(driver,addTocartByOne);
		//Helper.customWait(2);
		//addTocartByOne.click();
		/*Helper.safeJavaScriptClick(driver,addTocartByOne);
		Helper.customWait(2);
		Helper.safeJavaScriptClick(driver,addTocartByOne);
		Helper.customWait(2);
		Helper.safeJavaScriptClick(driver,addTocartByOne);
		Helper.customWait(2);*/
		etest.log(LogStatus.PASS,"Products Is getting added to the cart successfully");
		Helper.customWait(8);
	}
	Helper.customWait(8);
	//addTocartByOne.click();
	Helper.safeJavaScriptClick(driver,addTocartByOne);
	Helper.customWait(2);
	//addTocartByOne.click();
	/*Helper.safeJavaScriptClick(driver,addTocartByOne);
	*/Helper.customWait(2);
	/*Helper.safeJavaScriptClick(driver,addTocartByOne);
	Helper.customWait(2);
	Helper.safeJavaScriptClick(driver,addTocartByOne);
	Helper.customWait(2);
	//addTocartByOne.click();
	Helper.safeJavaScriptClick(driver,addTocartByOne);*/
	Helper.customWait(5);
	if(addToCartProduct2.isDisplayed())
	{
		//addToCartProduct2.click();
		Helper.safeJavaScriptClick(driver,addToCartProduct2);
		Helper.customWait(2);
	}else
	{
		//addTocartByOne1.click();
		Helper.safeJavaScriptClick(driver,addTocartByOne1);
		Helper.customWait(2);
	//	addTocartByOne1.click();
		/*Helper.safeJavaScriptClick(driver,addTocartByOne1);
		Helper.customWait(2);*/
		//addTocartByOne1.click();
		/*Helper.safeJavaScriptClick(driver,addTocartByOne1);
		Helper.customWait(2);
		Helper.safeJavaScriptClick(driver,addTocartByOne1);
		Helper.customWait(2);
		Helper.safeJavaScriptClick(driver,addTocartByOne1);*/
		Helper.customWait(2);
	}
	//addTocartByOne1.click();
	Helper.safeJavaScriptClick(driver,addTocartByOne1);
	Helper.customWait(2);
	//addTocartByOne1.click();
	/*Helper.safeJavaScriptClick(driver,addTocartByOne1);
	Helper.customWait(2);*/
	/*Helper.safeJavaScriptClick(driver,addTocartByOne1);
	Helper.customWait(2);
	Helper.safeJavaScriptClick(driver,addTocartByOne1);
	Helper.customWait(2);
	//addTocartByOne1.click();
	Helper.safeJavaScriptClick(driver,addTocartByOne1);*/
	Helper.customWait(10);
	
	//WebElement cart=driver.findElement(By.xpath("//span[text()='Cart']"));
	if(cart.isDisplayed())
	{
	helper.highlightElement(driver, cart);
	Helper.safeJavaScriptClick(driver,cart);
	etest.log(LogStatus.PASS,"Cart Link is Clicked successfully");
	Helper.customWait(10);
	}else
	{
		etest.log(LogStatus.FAIL,"Cart Link is Not Clicked successfully");
	}
	
	WebElement proceedBTN=	driver.findElement(By.xpath("//button[@class='btn-proceed']"));
if(proceedBTN.isDisplayed())
{
	System.out.println("pass");
	helper.highlightElement(driver, proceedBTN);
	proceedBTN.click();
	etest.log(LogStatus.PASS,"Proceed Button is Clicked successfully");
	Helper.customWait(2);
	}
else
	{
	etest.log(LogStatus.FAIL,"Proceed Button is NOT Clicked ");
	}
Helper.customWait(5);
/*WebElement address=driver.findElement(By.xpath("//button[@class='complete-address']"));
if(address.isDisplayed())
{
helper.highlightElement(driver, address);
address.click();
etest.log(LogStatus.PASS,"Address Button is Clicked successfully");
Helper.customWait(5);
}else
{
	etest.log(LogStatus.FAIL,"Address Button is NOT Clicked ");	
}*/
WebElement address=driver.findElement(By.xpath("//button[@class='li-add-address']"));
if(address.isDisplayed())
{
helper.highlightElement(driver, address);
Helper.safeJavaScriptClick(driver,address);
Helper.customWait(5);
etest.log(LogStatus.PASS,"address Link is Clicked successfully");
}else
{
	etest.log(LogStatus.FAIL,"address Link is Not Clicked ");
}
WebElement addlocation=driver.findElement(By.xpath("//input[@id='addr-location']"));
if(addlocation.isDisplayed())
{
addlocation.clear();
Helper.customWait(5);
addlocation.sendKeys("Licious ");
addlocation.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
etest.log(LogStatus.PASS,"address is entered successfully");
//newlogin.getLoactionTxtBox().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
Helper.customWait(5);
}else
{
	etest.log(LogStatus.FAIL,"address is Not entered successfully");
}
WebElement addFlat=driver.findElement(By.xpath("//input[@class='addr-flat']"));
helper.highlightElement(driver, addFlat);
addFlat.sendKeys("379,100 ft road");
Helper.customWait(5);
//driver.findElement(By.xpath("//input[@class='addr-city']")).sendKeys("Indira Nagar");
WebElement addmobilenum=driver.findElement(By.xpath("//input[@class='addr-mobile']"));
if(addmobilenum.isDisplayed())
{
helper.highlightElement(driver, addmobilenum);
addmobilenum.sendKeys("8884948076");
Helper.customWait(2);
etest.log(LogStatus.PASS,"Mobile Number is entered successfully");
}else
{
	etest.log(LogStatus.FAIL,"Mobile Number is Not entered ");
}
WebElement cta=driver.findElement(By.xpath("//p[@class='form-cta']"));
helper.highlightElement(driver, cta);
cta.click();
Helper.customWait(5);
WebElement completeAdd=driver.findElement(By.xpath("//button[@class='complete-address']"));
if(completeAdd.isDisplayed())
{
helper.highlightElement(driver, completeAdd);
completeAdd.click();
Helper.customWait(5);
etest.log(LogStatus.PASS,"Complete Address Button is Clicked successfully");
}else
{
	etest.log(LogStatus.FAIL,"Complete Address Button is Not Clicked ");
}
try
{
 slot=driver.findElement(By.xpath("(//div[@class='slots-selector'])[1]"));
}catch (Exception e) {
	// TODO: handle exception
}


try {
	Helper.customWait(5);
helper.highlightElement(driver, slot);
Helper.customWait(5);
slot.click();
Helper.customWait(5);

//List slots=driver.findElements(By.xpath("//div[@class='slot-day']/following-sibling::ul"));
try
{
WebElement slotn=driver.findElement(By.xpath("//div[@class='slots-selector']"));
Helper.customWait(5);
slotn.click();
}catch (Exception e) {
	// TODO: handle exception
}
try
{
	/*String slot1="//div[@data-ship_id='1']/following-sibling::div[2]/div/ul/li[1]";
	String slot2="//div[@data-ship_id='1']/following-sibling::div[2]/div/ul/li[2]";
	String slot3="//div[@data-ship_id='1']/following-sibling::div[2]/div/ul/li[3]";
	String slot4="//div[@data-ship_id='1']/following-sibling::div[2]/div/ul/li[4]";
	String slot5="//div[@data-ship_id='1']/following-sibling::div[2]/div/ul/li[5]";*/
	String slot1="(//img[@src='https://d2407na1z3fc0t.cloudfront.net/Banner/morning.png'])[1]/../../../following-sibling::div/div/ul/li[1]";
	String slot2="(//img[@src='https://d2407na1z3fc0t.cloudfront.net/Banner/morning.png'])[1]/../../../following-sibling::div/div/ul/li[2]";
	String slot3="(//img[@src='https://d2407na1z3fc0t.cloudfront.net/Banner/morning.png'])[1]/../../../following-sibling::div/div/ul/li[3]";
	String slot4="(//img[@src='https://d2407na1z3fc0t.cloudfront.net/Banner/morning.png'])[1]/../../../following-sibling::div/div/ul/li[4]";
	String slot5="(//img[@src='https://d2407na1z3fc0t.cloudfront.net/Banner/morning.png'])[1]/../../../following-sibling::div/div/ul/li[5]";
	
	WebElement slot1wb=driver.findElement(By.xpath(slot1));
	WebElement slot2wb=driver.findElement(By.xpath(slot2));
	WebElement slot3wb=driver.findElement(By.xpath(slot3));
	WebElement slot4wb=driver.findElement(By.xpath(slot4));
	WebElement slot5wb=driver.findElement(By.xpath(slot5));
	Helper.customWait(8);
	slot1wb.click();
Helper.customWait(8);
slot2wb.click();
Helper.customWait(5);
slot3wb.click();
Helper.customWait(5);
slot4wb.click();
Helper.customWait(5);
slot5wb.click();
Helper.customWait(5);
}catch(Exception e)
{

}
try
{
	driver.findElement(By.xpath("//img[@src='https://d2407na1z3fc0t.cloudfront.net/Banner/scooter.png']/following-sibling::span[@class='text-red']")).click();
}catch (Exception e) {
	// TODO: handle exception
}
}catch(Exception e)
{
}
try
{
 slotd=driver.findElement(By.xpath("(//div[@class='slots-selector'])[2]"));
}catch (Exception e) {
	// TODO: handle exception
}

try {
	helper.highlightElement(driver, slotd);
	slotd.click();
	Helper.customWait(5);
	try
	{
	WebElement slotn=driver.findElement(By.xpath("//div[@class='slots-selector']"));
	Helper.customWait(5);
	slotn.click();
	}catch (Exception e) {
		// TODO: handle exception
	}
	try
	{
		String slotd1="(//ul[@class='slot-time'])[2]/li[1]";
		String slotd2="(//ul[@class='slot-time'])[2]/li[2]";
		String slotd3="(//ul[@class='slot-time'])[2]/li[3]";
		String slotd4="(//ul[@class='slot-time'])[2]/li[4]";
		String slotd5="(//ul[@class='slot-time'])[2]/li[5]";
		WebElement slotd1wb=driver.findElement(By.xpath(slotd1));
		WebElement slotd2wb=driver.findElement(By.xpath(slotd2));
		WebElement slotd3wb=driver.findElement(By.xpath(slotd3));
		WebElement slotd4wb=driver.findElement(By.xpath(slotd4));
		WebElement slotd5wb=driver.findElement(By.xpath(slotd5));
	slotd1wb.click();
	Helper.customWait(8);
	slotd2wb.click();
	Helper.customWait(5);
	slotd3wb.click();
	Helper.customWait(5);
	slotd4wb.click();
	Helper.customWait(5);
	slotd5wb.click();
	Helper.customWait(5);
	}catch(Exception e1)
	{
	
	}
}catch (Exception e2) {
	// TODO: handle exception
}

/*if(slot1wb.isSelected())
{
	slot1wb.click();
}else if(slot2wb.isSelected())
{
	slot2wb.click();
}else if(slot3wb.isSelected())
{	
slot3wb.click();
}else if(slot4wb.isSelected())
{
slot4wb.click();
	}else if(slot5wb.isSelected())
	{
	slot5wb.click();	
	}*/

/*Robot robot=new Robot();

robot.keyPress(KeyEvent.VK_ENTER);*/
Helper.customWait(2);
WebElement shipment=driver.findElement(By.xpath("//button[@class='complete-shipments']"));
if(shipment.isDisplayed())
{
helper.highlightElement(driver, shipment);
Helper.customWait(5);
shipment.click();
etest.log(LogStatus.PASS,"Proceed to shipment Button is Clicked successfully");
Helper.customWait(5);
}else
{
	etest.log(LogStatus.FAIL,"Proceed to shipment Button  is NOT Clicked ");
}

String amount=driver.findElement(By.xpath("//li[text()='Total']/span")).getText();
System.out.println(amount);
/* String amount1=amount.substring(0,amount.length());
System.out.println(amount);*/
int amountRs = Integer.parseInt(amount);			
System.out.println(amountRs);
try {
if(amountRs<5000)
{
	
	driver.findElement(By.xpath("//li[@data-payname='pod']")).click();
	etest.log(LogStatus.PASS,"Pay On Delivery Button is selected And Clicked successfully");
}
}catch (Exception e) {
}
	/*try {
		// TODO: handle exception
		driver.findElement(By.xpath("//li[@data-payname='card']")).click();
		WebElement cardnum=driver.findElement(By.xpath("//input[@data-type='card-num']"));
		helper.highlightElement(driver, cardnum);
		helper.enterText(driver, cardnum, "4111111111111111");
		Helper.customWait(2);
		WebElement cardmon= driver.findElement(By.xpath("//input[@data-type='card-mon']"));
		helper.highlightElement(driver, cardmon);
		helper.enterText(driver, cardmon, "04");
		Helper.customWait(2);
		WebElement cardyear=driver.findElement(By.xpath("//input[@data-type='card-year']"));
		helper.highlightElement(driver, cardyear);
		helper.enterText(driver, cardyear, "2020");

		Helper.customWait(2);
		WebElement cardCVV=driver.findElement(By.xpath("//input[@data-type='card-cvv']"));
		helper.highlightElement(driver, cardCVV);
		helper.enterText(driver,cardCVV, "111");
		Helper.customWait(2);
		WebElement cardName= driver.findElement(By.xpath("//input[@data-type='card-name']"));
		helper.highlightElement(driver, cardName);
		helper.enterText(driver, cardName, "Deepa");
		etest.log(LogStatus.PASS,"Credit / Debit cards  is selected And Clicked successfully");
	}catch (Exception e) {
		// TODO: handle exception
	}*/

//int amountRs1 = Integer.parseInt(amount1);
//System.out.println(amountRs1);
/*WebElement cardnum=driver.findElement(By.xpath("//input[@data-type='card-num']"));
helper.highlightElement(driver, cardnum);
helper.enterText(driver, cardnum, "4111111111111111");
Helper.customWait(2);
WebElement cardmon= driver.findElement(By.xpath("//input[@data-type='card-mon']"));
helper.highlightElement(driver, cardmon);
helper.enterText(driver, cardmon, "04");
Helper.customWait(2);
WebElement cardyear=driver.findElement(By.xpath("//input[@data-type='card-year']"));
helper.highlightElement(driver, cardyear);
helper.enterText(driver, cardyear, "2020");

Helper.customWait(2);
WebElement cardCVV=driver.findElement(By.xpath("//input[@data-type='card-cvv']"));
helper.highlightElement(driver, cardCVV);
helper.enterText(driver,cardCVV, "111");
Helper.customWait(2);
WebElement cardName= driver.findElement(By.xpath("//input[@data-type='card-name']"));
helper.highlightElement(driver, cardName);
helper.enterText(driver, cardName, "Deepa");*/
Helper.customWait(2);
WebElement payButton=driver.findElement(By.xpath("//button[@class='init-pay']"));
Helper.customWait(2);
helper.highlightElement(driver, payButton);
payButton.click();
Helper.customWait(5);
//Helper.customWait(5);

//driver.findElement(By.xpath("//button[text()='Place Order']")).click();
String DeliverySuccessful=driver.findElement(By.xpath("//div[@class='out-delivery-text']")).getText();
System.out.println(DeliverySuccessful);
String shipmentID=driver.findElement(By.xpath("//div[@class='order-idtext']")).getText();
System.out.println(shipmentID);
/*String RazorPatTitle="Razorpay Bank";
Helper.switchOnWindowBasedOnTitle(driver, RazorPatTitle);*/
Helper.customWait(5);
//String rupee=driver.findElement(By.xpath("//i[@class='rupee']")).getText();
/*System.out.println(rupee);
int rupees=Integer.parseInt(rupee);
if(rupees>5000)
{
	WebElement pod=driver.findElement(By.xpath("//li[@data-payname='pod']"));
	if(pod.isEnabled())
	{
	pod.click();
	}
}else
{
System.out.println("Not clickable");	
}*/

System.out.println("*************************");

/*//Store the current window handle
String winHandleBefore = driver.getWindowHandle();

//Perform the click operation that opens new window

//Switch to new window opened
for(String winHandle : driver.getWindowHandles()){
 driver.switchTo().window(winHandle);
}

//Perform the actions on new window

//Close the new window, if that window no more required
driver.close();

//Switch back to original browser (first window)
driver.switchTo().window(winHandleBefore);*/

System.out.println("*************************");


//Continue with original browser (first window)

// Closing Pop Up window
//driver.quit();

Helper.customWait(5);
WebElement UserLink=driver.findElement(By.xpath("//a[@class='user']"));
helper.highlightElement(driver, UserLink);
Helper.safeJavaScriptClick(driver,UserLink);
//UserLink.click();

Helper.customWait(5);
WebElement userLogout=driver.findElement(By.xpath("//a[@class='user-logout']"));
if(userLogout.isDisplayed())
		{
	helper.highlightElement(driver, userLogout);
	Helper.safeJavaScriptClick(driver,userLogout);
	 etest.log(LogStatus.PASS,"Logout Button is Clicked successfully"); 
		}else
		{
			 etest.log(LogStatus.FAIL,"Logout Button is Not Clicked "); 
		}

	}	
}

