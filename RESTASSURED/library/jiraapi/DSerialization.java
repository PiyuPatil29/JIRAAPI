package com.library.jiraapi;

import com.libraryapiserializationanddserial.Addbook;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class DSerialization {
	
	static SessionFilter session = new SessionFilter();
	
	public static final String CREATE_PATH = "/rest/auth/1/session";
	public static final String CREATE_ISSUE="/rest/api/2/issue";
	public static final String CREATE_COMMENT="rest/api/2/issue/{key}/comment";
	public static final String ADD_ATTACHEMENT = "/rest/api/2/issue/{key}/attachments";
	
	public static void main(String[] args) {
		DSerialization.createSession();
		DSerialization.issueCreate();
		DSerialization.addComment();
		DSerialization.addAttachment();
	}
		//CreateSession(Session Created)
		public static void createSession() {
		
		RestAssured.baseURI="http://localhost:8082";
		
		Session s=new Session();
		s.setUsername("piyupatil01");
		s.setPassword("adityapatil");
		
		given().log().all()
		.contentType(ContentType.JSON)
		.body(s).filter(session).when()
		.post(CREATE_PATH)
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.body("session.value", Matchers.notNullValue())
		.extract().body().asString();
	
		}
		//CreateIssue (Issue created)
		
		public static void issueCreate() {
			Issuefielddata proj=new Issuefielddata();
		    proj.setKey("PB");
			
			Issuefieldkey issuetype=new Issuefieldkey();
			issuetype.setName("Story");
				
			Getsummaryissuedetail d=new Getsummaryissuedetail();
			d.setProject(proj);
		
			d.setSummary("Create session and create issue and add attachment file");
			d.setDescription("Demo creating a story on rest api");
			d.setIssuetype(issuetype);
			given().log().all()
			.contentType(ContentType.JSON)
			.body(d).filter(session)
			.when()
			.post(CREATE_ISSUE)
			.then().log().all()
			.assertThat()
			.statusCode(201).extract().body().asString();
			}
		
		//PostComment
		
		public static void addComment() {
			Payloadcomment comment=new Payloadcomment();
			comment.setComment("This is comment regarding response of comment from piyu");
			
			        String getcomment=given()
					.contentType(ContentType.JSON)
					.log().all()
					.header("X-Atlassian-Token","nocheck")
					.pathParam("key","attachentID")
					.body(CREATE_COMMENT)
					.log().all().filter(session)
					.when()
					.post()
					.then().assertThat()
					.statusCode(201)
					.extract().body().asString();
					
		}
		
		//Addattachment
		
		public static void addAttachment() {
			given().log().all()
			.header("X-Atlassian-Token","nocheck")
			.header("Content-Type","multipart/form-data")
			.pathParam("key","attachentID")
			.filter(session)
			.multiPart("file",new File("C:\\Users\\Hp\\eclipse-workspace\\AssignmentRestAssured\\File\\Assignment.txt"))
			.when()
			.post(ADD_ATTACHEMENT).then()
			
			.assertThat().statusCode(200).extract().body().asString();
		
		}
		
	}
		


