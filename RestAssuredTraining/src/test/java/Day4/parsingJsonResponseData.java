package Day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class parsingJsonResponseData {

//	@Test
	void testJsonResponse()
	{
		
//==============Approach 1&2 (Both are used to Verify Json response) ======================	

 /*
		given()
		.contentType(ContentType.JSON)
		
		.when()
		.get(" http://localhost:3000/store")
		
		
		.then()
		.statusCode(200)
		.header("Content-Type","application/json; charset=utf-8")
		.body("book[3].title",equalTo("The Lord of the Rings"));   // By this way we can validate the title but if the indexing of title 
		// will change then it will not work then follow Method 2( testJsonResponseBodyData())
		
		
// We can use conditional statement(if else) in .then() part		
	*/
		
//======================Approach 2========================
		
		Response res=given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		
		String bookname=res.jsonPath().get("book[3].title").toString();        // Convert Object in to String
		Assert.assertEquals(bookname,"The Lord of the Rings");
			
				
	}
	
	
	@Test(priority = 2)
	void testJsonResponseBodyData()
	{
	
		Response res=given()
		.contentType(ContentType.JSON)
		
		.when()
		.get("http://localhost:3000/store");
		
		JSONObject jo= new JSONObject(res.asString());      //JSONObject Class
		
		boolean status=false;
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			if(bookTitle.equals("The Lord of the Rings"))
		{
			System.out.println(bookTitle);
			status=true;
			break;
		}
			
			}
		
		Assert.assertEquals(status,true);
		
  // ============Validate Total price of books======================
		
		double totalprice=0;
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			totalprice=totalprice+Double.parseDouble(price);
			
		}	
		
		System.out.println("Total price of books is :"+totalprice);
		Assert.assertEquals(totalprice,526);
		
	}
	
	
		
	
}
