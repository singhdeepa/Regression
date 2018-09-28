package in.licious.util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import in.licious.test.BaseTest;

public class Helper extends BaseTest{
	
	public static String SCREEN_SHOT_PATH;
	private int invalidImageCount=0;
	public static String dateAndTimeStamp(){
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy-HH-mm-ss");
		 return sdf.format(new Date());
		
	}
	public static void customWait(long seconds){
		try{
			Thread.sleep(seconds*1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	private static WebDriver explicitWait(WebDriver driver,long timeOutInSecond,ExpectedCondition<WebDriver> expectedCondition){
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSecond);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(expectedCondition);
			}
	private static WebElement explicitWait(WebDriver driver,ExpectedCondition<WebElement> expectedCondition,long timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(expectedCondition);
	}
	public  void clickOnElement(WebDriver driver,WebElement element){
		explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10).click();
	}
	public  void clickOnElement(WebDriver driver,WebElement element,long timeOutInSecond){
		explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond).click();
	}
	public  void enterText(WebDriver driver,WebElement element,CharSequence text,long timeOutInSecond){
		
			if(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond).isDisplayed()){
				element.clear();
				element.sendKeys(text);
			}
	}
	public  void enterText(WebDriver driver,WebElement element,CharSequence text){
		
		if(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 15).isDisplayed()){
			element.clear();
			element.sendKeys(text);
		}
}
	 public static void takeScreenShot(String sname){
		 try {
			Robot robot=new Robot();
			BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			SCREEN_SHOT_PATH=System.getProperty("user.dir")+"/ScreenShots/"+sname+"-"+dateAndTimeStamp()+".png";
			try {
				ImageIO.write(image, "png", new File(SCREEN_SHOT_PATH));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}	
		 
	 }
	 public  WebDriver switchToFrame(WebDriver driver,WebElement element,long timeOutInSecond){
		 return  explicitWait(driver,timeOutInSecond, ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		 }
	 public  WebDriver switchBackFromFrame(WebDriver driver){
		return driver.switchTo().defaultContent();
	 }
	 /**switchToChildWindow() method works properly only when there is two window opened
	  */
	 public  void switchToChildWindow(WebDriver driver){
		 Iterator<String> itr = driver.getWindowHandles().iterator();
		 itr.next();
		 driver.switchTo().window(itr.next());
	 }
	 /**switchBackToParentWindow() method works properly only when there is two window opened
	  */
	 public  void switchBackToParentWindow(WebDriver driver){
		 Iterator<String> itr = driver.getWindowHandles().iterator();
		 driver.switchTo().window(itr.next());
	 }
	 public  void selectDropDown(WebDriver driver,WebElement element,String text){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10));
		 select.selectByVisibleText(text);
	 }
	 public  void selectDropDown(WebDriver driver,WebElement element,String text,long timeOutInSecond){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond));
		 select.selectByVisibleText(text);
	 }
	 public  void deSelectDropDown(WebDriver driver,WebElement element,String text){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), 10));
		 select.deselectByVisibleText(text);
	 }
	 public  void deSelectDropDown(WebDriver driver,WebElement element,String text,long timeOutInSecond){
		 Select select=new Select(explicitWait(driver, ExpectedConditions.elementToBeClickable(element), timeOutInSecond));
		 select.deselectByVisibleText(text);
	 }
	 public  void mouseHover(WebDriver driver,WebElement element){
		 Actions action=new Actions(driver);
		 action.moveToElement(element);
	 }
	 public  Alert switchToAlert(WebDriver driver){
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.alertIsPresent());
	 }
	 
 public void scrollBar(WebDriver driver,WebElement elementToFind)
	 {
		 while(true)
	        {
	            try
	            {	
	            	elementToFind.click();
	                break;
	            }
	            catch(Throwable t)
	            {
	            	
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	                js.executeAsyncScript(" ", "Window.scrollBy(0,50)");
	            }
	        }
	 }
 public void scrollBar1(WebDriver driver,WebElement elementToFind)
 {
	 while(true)
        {
            try
            {	
            	elementToFind.isEnabled();
                break;
            }
            catch(Throwable t)
            {
            	
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeAsyncScript(" ", "Window.scrollBy(0,50)");
            }
        }
 }
 //Created By Deepa
 
 public  void highlightElementList(WebDriver driver,List<WebElement> imagesList)
 {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
     //use executeScript() method and pass the arguments 
     //Here i pass values based on css style. Yellow background color with solid red color border. 
js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid blue;');", imagesList);
 }

 /*public static  void highlightElement1(WebDriver driver,String ele)
 {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
     //use executeScript() method and pass the arguments 
     //Here i pass values based on css style. Yellow background color with solid red color border. 
js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", ele);
 }*/
 public   void highlightElement(WebDriver driver,WebElement ele)
 {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
     //use executeScript() method and pass the arguments 
     //Here i pass values based on css style. Yellow background color with solid red color border. 
js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", ele);
 }
 public static void safeJavaScriptClick(WebDriver driver,WebElement element) throws Exception {
		try {
			if (element.isEnabled() || element.isDisplayed()) {
				//System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				
			
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			//System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
 
 public static void switchOnWindowBasedOnTitle(WebDriver driver, String your_title)
 {
	boolean flag=false;
	// String your_title = "This is the Title";
	 String currentWindow = driver.getWindowHandle();  //will keep current window to switch back
	 for(String winHandle : driver.getWindowHandles()){
	    if (driver.switchTo().window(winHandle).getTitle().equals(your_title)) {
	      //This is the one you're looking for
	    	//Helper.highlightElement1(driver,your_title );
	    	flag=true;
	    	driver.close();
	     // break;
	    } 
	 }
	 
	    driver.switchTo().window(currentWindow);
	    if(flag==true)
		 {
		 etest.log(LogStatus.PASS,"Title is Verified as Expected "+your_title );
		 }else
		 {
		 etest.log(LogStatus.FAIL,"Title is Not Verified as Expected "+your_title );
		 }
	 }

 public int verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			//System.out.println(imgElement.getAttribute("src"));
			String urlImg=imgElement.getAttribute("src");
			
		//	System.out.println(urlImg);
			try {
				int noImageURLCount=0;
			if(urlImg.equals(null))
			{
				noImageURLCount++;
			//System.out.println("No url 1 ======Invalid URL "+noImageURLCount);
			etest.log(LogStatus.PASS,"Unknown URL "+noImageURLCount);
			}else if(urlImg.equals(""))
			{
				noImageURLCount++;
				//System.out.println("No url 2 ======Invalid URL "+noImageURLCount++);	
				etest.log(LogStatus.PASS,"Unknown URL "+noImageURLCount);
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
			if(!urlImg.equals(""))
			{
			HttpGet request = new HttpGet(urlImg);
			
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			Helper.customWait(5);
			if (response.getStatusLine().getStatusCode() != 200)
			{
				int value=response.getStatusLine().getStatusCode();
				//System.out.println(response.getStatusLine().getStatusCode() );
				Helper.customWait(5);
				invalidImageCount++;
				//etest.log(LogStatus.PASS,"Invalid URL "+imgElement.getText()+invalidImageCount);
			}
			}
		} catch (Exception e) {
			
				/*HttpResponse response = client.execute(request);
				// verifying response code he HttpStatus should be 200 if not,
				// increment as invalid images count
				if (response.getStatusLine().getStatusCode() != 200)
				{
					int value=response.getStatusLine().getStatusCode();
					System.out.println(response.getStatusLine().getStatusCode() );
					invalidImageCount++;
				}*/
			e.printStackTrace();
		}
		return invalidImageCount;
	}
 }


