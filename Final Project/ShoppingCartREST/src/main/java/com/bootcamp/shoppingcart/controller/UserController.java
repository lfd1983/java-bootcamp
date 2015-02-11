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
import com.bootcamp.shoppingcart.exceptions.UserDoesNotExistException;
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
	
	  //add a new user
	  @RequestMapping( method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE )
	  @ResponseStatus( HttpStatus.CREATED )
	   public void create(@RequestBody User user) {
		  userRepository.save(user);
	     }
	  
	  
	  //Delete user
	  @RequestMapping( value = "{id}", method = RequestMethod.DELETE )
	  @ResponseStatus( HttpStatus.OK )
	   public void delete(@PathVariable long id) throws UserDoesNotExistException {
	  
		  User user = userRepository.findOne(id);
		  if (user == null) {
		   throw new UserDoesNotExistException(id);
		  }
		  userRepository.delete(user); 
		 }
		  
	    
	  //update user
	  @RequestMapping( value = "{id}", method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	  @ResponseStatus( HttpStatus.CREATED )
	   public void update(@PathVariable long id, @RequestBody User user) throws UserDoesNotExistException {
	    
	      User user2 = userRepository.findOne(id);
	      if(user2 == null){
	    	  throw new UserDoesNotExistException(id);
	      }
	      user.setId(user2.getId());
	      
	      userRepository.save(user);
	      }
	  
	  /**
	   * get the user passing its Id
	 * @throws UserDoesNotExistException 
	   *  
	   */
	  
	  @RequestMapping(value ="{id}",method = RequestMethod.GET)
	   public User getUserById(@PathVariable long id) throws UserDoesNotExistException {
		  User user = userRepository.findById(id);
		  		  	      
	      if(user == null){
	    	  throw new UserDoesNotExistException(id);
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