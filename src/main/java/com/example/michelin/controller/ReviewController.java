package com.example.michelin.controller;

import com.example.michelin.model.Review;
import com.example.michelin.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping()
    public @ResponseBody
    Iterable<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    @PostMapping()
    public @ResponseBody Review addNewReview(){
        Review newMeal = new Review();
        reviewRepository.save(newMeal);
        return newMeal;
    }
}
