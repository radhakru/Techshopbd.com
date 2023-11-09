package com.techshopbd.webobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsObject {

	private WebDriver ldriver;
	private List<WebElement> productLinkList,productImages,productReview;
	private Actions actions;
	private JavascriptExecutor js;
	private WebDriverWait wait;
	
	
	private int i=0;
	
	
	public ProductDetailsObject(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	public WebDriver getDriver() {
		return this.ldriver;
	}
	/*
	 * //div[@class='item js--product-item']/a //div[@class='item
	 * js--product-item']/a/div[@class='card']/p[@class='product-name']
	 * ////div[@class='item js--product-item']/a/div[@class='card'] private By
	 * allProductLink=By.xpath("//p[@class='product-name']");
	 */
	
	
	private By listProduct = By.xpath("//div[@class='product-info']/p[1]");
	
	
	private By allImages=By.xpath("//div[@class='thumbnail']//div[@class='owl-stage']/div/img");
	
	
	private By productName=By.xpath("//div[@class='card details-section h-100']/h1");
	
	private By productPrice=By.xpath("//div[@class='card details-section h-100']/p[2]");
	
	
	private By description=By.xpath("//div[@id='summery']/div[@class='content-section']/p[11]");
	
	
	private By review=By.xpath("//div[@class='qa-list-wrapper']/div/div[2]/p/span/span[1]");
	
	
	//select only one link
	public void clickOnOneProduct() {
		actions=new Actions(ldriver);
		productLinkList=ldriver.findElements(listProduct);
		for(WebElement link:productLinkList) {
			link.click();
			break;
		}
		
	}
	
	//see product name
	public void seeProductName() {
		System.out.println(ldriver.findElement(productName).getText());
	}
	
	//see the product price 
	public void seeProductPrice() {
		ldriver.findElement(productPrice).getText();
	}
	
	//see all the image 
	public void seeProductImage() {
		productImages=ldriver.findElements(allImages);
		for(WebElement image:productImages) {
			System.out.println("Source image link="+image.getAttribute("src"));
			System.out.println("alt image link="+image.getAttribute("alt"));
		}
	}
	
	//see the product Description
	public void seeProductDes() {
		System.out.println(ldriver.findElement(description).getText());
	}
	
	
	//See all the review 
	public void seeReview() {
		productReview=ldriver.findElements(review);
		for(WebElement Review: productReview) {
			System.out.println(Review.getText());
		}
	}
	
	
	
	
}
