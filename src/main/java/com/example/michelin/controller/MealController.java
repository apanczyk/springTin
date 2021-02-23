package com.example.michelin.controller;

import com.example.michelin.model.Meal;
import com.example.michelin.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/meals")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @GetMapping()
    public @ResponseBody Iterable<Meal> getAllMeals(){
        return mealRepository.findAll();
    }

    @PostMapping()
    public @ResponseBody Meal addNewMeal(){
        Meal newMeal = new Meal();
        mealRepository.save(newMeal);
        return newMeal;
    }
}
