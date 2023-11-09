package com.techshopbd.StepDefination;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.techshopbd.utility.Utility;
import com.techshopbd.webobject.ProductDetailsObject;
import com.techshopbd.webobject.UserSearchAndFilterObject;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsVerify extends Base {

	private WebDriver driver;
	private ProductDetailsObject pdo;
	private JavascriptExecutor js;
	private Utility utility;
	private UserSearchAndFilterObject usafo;
	Robot robot;

	@Before
	public void setUp() throws AWTException {
		driver = getDriver();
		pdo = new ProductDetailsObject(driver);
		usafo=new UserSearchAndFilterObject(driver);
		js = (JavascriptExecutor) driver;
		utility = getUtilityClass();
		//robot=new Robot();
		

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("user click on one product")
	public void user_click_on_one_product() throws InterruptedException {
		//js.executeScript("window.scrollBy(0,800)","");
		//robot.mouseWheel(-400);
		//Thread.sleep(5000);
		
		usafo.enterProductNameInSearchBar(utility.getSearch());
		usafo.clickOnSearchButton();
		pdo.clickOnOneProduct();
		
		
	}

	@Then("user can able to see product name and product price")
	public void user_can_able_to_see_product_name_and_product_price() {
		pdo.seeProductName();
		pdo.seeProductPrice();
	}

	@Then("user can able to see product image , product description")
	public void user_can_able_to_see_product_image_product_description() {
		js.executeScript("window.scrollBy(0,300)", "");
		pdo.seeProductImage();
		js.executeScript("window.scrollBy(0,700)", "");
		pdo.seeProductDes();
	}

	@Then("user can able to see product review box")
	public void user_can_able_to_see_product_review_box() {
		js.executeScript("window.scrollBy(0,500)", "");
		pdo.seeReview();
	}

}
