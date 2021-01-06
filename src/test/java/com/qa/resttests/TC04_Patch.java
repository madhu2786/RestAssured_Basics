package com.qa.resttests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_Patch 
{
	@Test
	public void patchrequest()
	{
		RestAssured.baseURI="http://localhost:3000/";
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject js=new JSONObject();
		js.put("itemname", "Tyson Chicken wings");
		httprequest.header("Content-Type","application/json");
		httprequest.body(js.toJSONString());
		
		Response response=httprequest.request(Method.PATCH,"/costco/99");
		String resbody=response.getBody().asString();
		System.out.println("The response body is: "+resbody);
		System.out.println("the status code is : "+response.statusCode());
	}
}
