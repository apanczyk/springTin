package com.example.michelin.controller;

import com.example.michelin.dto.ReviewDto;
import com.example.michelin.model.Review;
import com.example.michelin.repository.MealRepository;
import com.example.michelin.repository.ReviewRepository;
import com.example.michelin.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private VisitorRepository visitorRepository;

    @GetMapping()
    public @ResponseBody
    List<Review> getReviews(){
        return reviewRepository.findAll();
    }

    @PostMapping()
    public Review createReview(@RequestBody ReviewDto newReview){
        Review review = new Review(newReview.getRate(), newReview.getDate(), newReview.getMessage());
        return visitorRepository.findById(newReview.getVisitorId()).map(visitor -> {
            review.setVisitor(visitor);
            return mealRepository.findById(newReview.getMealId()).map(meal -> {
                review.setMeal(meal);
                return reviewRepository.save(review);
            }).orElseThrow(() -> new RuntimeException());
        }).orElseThrow(() -> new RuntimeException());
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Integer id) {
        return reviewRepository.findById(id)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Integer id, @RequestBody ReviewDto updateReview) {
        return reviewRepository.findById(id)
                .map(review -> {
                    review.setRate(updateReview.getRate());
                    review.setDate(updateReview.getDate());
                    review.setMessage(updateReview.getMessage());
                    return mealRepository.findById(updateReview.getMealId()).map(meal -> {
                        review.setMeal(meal);
                        return visitorRepository.findById(updateReview.getVisitorId()).map(visitor -> {
                            review.setVisitor(visitor);
                            return reviewRepository.save(review);
                        }).orElseThrow();
                    }).orElseThrow();
                }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Integer id) {
        reviewRepository.deleteById(id);
    }
}
