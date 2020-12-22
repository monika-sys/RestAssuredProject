package com.deserializationTest;

import java.util.List;

import org.hamcrest.core.StringContains;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pojo.DataPojo;
import com.pojo.ListUserPojo;
import com.testBase.TestBase;

import io.restassured.RestAssured;

public class PojoTest extends TestBase {

	 static String listUser="/api/users?page=2";
	@Test
	public void TestDeserialization() {

		RestAssured.baseURI = TestBase.baseUrl;

		ListUserPojo pojo = RestAssured.given().when().get(listUser).as(ListUserPojo.class);

		System.out.println(pojo.toString());
		List<DataPojo> list = pojo.getData();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("this is my " + i + " element list" + list.get(i));

		}

	}
}
