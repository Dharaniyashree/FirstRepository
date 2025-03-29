package restAssuredBasics;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SchemaValidationTest {

    @Test
    public void validateJsonSchema() {
        Response response = RestAssured
            .given()
            .baseUri("https://api.example.com")
            .when()
            .get("/users/1")
            .then()
            .assertThat()
            .body(matchesJsonSchemaInClasspath("schemaTest.json"))
            .extract()
            .response();

        assertEquals(200, response.statusCode());
    }
}
