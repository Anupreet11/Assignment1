package test;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pom.LoginElements;
import utils.ReardExcel;

public class Logintest extends Base{
	
	LoginElements loginloc;
	@BeforeClass(alwaysRun = true)
	public void beforeclass() {
		loginloc = new LoginElements(driver);
		System.out.println("before class ran ");
	}

@Parameters({"email","password"})	
  @Test
  public void NewUserloginTest(String em, String pswd) {
	
	String expected, actual;
	expected="MacBook Pro";
	 actual = loginloc.loginandVerify(em, pswd);
	 assertTrue(actual.contains(expected),"macpro is not the most expensive");
	 Reporter.log("verified macbook pro is the most expensive");

	 
}
@DataProvider(name = "LoginCredentials")

public static Object[][] login() throws Exception {
	ReardExcel excel=new ReardExcel();
	Object[][] testObjArray = excel.getTableArray("C:\\Automation\\Workspace\\TestngandPOMWOnderlabs\\TestngandPOMWOnderlabs\\Book 1.xlsx","LoginCredentials");

    return (testObjArray);
}

@Test(dataProvider="LoginCredentials")
public void loginwithexcel(String sUserName,String sPassword) {
	
loginloc.emailField.sendKeys(sUserName);
System.out.println(sUserName);
loginloc.passwordField.sendKeys(sPassword);
System.out.println(sPassword);

}



}
	 


