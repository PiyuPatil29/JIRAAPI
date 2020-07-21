package com.newapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Runner {
	
	public static String USERS_DETAILS="/public-api/users";
	public static String USERS_ID="/public-api/users/5386";
	public static String DELETE_ID="/public-api/users/5388";
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://gorest.co.in";
		
		Users use=new Users();
		use.setFirst_name("ronny joyess");
		use.setLast_name("foeesk");
		use.setGender("male");
		use.setEmail("ronyfoe2123@roberts.com");
		use.setStatus("active");
        
        given().log()
        .all().header("Authorization","Bearer QHg-NmZ6J2N6ipPyo_e0csmZkBDimy567wdX")
        .contentType(ContentType.JSON)
    	.when()
    	.body(use)
    	.post(USERS_DETAILS)
    	.then().log().all();
    	//.statusCode(201);
        
        //user id
        
        given().log().all()
        .header("Authorization","Bearer QHg-NmZ6J2N6ipPyo_e0csmZkBDimy567wdX")
        .contentType(ContentType.JSON)
        .when()
        .post(USERS_ID)
        .then().log().all();
    //	.statusCode(200);
        
        //DELETE_ID
        given().log().all()
        .header("Authorization","Bearer QHg-NmZ6J2N6ipPyo_e0csmZkBDimy567wdX")
        .contentType(ContentType.JSON)
        .when()
        .post(DELETE_ID)
        .then().log().all();
       // .statusCode(200);
        
        
	}

}
