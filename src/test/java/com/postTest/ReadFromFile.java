package com.postTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.testBase.TestBase;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;


public class ReadFromFile extends TestBase {
	
	@Test
	public static void createUserByFileJson() throws IOException {
		RestAssured.baseURI=TestBase.baseUrl;
		String createUserUrl="/api/users";

		
		String s=Stringfromfile("C:\\Users\\lenovo\\eclipse-workspace\\Rest_Framework\\Input_Payloads\\Payload.json");

		given().log().all().contentType(ContentType.JSON)
		.body(s).log().all().log().all()
		.when().post(createUserUrl)
		.then().log().all().statusCode(201);

	}
	public static String Stringfromfile(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));

 

}}
