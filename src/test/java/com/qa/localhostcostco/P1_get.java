package com.qa.localhostcostco;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class P1_get 
{
  @Test
  public void getTest()
  {
	  //specify the baseURI
	  RestAssured.baseURI="http://localhost:3000";
	  //specify the request object
	  RequestSpecification httprequest=RestAssured.given();
	  //declare the response object
	  Response response=httprequest.request(Method.GET, "/subjects");
	  //print response body on the console
	  String responsebody=response.getBody().asString();
	  System.out.println("The response payload is --"+responsebody);
	  
	  //validation
	  System.out.println("The status code is "+ response.getStatusCode());
	  Assert.assertEquals(response.getStatusCode(), 200);
  }
}
