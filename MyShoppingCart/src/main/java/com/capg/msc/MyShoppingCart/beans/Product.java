package com.capg.msc.MyShoppingCart.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "Product Bean")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ApiModelProperty(name = "ProductName",value = "Hold the min 3 char product name",required = true)
	@NotEmpty(message = "Product Name cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid Product Name, Product Name should have minimum 3 and maximim 15 characters")
	private String name;
	

	@ApiModelProperty(name = "Product cost",value = "Holds Product cost min cost 1000 allowed")
	@Min(value = 1000, message = "Cost cannot be less than 1000")
	private int cost;
	@Max(value = 5, message = "star rating should not be greater than 5")
	private int starRating;
	@NotEmpty(message = "Category Name cannot be left blank or null")
	@Size(min = 3, max = 15, message = "Invalid Category, category should have minimum 3 and maximum 15 characters")
	private String category;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getStarRating() {
		return starRating;
	}


	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}




	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", starRating=" + starRating + ", category="
				+ category + "]";
	}


	
}
