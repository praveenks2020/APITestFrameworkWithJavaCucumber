package qa.rates.api.utils;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class BaseLatestRates extends GetProperties {
	
	//private static String api_key;
	private static String path;
	private static String pathInvalid;
	private static Response response;
	
	public BaseLatestRates() {
		super();
		path = prop.getProperty("pathLatest");
		pathInvalid = prop.getProperty("pathInvalid");
		//api_key = prop.getProperty("access_key");
	}

	//to get Response for all rates for latest 
	public static Response setPath(RequestSpecification request) {
		response = request.when().get(path);
		return response;
	}
	
	//to get Response with invalid path
	public static Response setPathInvalid(RequestSpecification request) {
		response = request.when().get(pathInvalid);
		return response;
	}
	
	//to get Response for latest for given base or symbols
	public static Response setQueryParamsForLatest(RequestSpecification request, String baseOrSymbols, String queryParameter) {
		switch (baseOrSymbols.toLowerCase()) {
		case "base" :
			response = request.when().queryParam("base", queryParameter).get(path);
			break;
		case "symbols" :
			response = request.when().queryParam("symbols", queryParameter).get(path);
			break;
		}
		return response;
	}
			
	//to get response for latest with given base and symbols
	public static Response setAllQueryParamsForLatest(RequestSpecification request, String base, String symbols) {
		response = request.when()
					.queryParam("base", base)
					.queryParam("symbols", symbols)
					.get(path);
		return response;
	}

	
	/*
	 * Methods to execute with access_key
	 * 
	public static Response setPath(RequestSpecification request) {
		api_key = prop.getProperty("access_key");
		response = request.when().queryParam("access_key", api_key).get(path);
		return response;
	}
	
	public static Response setPathInvalid(RequestSpecification request) {
		api_key = prop.getProperty("access_key");
		path = prop.getProperty("pathInvalid");
		response = request.when().queryParam("access_key", api_key).get(path);
		return response;
	}
	
	public static Response setQueryParamsForLatest(RequestSpecification request,String baseOrSymbols, String queryParameter) {
		api_key = prop.getProperty("access_key");
		switch (baseOrSymbols) {
		case "base" :
			response = request.when().queryParam("access_key", api_key).queryParam("base", queryParameter).get(path);
			break;
		case "symbols" :
			response = request.when().queryParam("access_key", api_key).queryParam("symbols", queryParameter).get(path);
			break;
		}
		return response;
	}
	
	public static Response setAllQueryParamsForLatest(RequestSpecification request, String base, String symbols) {
		api_key = prop.getProperty("access_key");
		response = request.when()
					.queryParam("access_key", api_key)
					.queryParam("base", base)
					.queryParam("symbols", symbols)
					.get(path);
		return response;
	}*/
}

