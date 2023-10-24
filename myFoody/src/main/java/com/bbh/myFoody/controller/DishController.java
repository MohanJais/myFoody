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

import com.bbh.foody.entity.Dish;
import com.bbh.foody.service.DishService;

@RestController
@RequestMapping("/dishes")
public class DishController {
	
	@Autowired
	private DishService dishService;
	
	
	//Create
	@PostMapping("/")
	public ResponseEntity<Dish> createDish(@RequestBody Dish dish){
		return new ResponseEntity(dishService.createDish(dish), HttpStatus.CREATED);
	}
	
	//Update
	@PutMapping("/{dishId}")
	public ResponseEntity<Dish> updateDish(
			@PathVariable Long dishId,
			@RequestBody Dish dish
			){
		return new ResponseEntity<Dish>(dishService.updateDish(dishId, dish), HttpStatus.OK);
	}
	
	//View
	@GetMapping("/{dishId}")
	public ResponseEntity<Dish> viewDish(@PathVariable Long dishId){
		return new ResponseEntity<Dish>(dishService.viewDish(dishId), HttpStatus.OK);
	}
	
	//ViewAll
	@GetMapping("/")
	public ResponseEntity<List<Dish>> viewAllDish(){
		
		return new ResponseEntity<List<Dish>>(dishService.viewAllDish(), HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping
	public ResponseEntity<Void> deleteDish(@PathVariable Long dishId){
		boolean success = dishService.deleteDish(dishId);
		if(success) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
