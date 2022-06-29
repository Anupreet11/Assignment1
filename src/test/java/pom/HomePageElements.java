package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements {
	WebDriver driver;
	@CacheLookup
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	WebElement myAccountlink;
	
	
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'Register')][1]")
	WebElement registerlist;
	
	
	
	@CacheLookup
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstNameField;
	
	
	@CacheLookup
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastNameField;
	
	//input[@id='input-email']
	
	@CacheLookup
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailfield;
	

	
	@CacheLookup
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephoneField;
	
	@CacheLookup
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordField;
	
	@CacheLookup
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmPasswordField;
	
	@CacheLookup
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement continueBtn;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='agree']")
	WebElement AgreeChkbox;
	
	//input[@name='agree']
	
	public HomePageElements(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String registerAccount(String firstname, String lastname,String telephoneno, String email, String password) {
		myAccountlink.click();
		registerlist.click();
		firstNameField.sendKeys(firstname);
		lastNameField.sendKeys(lastname);
		emailfield.sendKeys(email);
		telephoneField.sendKeys(telephoneno);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);
		AgreeChkbox.click();
		continueBtn.click();
		String str1=driver.getCurrentUrl();
		return str1;
		
		
	}
	
	
}




