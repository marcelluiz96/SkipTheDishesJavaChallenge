package com.skipthedishes.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skipthedishes.api.model.Cousine;

public interface CousineRepository extends JpaRepository<Cousine, Long>{
	
	List<Cousine> findByNameIgnoreCaseContaining(String searchKeywords);

}
