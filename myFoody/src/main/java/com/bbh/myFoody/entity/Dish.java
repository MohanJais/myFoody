package com.bbh.myFoody.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dishId;
	private String dishName;
	private String dishDescription;
	private double dishprice;

	@ManyToOne
	@JoinColumn(name = "restaurantId")
	private Restaurant restaurant;

	public Dish() {
	}


	public Dish(Long dishId, String dishName, String dishDescription, double dishprice, Restaurant restaurant) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.dishDescription = dishDescription;
		this.dishprice = dishprice;
		this.restaurant = restaurant;
	}


	public Long getDishId() {
		return dishId;
	}

	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishDescription() {
		return dishDescription;
	}

	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}

	public double getDishprice() {
		return dishprice;
	}

	public void setDishprice(double dishprice) {
		this.dishprice = dishprice;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", dishDescription=" + dishDescription
				+ ", dishprice=" + dishprice + ", restaurant=" + restaurant + "]";
	}



}
