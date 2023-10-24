package com.bbh.myFoody.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbh.myFoody.entity.Restaurant;
import com.bbh.myFoody.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	//Create
	@PostMapping("/register")
	public ResponseEntity<Restaurant> registerRestaurant(@RequestBody Restaurant restaurant){
		
		return new ResponseEntity<> (restaurantService.createRestaurant(restaurant),HttpStatus.CREATED);
	}
	
	//Update
	@PutMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> updateRestaurant (
			@PathVariable Long restaurantId, 
			@RequestBody Restaurant updateRestaurant){	
		
		return new ResponseEntity<> (restaurantService.updateRestaurant(restaurantId, updateRestaurant), HttpStatus.OK);
	}


	//GetById
	@GetMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> viewRestaurant(@PathVariable Long restaurantId){
		
		return new ResponseEntity<> (restaurantService.viewRestaurant(restaurantId),HttpStatus.OK);
	}
	
	//GetAll
	@GetMapping("/")
	public ResponseEntity<List<Restaurant>> viewAllRestaurant(){
		return new ResponseEntity<>(restaurantService.viewAllRestaurant(), HttpStatus.OK);
		
	}
	
	//Delete
	@DeleteMapping("/restaurantId")
 	public ResponseEntity<Restaurant> deleteRestaurant (@PathVariable Long restaurantId){
		
		boolean success = restaurantService.deleteRestaurant(restaurantId);
		if(success) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
