package com.capg.msc.MyShoppingCart.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.msc.MyShoppingCart.beans.Product;
import com.capg.msc.MyShoppingCart.dao.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository repo;
	
	
	@Override
	public List<Product> getAllProducts(){
		
		return repo.findAll();
	}
	
	@Override
	@Transactional
	public Product saveProduct(Product p) {
		repo.save(p);
		return p;
	}
	
	@Override
	@Transactional
	public boolean deleteProduct(Product p, int pId) {
		boolean isDeleted = false;
		Product p1 = null;
		List<Product> pList = getAllProducts();
		for(Product product : pList) {
			if(product.getId() == pId) {
				isDeleted = true;
				p1 = product;
			}
		}
		repo.delete(p);
		return isDeleted;
		
	}
	
	
	@Override
	@Transactional
	public Product doUpdate(Product updatedProduct, int productId) {
		//boolean exist =  repo.existsById(productId);
		Optional<Product> p = repo.findById(productId);
		Product p1 = null;
		if(p.isPresent()) {
			p1 = p.get();
			p1.setCost(updatedProduct.getCost());
			p1.setId(updatedProduct.getId());
			p1.setName(updatedProduct.getName());
			p1.setStarRating(updatedProduct.getStarRating());
			p1.setCategory(updatedProduct.getCategory());
			repo.save(p1);
		}
		
		return p1;
	}
	
	@Override
	public List<Product> getAllProductsByCategory(String category) {
		
		return repo.getProductByCategory(category);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2) {
		
		return repo.getProductByCategoryAndPrice(category, range1, range2);
	}
	
	@Override
	public Product getProductById(int id)  {
		return repo.findById(id).get();
		
	}


}
