package com.qa.localhostcostco;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class P2_post 
{
	@Test
	public void postTest()
	{
		//specify the endpoint
		RestAssured.baseURI="http://localhost:3000";
		//specify the request object
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject requestpayload=new JSONObject();
     	requestpayload.put("id","67" );
	    requestpayload.put("name","Manual");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestpayload.toJSONString());//attach the payload to request object
		
		//specify the response object
		Response response=httprequest.request(Method.POST, "/subjects");
		
		//print the response data on the console
		String responsebody=response.getBody().asString();
		System.out.println("The response body is --"+responsebody);
	}
}
