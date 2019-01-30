package com.sw.ui.Starwars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StarwarsSignUpPage {
	
	WebDriver driver;

	
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(name="displayName")
	WebElement displayName;
	
	@FindBy(name="email")
	WebElement emailId;
	
	@FindBy(name="newPassword")
	WebElement password;
	
	@FindBy(xpath="//button[contains(.,'Create Account')]")
	WebElement createAccount;

	
	@FindBy(xpath="//div/div/select[1]")
	WebElement birthMonth;
	
	@FindBy(xpath="//div/div/select[2]")
	WebElement birthDate;
	
	@FindBy(xpath="//div/div/select[3]")
	WebElement birthYear;
	
	@FindBy(xpath="//div/label/span[contains(.,'Show password')]")
	WebElement showPassword;
	
	@FindBy(xpath="//div[@class='block show-password-action ng-scope']/label/input")
	WebElement showPasswordCheckbox;
	
	@FindBy(xpath="//div[@class='field ng-scope']/label/input")
	WebElement updates;
		
	@FindBy(xpath="//div[@class='field field-username-email']/label/span/input")
	WebElement username;
	
	@FindBy(xpath=".//*[@id='did-ui-view']/div/section/section/form/section/div[2]/div/label/span[2]/input")
	WebElement passwordSign;
	
	@FindBy(xpath=".//*[@id='did-ui-view']/div/section/section/form/section/div[3]/button")
	WebElement SignIn;
	
	@FindBy(xpath="//div[@class='btn-group']/a[contains(.,'Facebook')]")
	WebElement facebookSign;
	
	@FindBy(className="//div[@class='btn-group']/a[contains(.,'Google')]")
	WebElement GoogleSign;
	
	@FindBy(className="//div[@class='btn-group']/a[contains(.,'Account')]")
	WebElement createNewAccount;
	
	
	
	@FindBy(className=".//*[@id='nav-utility']/div[2]/div[2]/div[1]/span[1]")
	WebElement UserID;
	
	
	public StarwarsSignUpPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	StarwarsLibrary lib=new StarwarsLibrary(driver);
	public void  setEmailId(String Username){
		username.sendKeys(Username);
	}
	
	public void clickCreateAccount() {
		createAccount.click();
	}
	
	public void  setPassword(String Password) throws Exception{
		 lib.waitForElementIsDisplayed(password, 20);
	     password.sendKeys(Password);
	}
	public void clickSignIn() {
		SignIn.click();
	}
	
	
	
}
