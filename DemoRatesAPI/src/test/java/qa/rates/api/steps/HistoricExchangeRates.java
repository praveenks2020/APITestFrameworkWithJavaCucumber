package qa.rates.api.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qa.rates.api.utils.BaseHistoricRates;
import qa.rates.api.utils.BaseUri;
import qa.rates.api.utils.ResponseValidation;

public class HistoricExchangeRates extends BaseHistoricRates{
	
	boolean result;
	int statusCode;
	RequestSpecification requestSpec;
	Response response;
	String api_key;
	
	@Given("^Rates API for Historic Foreign Exchange$")
	public void rates_API_for_Latest_Foreign_Exchange_rates() {
		requestSpec = BaseUri.setBaseUri();	
	}

	@When("^This API is available for historic date \"([^\"]*)\"$")
	public void this_API_is_available_for_date(String historic) {		
		response = setPath(requestSpec,historic);	
	}

	@When("^This API is available for date \"([^\"]*)\" and base \"([^\"]*)\"$")
	public void this_API_is_available_for_date_and_base(String historic, String base) {		
			response = setParamForHistoric(requestSpec,"base",historic,base);	
	}
	
	@When("^This API is available for date \"([^\"]*)\" and symbols \"([^\"]*)\"$")
	public void this_API_is_available_for_date_and_symbols(String historic, String symbols) {		
		response = setParamForHistoric(requestSpec,"symbols",historic,symbols);
	}
	
	@When("^This API is available for date \"([^\"]*)\" and base \"([^\"]*)\" and symbols \"([^\"]*)\"$")
	public void this_API_is_available_for_date_and_symbols(String historic, String base, String symbols) {		
		response = setAllParamsForHistoric(requestSpec,historic,base,symbols);	
	}
	
	@Then("^Assert the response for historic$")
	public void assert_the_response () {		           
			ResponseValidation.responseHistoricValidation(response);
	}
}

