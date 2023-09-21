package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {

//	@Test(priority = 1)
	void testCookies()
	{
		given()
		 
		 .when()
		   .get("https://www.google.com/")
		 
		 .then()
		 .cookie("AEC","Ad49MVGnv1cCdIOgT_02BrWIt45tX4ajiX_1HgrsOKGYbrV46eMXNKtc_A")
		 .log().all();
		
			
	}
	

	@Test(priority = 2)
	void getCookiesInfo()
	{
		Response res= given()    // when we store entire response in res varaible then we can not use .then() after when()
		 
		 .when()
		   .get("https://www.google.com/");
		
  // get single cookie info
		String cookie_value=res.getCookie("AEC");     // i-e AEC is key
		System.out.println("Value of Cookie is "+cookie_value);     // get the value of AEC key
		 
		 
  // get all cookie inform
		
		Map<String, String>cookies_value=res.getCookies();
	//	System.out.println(cookies_value.keySet());    //return the all the key
		
		for(String K:cookies_value.keySet())
		{
			String cookie_value1=res.getCookie(K);
			System.out.println(K+"   "+cookie_value1);
			
		}
		
		
	}
	
}
