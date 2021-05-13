package com.capg.msc.MyShoppingCart.exception;

public class InvalidCostByUserException extends Exception{
	private int cost;

	public InvalidCostByUserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidCostByUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidCostByUserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCostByUserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCostByUserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCostByUserException(int cost) {
		super();
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	
}
