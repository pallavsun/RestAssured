package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;



public class Headersdemo {
	@Test
	void testheaders()
	
	{
	given()
	
	.when()
	  .get("https://www.google.com/")
	
	.then()
	.header("Content-Type","text/html; charset=ISO-8859-1")
	.header("Content-Encoding","gzip");
	
	}
	
	
   @Test
	void getheaders()
	{
		
	   
	  Response res= given()
		
		.when()
		.get("https://www.google.com/");
	  
	// get single header info
	  String headervalue=res.getHeader("Content-Type");
	  System.out.println("Value of Content tyope header is "+headervalue);
	   
  //  get all headers info 
	  Headers myheaders=res.getHeaders();
	  
	 for(Header hd:myheaders)
	 {
		 
		System.out.println(hd.getName()+"  "+hd.getValue()); 
	 }
	  
	}
	
	
	
	
	
}
