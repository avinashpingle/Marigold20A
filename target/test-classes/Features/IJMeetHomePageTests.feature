Feature: This feature describes positive and negative scnearios of homepage of ijmeet

Background:
	Given "Chrome" browser is opened
	And Application url is launced
@DoNotRun
Scenario: Verify title of homepage. Title should be IJmeet
	Given Title is stored in veriable
	Then check that title is equals to "IJmeet"

Scenario: Verify that length of contact number must be minimum 8 chars
	Given Signup page is opened
	Then Enter Fullname as "Avinash Pingale"
	And Enter company name as "Testing Shastra"
	And Enter email id as "Random"
	And Enter mobile number as "1234"
	And Enter password as "ABC@12343453"
	When User clicks on Signup button
	Then Verify that user is getting error for length of contact number