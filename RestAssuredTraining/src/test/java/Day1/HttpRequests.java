package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequests {
	
	int id;
	
	@Test(priority=1)
	void getUser()
	{
	 given()
	 
	 .when()
	   .get("https://reqres.in/api/users?page=2")
	 
	 .then()
	 .statusCode(200)
	 .body("page",equalTo(2))
	 .log().all();
		
	}
	
	@Test(priority = 2)
	void createUser()
	{
		// Create body of our API
		HashMap data=new HashMap();
		data.put("name","Ram");
		data.put("job","");
		
	      id=given()
		   .contentType("application/json")
		   .body(data)      // sending data 
		 
		 .when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id");
		   
		 
	//	 .then()
	//	   .statusCode(201)
	//	   .log().all();
		 
		
	}
	
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser()
	{
		// Create body of our API
		HashMap data=new HashMap();
		data.put("name","Sumit");
		data.put("job","Business");

		   given()
			.contentType("application/json")
			.body(data)      // sending data 

			.when()
			.put("https://reqres.in/api/users/"+id)
		   
		
		.then()
	    .statusCode(200)
		.log().all();
	
	}
	
	@Test(priority = 4)
	  void deleteUser()
	  {
		 
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204);
	  }
	
	
	
	

}
