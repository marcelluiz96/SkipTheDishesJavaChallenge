package com.skipthedishes.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skipthedishes.api.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
	
	List<Store> findByCousineId(Long cousineId);

}
