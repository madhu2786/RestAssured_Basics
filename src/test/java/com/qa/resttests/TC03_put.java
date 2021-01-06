package com.qa.resttests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_put 
{
       @Test
       public void putrequest()
       {
    	   //specify baseURI
    	   RestAssured.baseURI="http://localhost:3000/";
    	   //request object
    	   RequestSpecification httprequest=RestAssured.given();
    	   
    	   JSONObject reqpar=new JSONObject();
    	   reqpar.put("cost","$69");
    	   reqpar.put("itemname", "BP machine");
    	   reqpar.put("brand", "Breur");
    	   
    	   httprequest.header("Content-Type", "application/json");
    	   httprequest.body(reqpar.toJSONString());//attach the above body to request
    	   
    	   Response response=httprequest.request(Method.PUT,"/costco/95");
    	   String responsebody=response.getBody().asString();
    	   System.out.println("The response body is : "+responsebody);
    	   
    	   System.out.println("The status code is: "+response.statusCode());
       }
}
