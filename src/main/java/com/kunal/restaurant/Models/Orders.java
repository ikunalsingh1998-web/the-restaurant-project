package com.kunal.restaurant.Models;

public class Orders {

	int mealId;
	int mealCount;
	String mealName;
	String mealPrice;

	public Orders(int orderId, int mealId, int mealCount, String mealName, String mealPrice) {
		super();
		this.orderId = orderId;
		this.mealId = mealId;
		this.mealCount = mealCount;
		this.mealName = mealName;
		this.mealPrice = mealPrice;
	}

	int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public int getMealCount() {
		return mealCount;
	}

	public void setMealCount(int mealCount) {
		this.mealCount = mealCount;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getMealPrice() {
		return mealPrice;
	}

	public void setMealPrice(String mealPrice) {
		this.mealPrice = mealPrice;
	}

}
