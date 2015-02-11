/**
 * 
 */
package com.bootcamp.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.shoppingcart.entity.Category;
import com.bootcamp.shoppingcart.exceptions.CategoryDoesNotExistException;
import com.bootcamp.shoppingcart.repository.CategoryRepository;

/**
 * 
 *
 * @author RoDoX
 */
@RestController
@RequestMapping( value = "/api/categories" )
public class CategoryController {

  
	@Autowired
	private CategoryRepository categoryRepository;
  
  
 
	  /**
	   * Create a new time slot and save it in the database.
	   * 
	   * @param start, time slot start hour
	   * @param end, time slot end hour
	   * @return a string describing if the time slot is succesfully created or not.
	   */
	  @RequestMapping( method = RequestMethod.POST )
	  @ResponseStatus( HttpStatus.CREATED )
	   public void create(@RequestBody Category category) {
		  categoryRepository.save(category);
	     }
	  
	  
	  //delete a category
	  @RequestMapping( value = "{id}", method = RequestMethod.DELETE )
	  @ResponseStatus( HttpStatus.OK )
	   public void delete(@PathVariable long id) throws CategoryDoesNotExistException {
	   
		  Category category = categoryRepository.findById(id);
		  if(category == null){
	    	  throw new CategoryDoesNotExistException(id);
	      }
	      categoryRepository.delete(category); 
	  
	  }
	  
	    
	  //update a category
	  @RequestMapping( value = "{id}", method = RequestMethod.PUT)
	  @ResponseStatus( HttpStatus.CREATED )
	   public void update(@PathVariable long id, @RequestBody Category category) throws CategoryDoesNotExistException {
	    
	      Category category2 = categoryRepository.findById(id);
	      if(category2 == null){
	    	  throw new CategoryDoesNotExistException(id);
	      }
	      category.setId(category2.getId());
	      categoryRepository.save(category);
	      }
	  
	  //get a category
	  @RequestMapping(value ="{id}",method = RequestMethod.GET)
	   public Category getCategoryById(@PathVariable long id) throws CategoryDoesNotExistException {
		  Category category = categoryRepository.findById(id);
		  if(category == null){
	    	  throw new CategoryDoesNotExistException(id);
	      }
	      return category;
	  }
	
	  
	  @RequestMapping(method = RequestMethod.GET)
	   public List<Category> getCategories() {
		  List<Category> category = categoryRepository.findAll();
	      return category;
	  }
	
}