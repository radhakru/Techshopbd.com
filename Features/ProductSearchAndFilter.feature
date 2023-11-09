Feature: User Search and Filltering product

Background: 
Given user go to the url

Scenario: User should be able to search product 
##Given user go to the url
When user enter product name in search bar
|Product Name|
##|cable|
|Buzzer| 
Then user click on Search button
Then user should be able to see list of products
Then user verify some product through the product name
    
@Filter    
Scenario: User should be able to use filter
##Given user go to the url
Then user click on Accessories 
Then click on Computer peripherial
Then user should see all the product
Then user apply filter using sort by
Then user can see there product price according to filter.
     