Feature: Foreign Exchange rates for Specific Date

Scenario: Successful Running of the Latest Exchange Rates for Specific Date API
	Given Rates API for Specific date Foreign Exchange rates
	When Specific Date API is available
	Then Assert success status of the Specific Date API response

Scenario: Successful Running of the Latest Exchange Rates for Specific Date API
	Given Rates API for Specific date Foreign Exchange rates
	When Specific Date API is available
	Then Assert the response of Specific Date API response
	
Scenario: A future date is provided in the url
	Given Rates API for Specific date Foreign Exchange rates
	When A future date is provided in the url
	Then validate that the response matches for the current date