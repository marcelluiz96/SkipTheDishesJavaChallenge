package com.skipthedishes.api.config;

import java.util.ArrayList;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.skipthedishes.api.model.Cousine;
import com.skipthedishes.api.model.Store;
import com.skipthedishes.api.repository.CousineRepository;
import com.skipthedishes.api.repository.StoreRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CousineRepository cousineRepository;
	@Autowired
	private StoreRepository storeRepository;

	public void run(ApplicationArguments args) {
		IntStream.range(0, 4).forEach(
				number -> {
					Cousine cousine = new Cousine();
					cousine.setName("Cousine " + number);
					cousine.setStores(new ArrayList<>());

					Store store = new Store();
					store.setName("Store from " + cousine.getName());
					store.setAddress("Address " + number);
					store.setCousine(cousine);

					cousine.getStores().add(store);

					cousineRepository.save(cousine);
				}
				);
	}
}
