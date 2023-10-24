package com.bbh.myfoody.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbh.myFoody.entity.Dish;
import com.bbh.myFoody.repository.DishRepository;


@Service
public class DishService {
	
	@Autowired
	private DishRepository dishRepository;
	
	
	//createDish: Saves a new dish to the database.
	public Dish createDish(Dish dish) {
		return dishRepository.save(dish);
	}
	
	//updateDish: Updates an existing dish's information.
	public Dish updateDish(Long dishId, Dish UpdateDish) {
		Optional<Dish> existingDish = Optional.of(dishRepository.getById(dishId));
		if(existingDish.isPresent()) {
			Dish dish = existingDish.get();
			
			dish.setDishName(UpdateDish.getDishName());
			dish.setDishDescription(UpdateDish.getDishDescription());
			dish.setDishprice(UpdateDish.getDishprice());
			
			return dishRepository.save(dish);
		}else {
			return null;
		}
		
	}
	
	//getDishById: Retrieves a dish by its ID.
	public Dish viewDish(Long dishId) {
		return dishRepository.getById(dishId);
	}
	
	
	//getAllDishes: Retrieves a list of all registered dishes.
	public List<Dish> viewAllDish(){
		return dishRepository.findAll();
	}
	
	//deleteDish: Deletes a dish from the database
	public boolean deleteDish(Long dishId) {
		Optional<Dish> dish = Optional.of(dishRepository.getById(dishId));
		if(dish.isPresent()) {
			dishRepository.deleteById(dishId);
			return true;
		}else {
			return false;
		}
	}
	

}
