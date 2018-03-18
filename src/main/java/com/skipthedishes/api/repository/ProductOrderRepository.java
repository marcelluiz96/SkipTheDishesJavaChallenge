package com.skipthedishes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skipthedishes.api.model.OrderItem;

public interface ProductOrderRepository extends JpaRepository<OrderItem, Long>{

}
