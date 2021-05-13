package com.capg.msc.MyShoppingCart.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.capg.msc.MyShoppingCart.beans.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>, CustomProductRepository
{

	

}
