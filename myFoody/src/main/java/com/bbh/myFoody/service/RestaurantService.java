package com.bbh.myFoody.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbh.myFoody.entity.Restaurant;
import com.bbh.myFoody.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	//Create
	public Restaurant createRestaurant(Restaurant updateRestaurant) {
		
		// Boolean restaurant = restaurantRepository.getById(restaurantId);
		
		return restaurantRepository.save(updateRestaurant);
		
	}
	
	//Update
	public Restaurant updateRestaurant ( Long restaurantId, Restaurant updateRestaurant){
		
		Optional<Restaurant> existRestaurant = Optional.of(restaurantRepository.getById(restaurantId));
		
		if(existRestaurant.isPresent()) {
			Restaurant restaurant = existRestaurant.get();
			restaurant.setRestaurantName(updateRestaurant.getRestaurantName());
			restaurant.setEmailRestaurant(updateRestaurant.getEmailRestaurant());
			restaurant.setRestaurantAddress(updateRestaurant.getRestaurantAddress());
			
			return restaurantRepository.save(restaurant);
		}else {
			return null;
		}
		 
	}
	
	
	//GetById
	public Restaurant viewRestaurant(Long restaurantId){
		
		return restaurantRepository.getById(restaurantId);
		
	}

	//GetAll
	public List<Restaurant> viewAllRestaurant() {
		
		return restaurantRepository.findAll();
	}
	
	//Delete
	public boolean deleteRestaurant(Long restaurantId) {
		
		Optional<Restaurant> existRestaurant = Optional.of(restaurantRepository.getById(restaurantId));
		if(existRestaurant.isPresent()) {
			restaurantRepository.deleteById(restaurantId);
			return true;	
		}else {
			return false;
		}
		
	}
	
}
