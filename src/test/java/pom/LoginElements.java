package pom; 
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElements {
	WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAccountlink;

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Login')][1]")
	WebElement loginlist;

	@CacheLookup
	@FindBy(xpath = "//input[@id='input-email']")
	public WebElement emailField;

	@CacheLookup
	@FindBy(xpath = "//input[@id='input-password']")
	public WebElement passwordField;

	// input[@class='btn btn-primary']

	@CacheLookup
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement loginbtn;

	// a[contains(text(),'Laptops & Notebooks') and @class='dropdown-toggle']

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Laptops & Notebooks') and @class='dropdown-toggle']")
	WebElement laptopDropdwn;

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Show All Laptops & Notebooks')]")
	WebElement ShowallLaptoplink;

	// p[@class='price']

	@CacheLookup
	@FindBy(xpath = "//p[@class='price']")
	List<WebElement> Allprices;

	public LoginElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String loginandVerify(String email, String password) {
		ArrayList<String> pricelist = new ArrayList<String>();
		ArrayList<String> pricelist2 = new ArrayList<String>();
		ArrayList<Float> price = new ArrayList<Float>();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		// System.out.println(nf.format(new BigDecimal("1000")));
		// WebElement selectedEle;

		myAccountlink.click();
		loginlist.click();
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginbtn.click();
		laptopDropdwn.click();
		ShowallLaptoplink.click();
		// Allprices.sort(null);

		int i, j, count2;
		for (i = 0; i < Allprices.size(); i++) {
			// pricelist.add(Allprices.get(i).getText());
			String str[] = Allprices.get(i).getText().split(" ");
			System.out.println(Arrays.toString(str));
			pricelist.add(str[0]);
		}
		// System.out.println(pricelist);
		for (j = 0; j < pricelist.size(); j++)
			pricelist2.add(pricelist.get(j).replaceAll("[^0-9.]", "")); // replace all values except numbers and
																		// decimals

		for (String s : pricelist2)
			price.add(Float.valueOf(s));
		Collections.sort(price); // sorts price in ascending order
		System.out.println(price);
		int length = price.size();
		float Expprice = (price.get(length - 1));// get the last price which is the greatest value
		String Exppriceinstring = nf.format(new BigDecimal(Expprice));
		System.out.println(Exppriceinstring);

		for (count2 = 0; count2 < Allprices.size(); count2++) {
			String str = Allprices.get(count2).getText();
			if (str.contains(Exppriceinstring)) {
				str.contains(Exppriceinstring);
				WebElement selectedEle = Allprices.get(count2);
				System.out.println(selectedEle.getText());
				selectedEle.click();
				break;
			}

		}
		
	String expectedstr=	driver.getPageSource();
	
	return expectedstr;
//			System.out.println("verified!!The most Expensive laptop is the Macbook Pro");
//		else
//			System.out.println("Not this time");

	}
}




