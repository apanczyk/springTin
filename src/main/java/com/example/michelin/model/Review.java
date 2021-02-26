package com.example.michelin.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rate;
    private Date date;
    private String message;

    @ManyToOne()
    @JoinColumn(name = "meal_id", referencedColumnName = "id")
    private Meal meal;

    @ManyToOne()
    @JoinColumn(name = "visitor_id", referencedColumnName = "id")
    private Visitor visitor;

    public Review(Integer rate, Date date, String message) {
        this.rate = rate;
        this.date = date;
        this.message = message;
    }

    public Review() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }


}
