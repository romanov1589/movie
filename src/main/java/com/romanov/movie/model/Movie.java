package com.romanov.movie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    private int id;
    @NotNull
    @Size(min = 1, message = "Title must not be empty")
    private String title;
    @NotNull
    @Size(min = 1, max = 40, message = "Description must not be empty")
    private String shortDescription;
    @NotNull
    private String ageRating;
    @NotNull
    private String runningTime;
    @NotNull
    private String releaseDate;
    @NotNull
    private String genre;
    @NotNull
    private String director;
    private Set<Actor> actors = new HashSet<>();

    public Movie(String title, String shortDescription, String ageRating, String runningTime,
                 String releaseDate, String genre, String director) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.ageRating = ageRating;
        this.runningTime = runningTime;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.director = director;
    }

    public Movie() {
    }

    @Id
    @GeneratedValue
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

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "movie_actor",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "actorId")}
    )
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

}
