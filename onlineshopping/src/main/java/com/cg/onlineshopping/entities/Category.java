package com.cg.onlineshopping.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "category_details")
public class Category {
    
	@Id
	@Column(name = "cat_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_seq")
	@SequenceGenerator(name="category_seq",sequenceName="category_seq", allocationSize=1)
	private int catId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	public Category(int catId, String categoryName) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;
	}

	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	 private Set<Product> products = new HashSet<Product>();
	  
	  
	public Category() {
		super();
	}
	

	


	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", categoryName=" + categoryName + ", products=" + products + "]";
	}

	
	
}
