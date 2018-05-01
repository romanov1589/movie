package com.romanov.movie.controller;

import com.romanov.movie.model.Movie;
import com.romanov.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(value = "/movies")
    public List<Movie> getMovies(){
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    @PostMapping(value="/addmovie")
    public void addMovie(@RequestBody @Validated Movie movie){
        movieRepository.save(movie);
    }

    @GetMapping(value="/movies/{id}")
    public Movie getMovie(@PathVariable("id") Integer id){
        return movieRepository.findOne(id);
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public @ResponseBody String index() {
//        return "home";
//    }
}
