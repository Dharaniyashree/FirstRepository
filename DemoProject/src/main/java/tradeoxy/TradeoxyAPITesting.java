package tradeoxy;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class TradeoxyAPITesting {
	
	@Test
	void HomeScreenRequestTest() {
		RestAssured.baseURI = "https://api2.amplitude.com/2/httpapi";
		String response = given().header("Content-Type", "application/json").log().all()
				.body("{\r\n"
						+ "    \"api_key\": \"1c1790ac958c8df7046d0e2e978280b\",\r\n"
						+ "    \"events\": [\r\n"
						+ "        {\r\n"
						+ "            \"device_id\": \"2929c9b1-611a-41ce-8b89-e120f48adc81\",\r\n"
						+ "            \"session_id\": 1732455649600,\r\n"
						+ "            \"time\": 1732455926942,\r\n"
						+ "            \"platform\": \"Web\",\r\n"
						+ "            \"language\": \"en-US\",\r\n"
						+ "            \"ip\": \"$remote\",\r\n"
						+ "            \"insert_id\": \"e3a5c26e-9e98-447b-bd44-4c297de57c28\",\r\n"
						+ "            \"event_type\": \"[Amplitude] Page Viewed\",\r\n"
						+ "            \"event_properties\": {\r\n"
						+ "                \"[Amplitude] Page Domain\": \"tradeoxy.com\",\r\n"
						+ "                \"[Amplitude] Page Location\": \"https://tradeoxy.com/\",\r\n"
						+ "                \"[Amplitude] Page Path\": \"/\",\r\n"
						+ "                \"[Amplitude] Page Title\": \"15 min Breakout\",\r\n"
						+ "                \"[Amplitude] Page URL\": \"https://tradeoxy.com/\"\r\n"
						+ "            },\r\n"
						+ "            \"event_id\": 116,\r\n"
						+ "            \"library\": \"amplitude-ts-gtm/3.7.1\",\r\n"
						+ "            \"user_agent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36 Edg/131.0.0.0\"\r\n"
						+ "        }\r\n"
						+ "    ],\r\n"
						+ "    \"options\": {}\r\n"
						+ "}")
				.when().post().then().log().all().assertThat().statusCode(200).extract().asString();
		JsonPath js =new JsonPath(response);
		assertTrue(js.get("code").equals(200));
	}
	
	
	@Test
	void MarketStatusTest() {
		RestAssured.baseURI = "https://api.tradeoxy.com/api/tradeoxy/marketstatus";
		given().header("Content-Type", "application/json").log().all()
				.when().get().then().log().all().assertThat().statusCode(200).extract().asString();

	}

}
