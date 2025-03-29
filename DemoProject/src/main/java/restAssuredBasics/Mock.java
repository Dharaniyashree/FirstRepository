package restAssuredBasics;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class Mock {

	private WireMockServer wireMockServer;

	// @Before
	public void setUp() {
		wireMockServer = new WireMockServer(8080);
		wireMockServer.start();
	}
	
	//@After
	public void tearDown() {
		wireMockServer.stop();
	}
/*
	@Test
	public void testMockServer() {
		wireMockServer.stubFor(get(urlEqualTo("api/users"))
		.willReturn(Response()
				.withStatus(200)
				.withHeader("content-Type", "application/json").withBody("[{\"id\": 1, \"name\": \"John Doe\"}]")));

    Response response = given()
        .baseUri("http://localhost:8080")
        .when()
        .get("/api/users")
        .then()
        .extract()
        .response();

    assertEquals(200, response.statusCode());
    assertEquals("application/json", response.getHeader("Content-Type"));
    assertEquals("[{\"id\": 1, \"name\": \"John Doe\"}]", response.getBody().asString());
	}

	@Test
	public void verifyInteractions() {
	    wireMockServer.verify(getRequestedFor(urlEqualTo("/api/users")));
	}
*/
}
