package qa.rates.api.utils;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseLatestRates extends SetBaseURIAndPath{
	
	private static String api_key;
	private static String path;
	private static Response response;
	
	public BaseLatestRates() {
		super();
		path = prop.getProperty("pathLatest");
		api_key = prop.getProperty("access_key");
	}
	
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
	
	public static Response setParametersForLatestWithAccessKey(RequestSpecification request,String baseOrSymbols, String queryParameter) {
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
	
	public static Response setParametersForLatestBaseOrSymbol(RequestSpecification request, String baseOrSymbols, String queryParameter) {
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
	
	public static Response setAllQueryParametersForLatestWithAccessKey(RequestSpecification request, String base, String symbols) {
		api_key = prop.getProperty("access_key");
		response = request.when()
					.queryParam("access_key", api_key)
					.queryParam("base", base)
					.queryParam("symbols", symbols)
					.get(path);
		return response;
	}
		
	public static Response setAllQueryParametersForLatest(RequestSpecification request, String base, String symbols) {
			response = request.when()
						.queryParam("base", base)
						.queryParam("symbols", symbols)
						.get(path);
			return response;
	}
		
}

