package com.romanov.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = "/")
    public String getIndexPage(){
        return "allMovies";
    }

    @GetMapping(value = "/addmovie")
    public String addMoviePage(){
        return "addMovie";
    }

    @GetMapping(value = "/addactor")
    public String addActorPage(){
        return "addActor";
    }

    @GetMapping(value = "/allactors")
    public String getActorsPage(){
        return "allActors";
    }

    @GetMapping(value="/viewmovie/{id}")
    public String getMoviePage(){
        return "viewMovie";
    }



//    @GetMapping(value = "/allmovies/{id}")
//    public String getMoviePage(){
//        return "oneMovie";
//    }
}
