package com.qa.resttests;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_POST
{
	@Test
	public void postdata()
	{
		//Specify baseURI
		RestAssured.baseURI="http://localhost:3000/";
		
		//request object
		RequestSpecification httprequest=RestAssured.given();
        
		JSONObject requestparameters=new JSONObject();
		requestparameters.put("cost", "26");
		requestparameters.put("itemname", "chicken breast");
		requestparameters.put("brand","foster farm" );
		requestparameters.put("id","99");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparameters.toJSONString()); //attach the above body to request
		
		Response response=httprequest.request(Method.POST,"/costco");
		//print body on the console.
		
		String resbody=response.getBody().asString();
		System.out.println("The body is : "+resbody);
		
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
