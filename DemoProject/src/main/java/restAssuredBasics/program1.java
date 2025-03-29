package restAssuredBasics;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class program1 {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://conduit.bondaracademy.com/api/";

	/*	String response = given().log().all()
				.body(" {\"user\":{\"email\":\"karatetest123@gmail.com\",\"password\":\"karate1234\"}}")
				.when().post("users/login")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		
		JsonPath js =new JsonPath(response);
		System.out.println(js.getString("token"));
		*/
		
		String getResponse = given().log().all().when().get("tags").then().statusCode(200).extract().response().asPrettyString();
		System.out.println(getResponse);
	}

}
