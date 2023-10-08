package Day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class DeleteUser {


	@Test
	void test_getUser(ITestContext context)
	{
		
		int id=(Integer)context.getAttribute("user_id");;    // this should come from Create user Response
		
		String bearerToken="3f1e849a0ae6ecc3f0fe9e6194f27cae959c0bbfe0f18aee0b44ede130da466c";
		
		
		given()
		 .headers("Authorization","Bearer "+bearerToken)
		 .pathParam("id",id)
		
		.when()
		 .delete("https://gorest.co.in/public/v2/users/{id}")
		
		
		.then()
		 .statusCode(204)
		 .log().all();
		 	
		
	}
}
