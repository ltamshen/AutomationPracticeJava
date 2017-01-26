
package testcases;

import pages.*;
import testbase.testbase;

import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class BuySomething extends testbase{
	
	public void buyADress(){
	HomePage homePage = new HomePage(driver);
	DressesPage dressesPage = homePage.clickOnDresses();
	dressesPage.clickOnCasualLink();
	ShoppingCartPage shoppingCartPage = dressesPage.addToCart(Constants.dressesQty);
	Assert.assertTrue(shoppingCartPage.verifyItemInCart(Constants.dressesQty), "Could not verify item in shopping cart.");
	ShoppingCartSummaryPage shoppingCartSummaryPage = shoppingCartPage.proceedToCheckout();
	Assert.assertTrue(shoppingCartSummaryPage.verifyPage(),"Did not find expected information on Shopping Cart Summary page.");
	AuthenticationPage authenticationPage = shoppingCartSummaryPage.checkout();
	}
	
}
