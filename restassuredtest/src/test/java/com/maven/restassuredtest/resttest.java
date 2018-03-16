package com.maven.restassuredtest;


import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Validatable;
import com.jayway.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class resttest {
	
	//private static String ENDPOINT_GET_BOOK_BY_ISBN=""------;
	
public static void main(String[] args){
	
		//String isbn="isbn:9781451648546";
		ValidatableResponse s=given().
		//param("q", isbn).
			when().
				get("https://www.googleapis.com/books/v1/volumes").
					then().
						statusCode(400).
							body("error.errors.domain", equalTo("global"),
									"error.errors.reason", contains("required"),
									  "error.errors.message", contains("Required parameter: q"),
									  	 "error.errors.locationType",contains("parameter"),
									  	    "error.errors.location",contains("q"),
									  	    	"error.code",equalTo(400),
									  	    		"error.message",equalTo("Required parameter: q")
									  	    		);
		
			ExtractableResponse e=s.extract();
			System.out.println(e.response());
			System.out.println(s);
}
}
