/**
 * 
 */
package com.bootcamp.shoppingcart.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "user")
public class User {

		@Id
		@GeneratedValue
		@Column(name = "id")
		private Long id;
		@Column(name = "firstname")
		@NotNull
		private String firstname;
		@Column(name = "lastname")
		@NotNull
		private String lastname;
		@Column(name = "mail")
		@NotNull
		private String mail;
		@Column(name = "address")
		@NotNull
		private String address;
		@Column(name = "username")
		@NotNull
		private String username;
		@Column(name = "password")
		@NotNull
		private String password;
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="user_id", referencedColumnName="id")
		private List<CreditCard> creditCard;
	
		@OneToMany
		@JoinColumn(name="user_id", referencedColumnName="id")
		private List<ShoppingCart> shoppingCart;
		
		
		public User() {
		}
	
		
		public User(String firstname, String lastname, String mail, String address,
				String username, String password, List<CreditCard> creditCard) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.mail = mail;
			this.address = address;
			this.username = username;
			this.password = password;
			this.creditCard = creditCard;
		}
	
	
		/**
		 * @param id2
		 */
		public User(long id) {
			this.id = id;
		}
	
	
	
		public Long getId() {
			return id;
		}
	
	
	
		public void setId(Long id) {
			this.id = id;
		}
	
	
	
		public String getFirstname() {
			return firstname;
		}
	
	
	
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
	
	
	
		public String getLastname() {
			return lastname;
		}
	
	
	
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
	
	
	
		public String getMail() {
			return mail;
		}
	
	
	
		public void setMail(String mail) {
			this.mail = mail;
		}
	
	
	
		public String getAddress() {
			return address;
		}
	
	
	
		public void setAddress(String address) {
			this.address = address;
		}
	
	
	
		public String getUsername() {
			return username;
		}
	
	
	
		public void setUsername(String username) {
			this.username = username;
		}
	
	
	
		public String getPassword() {
			return password;
		}
	
	
	
		public void setPassword(String password) {
			this.password = password;
		}
	
	
	
		public List<CreditCard> getCreditcard() {
			return creditCard;
		}
	
	
	
		public void setCreditcard(List<CreditCard> creditcard) {
			this.creditCard = creditcard;
		}
		
		
}

	
