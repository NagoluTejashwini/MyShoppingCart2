package com.capg.msc.MyShoppingCart.dao;

import java.util.List;

import com.capg.msc.MyShoppingCart.beans.Product;

public interface CustomProductRepository  {
	public List<Product> getProductByCategory(String proudctCategory);
	public List<Product> getProductByCategoryAndPrice(String proudctCategory,int range1,int range2);
}
