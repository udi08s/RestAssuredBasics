package com.testingfoo.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class GetReqRes {

	@Test
	public void test() {


		//baseURI
		RestAssured.baseURI="https://reqres.in";
		
		given().
				param("page","2").
				when().	
				get("/api/users").
				then().assertThat().statusCode(200).and().
			    contentType(ContentType.JSON).and().
			    body("data[0].first_name",equalTo("Eve")).and().
			    body("total",equalTo(12)).and().
			    header("server", "cloudflare");
		
		
	}

}
