package Day2;
/*  Differnt ways to create Post Request Body
 * 1-Using HashMap
 * 2-using Org.json
 * 3-Using POJO Class
 * 4-Using External Json data file
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import io.restassured.internal.support.FileReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DifferntWaysToCreatePostRequestBody {

// 1->Post Request body using HashMap
	
// Add the student record	
//	@Test(priority=1)
	void testPostusingHashMap()
	{
		HashMap data=new HashMap();
		data.put("name","Scott");
		data.put("location","France");
		data.put("phone","123456");
		
		String courseArray[]= {"C","C++"};
		data.put("courses",courseArray);
		
		
		given()
		 .contentType("application/json")
		 .body(data)
		 
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("location",equalTo("France"))
		.body("phone",equalTo("123456"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		
		.log().all();
		
	}
	
	
// 2-> Post Request body using Org.json Library	
	//@Test(priority=1)
	void testPostusingJsonLibrary()
	{
		JSONObject data=new JSONObject();
		
		data.put("name","Scott");
		data.put("location","France");
		data.put("phone","123456");
		
		String courseArray[]= {"C","C++"};
		data.put("courses",courseArray);
		
		
		given()
		 .contentType("application/json")
		 .body(data.toString())
		 
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("location",equalTo("France"))
		.body("phone",equalTo("123456"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		
		.log().all();
		
	}
	
 
//3->Post Request body using POJO class
	
	
//	@Test(priority=1)
		void testPostusingPOJO()
		{
			Pojo_PostRequest data=new Pojo_PostRequest();
			
			data.setName("Scott");
			data.setLocation("France");
			data.setPhone("123456");
			
			String courseArray[]= {"C","C++"};
			data.setCourses(courseArray);
		
			
			given()
			 .contentType("application/json")
			 .body(data)
			 
			.when()
			.post("http://localhost:3000/students")
			
			.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"))
			.body("phone",equalTo("123456"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			
			.log().all();
			
		}
	

//4->Post Request body using ExternalJsonFile
	
		@Test(priority=1)
			void testPostusingExternalJsonFile() throws FileNotFoundException
			{
				
			    File f= new File(".\\body.json");
			    
			    java.io.FileReader fr=new java.io.FileReader(f);
			    JSONTokener jt=new JSONTokener(fr);
				
			    JSONObject data=new JSONObject(jt);
				
				
				given()
				 .contentType("application/json")
				 .body(data.toString())
				 
				.when()
				.post("http://localhost:3000/students")
				
				.then()
				.statusCode(201)
				.body("name",equalTo("Scott"))
				.body("location",equalTo("France"))
				.body("phone",equalTo("123456"))
				.body("courses[0]",equalTo("C"))
				.body("courses[1]",equalTo("C++"))
				
				.log().all();
				
			}
	
		
		
		
	
	
  // delete the student record	
	@Test(priority = 2)
	void testdelete()
	{
		
		given()
		
		.when()
		.delete("http://localhost:3000/students/4")   
		
		.then()
		.statusCode(200);
		
		
		
	}
	
	

	
	
}
