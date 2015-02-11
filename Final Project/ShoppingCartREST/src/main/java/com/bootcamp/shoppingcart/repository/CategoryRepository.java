package com.bootcamp.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.shoppingcart.entity.Category;
import com.bootcamp.shoppingcart.entity.Product;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	public Category findById(Long id);
	public List<Category> findAll(); 
	public Category findByNameLike(String name);
	public List<Category> findByNameAndProducts(String name, Product product);
	
}
