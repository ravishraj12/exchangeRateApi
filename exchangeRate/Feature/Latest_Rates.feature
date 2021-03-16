Feature: Latest Foreign Exchange rates

Scenario: Successful Running of the Latest Exchange Rates API
	Given Rates API for Latest Foreign Exchange rates
	When Latest Rates API is available
	Then Assert success status of the Latest Rates API response

Scenario: Successful Running of the Latest Exchange Rates API
	Given Rates API for Latest Foreign Exchange rates
	When Latest Rates API is available
	Then Assert the response of Latest Rates API
	
Scenario: An incorrect or incomplete url is provided
	Given Rates API for Latest Foreign Exchange rates
	When An incorrect or incomplete url is provided
	Then Assert the correct response supplied by the call

