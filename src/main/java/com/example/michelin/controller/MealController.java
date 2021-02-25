package com.example.michelin.controller;

import com.example.michelin.model.Meal;
import com.example.michelin.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/meals")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @GetMapping()
    public List<Meal> getMeals(){
        return mealRepository.findAll();
    }

    @PostMapping()
    public @ResponseBody
    Meal createMeal(@RequestBody Meal newMeal){
        return mealRepository.save(newMeal);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Meal getMealById(@PathVariable Integer id) {
        return mealRepository.findById(id)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Meal updateMeal(@PathVariable Integer id, @RequestBody Meal updateMeal) {
        return mealRepository.findById(id)
                .map(meal -> {
                    meal.setName(updateMeal.getName());
                    meal.setDescription(updateMeal.getDescription());
                    return mealRepository.save(meal);
                }).orElseGet(() -> {
                    updateMeal.setId(id);
                    return mealRepository.save(updateMeal);
                });
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void deleteMeal(@PathVariable Integer id) {
        mealRepository.deleteById(id);
    }
}
