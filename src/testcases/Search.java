package testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.HomePage;
import pages.*;
import testbase.testbase;

public class Search extends testbase {

	@Test
	public void searchForDress() {
		HomePage homePage = new HomePage(driver);
		SearchResultsPage searchResultsPage = homePage.enterSearchCriteria("dress");
		Assert.assertTrue(searchResultsPage.someResultsFound(), "Expected more than one result but none found.");
	}
}
