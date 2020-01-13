package com.rest.assure;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAndPost {
	
	@Test
	public void testQueryGenderParam(){
		//providing authentication
		 RestAssured.authentication = RestAssured.basic("admin", "password");
		 Response res = (Response) RestAssured
				.given().
						queryParam("type", "gender").
						queryParam("value", "m").
				when()
						.contentType("application/json")
						.get("http://localhost:8585/getPerson");
		
		//System.out.println("response body is "+res);
		
		 
		    
		    
		int statusCode = res.getStatusCode();
			System.out.println("statusCode is :"+statusCode);
			System.out.println("StatusLine is :"+res.getStatusLine());
			System.out.println("time is :"+res.getTime());
			System.out.println("Response Body is  " + res.asString());
			System.out.println("Preety----"+res.prettyPeek());
			System.out.println("ContentType is " +res.contentType());
			Assert.assertNotNull(statusCode);
			
			
	}

	
	@Test
	public void postserviceop() throws JSONException{
		RestAssured.authentication = RestAssured.basic("admin", "password");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "umesh"); 
		requestParams.put("age", "9");
		requestParams.put("gender", "m");
		requestParams.put("location", "rajest");
		requestParams.put("state", "telengana");
		requestParams.put("income", "10000");
		requestParams.put("maritalStatus", "f");
		
		request.body(requestParams.toString());
		Response response = request.post("http://localhost:8585/person"); 
		int statusCode = response.getStatusCode(); 
		System.out.println("Status code : " + statusCode);       
		System.out.println("Response body: " + response.body().asString()); //Get Response Body
		}
	

}
