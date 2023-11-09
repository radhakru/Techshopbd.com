package com.techshopbd.webobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserRegistationAndLogInObject {
	// declare one local driver.
	private WebDriver ldriver;
	private List<WebElement> formText;
	private Actions action;
	private WebDriverWait wait;
	private boolean loginValue;
	private String loginPageUrl;

	// create the object class constructor
	// we need to call this class to our stepdefination class so we need one
	// parameterize constructor
	// which accepts the WebDrier driver.

	public UserRegistationAndLogInObject(WebDriver rdriver) {
		// here we initialize our local driver to our remote driver which is nothing but
		// when we call this constructor in
		// stepdefination class we pass driver object in it.
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Encapsulation concept
	public WebDriver getDriver() {
		return this.ldriver;
	}

	// login button xpath
	private By loginButton = By.xpath("//*[contains(text(),'Login')]");

	// All the form text xpath
	private By allFormText = By.xpath("//ul[@id='myTab']/li/a");

	// SIGN Up field locator by id
	private By fullName = By.id("userName");

	private By emailId = By.id("email");

	private By phoneNo = By.id("phone");

	private By password = By.id("password");

	// private By policyCheckBox=By.xpath("//input[@type='checkbox' and
	// @id='privacy']");
	By policyCheckBox = By.xpath("//div[@class='form-group']/div/input");

	// signup Button xpath
	private By signupButton = By.xpath("//input[@type='submit' and @value='Sign Up']");

	// form id
	private By form = By.id("otp-submit");
	// email send verify code text
	// private By emailVerifyCodeMes=By.tagName("p");

	private By emailverifyMes = By.xpath("//div[@class='tab-pane']/form/p[1]");

	private By allOptBox = By.xpath("//div[@class='form-inline']/input[@class='otp-control']");

	// submit button xpath
	private By submitButton = By.xpath("//input[@type='button']");

	private By loginemailId = By.name("username");
	private By loginpassword = By.name("password");
	private By signInbutton = By.xpath("//input[@type='submit' and @value='Sign In']");
	//private By verification_text = By.xpath("//span[@id='message']");

	// profile verify
	private By profileText = By.xpath("//div[@class='user mr-0 ml-4']/a/span[2]");
	
	
	//private By allLinkTextOfProfile=By.xpath("//div[@class='dropdown-menu show']/a");
	
	//toggelbutton
	private By toggelButton=By.xpath("//a[@class='dropdown-toggle-user']");
	
	//logout button
	private By logoutbutton=By.xpath("//input[@type='submit']");

	
	//forget password link
	private By forgotpassword=By.linkText("Forgot Password?");
	
	
	private By recoveryEmail=By.id("phoneOrEmail");
	
	//submit button
	private By forgetSubmitButton=By.xpath("//input[@type='submit']");
	
	
	
	private By codeSubmitButton=By.id("code-submit");
	
	private By newPassword=By.id("newPassword");
	
	private By enterNewPasswordButton=By.id("change-your-password");
	
	

	public By getForm() {
		return form;
	}

	// click on login button
	public void clickOnLoginButton() {
		ldriver.findElement(loginButton).click();
	}

	// print all the form present in login page
	public void printAllForm() {
		formText = ldriver.findElements(allFormText);
		for (WebElement form : formText) {
			System.out.println("Form name= " + form.getText());
		}
	}

	// click on SignUp form
	public void clickOnSignUpForm() {
		for (WebElement form : formText) {
			if (form.getText().equalsIgnoreCase("Sign up")) {
				form.click();
				break;
			}
		}
	}

	// enter sign up all the field.
	public void enterFullName(String fullname) {
		ldriver.findElement(fullName).sendKeys(fullname);
	}

	public void enterEmailId(String email) {
		ldriver.findElement(emailId).sendKeys(email);
	}

	public void enterPhoneNumber(String number) {
		ldriver.findElement(phoneNo).sendKeys(number);
	}

	public void enterPassword(String Password) {
		ldriver.findElement(password).sendKeys(Password);
	}

	// check in term and condition
	public void checkInTermAndCondition() {
		action = new Actions(ldriver);
		System.out.println(ldriver.findElement(policyCheckBox).getAttribute("id"));
		// if(ldriver.findElement(policyCheckBox).isSelected()!=true) {
		action.moveToElement(ldriver.findElement(policyCheckBox)).click().build().perform();
		// }

	}

	// click on signUp button
	public void clickonSignUpButton() {
		ldriver.findElement(signupButton).click();
	}

	// grap the text
	public void getVerifyText() {
		wait = new WebDriverWait(ldriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allOptBox));
		System.out.println(ldriver.findElement(emailverifyMes).getText());
	}

	// click on submit button
	public void clickonSubmitButton() {
		ldriver.findElement(submitButton).click();
	}

	// click on signin form
	public void clickonSignInForm() {
		printAllForm();
		for (WebElement form : formText) {
			if (form.getText().equalsIgnoreCase("Sign in")) {
				form.click();
			}
			break;
		}

	}

	// enter email id
	public void enterEmailIdInLogInForm(String emailid) {
		loginPageUrl = ldriver.getCurrentUrl();
		ldriver.findElement(loginemailId).sendKeys(emailid);
	}

	// enter password
	public void enterPasswordInLogInForm(String password) {
		ldriver.findElement(loginpassword).sendKeys(password);
		System.out.println("Before sign in button url" + ldriver.getCurrentUrl());

	}

	// click on Sign in button
	public void clickonSignInButton() {
		ldriver.findElement(signInbutton).click();
		System.out.println("After signin buttonclick url=" + ldriver.getCurrentUrl());

	}

	// check the user name and password validation using currentUrl.
	public boolean getVerifyLogin() {
		loginValue = false;
		String loginErrorurlname = loginPageUrl + "?error";
		if (ldriver.getCurrentUrl().equals(loginErrorurlname)) {
			loginValue = true;
		}
		return loginValue;
	}

	// verify the login credential
	public void checkUserCredential() {
		boolean check = getVerifyLogin();
		if (check == true) {
			System.out.println("invalid login");

		} else if (check != true) {
			System.out.println("valid login");
			System.out.println("profile name=" + ldriver.findElement(profileText).getText());
		}
		
	}
	//check the user name after successful login
	public void checkUserName(String[] name) {
		String emailId = ldriver.findElement(profileText).getText();
		for(String email:name) {
			if(emailId.equals(name)) {
				Assert.assertTrue(true);
				break;
			}
		}
		

	}
	
	
	//click on logout button
	public void clickonLogoutbutton() {
		action=new Actions(ldriver);
		//action.moveToElement(ldriver.findElement(By.xpath("//a[@class='dropdown-toggle-user']"))).click().build().perform();
		action.moveToElement(ldriver.findElement(toggelButton)).click().build().perform();
		ldriver.findElement(logoutbutton).click();
		System.out.println(ldriver.getCurrentUrl());
		
	}
	
	//click on forget password link
	public void clickOnForgetPassword() {
		ldriver.findElement(forgotpassword).click();
	}
	
	//recovery email enter
	public void enterRecoveryEmail(String email) {
		ldriver.findElement(recoveryEmail).sendKeys(email);
	}
	
	//submit button for forget link
	public void clickOnSubmitButtonInRecover() {
		ldriver.findElement(forgetSubmitButton).click();
	}
	
	public void enterCode() {
		System.out.println("entering code");
	}
	
	public void clickOnCodeSubmitButton() {
		ldriver.findElement(codeSubmitButton).click();
	}
	
	//enter new password
	public void enterNewPassword(String password) {
		ldriver.findElement(newPassword).sendKeys(password);
	}
	
	
	public void clickOnNewPasswordButton() { 
		ldriver.findElement(enterNewPasswordButton).click();
	}
	
	
	
	
	
	
	
	
	
	

}
