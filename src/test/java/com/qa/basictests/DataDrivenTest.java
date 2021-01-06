package com.qa.basictests;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenTest 
{
//	@DataProvider(name="testdata")
//	public Object[][] readDataForPost()
//	{
//		return new Object[][] {
//			{"$12","drumsticks","Foster"},
//			{"$9","pokkysticks","bunny"}
//		};
//		
//	}
	@DataProvider(name="deletedata")
	public Object[] deletedata()
	{
		return new Object[] {
			9,51,16
		};
	}
//	@Test(dataProvider="testdata")
//	public void post(String cost,String itemname,String brand)
//	{
//		JSONObject request=new JSONObject();
//		request.put("cost", cost);
//		request.put("itemname", itemname);
//		request.put("brand", brand);
//		
//		given().
//		contentType(ContentType.JSON).
//		accept(ContentType.JSON).
//		header("content-type","application/json").
//		body(request.toJSONString()).
//		when().
//		post("http://localhost:3000/costco").
//		then().statusCode(201).log().all();
//	}
	@Test(dataProvider="deletedata")
	public void delete(int id)
	{
		when().delete("http://localhost:3000/costco/"+id).
		then().statusCode(200).log().all();
	}

}
