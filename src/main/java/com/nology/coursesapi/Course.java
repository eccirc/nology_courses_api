package com.nology.coursesapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String locations;
    private int durationWeeks;
    private double price;
    private String summary;

    public Course(String courseName, String locations, int durationWeeks, double price, String summary) {
        this.courseName = courseName;
        this.locations = locations;
        this.durationWeeks = durationWeeks;
        this.price = price;
        this.summary = summary;
    }

    public Course(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }

    public void setDurationWeeks(int durationWeeks) {
        this.durationWeeks = durationWeeks;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    @Override
    public String toString() {
        String format = "{ id: %s, courseName: %s, locations: %s,  duration: %s, price: %s, summary: %s}";
        return String.format(format, id, courseName, locations, durationWeeks, price, summary);
    }
}
