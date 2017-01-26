package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ShoppingCartPage{
	protected WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//*[@id='layer_cart']/div[1]/div[2]/h2/span[1]/span")
	private WebElement itemsInCart;

	@FindBy(how = How.XPATH, using = "//*[@id='layer_cart_product_title']")
	private WebElement selectedCartItem;
	
	@FindBy(how=How.XPATH, using = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	private WebElement proceedToCheckOut;
	
	public boolean verifyItemInCart(String quantity) {
		if(itemsInCart.getText().equals("0")){
			Helper.Log("ERROR - No items are in cart.");
			return false;
		}
		if(!itemsInCart.getText().equals(quantity)){
			Helper.Log("ERROR - incorrect number of items in cart.");
			return false;
		}
		if(!selectedCartItem.getText().equals("Printed Dress")){
			Helper.Log("ERROR - Printed Dress is not in shopping cart.");
			return false;
		}
		return true;	

		
	}

	public ShoppingCartSummaryPage proceedToCheckout() {
	 proceedToCheckOut.click();
	 Helper.WaitForPage();
	 return new ShoppingCartSummaryPage(driver);
		
	}
}
