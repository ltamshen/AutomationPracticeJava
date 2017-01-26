package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.*;
import pages.*;

public class Links extends testbase
{
  @Test
  public void FooterLinks() {
	  FooterPage footerPage = new FooterPage(driver);
	  Assert.assertTrue(footerPage.verifyCategoriesLinks(), "Category links in footer are not as expected.");
	  Assert.assertTrue(footerPage.verifyInformationLinks(),"Information links in footer are not as expected.");
  }
  
  @Test
  public void ContactUsLink(){
	  HomePage homePage = new HomePage(driver);
	  ContactUsPage contactUsPage = homePage.clickOnContactUs();
	  Assert.assertTrue(contactUsPage.ValidateBreadcrumb(), "Error going to Contact Us page.");
  }
}
