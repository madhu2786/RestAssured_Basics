package com.qa.basictests;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterization 
{
	@Parameters({"id"})
	@Test
	public void delete(int id)
	{
		when().delete("http://localhost:3000/costco/"+id).
		then().statusCode(200).log().all();
	}

}
