package com.getTest;

import org.testng.annotations.Test;


import com.testBase.TestBase;

import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;

import io.restassured.RestAssured;

public class GetUser extends TestBase {

	static String getSingleUserUrl = "/api/users/2";
	static String getListUserUrl = "/api/users?page";

	@Test(enabled = false)
	public void getSingleUser() {
		RestAssured.baseURI = TestBase.baseUrl;
		given().contentType(ContentType.JSON).when().get(getSingleUserUrl).then().log().all()
				.assertThat().statusCode(200);

	}

	@Test(enabled = true)
	public void getListOfUser() {
		RestAssured.baseURI = TestBase.baseUrl;
		given().contentType(ContentType.JSON).when().get(getListUserUrl).then().log().all()
				.assertThat().statusCode(200);

	}

}
