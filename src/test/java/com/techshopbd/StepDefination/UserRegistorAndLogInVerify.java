package com.techshopbd.StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.techshopbd.utility.Utility;
import com.techshopbd.webobject.UserRegistationAndLogInObject;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistorAndLogInVerify extends Base {

	private static WebDriver driver;
	private JavascriptExecutor js;
	private UserRegistationAndLogInObject uralo;
	private Utility utility;
	private WebDriverWait wait;

	@Before
	public void setUp() {
		driver = getDriver();
		js = (JavascriptExecutor) driver;
		uralo = new UserRegistationAndLogInObject(driver);
		utility = getUtilityClass();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("user go to the url")
	public void user_go_to_the_url() {
		// System.out.println(utility.getUrl());
		// driver=getDriver();
		driver.get(utility.getUrl());
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("user click on Login button")
	public void user_click_on_login_button() {
		uralo.clickOnLoginButton();
	}

	@Then("user can see SIGN IN and SIGN UP form")
	public void user_can_see_sign_in_and_sign_up_form() throws InterruptedException {
		uralo.printAllForm();
		// Thread.sleep(2000);
	}

	@Then("user click on SIGN UP form")
	public void user_click_on_sign_up_form() throws InterruptedException {
		uralo.clickOnSignUpForm();
		Thread.sleep(2000);

	}

	@Then("user enter fullname {string}")
	public void user_enter_fullname(String string) {
		uralo.enterFullName(string);
	}

	@Then("user enter email id {string}")
	public void user_enter_email_id(String string) {
		uralo.enterEmailId(string);
	}

	@Then("user enter phone number {string}")
	public void user_enter_phone_number(String string) {
		uralo.enterPhoneNumber(string);
	}

	@Then("user enter password {string}")
	public void user_enter_password(String string) throws InterruptedException {
		uralo.enterPassword(string);
		// Thread.sleep(2000);
		// js.executeScript("window.scrollBy(0,300)", "");
	}

	@Then("user check in term and condition aggrements")
	public void user_check_in_term_and_condition_aggrements() {
		uralo.checkInTermAndCondition();

	}

	@Then("user click on SIGN UP button")
	public void user_click_on_sign_up_button() {
		uralo.clickonSignUpButton();
	}

	@Then("user enter verification code")
	public void user_enter_verification_code() throws InterruptedException {
		Thread.sleep(7000);
		uralo.getVerifyText();
	}

	@Then("click on Submit button")
	public void click_on_submit_button() throws InterruptedException {
		Thread.sleep(3000);
		uralo.clickonSubmitButton();
	}

	// scenario:2

	@Then("user click on SIGN IN form")
	public void user_click_on_sign_in_form() {
		uralo.clickonSignInForm();
	}

	@Then("user enter Email for login {string}")
	public void user_enter_email_for_login(String string) throws InterruptedException {
		uralo.enterEmailIdInLogInForm(string);
		Thread.sleep(2000);
	}

	@Then("user enter Password for login {string}")
	public void user_enter_password_for_login(String string) throws InterruptedException {
		uralo.enterPasswordInLogInForm(string);
		Thread.sleep(2000);
	}

	@Then("user click on SIGN IN button")
	public void user_click_on_sign_in_button() {
		uralo.clickonSignInButton();
	}

	@Then("user check the password")
	public void user_check_the_password() throws InterruptedException {
		Thread.sleep(2000);
		uralo.checkUserCredential();

	}

	@Then("user should be see his\\/her email id in login text place.")
	public void user_should_be_see_his_her_email_id_in_login_text_place() {
		 
			//uralo.checkUserName(verifyEmail);
		//update
		uralo.checkUserName(utility.getEmailId());
	}

	@Then("user click on Logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		Thread.sleep(2000);
		uralo.clickonLogoutbutton();

	}
	
	
	//scenario:3
	@Then("user click on forget password link")
	public void user_click_on_forget_password_link() {
	    uralo.clickOnForgetPassword();
	}

	@Then("user should enter login email id for receive recovery code {string}")
	public void user_should_enter_login_email_id_for_receive_recovery_code(String string) {
	    uralo.enterRecoveryEmail(string);
	}

	@Then("user click on Submit button in forget password")
	public void user_click_on_submit_button_in_forget_password() throws InterruptedException {
	   uralo.clickOnSubmitButtonInRecover();
	   Thread.sleep(5000);
	}

	@Then("user enter recovery code")
	public void user_enter_recovery_code() throws InterruptedException {
		uralo.enterCode();
		Thread.sleep(4000);
	}

	@Then("user click on Submit button in recovery account")
	public void user_click_on_submit_button_in_recovery_account() throws InterruptedException {
		
	    uralo.clickOnCodeSubmitButton();
	}

	@Then("user enter new password {string}")
	public void user_enter_new_password(String string) {
	   uralo.enterNewPassword(string);
	}

	@Then("user click on new password button")
	public void user_click_on_new_password_button() {
	 uralo.clickOnNewPasswordButton();   
	}

	
	
	

	@AfterAll
	public static void tearDown() {
		driver.close();
	}

	@AfterStep
	public void takeScreenShot(Scenario scenario) {
		addscreenShot(scenario);
	}

}
