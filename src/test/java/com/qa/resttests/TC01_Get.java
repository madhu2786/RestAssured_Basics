package com.qa.resttests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_Get 
{
	@Test
	public void getRequest()
	{
		// Specify baseURI
		RestAssured.baseURI="https://reqres.in/";
		
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response Object
		Response response=httprequest.request(Method.GET,"api/users/2");
		
		//print responsebody on console
		String responsebody=response.getBody().asString();
		System.out.println("The response body is: "+responsebody);
		
		//statuscode validation
		System.out.println("The status code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("the status line is : "+response.statusLine());
	}

}
