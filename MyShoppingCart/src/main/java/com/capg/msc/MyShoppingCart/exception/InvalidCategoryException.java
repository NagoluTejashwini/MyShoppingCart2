package com.capg.msc.MyShoppingCart.exception;

public class InvalidCategoryException extends Exception{
	private String category;

	public InvalidCategoryException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	
	
	
}
