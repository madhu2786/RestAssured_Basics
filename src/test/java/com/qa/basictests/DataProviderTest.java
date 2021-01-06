package com.qa.basictests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProviderTest 
{
	@Test(dataProvider="testdata", dataProviderClass=DataProviderClass.class)
	public void post(String cost,String itemname,String brand)
	{
		JSONObject request=new JSONObject();
		request.put("cost", cost);
		request.put("itemname", itemname);
		request.put("brand", brand);
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		header("content-type","application/json").
		body(request.toJSONString()).
		when().
		post("http://localhost:3000/costco").
		then().statusCode(201).log().all();
	}

}
