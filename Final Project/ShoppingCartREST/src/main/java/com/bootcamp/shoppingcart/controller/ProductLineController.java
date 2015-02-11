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
import com.bootcamp.shoppingcart.entity.ProductLine;
import com.bootcamp.shoppingcart.entity.ShoppingCart;
import com.bootcamp.shoppingcart.exceptions.ProductDoesNotExistException;
import com.bootcamp.shoppingcart.repository.ProductLineRepository;
import com.bootcamp.shoppingcart.repository.ProductRepository;
import com.bootcamp.shoppingcart.repository.ShoppingCartRepository;

/**
 * 
 *
 * @author RoDoX
 */
@RestController
@RequestMapping( value = "/api" )
public class ProductLineController {

  
	@Autowired
	private ProductLineRepository productLineRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
  
  
	//add products to the cart
	@RequestMapping(value = "users/{uId}/cart/", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE  )
	@ResponseStatus( HttpStatus.CREATED )
	public void create(@RequestBody ProductLine productLine ) {
		  
		  Product product = productRepository.findById((long) productLine.getProduct_id());
		  productLine.setSubTotal(productLine.getQuantity()*product.getPrice());
		  productLineRepository.save(productLine);
	     }
	
	//update the product from the car
	@RequestMapping(value = "users/{uId}/cart/{spId}/products/{plId}", method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE  )
	@ResponseStatus( HttpStatus.CREATED )
	public void update(@PathVariable long plId, @RequestBody ProductLine productLine ) throws ProductDoesNotExistException {
		ProductLine productLine2 = productLineRepository.findById(plId);
		if(productLine2 == null){
		    	  throw new ProductDoesNotExistException();
		      }
		Product product = productRepository.findById((long) productLine.getProduct_id());
		productLine = productLine2;
		productLine.setSubTotal(productLine.getQuantity()*product.getPrice());
		productLineRepository.save(productLine);
	     }
	
	  
	//get product using its id
	@RequestMapping(value = "users/{uId}/cart/{spId}/products/{plId}", method = RequestMethod.GET )
	@ResponseStatus( HttpStatus.OK )
	public ProductLine getProductLine(@PathVariable long plId) throws ProductDoesNotExistException {
		ProductLine productLine = productLineRepository.findById(plId);
		   if(productLine == null){
		    	  throw new ProductDoesNotExistException();
		      }
		  return productLine;
	     }
	
	//get all products from the cart
	@RequestMapping(value = "users/{uId}/cart/{spId}/products", method = RequestMethod.GET )
	@ResponseStatus( HttpStatus.OK )
	public List<ProductLine> getProducts(@PathVariable long spId) {
		ShoppingCart shoppingCart = shoppingCartRepository.findById(spId);
		return shoppingCart.getProductLine();
	}
	
	
	//delete a product from the cart
		@RequestMapping(value = "users/{uId}/cart/{spId}/products/{plId}", method = RequestMethod.DELETE )
		@ResponseStatus( HttpStatus.OK )
		public void deletetProductLine(@PathVariable long plId) throws ProductDoesNotExistException {
			ProductLine productLine = productLineRepository.findById(plId);
			   if(productLine == null){
			    	  throw new ProductDoesNotExistException();
			      }
			productLineRepository.delete(productLine);
		     }
	
	
}