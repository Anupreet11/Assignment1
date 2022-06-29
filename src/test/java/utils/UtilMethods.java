package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UtilMethods {

	WebDriver driver;

	public void launch(String browser, String url) {
		String path = System.getProperty("user.dir");
		System.out.println(path);

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", path + "\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("msedge")) {
			System.setProperty("webdriver.edge.driver", path + "\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();

		} else {
			System.out.println("this is not the correct browser parameter>> give valid input");
			System.exit(0);
		}
		if (url != "")
			driver.get(url);
		else
			driver.get("about:blank");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void tearDown() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
