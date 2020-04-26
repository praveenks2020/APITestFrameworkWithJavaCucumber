package qa.rates.api.utils;

import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;

public class BaseUri extends GetProperties {

	private static String baseURI;
	private static RequestSpecification request;
	
	public BaseUri() {
		super();
	}
	
	//method to set baseUri for request
	public static RequestSpecification setBaseUri() {
		baseURI = prop.getProperty("baseURI");
		request = given().baseUri(baseURI);
		return request;
	}
		
	
}