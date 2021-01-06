package com.qa.localhostcostco;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class P4_patch 
{
   @Test
   public void patchTest()
   {
	   RestAssured.baseURI="http://localhost:3000/";
	   RequestSpecification httprequest=RestAssured.given();
	   JSONObject respayload=new JSONObject();
	   respayload.put("itemname", "Kinder Beuno");
	   respayload.put("cost", "$17");
	   
	   httprequest.header("Content-Type","application/json");
	   httprequest.body(respayload.toJSONString());
	   Response response= httprequest.request(Method.PATCH,"costco/101");
	   String resbody=response.getBody().asString();
	   System.out.println("The body is "+resbody);
   }
}
