package com.javainuse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.error.GlobalErrormessage;
import com.javainuse.model.Product;
import com.javainuse.model.ProductJoin;
import com.javainuse.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/allproducts")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@PostMapping("/createProduct")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PutMapping("/updateQuantity/{quantity}")
	public Product updateQuantity(@PathVariable("quantity") int quantity,@RequestParam(name="id") Integer id) {
		return productService.updateProductQuantity(id, quantity);
	}
	
	@GetMapping("/getByQuantity/{quantity}")
	public List<Product> getByQuantity(@PathVariable("quantity") Integer quantity){
		return productService.findByQuantity(quantity);
	}
	
	@GetMapping("/getByQuantity/{min}/{max}")
	public List<Product> getBetweenQuantity(@PathVariable("min") Integer min,@PathVariable("max") Integer max){
		return productService.findBetweenQuantity(min,max);
	}
	
	@GetMapping("/getByasendengingOrder")
	public List<Product> getByasendingOrder(){
		return productService.priceOrderByasending();
	}
	
	@GetMapping("/getBydesndingOrder")
	public List<Product> getBydesendingOrder(){
		return productService.priceOrderBydesending();
	}
	
	@GetMapping("/getProductCategory")
	 public List<ProductJoin> getProductCategory(){	 
		return productService.join();
	 }

}
