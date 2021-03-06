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
    public String getAddMoviePage(){
        return "addMovie";
    }

    @GetMapping(value = "/addactor")
    public String getAddActorPage(){
        return "addActor";
    }

}
