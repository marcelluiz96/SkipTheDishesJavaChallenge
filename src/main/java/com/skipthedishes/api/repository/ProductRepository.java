package com.skipthedishes.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skipthedishes.api.model.Product;
import com.skipthedishes.api.model.Store;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByStoreId(Long storeId);
}
