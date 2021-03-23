package com.cg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.service.ProductService;

@RestController
@RequestMapping("/onlineshopping/api")
public class ProductRestController {

	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		
		return productService.addProduct(product);
		
	}
	
	@GetMapping("/product")
    public List<Product> viewAllProduct()
    {
        return productService.viewAllProducts();
    }
   
    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product)
    {
        return productService.updateProduct(product);
    }
   
    @GetMapping("/product/{productId}")
    public Product viewProductById(@PathVariable("productId") int prodId)
    {
        return productService.viewProduct(prodId);
    }
   /*
    @GetMapping("/product/{catId}")
    public List<Product> viewProductsByCategory(@PathVariable("catId") int catId)
    {
        return productService.viewProductsByCategory(catId);
    }
   */
    @DeleteMapping("/product/{prodId}")
    public Product removeProduct(@PathVariable("prodId") int prodId)
    {
        return productService.removeProduct(prodId);
    }
}
