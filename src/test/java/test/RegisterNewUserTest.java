package test; 
import static org.testng.Assert.assertFalse;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.HomePageElements;
import pom.LoginElements;
public class RegisterNewUserTest extends Base {
	HomePageElements homePage;
	@BeforeClass(alwaysRun = true)
	public void beforeclass() {
	 homePage= new HomePageElements(driver);
		System.out.println("before class ran ");
	}
 @Parameters({"firstname","lastname","telephone","email","password"})	
  @Test
  public void RegisterUser(String firstname, String lastname,String telephoneno, String email, String password) {
	 String actual,Str1;
	
	  actual=homePage.registerAccount(firstname,lastname,telephoneno,email,password);
	  Str1="https://naveenautomationlabs.com/opencart/index.php?route=account/register";
	  
	  assertFalse(actual.contains(Str1),"account registration not successful");
	  Reporter.log("new account successfully registered");
			  
//	  if(equalsIgnoreCase("http://naveenautomationlabs.com/opencart/index.php?route=account/register"))
//			System.out.println("account already exists");
//			System.out.println("success");
//	  System.out.println("account registered Successfully");
 }}

//  


