package com.javainuse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.model.Product;
import com.javainuse.model.ProductJoin;
import com.javainuse.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProduct(Integer id) {
		return productRepository.findById(id);
	}

	public Long getProductCount() {
		return productRepository.count();
	}

	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}
	
	public Iterable<Product> saveProducts(Iterable<Product> products){
		return productRepository.saveAll(products);
	}
	
	public Product updateProductQuantity(Integer id, int quantity) {
		Optional<Product> productOptional = productRepository.findById(id);
		Product product=productOptional.get();
		product.setQuantity(quantity);
		return productRepository.save(product);
	
	}
	
	public List<Product> findByQuantity(Integer quantity){
		return productRepository.findByQuantity(quantity);
	}
	
	 public List<ProductJoin> join(){
		 return productRepository.join();
	 }
	
	public List<Product> findBetweenQuantity(Integer min,Integer max){
		return productRepository.findBetweenQuantity(min,max);
	}
	
	public List<Product> priceOrderByasending(){
		return productRepository.priceOrderByasending();
	}
	
	public List<Product> priceOrderBydesending(){
		return productRepository.priceOrderBydesending();
	}

}
