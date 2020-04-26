package qa.rates.api.steps;


import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qa.rates.api.utils.BaseLatestRates;
import qa.rates.api.utils.BaseUri;
import qa.rates.api.utils.ResponseValidation;

public class LatestExchangeRates extends BaseLatestRates{
	boolean result;
	int statusCode;
	RequestSpecification requestSpec;
	Response response;
	
	@Given("Rates API for Latest Foreign Exchange")
	public void rates_API_for_Latest_Foreign_Exchange_rates() throws IOException {
		requestSpec = BaseUri.setBaseUri();
	}

	@When("This API is available")
	public void this_API_is_available() {
		response = setPath(requestSpec);
	}
	
	@When("This API is available with invalid path")
	public void this_API_is_available_with_invalid_path() {		
		response = setPathInvalid(requestSpec);
	}
	
	@When("^This API is available for base \"([^\"]*)\"$")
	public void this_API_is_available_for_base (String base) {
		response = setQueryParamsForLatest(requestSpec,"base", base);
	}
	
	@When("^This API is available for symbols \"([^\"]*)\"$")
	public void this_API_is_available_for_symbols (String symbols) {
		response = setQueryParamsForLatest(requestSpec,"symbols",symbols);
	}

	@When("^This API is available for base \"([^\"]*)\" and symbols \"([^\"]*)\"$")
	public void this_API_is_available_for_base_and_symbols (String base, String symbols) {
		response = setAllQueryParamsForLatest(requestSpec,base,symbols);
	}
	
	@Then("Verify the response")
	public void assert_the_status_code() {
		ResponseValidation.responseLatestValidation(response);
	}
	
	@Then("Assert the status code {int}")
	public void assert_the_status_code(int responseCode) {
		ResponseValidation.responseLatestValidation(response);
	}
	
	@Then("^Assert the response for latest$")
	public void assert_the_response_for_latest () {		           
		ResponseValidation.responseLatestValidation(response);
	}
	
}
