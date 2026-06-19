package com.kunal.restaurant.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "orders")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "order_id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	@Column(name = "order_name")
	private String orderName;

	@Column(name = "cuisine")
	private String cuisine;

	@Column(name = "order_price")
	private String orderPrice;
	
}
