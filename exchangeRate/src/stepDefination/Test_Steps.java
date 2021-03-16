package stepDefination;

import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_Steps {
	private static Response response;
	private String baseURI;
	private int statusCode;
	private String contentType;
	private String serverType;
	private String contentEncoding;
	private String bodyAsString;
	
	@Given("^Rates API for Latest Foreign Exchange rates$")
	public void rates_API_for_Latest_Foreign_Exchange_rates() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		baseURI = "https://api.ratesapi.io/api/latest";
		
	}

	@When("^Latest Rates API is available$")
	public void latest_Rates_API_is_available() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(baseURI);
		statusCode = response.getStatusCode();
		contentType = response.header("Content-Type");
		serverType = response.getHeader("Server");
		contentEncoding = response.header("Content-Encoding");
		bodyAsString = response.getBody().asString();
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getBody().asString());
	    
	}

	@Then("^Assert success status of the Latest Rates API response$")
	public void assert_success_status_of_the_Latest_Rates_API_response() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
//		System.out.println(statusCode);
//		System.out.println(response.getBody().asString());
		
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	    
	}

	@Then("^Assert the response of Latest Rates API$")
	public void assert_the_response_of_Latest_Rates_API() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//		 Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
//		 Assert.assertEquals(serverType /* actual value */, "cloudflare" /* expected value */);
//		 Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
		 Assert.assertEquals(bodyAsString.contains("EUR"), true);
	}

	@When("^An incorrect or incomplete url is provided$")
	public void an_incorrect_or_incomplete_url_is_provided() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		baseURI = "https://api.ratesapi.io/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(baseURI);
		bodyAsString = response.getBody().asString();
	    
	}

	@Then("^Assert the correct response supplied by the call$")
	public void assert_the_correct_response_supplied_by_the_call() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(bodyAsString.contains("does not match format"), true);
	}

	@Given("^Rates API for Specific date Foreign Exchange rates$")
	public void rates_API_for_Specific_date_Foreign_Exchange_rates() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		baseURI = "https://api.ratesapi.io/api/2010-01-12";	
		
	}

	@When("^Specific Date API is available$")
	public void specific_Date_API_is_available() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(baseURI);
		statusCode = response.getStatusCode();
		contentType = response.header("Content-Type");
		serverType = response.getHeader("Server");
		contentEncoding = response.header("Content-Encoding");
		bodyAsString = response.getBody().asString();
	}

	@Then("^Assert success status of the Specific Date API response$")
	public void assert_success_status_of_the_Specific_Date_API_response() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}

	@Then("^Assert the response of Specific Date API response$")
	public void assert_the_response_of_Specific_Date_API_response() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 Assert.assertEquals(serverType /* actual value */, "cloudflare" /* expected value */);
		 Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
		 Assert.assertEquals(bodyAsString.contains("EUR"), true);
	}

	@When("^A future date is provided in the url$")
	public void a_future_date_is_provided_in_the_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		baseURI = "https://api.ratesapi.io/api/2022-01-12";
	}

	@Then("^validate that the response matches for the current date$")
	public void validate_that_the_response_matches_for_the_current_date() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(baseURI);
		bodyAsString = response.getBody().asString();
		Assert.assertEquals(bodyAsString.contains("2021-03-12"), true);
	}
	
}
