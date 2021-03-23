package com.cg.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Category;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.repository.CategoryRepository;
import com.cg.onlineshopping.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository categoryRepo;
	
	@Override
	public List<Product> viewAllProducts() {
		
		return productRepo.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		
		productRepo.save(product);
	       
        return  product;
	}

	@Override
	public Product updateProduct(Product product) {
		productRepo.save(product);
		return product;
	}

	@Override
	public Product viewProduct(int id) {
		
		return productRepo.findById(id).get();
	}

	@Override
	public List<Product> viewProductsByCategory(int catId) {
		Category cat = categoryRepo.findById(catId).get();
        List<Product> product = new ArrayList<>(cat.getProducts());
        return product;		
		
	}

	@Override
	public Product removeProduct(int productId) {
		Product product = productRepo.findById(productId).get();
		productRepo.deleteById(productId);
		return product;
	}

}
