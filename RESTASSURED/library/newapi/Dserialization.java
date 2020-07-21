package com.newapi;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class Dserialization {
	
	public static String USERS_DETAILS="/public-api/users";
	public static String USERS_ID="/public-api/users/5386";
	public static String DELETE_ID="/public-api/users/5388";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	RestAssured.baseURI="https://gorest.co.in";
		
		Users use=new Users();
		use.setFirst_name("ronny");
		use.setLast_name("foe");
		use.setGender("male");
		use.setEmail("ronny09@roberts.com");
		use.setStatus("active");
			
		 String response=	given().log().all()
		 .header("Content-Type","application/json")
		 .body(use)
		//.expect()
	   //.defaultParser(Parser.JSON)
	     .when()
		 .post(USERS_DETAILS)
		 .then()
		 .log().all()
		 .assertThat()
		 .statusCode(200)
		 .extract().asString();
		   
		   ObjectMapper mapper=new ObjectMapper();
		   mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		   mapper.readValue(response,_meta.class);

	}

}
