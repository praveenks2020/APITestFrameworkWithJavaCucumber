package qa.rates.api.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseHistoricRates extends SetBaseURIAndPath{
	private static String api_key;
	private static String path;
	private static Response response;
	
	public BaseHistoricRates() {
		super();
		path = prop.getProperty("pathHistoric");
		api_key = prop.getProperty("access_key");
	}
	
	public static Response setPath(RequestSpecification request, String historicDate) {
		api_key = prop.getProperty("access_key");
		response = request.pathParam("historic", historicDate)
				.when().queryParam("access_key", api_key)
				.get(path);
		return response;
	}
	
	public static Response setParametersForHistoricWithAccessKey(RequestSpecification request,String baseOrSymbols, String historic, String queryParameter) {
		api_key = prop.getProperty("access_key");
		switch (baseOrSymbols.toLowerCase()) {
		case "base" :
			response = request.pathParam("historic", historic)
					.when().queryParam("access_key", api_key)
					.queryParam("base", queryParameter).get(path);
			break;
		case "symbols" :
			response = request.pathParam("historic", historic)
				.when().queryParam("access_key", api_key)
				.queryParam("symbols", queryParameter).get(path);
			break;
		}
		return response;
	}
	
	public static Response setParamForHistoric(RequestSpecification request, String baseOrSymbols, String historic, String queryParameter) {
		switch (baseOrSymbols.toLowerCase()) {
		case "base" :
			response = request.pathParam("historic", historic).when().queryParam("base", queryParameter).get(path);
			break;
		case "symbols" :
			response = request.pathParam("historic", historic).when().queryParam("symbols", queryParameter).get(path);
			break;
		}
		return response;
	}
	
	public static Response setAllQueryParamsForHistoricWithAccessKey(RequestSpecification request, String historic, String base, String symbols) {
		api_key = prop.getProperty("access_key");
		response = request.pathParam("historic", historic).when()
					.queryParam("access_key", api_key)
					.queryParam("base", base)
					.queryParam("symbols", symbols)
					.get(path);
		return response;
	}
		
	public static Response setAllQueryParamsForHistoric(RequestSpecification request, String historic, String base, String symbols) {
			response = request.pathParam("historic", historic).when()
						.queryParam("base", base)
						.queryParam("symbols", symbols)
						.get(path);
			return response;
	}
}
