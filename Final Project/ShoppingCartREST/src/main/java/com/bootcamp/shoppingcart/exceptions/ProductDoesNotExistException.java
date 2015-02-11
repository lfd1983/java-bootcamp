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
public class ProductDoesNotExistException extends Exception{

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public ProductDoesNotExistException() {
        super(String.format("Product does not exist"));
    }
}