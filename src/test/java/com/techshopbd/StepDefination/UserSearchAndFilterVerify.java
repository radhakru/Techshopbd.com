package com.techshopbd.StepDefination;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.techshopbd.utility.Utility;
import com.techshopbd.webobject.UserSearchAndFilterObject;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSearchAndFilterVerify extends Base {

	private WebDriver driver;
	private UserSearchAndFilterObject usafo;
	private Utility utility;
	private List<Map<String, String>> searchData;
	
	@Before
	public void setup() {
		driver = getDriver();
		usafo = new UserSearchAndFilterObject(driver);
		utility=getUtilityClass();
	}
	

	@When("user enter product name in search bar")
	public void user_enter_product_name_in_search_bar(DataTable dataTable) {
		/*
		 * driver = getDriver(); usafo = new UserSearchAndFilterObject(driver);
		 */		/* utility=getUtilityClass(); */
		searchData = dataTable.asMaps(String.class, String.class);
		System.out.println(searchData.size());
		for (int i = 0; i < searchData.size(); i++) {
			System.out.println(searchData.get(i).get("Product Name"));

			usafo.enterProductNameInSearchBar(searchData.get(i).get("Product Name"));
		}

	}

	@Then("user click on Search button")
	public void user_click_on_search_button() {
		usafo.clickOnSearchButton();
	}

	@Then("user should be able to see list of products")
	public void user_should_be_able_to_see_list_of_products() {
		usafo.getAllProduct();
	}

	@Then("user verify some product through the product name")
	public void user_verify_some_product_through_the_product_name() {
		Set<String> Key = searchData.get(0).keySet();
		System.out.println(Key.size());
		for (String key : Key) {
			System.out.println(key);
			usafo.verifyProduct(key);
		}
	}
	
	
	
	@Then("user click on Accessories")
	public void user_click_on_accessories() {
		usafo.selectCatagory(utility.getCatagory());
	    
	}

	@Then("click on Computer peripherial")
	public void click_on_computer_peripherial() {
	    usafo.selectSubCatagory(utility.getSubCatagory());
	}

	@Then("user should see all the product")
	public void user_should_see_all_the_product() {
		usafo.getAllProduct();
	    
	}

	@Then("user apply filter using sort by")
	public void user_apply_filter_using_sort_by() {
	    usafo.selectFilter(utility.getFilterPrice());
	}

	@Then("user can see there product price according to filter.")
	public void user_can_see_there_product_price_according_to_filter() {
	    usafo.getAllPrice();
	}

}
