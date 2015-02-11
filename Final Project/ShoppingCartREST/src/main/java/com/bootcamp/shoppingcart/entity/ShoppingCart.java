/****
 * 
 */
package com.bootcamp.shoppingcart.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 * @author RoDoX
 *
 */

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	
	@OneToMany
	@JoinColumn(name="shoppingcart_id", referencedColumnName="id")
	private List<ProductLine> productLine;
	
	@NotNull
	@Column(name="user_id")
	public  int user_id;


	public ShoppingCart() {
	}

	public ShoppingCart(long id){
		this.id = id;
	}
	
	
	public ShoppingCart(int user_id, List<ProductLine> productLine) {
		this.productLine = productLine;
		this.user_id = user_id;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<ProductLine> getProductLine() {
		return productLine;
	}


	public void setProductLine(List<ProductLine> productLine) {
		this.productLine = productLine;
	}

	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	

		
	
}