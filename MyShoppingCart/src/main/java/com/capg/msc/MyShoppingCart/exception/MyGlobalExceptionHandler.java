package com.capg.msc.MyShoppingCart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler {


	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> inavlidCostInputByUser(InvalidCostRangeException ex)
	{
		
		int range1 = ex.getRange1();
		int range2 = ex.getRange2();
		
		// design custom exception response 
		
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Cost Range "+range1+" and "+range2+", pls try again");
		
		
		return new ResponseEntity<MyExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	// java.util.NoSuchElementException
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidProductId(java.util.NoSuchElementException ex)
	{
		
		
		// design custom exception response 
		
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Product Id pls try again");
		
		
		return new ResponseEntity<MyExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
	

	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidInputByUser(InvalidCostByUserException ex)
	{
		
		
		// design custom exception response 
		
		int cost = ex.getCost();
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
	
		excResponse.setExceptionMsg("price should be atleast 10000");
		
	
		return new ResponseEntity<MyExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidCategoryByUser(InvalidCategoryException ex)
	{
		
		
		// design custom exception response 
		String category = ex.getCategory();
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Category, the length should have atleast 3 characters and it should not be numeric and should not contain any special characters");

		
		return new ResponseEntity<MyExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
}
