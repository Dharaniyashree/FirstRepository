package restAssuredBasics;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AddBook {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().header("Content-Type", "application/json").log().all()
				.body("{\r\n"
						+ "		\"name\":\"learn\",\r\n"
						+ "		\"isbn\":\"bplqw\",\r\n"
						+ "		\"asile\":\"1211\",\r\n"
						+ "		\"author\":\"Jon\"\r\n"
						+ "	}")
				.when().post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().asString();
		
	//	JsonPath js = new JsonPath(response);
		//String id = js.getString("ID");
		//System.out.println(id);
		
		
		/*
		 	RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given().log().all()
						 .queryParam("key","qaclick123")
						 .header("Content-Type","application/json")
						 .body("{\r\n"
						 		+ "	\"location\":{\r\n"
						 		+ "		\"lat\": 000,\r\n"
						 		+ "		\"lng\":121\r\n"
						 		+ "		},\r\n"
						 		+ "	\"accuracy\": 2,\r\n"
						 		+ "	\"name\": \"Abc\",\r\n"
						 		+ "	\"phone_number\": \"11231211\",\r\n"
						 		+ "	\"address\": \"2,qwea21\",\r\n"
						 		+ "	\"types\":[\"shoe park\",\"shop\"],\r\n"
						 		+ "	\"website\":\"https://rahulshetty.com\",\r\n"
						 		+ "	\"language\": \"English\"\r\n"
						 		+ "	}\r\n")
						 .when().post("maps/api/place/add/json")
						 .then().log().all()
						 .assertThat().statusCode(200)
						 .body("scope", equalTo("APP"))
						 .header("Server","Apache/2.4.52 (Ubuntu)")
						 .extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		System.out.println(js.getString("place_id"));
		 * */
		
		RequestSpecification req = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("").addQueryParam("key", "").build();
		
		ResponseSpecification res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		given().spec(req).body("").post().then().spec(res).extract().asString();
		}
	
}