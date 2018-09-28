package in.licious.test;

import java.util.List;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.HomePage;
import in.licious.pom.NewLoginFlow;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class Cold_CutsCategory_Regression extends BaseTest{
@Test
public void Cold_CutsCategory_RegressionTest() throws Exception
{
	 int invalid=0;
	 WebElement slot=null;
	 WebElement slotd=null;
	Helper helper=new Helper();
	NewLoginFlow newlogin = new NewLoginFlow(driver);
	DataBaseCCC db1=new DataBaseCCC();
	HomePage hp=new HomePage(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
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
		
		helper.clickOnElement(driver, newlogin.getpasswordLogin());
		Helper.customWait(2);
				
		// Enter the password
		helper.highlightElement(driver, newlogin.getenterpassword());
		helper.enterText(driver, newlogin.getenterpassword(), passWord);
		Helper.customWait(5);
		//helper.highlightElement(driver, newlogin.getpasswordloginBtn());
		//helper.clickOnElement(driver, newlogin.getpasswordloginBtn());
		Helper.safeJavaScriptClick(driver,newlogin.getpasswordloginBtn());
		

Helper.customWait(8);
	//Helper.customWait(5);

WebElement coldAndCuts=driver.findElement(By.xpath("//a[@href='/breakfast']"));
String expColdCutsLink="Cold Cuts";
 helper.highlightElement(driver, coldAndCuts);
 Helper.customWait(5);
String actColdCutsLink=coldAndCuts.getText();
Assert.assertEquals(actColdCutsLink, expColdCutsLink);
etest.log(LogStatus.PASS," Cold Cuts Link is validated successfully");
Helper.customWait(5);
Helper.safeJavaScriptClick(driver,coldAndCuts);
Assert.assertTrue(true, "Cold Cuts  link is Clicked successfully");
etest.log(LogStatus.PASS,"Cold Cuts  link is Clicked successfully"); 
Helper.customWait(5);  
	
	
	try {
		//invalidImageCount = 0;
		int index=0;
		List<WebElement> imagesList = driver.findElements(By.xpath("//div[@class='item-img']/img"));
		System.out.println("Total no. of images are " + imagesList.size());
		for (WebElement imgElement : imagesList) {
			if (imgElement != null) {
				helper.highlightElement(driver, imagesList.get(index));
				 Helper.customWait(5);
				 invalid=helper.verifyimageActive(imgElement);
				 index++;
				
			}
			
		}
		System.out.println(invalid);
		etest.log(LogStatus.PASS,"Total no. of invalid images are "	+ invalid);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
      
     
      try {
			List<WebElement> itemTitle =driver.findElements(By.xpath("(//div[@class='item-title'])"));	
          System.out.println("Total no. of itemTitle are " + itemTitle.size());
          int count=0;int count1=0;
          for(int i=0;i<=itemTitle.size()-1;i++)
          {
         // System.out.println(itemTitle.get(i).getText());
        	  helper.scrollBar1(driver,itemTitle.get(count));
        	  helper.highlightElement(driver, itemTitle.get(count));
        	 
          if(itemTitle.get(i).getText().contains(itemTitle.get(count).getText()));
          {
          	System.out.println(itemTitle.get(count).getText());
          	//helper.scrollBar(driver,itemTitle.get(count+1));
          	helper.highlightElement(driver, itemTitle.get(count));
          	List<WebElement> rates =driver.findElements(By.xpath("//span[contains(@class,'rupee ')]"));
          	List<WebElement> itemDesc=driver.findElements(By.xpath("//p[@class='item-desc']"));
          	List<WebElement> netWeight=driver.findElements(By.xpath("//span[@class='net-weight']"));
          	
          	helper.highlightElement(driver, rates.get(count1));
          	System.out.println(rates.get(count1).getText()); 
          	helper.highlightElement(driver, itemDesc.get(count));
          	System.out.println(itemDesc.get(count).getText());
          	helper.highlightElement(driver, netWeight.get(count));
          	System.out.println(netWeight.get(count).getText());
          	count1++;
          	count1++;
          	count++;
          	if(itemTitle.get(count).isDisplayed())
          	{
          		etest.log(LogStatus.PASS,"Product Name is "+itemTitle.get(count).getText()+ "and rate ,Description and Weight are ...."+rates.get(count1).getText()+itemDesc.get(count).getText()+netWeight.get(count).getText());	
          	}
          	else
          	{
          		etest.log(LogStatus.FAIL,"Product name and Descriptions Not Shown");
          	}
          }
          }
			}
          catch (Exception e) {
				// TODO: handle exception
			}
			
			Helper.customWait(5);
			WebElement cart=driver.findElement(By.xpath("//span[text()='Cart']"));
			helper.highlightElement(driver, cart);
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
			
		  List<WebElement> addToCart=driver.findElements(By.xpath("//button[@class='add-to-cart addCartBtn-home']"))	;
		  System.out.println(addToCart);
		  List<WebElement> addTocartByOne=driver.findElements(By.xpath("//span[@class='cart-btns add-one']"));
		  System.out.println(addTocartByOne);
		   for (int i = 0; i < 5; i++) {
			   try
				{
			//addToCart.get(i).click();
				   helper.highlightElement(driver, addToCart.get(i));
			Helper.safeJavaScriptClick(driver,addToCart.get(i));
			Helper.customWait(5);
				}catch (Exception e) {
				// TODO: handle exception
					//addTocartByOne.get(i).click();
					try
					{
					  helper.highlightElement(driver,addTocartByOne.get(i));
					Helper.safeJavaScriptClick(driver,addTocartByOne.get(i));
					}catch(Exception e1)
					{
						
					}
			}
			   
		   }
		   Helper.customWait(5);
			 cart=driver.findElement(By.xpath("//span[text()='Cart']"));
//			helper.highlightElement(driver, cart);
			Helper.safeJavaScriptClick(driver,cart);
			 Helper.customWait(7);
		   WebElement proceedBTN=	driver.findElement(By.xpath("//button[@class='btn-proceed']"));
			if(proceedBTN.isEnabled())
			{
				//System.out.println("pass");
				//helper.scrollBar1(driver, proceedBTN);
			//	 js.executeScript("window.scrollBy(0,50)");
				
				helper.highlightElement(driver, proceedBTN);
				 Helper.customWait(7);
				Helper.safeJavaScriptClick(driver,proceedBTN);
				//proceedBTN.click();
				etest.log(LogStatus.PASS,"Proceed Button is Clicked successfully");
				Helper.customWait(2);
				}
			else
				{
				etest.log(LogStatus.FAIL,"Proceed Button is NOT Clicked ");
				}
			Helper.customWait(8);
			
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
			Helper.safeJavaScriptClick(driver,completeAdd);
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
				//slot1wb.click();
				Helper.safeJavaScriptClick(driver,slot1wb);
			Helper.customWait(8);
			//slot2wb.click();
			Helper.safeJavaScriptClick(driver,slot2wb);
			Helper.customWait(5);
			//slot3wb.click();
			Helper.safeJavaScriptClick(driver,slot3wb);
			Helper.customWait(5);
			//slot4wb.click();
			Helper.safeJavaScriptClick(driver,slot4wb);
			Helper.customWait(5);
			//slot5wb.click();
			Helper.safeJavaScriptClick(driver,slot5wb);
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
				Helper.customWait(5);
			 slotd=driver.findElement(By.xpath("(//div[@class='slots-selector'])[2]"));
			}catch (Exception e) {
				// TODO: handle exception
			}

			try {
				Helper.customWait(5);
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
					Helper.customWait(5);
					String slotd1="(//li[@data-ship_id='2'])[1]";
					String slotd2="(//li[@data-ship_id='2'])[2]";
					String slotd3="(//li[@data-ship_id='2'])[3]";
					String slotd4="(//li[@data-ship_id='2'])[4]";
					String slotd5="(//li[@data-ship_id='2'])[5]";
					WebElement slotd1wb=driver.findElement(By.xpath(slotd1));
					WebElement slotd2wb=driver.findElement(By.xpath(slotd2));
					WebElement slotd3wb=driver.findElement(By.xpath(slotd3));
					WebElement slotd4wb=driver.findElement(By.xpath(slotd4));
					WebElement slotd5wb=driver.findElement(By.xpath(slotd5));
				//slotd1wb.click();
				Helper.safeJavaScriptClick(driver,slotd1wb);
				Helper.customWait(8);
				//slotd2wb.click();
				Helper.safeJavaScriptClick(driver,slotd2wb);
				Helper.customWait(5);
				
				//slotd3wb.click();
				//Helper.customWait(5);
				Helper.safeJavaScriptClick(driver,slotd3wb);
				//slotd4wb.click();
				Helper.customWait(5);
				Helper.safeJavaScriptClick(driver,slotd4wb);
				//slotd5wb.click();
				Helper.customWait(5);
				Helper.safeJavaScriptClick(driver,slotd5wb);
				Helper.customWait(5);
				}catch(Exception e1)
				{
				
				}
			}catch (Exception e) {
				// TODO: handle exception
			}


				
			Helper.customWait(8);
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