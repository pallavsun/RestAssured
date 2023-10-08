package Day8;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test
	void test_updateUser(ITestContext context)
	{


		
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().firstName());
		data.put("gender","Male");
		data.put("email",faker.internet().emailAddress());
		data.put("Status","active");
		
		String bearerToken="3f1e849a0ae6ecc3f0fe9e6194f27cae959c0bbfe0f18aee0b44ede130da466c";
		
		int id=(Integer)context.getAttribute("user_id");;    // this should come from Create user Response
		
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.pathParam("id",id)
		.body(data.toString())
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
			
		
	}
	
}
