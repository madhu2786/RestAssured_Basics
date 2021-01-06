package com.qa.localhostcostco;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class P3_put 
{
    @Test
    public void putTest()
    {
    	RestAssured.baseURI="http://localhost:3000/";
    	RequestSpecification httprequest=RestAssured.given();
    	
    	JSONObject reqpayload=new JSONObject();
    	reqpayload.put("name", "AcceptanceTesting");
    	httprequest.header("Content-Type","application/json");
    	httprequest.body(reqpayload.toJSONString());
    	
    	Response response=httprequest.request(Method.PUT, "subjects/23");
    	String responsebody=response.getBody().asString();
    	System.out.println("The response body is "+responsebody);
    	
    	//validation
    	System.out.println("the status code is  "+response.getStatusCode());
    	Assert.assertEquals(response.getStatusCode(),200);
    }
}
