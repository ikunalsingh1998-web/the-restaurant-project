package com.kunal.restaurant.Services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunal.restaurant.Entity.OrderEntity;
import com.kunal.restaurant.Repository.OrderSaveRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderSaveRepository orderSaveRepository;
	
	public OrderEntity saveOrders(OrderEntity orderEntity) throws SQLException {

		return orderSaveRepository.save(orderEntity);

	}

}
