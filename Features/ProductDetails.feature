Feature: Product Details Page

Background: 
Given user go to the url

Scenario: Product Details page verify
##Given user go to the url
When user click on one product
Then user can able to see product name and product price
Then user can able to see product image , product description
Then user can able to see product review box