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

import com.bootcamp.shoppingcart.entity.CreditCard;
import com.bootcamp.shoppingcart.entity.User;
import com.bootcamp.shoppingcart.repository.UserRepository;

/**
 *
 * @author RoDoX
 */
@RestController
@RequestMapping( value = "api/users" )
public class UserController {

	  
	  @Autowired
	  private UserRepository userRepository;
	  /**
	   * Create a user and save it in the database.
	   * 
	   * 
	   */
	  @RequestMapping( method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	  @ResponseStatus( HttpStatus.CREATED )
	   public void create(@RequestBody User user) {
		  userRepository.save(user);
	     }
	  
	  
	  /**
	   * Delete the user the passed id.
	   * 
	   */
	  @RequestMapping( value = "{id}", method = RequestMethod.DELETE )
	  @ResponseStatus( HttpStatus.OK )
	   public void delete(@PathVariable long id) {
	   
		  User user = new User(id);
		  userRepository.delete(user); 
	  
	  }
	  
	    
	  /**
	   * Update the user
	   *  
	   */
	  @RequestMapping( value = "{id}", method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	  @ResponseStatus( HttpStatus.CREATED )
	   public void update(@PathVariable long id, @RequestBody User user) {
	    
	      User user2 = userRepository.findOne(id);
	      if(user2 == null){
	    	  throw new IllegalStateException("No User with id: " + id);
	      }
	      user.setId(user2.getId());
	      
	      userRepository.save(user);
	      }
	  
	  /**
	   * get the user passing its Id
	   *  
	   */
	  
	  @RequestMapping(value ="{id}",method = RequestMethod.GET)
	   public User getUserById(@PathVariable long id) {
		  User user = userRepository.findById(id);
		  		  	      
	      if(user == null){
	    	  throw new IllegalStateException("No user with id: " + id);
	      }
	       return user;
	  }
	
	  /**
	   * get all users data
	   *  
	   */
	  @RequestMapping(method = RequestMethod.GET)
	   public List<User> getUsers() {
		  List<User> user = userRepository.findAll();
	      return user;
	  }
	
	
	  
	  
	//Get Credit all user´s Credit Cards
	  @RequestMapping( value = "{id}/creditcards", method = RequestMethod.GET)
	  public List<CreditCard> findAllByUserId(@PathVariable long id) {
		  User user = userRepository.findById(id);
		  return user.getCreditcard();
	  }
	  
	 
	
}