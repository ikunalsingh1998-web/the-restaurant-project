package com.kunal.restaurant.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kunal.restaurant.Configuration.CustomDateTimeDeserializer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_details")
//@NamedQuery(name = "user_info.findAll", query = "SELECT s FROM UserSaveRepository s")
public class UserSaveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "client_id", updatable = false, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer clientId;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "client_gender")
	private String clientGender;

	@Column(name = "client_email_id")
	private String clientEmailId;

	@Column(name = "client_password")
	private String clientPassword;

	@Column(name = "client_mobile_number")
	private String clientMobileNumber;

	@Column(name = "client_address")
	private String clientAddress;

	@Column(name = "created_on")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@JsonDeserialize(using= CustomDateTimeDeserializer.class)
    private Timestamp createdOn;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="order_id")
	//private OrderEntity orders;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="client_id", referencedColumnName = "client_id")
	private List<OrderEntity> orders;
	
	
}
