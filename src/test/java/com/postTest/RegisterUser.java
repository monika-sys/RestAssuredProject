package com.postTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.utility.Payloads;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RegisterUser {

	static String registerUserUrl="/api/register";
	@Test
	public void createFirstUser() throws IOException {
		RestAssured.baseURI = "https://reqres.in/";
		String s=Stringfromfile("C:\\Users\\lenovo\\eclipse-workspace\\Rest_Framework\\Input_Payloads\\Register.json");
		given().log().all().contentType(ContentType.JSON)
		.body(s).log().all()
		.when().post(registerUserUrl)
		.then().log().all().assertThat().statusCode(200);

}
	public static String Stringfromfile(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}	
}
