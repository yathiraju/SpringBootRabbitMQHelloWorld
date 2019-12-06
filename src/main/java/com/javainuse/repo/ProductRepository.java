package com.javainuse.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javainuse.model.Product;
import com.javainuse.model.ProductJoin;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	@Query("from Product where quantity >= :min")
	public List<Product> findByQuantity(@Param("min") Integer min);
	
	@Query("from Product where quantity between :min and :max")
	public List<Product> findBetweenQuantity(@Param("min") Integer min,@Param("max") Integer max);
	
	@Query("from Product order by price desc")
	public List<Product> priceOrderBydesending();
	
	@Query("from Product order by price asc")
	public List<Product> priceOrderByasending();
	
	@Query("select new com.javainuse.model.ProductJoin(p.id,p.name,p.price,p.category.name,p.category.id) from Product p , Category c where p.category.id = c.id")
    public List<ProductJoin> join();
}
