package com.favmovie.respository;

import com.favmovie.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {
    Movie findByName(String name);
}
