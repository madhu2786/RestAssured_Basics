package com.qa.localhostcostco;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class P5_delete 
{
   @Test
   public void deleteTest()
   {
	   RestAssured.baseURI="http://localhost:3000/costco/";
	   RequestSpecification httprequest=RestAssured.given();
	   Response response=httprequest.request(Method.DELETE,"99");
	   String resbody=response.getBody().asString();
	   System.out.println("the body is "+resbody);
   }
}
