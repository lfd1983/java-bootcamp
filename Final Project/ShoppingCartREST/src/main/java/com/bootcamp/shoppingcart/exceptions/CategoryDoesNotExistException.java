/**
 * 
 */
package com.bootcamp.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author RoDoX
 *
 */


@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryDoesNotExistException extends Exception{

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public CategoryDoesNotExistException(Long id) {
        super(String.format("Category id '%d' does not exist", id));
    }
}