package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Long> {
	
	Dish findByDishId(String dishId);
	
	Dish findByDishName(String dishName);

}
