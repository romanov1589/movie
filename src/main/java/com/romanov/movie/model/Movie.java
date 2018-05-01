package com.romanov.movie.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @Size(min = 1, message = "Title must not be empty")
    private String title;
    @NotNull
    @Size(min = 1, max = 40, message = "Description must not be empty")
    private String shortDescription;
    private String ageRating;

    public Movie(String title, String shortDescription, String ageRating) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.ageRating = ageRating;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }
}
