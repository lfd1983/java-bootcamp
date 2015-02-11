/**
 * 
 */
package com.bootcamp.shoppingcart.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.shoppingcart.entity.ShoppingCart;
import com.bootcamp.shoppingcart.repository.ShoppingCartRepository;

/**
 * 
 *
 * @author RoDoX
 */
@RestController
@RequestMapping( value = "api/user" )
public class ShoppingCartController {

  
	 @Autowired
	 private ShoppingCartRepository shoppingCartRepository;
	 //create a ShoppingCart
	 @RequestMapping(value ="{id}/cart", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE  )
	  @ResponseStatus( HttpStatus.CREATED )
	   public void create(@PathVariable String id, @RequestBody ShoppingCart shoppingCart) throws IOException {
		  shoppingCartRepository.save(shoppingCart);
		  
		  }
	 
	 
	 //get a shoppingcart with the passed id
	   @RequestMapping(value ="{id}/cart/{scid}",method = RequestMethod.GET)
	   public ShoppingCart getShoppingCartById(@PathVariable long scid) {
		  ShoppingCart shoppingCart = shoppingCartRepository.findById(scid);
	      return shoppingCart;
	  }
	 
	   //delete a shopping cart 
	   @RequestMapping( value = "{id}/cart/{scid}", method = RequestMethod.DELETE )
	   @ResponseStatus( HttpStatus.OK )
	   public void deleteCreditCard(@PathVariable long id,@PathVariable long scid) {
		   
			  ShoppingCart shoppingCart = new ShoppingCart(id);
			  shoppingCartRepository.delete(shoppingCart); 
		  
		  }
			   

	 
	  

}