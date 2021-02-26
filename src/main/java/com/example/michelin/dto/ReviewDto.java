package com.example.michelin.dto;

import java.util.Date;

public class ReviewDto {
    private Integer id;
    private Integer rate;
    private Date date;
    private String message;
    private Integer visitorId;
    private Integer mealId;

    public Integer getId() {
        return id;
    }

    public Integer getRate() {
        return rate;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public Integer getMealId() {
        return mealId;
    }

}
