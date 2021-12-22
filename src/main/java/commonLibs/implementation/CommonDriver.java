package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import okio.Timeout;

public class CommonDriver {

	private WebDriver driver;

	private int pageLoadTimeout = 20;

	private int elementDetectionTimeout = 30;

	private String currentworkingDirectory;

	public CommonDriver(String brwserType) throws Exception{

		if(brwserType.equalsIgnoreCase("chrome"))
		{
			currentworkingDirectory = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", currentworkingDirectory + "/drivers/chromedrivernew.exe");
			driver = new ChromeDriver();		
		}else if(brwserType.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", currentworkingDirectory + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();	
		}else
		{
			throw new Exception("invalid Broswer type" + brwserType );
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void navigateToUrl(String url) {

		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		driver.get(url);	
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public String getTitle()
	{
		return driver.getTitle();
	}

	public void closeAllDrivers() {
		driver.quit();
	}
}

