package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class Loggingdemo {

	
	
	@Test
	void testheaders()
	
	{
	given()
	
	.when()
	  .get("https://reqres.in/api/users?page=2")
	
	.then()
//	.log().body();    // print only body in console
//	.log().headers();  // print only headers in console
	
	.log().all();   //print everything in console
	
	
	}
}
