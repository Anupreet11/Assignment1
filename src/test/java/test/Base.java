package test;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.UtilMethods;

public class Base {
	static WebDriver driver;
	UtilMethods utilm = new UtilMethods();
	
  
  @Parameters({"browser","url"})
	  
	  @BeforeTest(alwaysRun = true)
	  public void beforeTest(String br, String url) {
	  
	  utilm.launch(br,url);
	  driver= utilm.getDriver();
	  
	  }
	 
 
  @AfterSuite
  public void afterClass() {
	  utilm.tearDown();
  }

}


