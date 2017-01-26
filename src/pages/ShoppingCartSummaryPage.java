package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.Reporter;

public class ShoppingCartSummaryPage {
	protected WebDriver driver;
	
	public ShoppingCartSummaryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(how = How.ID, using = "cart_title")
private WebElement summaryText;

@FindBy(how = How.XPATH, using = "//*[@id='product_3_13_0_0']/td[5]/input[2]")
private WebElement qtyItems;

@FindBy(how = How.XPATH, using = "//*[@id='center_column']/p[2]/a[1]")
private WebElement proceedToCheckOut;

@FindBy(how = How.XPATH, using = "//*[@id='center_column']/h1")
private WebElement authenticationText;

public boolean verifySummaryText(){
	return summaryText.getText().contains(Constants.shoppingCartSummaryText);

}
public boolean verifyQty(){
	return qtyItems.getAttribute("value").equals(Constants.dressesQty);
}
public boolean verifyAuthenticationText(){
	return authenticationText.getText().equals(Constants.authenticationText);
}
public boolean verifyPage(){
	return verifySummaryText() && verifyQty();
}
public AuthenticationPage checkout(){
	proceedToCheckOut.click();
	Helper.WaitForPage();
	return new AuthenticationPage(driver);
}
}
