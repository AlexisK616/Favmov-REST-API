package com.favmovie.service;

import com.favmovie.dto.MovieAndActorDto;
import com.favmovie.dto.MovieDto;
import java.io.IOException;
import java.util.List;

public interface IMovieService {
    public MovieDto addMovie(MovieDto movie) throws IOException;
    public List<MovieAndActorDto> getAllMovies();
    public void deleteMovie(Long id);
}
