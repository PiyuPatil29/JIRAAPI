package com.getlibraryserialanddserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class Getid {
	public static String GET_ID="Library/GetBook.php?ID=oppo22337";
	@Test(priority = 1)
	public void getAuthorname() {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
	             Get[] array=given().log()
	             .all().header("content-type","application/json")
				.expect()
				.defaultParser(Parser.JSON)
				.when()
				.post(GET_ID)
				.then().log().all()
				.assertThat()
				.statusCode(200)
				.extract()
				.as(Get[].class);
	             
	             for(Get getdata :array) {
		        
		       
		        System.out.println(getdata.getBook_name());
		        System.out.println(getdata.getAisle());
		        System.out.println(getdata.getIsbn());
	}
	}


}
