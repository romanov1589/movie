package com.romanov.movie.repository;

import com.romanov.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Transactional
    void deleteMovieById(Integer id);
}
