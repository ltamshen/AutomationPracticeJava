package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.testng.Reporter;

public class Helper {


	public static void WaitForPage() {
		try {
			Thread.sleep(1700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void Log(String msg){
		Reporter.log(msg,true);
	}
	
	public static boolean checkFooterLinks(WebDriver driver, int numOfItems,String xpathString, List<String> linkNames) {
		try{
			for(int i=1;i<=numOfItems;i++){
				WebElement categoryLink = driver.findElement(By.xpath(String.format(xpathString,i)));
				categoryLink.click();
				Helper.WaitForPage();
				// Note: after putting ValidateBreadcrumb in Helper, call it below
				if(!linkNames.get(i-1).equals(driver.findElement(By.className(Constants.breadcrumb)).getText().trim())){
					return false;
				}
				driver.navigate().back();
				Helper.WaitForPage();
			}
			return true;
		}
		catch(NoSuchElementException e){
			Helper.Log("Error when selecting link.");
			return false;
		}
	}
	public static void scrollDown(WebDriver driver){
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("scroll(0,400)");
	}
}
