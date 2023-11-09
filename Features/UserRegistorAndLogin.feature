Feature: User Registation and Login

@Regisation
Scenario Outline: User should be register successfull 
Given user go to the url
When user click on Login button
Then user can see SIGN IN and SIGN UP form
Then user click on SIGN UP form
Then user enter fullname "<FullName>"
Then user enter email id "<EmailId>"
Then user enter phone number "<phone number>"
Then user enter password "<password>"
Then user check in term and condition aggrements
Then user click on SIGN UP button
Then user enter verification code 
Then click on Submit button




Examples:
|FullName|EmailId|phone number|password|
|Ram|sradhakrushna.45@gmail.com|988668079|Ra@123489|




@Signin
Scenario Outline: User should be verify there profile
Given user go to the url
When user click on Login button
Then user click on SIGN IN form
Then user enter Email for login "<Email Id>"
Then user enter Password for login "<Password>"
Then user click on SIGN IN button
Then user check the password
Then user should be see his/her email id in login text place.
Then user click on Logout button 


Examples:
|Email Id|Password|
|sradhakrushna.45@gmail.com|Ra@12349|
|sradhakrushna.45@gmail.com|Ra@123489|
|sradhakrushna.45@gmail.com|Ra@12345|
|radhakrushnasatapathy7461@gmail.com|Ram~10978@|


@Forget
Scenario Outline: User should use forget password
Given user go to the url
When user click on Login button
Then user click on forget password link
Then user should enter login email id for receive recovery code "<Email Id>"
Then user click on Submit button in forget password
Then user enter recovery code 
Then user click on Submit button in recovery account
Then user enter new password "<new password>"  
Then user click on new password button  


Examples:
|Email Id|new password|
|radhakrushnasatapathy7461@gmail.com|Ram~10978@|

