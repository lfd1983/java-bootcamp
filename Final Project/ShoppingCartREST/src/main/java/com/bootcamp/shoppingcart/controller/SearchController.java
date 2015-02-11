/**
 * 
 */
package com.bootcamp.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.shoppingcart.entity.Category;
import com.bootcamp.shoppingcart.entity.Product;
import com.bootcamp.shoppingcart.exceptions.CategoryDoesNotExistException;
import com.bootcamp.shoppingcart.exceptions.ProductDoesNotExistException;
import com.bootcamp.shoppingcart.repository.CategoryRepository;
import com.bootcamp.shoppingcart.repository.ProductRepository;

/**
 * 
 *
 * @author RoDoX
 */
@RestController
@RequestMapping( value = "/api/search" )
public class SearchController {

  
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
  
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findAllByProductNameAndCategory(@RequestParam(required = true) String name, 
			@RequestParam(required = true) String category) 
			throws CategoryDoesNotExistException, ProductDoesNotExistException  {
		  		Category category2 = categoryRepository.findByNameLike(category);
				if (category == null) {
			     throw new CategoryDoesNotExistException((long) 1);
				      } else {
		   	  		long id = category2.getId();
		   	  		int id2 = (int) id;
		   	  		List<Product> product = productRepository.findByNameAndCategoryId(name, id2);
		   	  		if(product == null){
		   	  			throw new ProductDoesNotExistException();
		   	  		} 
		   	  			return product;
		   	  		} 
			  }
	
	@RequestMapping(value = "products",method = RequestMethod.GET)
	public List<Product> findAllByProductName(@RequestParam(required = true) String name) 
			throws ProductDoesNotExistException  {
		  		List<Product> product = productRepository.findByNameLike(name);
				if (product == null) {
			     throw new ProductDoesNotExistException();
				      } else {
		   	  			return product;
		   	  		} 
			  }
	
	@RequestMapping(value = "products/categories",method = RequestMethod.GET)
	public List<Product> findAllByCategoryName(@RequestParam(required = true) String name) 
			throws ProductDoesNotExistException, CategoryDoesNotExistException  {
			Category category = categoryRepository.findByNameLike(name);
			if (category == null) {
				throw new CategoryDoesNotExistException((long) 1);
		      	} else {
		      		long id = category.getId();
		      		int id2 = (int) id;
		      		List<Product> product = productRepository.findByCategoryId(id2);
   	  		if(product == null){
   	  			throw new ProductDoesNotExistException();
   	  		} 
   	  			return product;
   	  		} 
	  }
	
}