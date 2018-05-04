package com.romanov.movie.controller;

import com.romanov.movie.model.Actor;
import com.romanov.movie.model.Movie;
import com.romanov.movie.repository.ActorRepository;
import com.romanov.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping(value = "/movies")
    public List<Movie> getMovies(){
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    @PostMapping(value="/addmovie")
    public void addMovie(@RequestBody @Validated Movie movie){
        movieRepository.save(movie);
    }

    @DeleteMapping(value="/movies/{id}")
    public void deleteMovie(@PathVariable("id") Integer id){
        movieRepository.deleteMovieById(id);
    }

    @GetMapping(value="/movies/{id}")
    public Movie getMovie(@PathVariable("id") Integer id){
        return movieRepository.findOne(id);
    }

    @PutMapping(value="movies/{id}/{actorId}")
    public void addActorMovie(@PathVariable("id") Integer id, @RequestBody @PathVariable("actorId") Integer actorId){
        Movie movie = movieRepository.findOne(id);
        Actor actor = actorRepository.findOne(actorId);
        movie.getActors().add(actor);
        movieRepository.save(movie);
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public @ResponseBody String index() {
//        return "home";
//    }
}
