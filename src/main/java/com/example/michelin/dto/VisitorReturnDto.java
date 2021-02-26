package com.example.michelin.dto;

import com.example.michelin.model.Review;

import java.util.Set;

public class VisitorReturnDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Set<Review> reviews;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Review> getReviews() {
        return reviews;
    }
}
