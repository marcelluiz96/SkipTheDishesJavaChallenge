package com.skipthedishes.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skipthedishes.api.model.Product;
import com.skipthedishes.api.model.Store;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByStoreId(Long storeId);
	
	// FullTextSearch is A MUST to replace this. ElasticSearch, Couchbase, or even the database's own feature
	List<Product> findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(String name, String description);
}
