package com.postTest;
import org.testng.annotations.Test;

import com.utility.Payloads;


import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;

import io.restassured.RestAssured;
public class CreateUser {
	
	static String createUserUrl="api/users";
	@Test
	public void createFirstUser() {
		RestAssured.baseURI = "https://reqres.in/";
		given().log().all().contentType(ContentType.JSON)
		.body(Payloads.createUser()).log().all()
		.when().post(createUserUrl)
		.then().log().all().assertThat().statusCode(201);

	}
	
	
	
	
	

}
