package com.qa.basictests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class LIVEGetPutPostDeletePatch
{
	@Test
	public void test_get()  //get the resource details
	{
		baseURI="http://localhost:3000/";
		given().
			get("/costco").
	    then().statusCode(200).log().all();
	}
	@Test
	public void test_post()  //adding the resource
	{
		baseURI="http://localhost:3000/";
		JSONObject request=new JSONObject();
		request.put("cost","8");
		request.put("itemname","Madelines");
		request.put("brand","kirkland");
		
		request.put("cost","9");
		request.put("itemname","Brownies");
		request.put("brand","kirkland");
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("Content-Type","application/json").
		body(request.toJSONString()).
		when().post("/costco").
		then().statusCode(201).
		log().all();
	}
	
	@Test
	public void test_patch() // update the part of existing resource
	{
		JSONObject request=new JSONObject();
		request.put("itemname", "D-animals");
		
		given().
				contentType(ContentType.JSON).
		accept(ContentType.JSON).
				header("Content-Type","application/json").
		body(request.toJSONString()).
				when().
		patch("http://localhost:3000/costco/94").
				then().
		statusCode(200).log().all();
		
	}
	@Test
	public void test_delete()  //delete the resource
	{
		when().
			delete("http://localhost:3000/costco/94").
		then().statusCode(200).log().all();
	}
	@Test
	public void test_put()   //updating the existing resource totally
	{
		baseURI="http://localhost:3000/";
		JSONObject request=new JSONObject();
		request.put("cost","$23");
		request.put("itemname","Tilapia");
		request.put("brand","FarmsFresh");
		
		given().
			contentType(ContentType.JSON).
		accept(ContentType.JSON).
			header("Content-Type","application/json").
		body(request.toJSONString()).
			when().
		put("/costco/93").then().statusCode(200).log().all();
	}
	
	

}
