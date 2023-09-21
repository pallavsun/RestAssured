package Day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;


public class ParsingXMLResponse {
	
//	@Test
	void testXmlResponse()
	{
	
	/*=================Approach 1==============================	
		given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
		.statusCode(200)
		.header("Content-Type","application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page",equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
		
	*/
		
	//========================Approach 2================================
		
		
        Response res= given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
         Assert.assertEquals(res.getStatusCode(),200);
        
         
        String pageNo =res.xmlPath().get("TravelerinformationResponse.page").toString();
        Assert.assertEquals(pageNo,"1");
		
        String travelerName =res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
        Assert.assertEquals(travelerName,"Developer");
		
   }
	
	
	@Test
	void testXmlResponseResponseBody()
	{
	
        Response res= given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
        
        XmlPath xmlobj=new XmlPath(res.asString());
        
        List<String>travellers=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation"); 
        Assert.assertEquals(travellers.size(),10);
		
        
 // Verify traveller name is present in response or not 
        
        boolean status=false;
       List<String>traveller_names=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");  
       
       for(String travellername:traveller_names)
       {
    	   if(travellername.equals("Developer"))
    	   {
    		status=true;
    	    break;
    	   }
       }
		
       Assert.assertEquals(status,true); 
	}
	

}
