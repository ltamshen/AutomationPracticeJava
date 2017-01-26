package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ContactUsPage {
	protected WebDriver driver;
	public ContactUsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CLASS_NAME, using = Constants.breadcrumb)
	private WebElement breadcrumb;
	
	public boolean ValidateBreadcrumb(){
		// Note: put this in Helper
			return breadcrumb.getText().equals("Contact");
			
	}
}
