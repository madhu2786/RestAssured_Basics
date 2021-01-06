package com.qa.basictests;

import org.testng.annotations.DataProvider;

public class DataProviderClass
{
	@DataProvider(name="testdata")
	public Object[][] readDataForPost()
	{
		return new Object[][] 
		{
			{"$12","drumsticks","Foster"},
			{"$9","pokkysticks","bunny"}
	    };
	}
}
