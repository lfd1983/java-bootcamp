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
@Table(name = "product")
public class Product {

		@Id
		@GeneratedValue
		@Column(name = "id")
		private Long id;
		@Column(name = "name")
		@NotNull
		private String name;
		@Column(name = "description")
		@NotNull
		private String description;
		@Column(name = "price")
		@NotNull
		private double price;
		@Column(name = "quantity")
		@NotNull
		private double quantity;
		@OneToMany
		@JoinColumn(name="product_id", referencedColumnName="id")
		private List<ProductLine> productLine;
		
		/*@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "category_id")*/
		private int category_id;
		/*private Category category;
		public Category getCategory() {
			return category;
		}
	
	
		public void setCategory(Category category) {
			this.category = category;
		}
	*/
		public Product() {
		}
	
		public Product(long id){
			this.id = id;
		}
		
		public Product(String name, String description, double price,
				double quantity, int category_id) {
			super();
			this.name = name;
			this.description = description;
			this.price = price;
			this.quantity = quantity;
			this.category_id = category_id;
		}
	
	
		public Long getId() {
			return id;
		}
	
	
		public void setId(Long id) {
			this.id = id;
		}
	
	
		public String getName() {
			return name;
		}
	
	
		public void setName(String name) {
			this.name = name;
		}
	
	
		public String getDescription() {
			return description;
		}
	
	
		public void setDescription(String description) {
			this.description = description;
		}
	
	
		public double getPrice() {
			return price;
		}
	
	
		public void setPrice(double price) {
			this.price = price;
		}
	
	
		public double getQuantity() {
			return quantity;
		}
	
	
		public void setQuantity(double quantity) {
			this.quantity = quantity;
		}

		public int getCategory_id() {
			return category_id;
		}

		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}
	
	
		
		
		
		
	
}