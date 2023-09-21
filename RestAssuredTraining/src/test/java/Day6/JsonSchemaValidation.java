package Day6;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//  Tool for concert json---jsonschema
// https://jsonformatter.org/json-to-jsonschema

public class JsonSchemaValidation {

	@Test
	void jsonschemavalidation()
	{
		
		given()
		
		.when()
		  .get("http://localhost:3000/store")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storejsonschema.json"));   // For Schema Validation
		
	}
	
}
