package pages;

import org.openqa.selenium.WebDriver;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class DressesPage {
	protected WebDriver driver;

	public DressesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(how=How.LINK_TEXT, using = "Casual Dresses")
private WebElement casualDressLink;


@FindBy(how=How.XPATH, using = "//*[@id='add_to_cart']/button")
private WebElement addToCartButton;

@FindBy(how = How.XPATH, using = "//*[@id='layer_cart']/div[1]/div[2]/h2/span[1]/span")
private WebElement itemsInCart;

@FindBy(how = How.XPATH, using = "//*[@id='layer_cart_product_title']")
private WebElement selectedCartItem;

@FindBy(how=How.CLASS_NAME, using = "btn btn-default button button-medium")
private WebElement proceedToCheckoutButton;

@FindBy (how = How.XPATH, using = "//*[@id='center_column']/ul/li/div/div[2]/h5/a")
private  WebElement hoverImage;

@FindBy (how = How.CLASS_NAME, using = "product-name")
private WebElement printedDress;

@FindBy (how=How.XPATH, using = "//*[@id='categories_block_left']/div/ul/li")
private List<WebElement> dressesList;

@FindBy (how=How.XPATH, using = "//input[@id='quantity_wanted']")
private WebElement quantity;
// //*[@id="quantity_wanted"]

public void clickOnCasualLink(){
	casualDressLink.click();
}

public ShoppingCartPage addToCart(String quantity) {
	//scroll down to get element in view
	Helper.scrollDown(driver);
	hoverImage.click();
	Helper.WaitForPage();
	enterQuantity(quantity);
	addToCartButton.click();
	Helper.WaitForPage();
	return new ShoppingCartPage(driver);
}

public void enterQuantity(String qty){
	quantity.clear();
	quantity.sendKeys(qty);
}
public void printDressesList(){
	for(WebElement e:dressesList){
		System.out.println(e.getText());
	}
}
public boolean selectDressType(String dressType){
	for(WebElement e:dressesList){
		if(e.getText().equals(dressType)){
			Helper.Log("Clicking on dress type " + e.getText());
			e.click();
			return true;
		}
	}
	Helper.Log("Could not find dress type in list");
	return false;
}

/*public boolean addItemToCart(String dressType,String quantity){
	if(!selectDressType(dressType)){
		Helper.Log("Could not find dress type " + dressType);
		return false;
	}
	ShoppingCartPage shoppingCartPage = addToCart(quantity);
	return shoppingCartPage.verifyItemInCart(quantity);

	
	
	
}*/
}
