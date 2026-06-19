package com.kunal.restaurant.Models;

import java.util.List;

public class UserResponseModel {

	int clientID;
	String clientName;
	String clientGender;
	String clientEmailId;
	String clientPassword;
	String clientMobileNumber;
	String clientAddress;
	List<Orders> clientOrders;

	public UserResponseModel(int clientID, String clientName, String clientGender, String clientEmailId,
			String clientPassword, String clientMobileNumber, String clientAddress, List<Orders> clientOrders) {
		super();
		this.clientID = clientID;
		this.clientName = clientName;
		this.clientGender = clientGender;
		this.clientEmailId = clientEmailId;
		this.clientPassword = clientPassword;
		this.clientMobileNumber = clientMobileNumber;
		this.clientAddress = clientAddress;
		this.clientOrders = clientOrders;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientGender() {
		return clientGender;
	}

	public void setClientGender(String clientGender) {
		this.clientGender = clientGender;
	}

	public String getClientEmailId() {
		return clientEmailId;
	}

	public void setClientEmailId(String clientEmailId) {
		this.clientEmailId = clientEmailId;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public String getClientMobileNumber() {
		return clientMobileNumber;
	}

	public void setClientMobileNumber(String clientMobileNumber) {
		this.clientMobileNumber = clientMobileNumber;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public List<Orders> getClientOrders() {
		return clientOrders;
	}

	public void setClientOrders(List<Orders> clientOrders) {
		this.clientOrders = clientOrders;
	}

}
