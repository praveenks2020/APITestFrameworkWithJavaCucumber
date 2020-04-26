package qa.rates.api.utils;

import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;

public class SetBaseURIAndPath extends GetProperties {

	private static String baseURI;
	private static RequestSpecification request;
	
	public SetBaseURIAndPath() {
		super();
	}
	public static RequestSpecification setPathParameters() {
		baseURI = prop.getProperty("baseURI");
		request = given().baseUri(baseURI);
		return request;
	}
		
	/*public static String setPath(String pathURI) {
		switch (pathURI.toLowerCase()) {
		case "latest" :
			path = prop.getProperty("pathLatest");
			break;
		case "historic" :
			path = prop.getProperty("pathHistoric");;
			break;
		}
		return path;
	}*/
	
}