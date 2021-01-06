package com.qa.basictests;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetPostPutPatchDelete 
{
	@Test
	public void Post()  
	{
		
		JSONObject request=new JSONObject();
		request.put("name", "madhuri");
		request.put("job", "wife");
		
		System.out.println(request.toJSONString());
		given().header("Content-Type","application/json").contentType(ContentType.JSON).
		accept(ContentType.JSON)
		
		
		.body(request.toJSONString()).when().post("https://reqres.in/api/users?page=2")
		.then().statusCode(201);
      }
      
	@Test
	public void put()
	{
		
		JSONObject request=new JSONObject();
		request.put("name", "sahana");
		request.put("job", "daughter");
		
		System.out.println(request.toJSONString());
		given().header("Content-Type","application/json").contentType(ContentType.JSON).
		accept(ContentType.JSON)
		.body(request.toJSONString()).when().put("https://reqres.in/api/users?page=2")
		.then().statusCode(200).log().all();
      }
	
	@Test
	public void patch()
	{
		
		JSONObject request=new JSONObject();
		request.put("name", "samee");
		request.put("job", "daughter");
		
		System.out.println(request.toJSONString());
		given().header("Content-Type","application/json").contentType(ContentType.JSON).
		accept(ContentType.JSON)
		.body(request.toJSONString()).when().patch("https://reqres.in/api/users/2")
		.then().statusCode(200).log().all();
      }

	@Test
	public void delete()
	{
		
		when().delete("https://reqres.in/api/users/2")
		.then().statusCode(204).log().all();
      }


}
