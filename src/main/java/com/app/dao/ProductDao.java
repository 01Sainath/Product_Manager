package com.app.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.entities.User;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	
	public List<Product> findByCategory(Category name);
	public List<Product> findByProvider(User u);
}
