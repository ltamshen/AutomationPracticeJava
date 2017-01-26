package testbase;

import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.*;

public class testbase {
	protected WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void initialize(String browser) {
		driver = selectBrowser(browser);
		driver.get("http://www.automationpractice.com");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public WebDriver selectBrowser(String browser) {
		switch (browser) {
		case ("IE"): {
			// When using IE, turn of Protected Mode for all zones otherwise
			// tests will fail
			//System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\eclipse\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", ".\\resources\\webDrivers\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		case ("Chrome"): {
			System.setProperty("webdriver.chromedriver.driver", ".\\resources\\webDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			return new ChromeDriver(options);
		}
		default: {
			System.setProperty("webdriver.ie.driver", ".\\resources\\webDrivers\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}

		}
	}
}
