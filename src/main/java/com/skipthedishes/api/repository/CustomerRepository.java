package com.skipthedishes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skipthedishes.api.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
