/****
 * 
 */
package com.bootcamp.shoppingcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 * @author RoDoX
 *
 */

@Entity
@Table(name = "product_line")
public class ProductLine {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

/*	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;*/
	@NotNull
	@Column(name = "quantity")
	private int quantity;
	@NotNull
	@Column(name = "subtotal")
	private double subTotal;
	
	@Column(name="shoppingcart_id")
	private int shoppingcart_id;

	@Column(name="product_id")
	private int product_id;
/*	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shoppingcart_id")
	private ShoppingCart shoppingCart;*/

	
	/*public ProductLine(Product product, int quantity, double subTotal,
			int shoppingcart_id) {
		this.product = product;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.shoppingcart_id = shoppingcart_id;
	}
*/

	
	
	public ProductLine(Long id) {
		this.id = id;
	}


	public ProductLine(int quantity, double subTotal, int shoppingcart_id,
		int product_id) {
	this.quantity = quantity;
	this.subTotal = subTotal;
	this.shoppingcart_id = shoppingcart_id;
	this.product_id = product_id;
}


	public ProductLine() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	/*public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
*/

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public int getShoppingcart_id() {
		return shoppingcart_id;
	}


	public void setShoppingcart_id(int shoppingcart_id) {
		this.shoppingcart_id = shoppingcart_id;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


/*	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}


	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}*/
	
	
	
	
}