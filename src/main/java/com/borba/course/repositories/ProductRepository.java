package com.borba.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borba.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
