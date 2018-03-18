package com.skipthedishes.api.config;

import java.util.ArrayList;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.skipthedishes.api.model.Cousine;
import com.skipthedishes.api.model.Product;
import com.skipthedishes.api.model.Store;
import com.skipthedishes.api.repository.CousineRepository;
import com.skipthedishes.api.repository.ProductRepository;
import com.skipthedishes.api.repository.StoreRepository;

//TODO Move this to the appropriate testing package

@Component
@Profile("unit")
public class DataLoader implements ApplicationRunner {

	// Perhaps a GenericRepository or GenericDAO would do better than several @Autowired injections
	@Autowired
	private CousineRepository cousineRepository;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private ProductRepository productRepository;

	public void run(ApplicationArguments args) {
		IntStream.range(0, 4).forEach(
				number -> {
					//new Cousine
					Cousine cousine = new Cousine();
					cousine.setName("Cousine " + number);
					cousine.setStores(new ArrayList<>());

					// new Store associated to that cousine
					Store store = new Store();
					store.setName("Store from " + cousine.getName());
					store.setAddress("Address " + number);
					store.setProducts(new ArrayList<>());

					// Making the associations betweeen Cousine and store
					store.setCousine(cousine);
					cousine.getStores().add(store);


					// new Product associated to that store
					Product product = new Product();
					product.setName("Product " + number);
					product.setPrice(new Double(number));
					product.setDescription("Description of product " + number);

					// Making the associations between Store and Product
					product.setStore(store);
					store.getProducts().add(product);

					// All the entities above are persisted via Cascade by the save below
					cousineRepository.saveAndFlush(cousine); 
				}
				);
	}
}
