package Day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authentication {

	@Test(priority=1)
	void testBasicAuthentication()
	{
		
		given()
		  .auth().basic("postman","password")
		  
		  .when()
		  .get("https://postman-echo.com/basic-auth")
		  
		  .then()
		    .statusCode(200)
		    .body("authenticated",equalTo(true))
		    .log().all();
		
	}
	
	@Test(priority=2)
	void testDigestAuthentication()
	{
		
		given()
		  .auth().digest("postman","password")
		  
		  .when()
		  .get("https://postman-echo.com/basic-auth")
		  
		  .then()
		    .statusCode(200)
		    .body("authenticated",equalTo(true))
		    .log().all();
		
		
	}
	

	@Test(priority=3)
	void testPreemptiveAuthentication()
	{
		
		given()
		  .auth().preemptive().basic("postman","password")
		  
		  .when()
		  .get("https://postman-echo.com/basic-auth")
		  
		  .then()
		    .statusCode(200)
		    .body("authenticated",equalTo(true))
		    .log().all();
			
	}
	
	@Test(priority=4)
	void testBearerTokenAuthentication()
	{
		
		String bearerToken="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";
		
		 given()
		.headers("Authorization","Bearer "+bearerToken)
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		 .statusCode(200)
		 .log().all();
	}
	
	//@Test(priority=5)
	void testOAuthTokenAuthentication()
	{
		
	
		 given()
		.auth().oauth2("token value")
		
		.when()
		.get("url")
		
		.then()
		 .statusCode(200)
		 .log().all();
	}
	
	 @Test(priority=5)
		void testAPIKeyAuthentication()
		{
		  // Method 1
		 /*
			 given()
			.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")   //appid is apikey
			
			.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&cnt=1")
			
			.then()
			 .statusCode(200)
			 .log().all();
			 
		*/
		 
		// Method 2
		 given()
			.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")   //appid is apikey
			
			.pathParam("mypath","data/2.5/forecast/daily")
			.queryParam("q","Delhi")
			.queryParam("cnt","1")
			
			.when()
			 .get("https://api.openweathermap.org/{mypath}")

			
			.then()
			 .statusCode(200)
			 .log().all();
		  
		 
		}
		
	
	
	
	
}
