package com.capg.msc.MyShoppingCart.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.msc.MyShoppingCart.beans.Product;
import com.capg.msc.MyShoppingCart.exception.InvalidCategoryException;
import com.capg.msc.MyShoppingCart.exception.InvalidCostRangeException;
import com.capg.msc.MyShoppingCart.exception.InvalidCostByUserException;
import com.capg.msc.MyShoppingCart.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api")
@Api(value = "My Shopping Cart",description = "Various api works on shopping cart inventory management")
public class ProductRestController {

	@Autowired
	private ProductService service;
	
	public ProductRestController() {
		System.out.println("---->> Product Rest constructor");
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : My Shopping App " + LocalDateTime.now();
	}
	
	@ApiOperation(value = "product post mapping" , response = Product.class)
	@PostMapping("/product")
	public Product insertProduct(@RequestBody @Valid Product p) {
		service.saveProduct(p);
		return p;
	}
	
	@ApiOperation(value = "product Get mapping to fetch all products" , response = List.class)
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id)
	{
		return service.getProductById(id);
		
	}
	
	@PostMapping("/product/delete")
	public boolean deleteProduct(@RequestBody Product p) {
		return service.deleteProduct(p , p.getId());
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return service.doUpdate(product, product.getId());
	}
	@GetMapping("/products/{category}")
	public List<Product> getAllProductsByCategory(@PathVariable String category) throws InvalidCategoryException
	{
		Matcher m = Pattern.compile("[0-9]|@|[\\+-x\\*]").matcher(category);
		if(category.length()<3 || m.find()) {
			throw new InvalidCategoryException(category);
		}
		return service.getAllProductsByCategory(category);
	}
	
	@GetMapping("/products/{category}/{range1}/{range2}")
	public List<Product> getAllProductsByCategoryAndPrice(@PathVariable String category,
			@PathVariable int range1,@PathVariable int range2)throws InvalidCostRangeException
	{
		if(category.equals("Laptop")&&range1<10000)
		{
			throw new InvalidCostRangeException(range1,range2);
		}
		return service.getAllProductsByCategoryAndPrice(category, range1, range2);
	}
	
}

