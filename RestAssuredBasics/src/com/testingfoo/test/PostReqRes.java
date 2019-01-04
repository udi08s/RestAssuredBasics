package com.restAssuredAPI.Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostReqRes {
	@Test
	public void test() {

		// baseURI
		RestAssured.baseURI = "https://reqres.in";

		Response res = given().body("{\n" + "    \"name\": \"morpheus\",\n" + "    \"job\": \"leader\"\n" + "}").when()
				.post("/api/users").then().assertThat().statusCode(201).and().contentType(ContentType.JSON).extract()
				.response();

		String resInString = res.asString();
		System.out.println(resInString);
		JsonPath js = new JsonPath(resInString);
		String id = js.get("id");
		System.out.println(id);

	}
}
