package com.example.michelin.controller;

import com.example.michelin.model.Review;
import com.example.michelin.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping()
    public @ResponseBody
    Iterable<Review> getReviews(){
        return reviewRepository.findAll();
    }

    @PostMapping()
    public @ResponseBody
    Review createReview(@RequestBody Review newVisitor){
        return reviewRepository.save(newVisitor);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Review getReviewById(@PathVariable Integer id) {
        return reviewRepository.findById(id)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Review updateReview(@PathVariable Integer id, @RequestBody Review updateReview) {
        return reviewRepository.findById(id)
                .map(review -> {
                    review.setRate(updateReview.getRate());
                    review.setDate(updateReview.getDate());
                    review.setMessage(updateReview.getMessage());
                    review.setVisitor(updateReview.getVisitor());
                    review.setMeal(updateReview.getMeal());
                    return reviewRepository.save(review);
                }).orElseGet(() -> {
                    updateReview.setId(id);
                    return reviewRepository.save(updateReview);
                });
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void deleteReview(@PathVariable Integer id) {
        reviewRepository.deleteById(id);
    }
}
