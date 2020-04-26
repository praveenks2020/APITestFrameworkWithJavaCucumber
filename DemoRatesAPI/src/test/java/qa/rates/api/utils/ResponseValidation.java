package qa.rates.api.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResponseValidation {
 static boolean result;
 
 	//validate response for latest rates end point
	public static void responseLatestValidation(Response reponse) {
		int statusCode = reponse.getStatusCode();		
		if(statusCode==200) {
			result = reponse.then().contentType(ContentType.JSON).extract().body().jsonPath().getBoolean("success");
			if (result) {
				assertTrue(reponse.asString().contains("base"));
				assertTrue(reponse.asString().contains("rates"));
				assertTrue(reponse.asString().contains("date"));
				assertTrue(reponse.asString().contains("timestamp"));
			} else {
				assertTrue(reponse.asString().contains("error"));
				System.out.println("Server returned the error code: "+ errorCode(reponse));
			}
		} else {
			System.out.println("Request failed with status code: "+statusCode);
			assertFalse(true);
		}
	}
	
	//validate response for latest rates end point
	public static void responseHistoricValidation(Response reponse) {
		int statusCode = reponse.getStatusCode();		
		if(statusCode==200) {
			result = reponse.then().contentType(ContentType.JSON).extract().body().jsonPath().getBoolean("success");
			if (result) {
				assertTrue(reponse.asString().contains("base"));
				assertTrue(reponse.asString().contains("rates"));
				assertTrue(reponse.asString().contains("date"));
				assertTrue(reponse.asString().contains("timestamp"));
				assertTrue(reponse.asString().contains("historical"));
			} else {
				assertTrue(reponse.asString().contains("error"));
				System.out.println("Server returned the error code: "+ errorCode(reponse));
			}
		} else {
			System.out.println("Request failed with status code: "+statusCode);
			assertFalse(true);
		}
	}
	
	
	//Fetch error code returned with response 
	private static int errorCode(Response reponse) {
		int errorCode = (int) reponse.then()
				.contentType(ContentType.JSON)
				.extract().body()
				.jsonPath().getMap("error").get("code");
		return errorCode;
	}
}
