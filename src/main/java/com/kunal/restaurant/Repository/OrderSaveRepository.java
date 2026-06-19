package com.kunal.restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kunal.restaurant.Entity.OrderEntity;

public interface OrderSaveRepository extends JpaRepository<OrderEntity, Integer>{

}
