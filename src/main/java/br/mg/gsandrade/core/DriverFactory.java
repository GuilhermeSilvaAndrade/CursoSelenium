package br.mg.gsandrade.core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if(driver == null) {

			switch (Propriedades.browser) {
			
				case FIREFOX: 
					System.setProperty("webdriver.gecko.driver", "resources\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
					break;
				
				case CHROME: 
					System.setProperty("webdriver.chrome.driver", "resources\\drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
					
				case IE:
					System.setProperty("webdriver.ie.driver", "resources\\drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					break;
			}
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
		driver.quit();
		driver = null;
		}
	}
}
