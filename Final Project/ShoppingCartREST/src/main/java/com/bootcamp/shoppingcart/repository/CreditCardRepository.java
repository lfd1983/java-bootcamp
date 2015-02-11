/**
 * 
 */
package com.bootcamp.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.shoppingcart.entity.CreditCard;

/**
 * @author RoDoX
 *
 */
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	public CreditCard findById(Long id);
	public List<CreditCard> findAll(); 
	}
