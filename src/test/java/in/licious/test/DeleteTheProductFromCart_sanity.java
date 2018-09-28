package in.licious.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.ChickenPage;
import in.licious.pom.HomePage;
import in.licious.pom.NewLoginFlow;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class DeleteTheProductFromCart_sanity extends BaseTest{
@Test
public void deleteTheProductfromcartTest() throws Exception
{
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
		//helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
		Helper.safeJavaScriptClick(driver,newlogin.getpasswordloginBtn());
		 Helper.customWait(5);
	
	/*Helper.customWait(5);
	WebElement weekendsTreat=driver.findElement(By.xpath("//a[@href='/delicious-deals']"));
	helper.highlightElement(driver, weekendsTreat);
	weekendsTreat.click();
	Helper.customWait(5);*/

		String expWeekendsTreatLink="Weekend Treats";
		WebElement weekendTreat=driver.findElement(By.xpath("//a[@href='/delicious-deals']"));
        String actWeekendsTreatLink=weekendTreat.getText();
        helper.highlightElement(driver, weekendTreat);
        Helper.customWait(5);
		Assert.assertEquals(actWeekendsTreatLink, expWeekendsTreatLink);
		etest.log(LogStatus.PASS,"Weekends Treat link is validated successfully");	
		Helper.customWait(9);
		
		if(weekendTreat.isDisplayed())
		{
			Helper.safeJavaScriptClick(driver,weekendTreat);
		//Helper.safeJavaScriptClick(driver,WeekendsTreatLink);
		//Assert.assertTrue(true, "Weekends Treat link is Clicked successfully");
		etest.log(LogStatus.PASS,"Weekends Treat link is Clicked successfully");
		}else
		{
			etest.log(LogStatus.FAIL,"Weekends Treat link is Not Clicked ");
		}
			
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
			Helper.customWait(2);
			//addTocartByOne.click();
			Helper.safeJavaScriptClick(driver,addTocartByOne);
			Helper.customWait(2);
			//addTocartByOne.click();
			Helper.safeJavaScriptClick(driver,addTocartByOne);
			Helper.customWait(8);
			etest.log(LogStatus.PASS,"Products Is getting added to the cart successfully");
		}
		//addTocartByOne.click();
		Helper.safeJavaScriptClick(driver,addTocartByOne);
		Helper.customWait(2);
		//addTocartByOne.click();
		Helper.safeJavaScriptClick(driver,addTocartByOne);
		Helper.customWait(2);
		//addTocartByOne.click();
		Helper.safeJavaScriptClick(driver,addTocartByOne);
		etest.log(LogStatus.PASS,"Product Is getting added to the cart successfully");
		Helper.customWait(2);
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
			//addTocartByOne1.click();
			Helper.safeJavaScriptClick(driver,addTocartByOne1);
			Helper.customWait(2);
			//addTocartByOne1.click();
			Helper.safeJavaScriptClick(driver,addTocartByOne1);
			Helper.customWait(2);
		}
		//addTocartByOne1.click();
		Helper.safeJavaScriptClick(driver,addTocartByOne1);
		Helper.customWait(2);
		//addTocartByOne1.click();
		Helper.safeJavaScriptClick(driver,addTocartByOne1);
		Helper.customWait(2);
		//addTocartByOne1.click();
		Helper.safeJavaScriptClick(driver,addTocartByOne1);
		Helper.customWait(8);
		/*//WebElement numberOfProductInCart=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/p/span[2]"));
		String numberOfProductInCartBeforeadd=numberOfProductInCart.getText();
		//WebElement addTocartByOne=driver.findElement(By.xpath("//div[contains(text(),'Lobster (Whole)')]/following-sibling::div/div[2]/div/p/span[3]"));
		helper.highlightElement(driver, addTocartByOne);
		addTocartByOne.click();
		Helper.customWait(2);
		addTocartByOne.click();
		Helper.customWait(2);
		addTocartByOne.click();*/
	WebElement cart=driver.findElement(By.xpath("//span[text()='Cart']"));
	/*helper.highlightElement(driver, cart);
	cart.click();*/
	
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
		List<WebElement> itemTitle =driver.findElements(By.xpath("//div[@class='item-desc']"));	
		System.out.println(itemTitle.size());
		/*List<WebElement> closeitem =driver.findElements(By.xpath("(//div[@class='item-desc']/span[2])[1]"));	*/
		List<WebElement> closeItem=driver.findElements(By.xpath("//span[@class='close']"));
		System.out.println(closeItem.size());
		//System.out.println(closeitem.size());
		try {
		for (int i = 0; i <= closeItem.size()-1; i++) {
			 closeItem=driver.findElements(By.xpath("//span[@class='close']"));
			System.out.println(closeItem.size());
			Helper.customWait(5);
			closeItem.get(0).click();
			Helper.customWait(5);	
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	//	Helper.customWait(5);
		WebElement mainclose=driver.findElement(By.xpath("//div[@class='close']"));
		helper.highlightElement(driver, mainclose);
		Helper.safeJavaScriptClick(driver,mainclose);
		Helper.customWait(5);
		
		//WebElement cart=driver.findElement(By.xpath("//a[@class='cart loaded']"));
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
		Helper.customWait(5);
		helper.highlightElement(driver, mainclose);
		Helper.safeJavaScriptClick(driver,mainclose);
		}catch (Exception e) {
			// TODO: handle exception
		}
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
		/*Helper.customWait(5);
		driver.quit();*/
}
}
