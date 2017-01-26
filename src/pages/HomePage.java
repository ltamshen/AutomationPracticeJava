package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class HomePage {
	protected WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "search_query")
	private WebElement searchBox;

	@FindBy(how = How.NAME, using = "submit_search")
	private WebElement searchButton;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'contact-link')]/a")
	private WebElement contactUsLink;
	
	//@FindBy(how=How.LINK_TEXT, using = "Dresses")
	//private WebElement dressesLink;
	
	//@FindBy(how=How.XPATH, using = "//a[contains(@title,'Dresses')]")
	@FindBy(how = How.XPATH, using = ("//div[6]/ul/li[2]/a"))
	private WebElement dressLinkXpath;
	
	@FindBy(how=How.XPATH, using = "//div/a[contains(@data-id-product,'3')]")
	private WebElement firstDressAddToCart;

	public SearchResultsPage enterSearchCriteria(String criteria) {
		searchBox.sendKeys(criteria);
		searchButton.click();
		Helper.WaitForPage();
		return new SearchResultsPage(driver);
	}
	public ContactUsPage clickOnContactUs(){
		contactUsLink.click();
		Helper.WaitForPage();
		return new ContactUsPage(driver);
	}
	public DressesPage clickOnDresses(){
		//dressesLink.click();
		dressLinkXpath.click();
		Helper.WaitForPage();
		return new DressesPage(driver);
	}
	public void addDressToCart(){
		firstDressAddToCart.click();
	}
}
