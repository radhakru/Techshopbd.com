package com.techshopbd.webobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserSearchAndFilterObject {

	private WebDriver ldriver;
	private List<WebElement> productList;
	private List<WebElement> productCatagory;
	private List<WebElement> subCatagory;
	private List<WebElement> productPrice;
	private Actions actions;
	private int count = 0;
	private Select select;

	public UserSearchAndFilterObject(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public WebDriver getDriver() {
		return this.ldriver;
	}

	// search bar locator
	private By searchBar = By.id("js--search-option");

	// search button locator
	private By searchButton = By.id("go-to-search-page");

	// list of all products locator
	private By listProduct = By.xpath("//div[@class='product-info']/p[1]");

	private By listCatagory = By.xpath("//ul[@class='category-list']/li/a");

	private By selectedSubCatagory = By.xpath("//div[@class='dropdown-menu d-block']/a");
	
	//all product price
	private By allproductPrice=By.xpath("//div[@class='product-info']/div/p[1]"); 
	
	private By filterPrice=By.xpath("//select[@id='browse-filter']");
	

	public void enterProductNameInSearchBar(String productname) {
		actions = new Actions(ldriver);
		WebElement searchbar = ldriver.findElement(searchBar);
		actions.moveToElement(searchbar).click().sendKeys(productname).build().perform();
	}

	public void clickOnSearchButton() {
		WebElement searchbutton = ldriver.findElement(searchButton);
		actions.moveToElement(searchbutton).click().build().perform();
	}

	public void getAllProduct() {
		productList = ldriver.findElements(listProduct);
		for (WebElement product : productList) {
			System.out.println(product.getText());
		}
	}

	// verify product for first 3 product name which is present in productList.
	public void verifyProduct(String productname) {
		while (count < 3) {
			if (productList.get(count).getText().contains(productname)) {
				Assert.assertTrue(true);
			}
			count++;
		}
	}

	public void selectCatagory(String Catagory) {
		actions=new Actions(ldriver);
		productCatagory = ldriver.findElements(listCatagory);
		for (WebElement catagory : productCatagory) {
			if (catagory.getText().equalsIgnoreCase(Catagory)) {
				actions.moveToElement(catagory).build().perform();
				break;
			}
		}

	}

	public void selectSubCatagory(String subcatagorypro) {
		subCatagory = ldriver.findElements(selectedSubCatagory);
		for (WebElement subcatagory : subCatagory) {
			if (subcatagory.getText().equals(subcatagorypro)) {
				actions.moveToElement(subcatagory).click().build().perform();
				break;
			}
		}
	}
	
	public void selectFilter(String filterName) {
		ldriver.findElement(filterPrice).click();
		select=new Select(ldriver.findElement(filterPrice));
		select.selectByVisibleText(filterName);
	}
	
	public void getAllPrice() {
		productPrice=ldriver.findElements(allproductPrice);
		for(WebElement price:productPrice) {
			System.out.println(price.getText());
		}
	}
	
	
	

}
