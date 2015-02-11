/**
 * 
 */
package com.bootcamp.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.shoppingcart.entity.Product;
import com.bootcamp.shoppingcart.repository.ProductRepository;

/**
 *
 * @author RoDoX
 */
@RestController
@RequestMapping( value = "api/products" )
public class ProductController {

	  
	  @Autowired
	  private ProductRepository productRepository;
	  
	  //Create a product and save it in the database.
	  @RequestMapping(value = "{catid}", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	  @ResponseStatus( HttpStatus.CREATED )
	   public void create(@RequestBody Product product) {
		  productRepository.save(product);
	     }
	  
	  
	  //Delete the product with the passed id.
	  @RequestMapping( value = "{id}", method = RequestMethod.DELETE )
	  @ResponseStatus( HttpStatus.OK )
	  public void delete(@PathVariable long id) {
	   	  Product product = new Product(id);
		  productRepository.delete(product); 
	  	  }
	  
	    
	 //Update the product
	  @RequestMapping( value = "{id}", method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	  @ResponseStatus( HttpStatus.CREATED )
	   public void update(@PathVariable long id, @RequestBody Product product) {
	    
		  Product product2 = productRepository.findById(id);
	      if(product2 == null){
	    	  throw new IllegalStateException("No product with id: " + id);
	      }
	      product.setId(product2.getId());
	      
	      productRepository.save(product);
	      }
	  
	  
	 //get the product passing its Id
	  
	  @RequestMapping(value ="{id}",method = RequestMethod.GET)
	   public Product getProductsById(@PathVariable long id) {
		  Product product = productRepository.findById(id);
	      return product;
	  }
	
	  //get all products
	  @RequestMapping(method = RequestMethod.GET)
	   public List<Product> getProducts() {
		  List<Product> product = productRepository.findAll();
	      return product;
	  }
	
	
	  
	 
}