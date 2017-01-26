package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SearchResultsPage {
	protected WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CLASS_NAME, using = "heading-counter")
	private WebElement numOfResults;

	public void getURL() {
		System.out.println(driver.getTitle());
	}

	public boolean someResultsFound() {
		String[] s = numOfResults.getText().split(" ");
		// "x results have been found."
		Helper.Log(numOfResults.getText());
		return Integer.parseInt(s[0]) > 0;

	}

}
