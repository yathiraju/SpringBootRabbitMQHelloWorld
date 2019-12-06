package com.javainuse.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductJoin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductJoin(Integer id,String name ,BigDecimal price ,String categoryName ,Integer categoryId) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.categoryId=categoryId;
		this.categoryName=categoryName;
	}

	
	  public ProductJoin() {
	  
	  }

	private Integer id;
	private String name;
	private BigDecimal price;
	
	private String categoryName;
	private Integer categoryId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	

}
