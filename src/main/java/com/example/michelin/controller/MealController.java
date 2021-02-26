package com.example.michelin.controller;

import com.example.michelin.dto.MealReturnDto;
import com.example.michelin.model.Meal;
import com.example.michelin.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Meal createMeal(@RequestBody Meal newMeal){
        return mealRepository.save(newMeal);
    }

    @GetMapping("/{id}")
    public MealReturnDto getMealById(@PathVariable Integer id) {
        MealReturnDto returnMeal = new MealReturnDto();
        return mealRepository.findById(id).map(meal -> {
            returnMeal.setId(meal.getId());
            returnMeal.setName(meal.getName());
            returnMeal.setDescription(meal.getDescription());
            returnMeal.setReviews(meal.getReviews());
            return returnMeal;
        }).orElseThrow();
    }

    @PutMapping("/{id}")
    public Meal updateMeal(@PathVariable Integer id, @RequestBody Meal updateMeal) {
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
    public void deleteMeal(@PathVariable Integer id) {
        mealRepository.deleteById(id);
    }
}
