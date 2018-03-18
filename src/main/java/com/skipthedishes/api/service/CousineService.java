package com.skipthedishes.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skipthedishes.api.model.Cousine;
import com.skipthedishes.api.model.Store;
import com.skipthedishes.api.repository.CousineRepository;
import com.skipthedishes.api.repository.StoreRepository;


/**
 * Sample service with pre-query validation and enforced Optional return.
 * 
 * @author marcelluiz
 *
 */
@Service
public class CousineService {

	@Autowired
	private CousineRepository cousineRepository;

	@Autowired
	private StoreRepository storeRepository;

	public Optional<List<Store>> findStoresByCousineId(Long cousineId) {
		List<Store> cousineStores = null;

		if (cousineRepository.existsById(cousineId)) {
			cousineStores = storeRepository.findByCousineId(cousineId);
		}

		return Optional.of(cousineStores);
	}
	
	public Optional<List<Cousine>> listAll() {
		List<Cousine> allCousines = cousineRepository.findAll();
		return Optional.of(allCousines);
	}
	
	public Optional<List<Cousine>> findByKeywords(String searchKeywords) {
		 List<Cousine> foundCousines = cousineRepository.findByNameIgnoreCaseContaining(searchKeywords);
		
		return Optional.of(foundCousines);
	}
	
	

}
