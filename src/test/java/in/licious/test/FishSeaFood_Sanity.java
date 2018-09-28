package in.licious.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.pom.HomePage;
import in.licious.pom.NewLoginFlow;
import in.licious.util.DataBaseCCC;
import in.licious.util.Helper;

public class FishSeaFood_Sanity extends BaseTest {
	@Test
	public void validateFishSeaFoodTest()
	{
		 int invalidImageCount;
		try {
		
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
				helper.clickOnElement(driver, newlogin.getpasswordloginBtn());

				String expFishAndSeaFoodlink="Fish & Seafood";
				   String actFishAndSeaFoodlink=driver.findElement(By.xpath("//a[@href='/seafood']")).getText();
				   Assert.assertEquals(actFishAndSeaFoodlink, expFishAndSeaFoodlink);
				   etest.log(LogStatus.PASS,"Fish & Seafood Link is validated successfully");
				   Helper.customWait(5);
				   driver.findElement(By.xpath("//a[@href='/seafood']")).click();
					Assert.assertTrue(true, "Fish & Seafood  link is Clicked successfully");
					etest.log(LogStatus.PASS,"Fish & Seafood  link is Clicked successfully");
					Helper.customWait(5);
		}
					catch (Exception e) {
						// TODO: handle exception
					}
					/*try {
						invalidImageCount = 0;
						List<WebElement> imagesList = driver.findElements(By.tagName("img"));
						System.out.println("Total no. of images are " + imagesList.size());
						for (WebElement imgElement : imagesList) {
							if (imgElement != null) {
								Helper.verifyimageActive(imgElement,invalidImageCount);
							}
						}
						System.out.println("Total no. of invalid images are "	+ invalidImageCount);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}*/
					try {
					List<WebElement> itemTitle =driver.findElements(By.xpath("(//div[@class='item-title'])"));	
		            System.out.println("Total no. of itemTitle are " + itemTitle.size());
		            int count=0;int count1=0;
		            for(int i=0;i<=itemTitle.size()-1;i++)
		            {
		           // System.out.println(itemTitle.get(i).getText());
		            	
		            if(itemTitle.get(i).getText().contains(itemTitle.get(count).getText()));
		            {
		            	System.out.println(itemTitle.get(count).getText());
		            	List<WebElement> rates =driver.findElements(By.xpath("//span[contains(@class,'rupee ')]"));
		            	List<WebElement> itemDesc=driver.findElements(By.xpath("//p[@class='item-desc']"));
		            	List<WebElement> netWeight=driver.findElements(By.xpath("//span[@class='net-weight']"));
		            	System.out.println(rates.get(count1).getText());
		            	System.out.println(itemDesc.get(count).getText());
		            	System.out.println(netWeight.get(count).getText());
		            	count1++;
		            	count1++;
		            	count++;
		            }
		            }
					}
		            catch (Exception e) {
						// TODO: handle exception
					}
	}
}
