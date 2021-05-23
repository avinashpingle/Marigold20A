Feature: This is first feature to understand working of cucumber

Scenario Outline:
	Given I have numbers from <rowNum> row
	When I add both numbers
	Then check whetehr the addition is even
	Examples:
	|rowNum|
	|1|
	|2|
	|3|
	|4|
	|5|
	|6|

	