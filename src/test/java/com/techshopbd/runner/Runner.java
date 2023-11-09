package com.techshopbd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={//"./Features/UserRegistorAndLogin.feature"
				
				//"./Features/ProductSearchAndFilter.feature"
				"./Features/ProductDetails.feature"
		},
		glue={"com/techshopbd/StepDefination"},
		dryRun=false,
		monochrome=true,
		//tags="@Signin",
		//publish=true
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				
		)

public class Runner {

}
