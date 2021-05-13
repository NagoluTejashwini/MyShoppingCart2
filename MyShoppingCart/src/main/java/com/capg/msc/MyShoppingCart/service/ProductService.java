package com.capg.msc.MyShoppingCart.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.msc.MyShoppingCart.beans.Product;

public interface ProductService{

	List<Product> getAllProducts();

	Product saveProduct(Product p);

	boolean deleteProduct(Product p, int id);

	Product doUpdate(Product product, int id);

	List<Product> getAllProductsByCategory(String category);

	List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2);

	Product getProductById(int id);


}
