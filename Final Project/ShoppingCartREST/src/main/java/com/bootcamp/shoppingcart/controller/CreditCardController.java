/**
 * 
 */
package com.bootcamp.shoppingcart.controller;

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
import com.bootcamp.shoppingcart.repository.CreditCardRepository;

/**
 *
 * @author RoDoX
 */
@RestController
@RequestMapping( value = "api/users/{idusr}/creditcards" )
public class CreditCardController {

	  
	  @Autowired
	  private CreditCardRepository creditCardRepository;
	  
	 
	  //Get Credit Card By Id
	  @RequestMapping(value = "{idcc}", method = RequestMethod.GET)
	  public CreditCard findByUserId(@PathVariable long idcc) {
	   return creditCardRepository.findOne(idcc);
	  }
	  
	  
	 //add a credit card to the user passing its
	  
	  @RequestMapping(method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE  )
	  @ResponseStatus( HttpStatus.CREATED )
	   public void createCreditCard(@RequestBody CreditCard creditCard) {
		  creditCardRepository.save(creditCard);
	     }
	  
	  
	  /**
	   * Update the user´s credit card
	   *  
	   */
	  @RequestMapping( value = "{idcc}", method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE )
	  @ResponseStatus( HttpStatus.CREATED )
	   public void updateCreditCard(@PathVariable long id, @RequestBody CreditCard creditCard) {
	    
	      CreditCard creditCard2 = creditCardRepository.findOne(id);
	      if(creditCard2 == null){
	    	  throw new IllegalStateException("No CreditCard with id: " + id);
	      }
	      creditCard.setId(creditCard2.getId());
	      creditCardRepository.save(creditCard);
	      }
	 
	  
	  //delete credit card
	  @RequestMapping( value = "{idcc}", method = RequestMethod.DELETE )
	  @ResponseStatus( HttpStatus.OK )
	   public void deleteCreditCard(@PathVariable long idcc) {
	   
		  CreditCard creditCard = new CreditCard(idcc);
		  creditCardRepository.delete(creditCard); 
	  
	  }
	  
}