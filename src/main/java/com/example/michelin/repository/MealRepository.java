package com.example.michelin.repository;

import com.example.michelin.model.Meal;
import org.springframework.data.repository.CrudRepository;

public interface MealRepository extends CrudRepository<Meal, Integer> {
}
