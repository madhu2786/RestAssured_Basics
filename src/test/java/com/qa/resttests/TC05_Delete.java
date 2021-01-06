package com.qa.resttests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC05_Delete
{
	@Test
	public void deleterequest()
	{
		RestAssured.baseURI="http://localhost:3000/";
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.DELETE,"/costco/95");
		System.out.println("The status code is: "+response.statusCode());
	}
}
