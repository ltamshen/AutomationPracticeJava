package pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.Reporter;

public class FooterPage {
	protected WebDriver driver;

	public FooterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

public boolean verifyCategoriesLinks() {
	try{
		driver.findElement(By.xpath("//section/h4[contains(text(),'Categories')]"));
		int numOfItems = driver.findElements(By.xpath("//div[contains(@class,'category_footer')]/div/ul")).size();
		String xpathString = "//div[contains(@class,'category_footer')]/div/ul/li[%1$d]/a";
		return checkFooterLinks(driver, numOfItems, xpathString,Constants.footerCategories);
	}
	catch(NoSuchElementException e){
		Helper.Log("Categories section in does not display in footer as expected.");
		return false;
	}
}

public boolean verifyInformationLinks(){
	try{
		driver.findElement(By.xpath("//section/h4[contains(text(),'Information')]"));
		int numOfItems = driver.findElements(By.xpath("//section[contains(@id,'block_various_links_footer')]/ul/li")).size();
		String xpathString = "//section[contains(@id,'block_various_links_footer')]/ul/li[%1$d]/a";
		return checkFooterLinks(driver, numOfItems, xpathString,Constants.footerInformation);
	}
	catch(NoSuchElementException e){
		Reporter.log("Information section does not display in footer as expected.");
		return false;
	}
}

public static boolean checkFooterLinks(WebDriver driver,int numOfItems,String xpathString, List<String> linkNames) {
	try{
		for(int i=1;i<=numOfItems;i++){
			WebElement categoryLink = driver.findElement(By.xpath(String.format(xpathString,i)));
			categoryLink.click();
			//Helper.WaitForPage();
			if(!linkNames.get(i-1).equals(driver.findElement(By.className(Constants.breadcrumb)).getText().trim())){
				return false;
			}
			driver.navigate().back();
			//Helper.WaitForPage();
		}
		return true;
	}
	catch(NoSuchElementException e){
		Helper.Log("Error when selecting link.");
		return false;
	}
}
/*public boolean verifyMyAccountLinks(){
	try {
	driver.findElement(By.xpath("//section/h4/a[contains(text(),'My account')]"));
	int numOfItems = driver.findElements(By.xpath("//section/div[contains(@class,'block_content')]/ul/li")).size();
	String xpathString = "//section/div[contains(@class,'block_content')]/ul/li/a";
	return Helper.checkLinks(driver, numOfItems, xpathString);
	}
	catch(NoSuchElementException e){
		Helper.Log("My Account section does not display in footer as expected.");
		return false;
	}
}*/
}
