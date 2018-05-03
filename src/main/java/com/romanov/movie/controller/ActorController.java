package com.romanov.movie.controller;

import com.romanov.movie.model.Actor;
import com.romanov.movie.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @PostMapping(value="/addactor")
    public void addActor(@RequestBody @Validated Actor actor){
        actorRepository.save(actor);
    }
}
