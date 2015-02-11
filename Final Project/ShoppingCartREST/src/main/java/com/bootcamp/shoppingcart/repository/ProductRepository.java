package com.bootcamp.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.shoppingcart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	public Product findById(Long id);
	public List<Product> findAll(); 
	List<Product> findByNameLike(String name);
	List<Product> findByCategoryId(int i);
	List<Product> findByNameAndCategoryId(String name,int i);
}
