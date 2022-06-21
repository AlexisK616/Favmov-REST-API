package com.favmovie.service;

import com.favmovie.dto.ActorDto;
import com.favmovie.dto.MovieAndActorDto;
import com.favmovie.dto.MovieDto;
import com.favmovie.models.Actor;
import com.favmovie.models.Movie;
import com.favmovie.respository.IActorRepository;
import com.favmovie.respository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService {
    @Autowired
    IMovieRepository movieRepository;

    @Autowired
    IActorRepository actorRepository;

    @Override
    public MovieDto addMovie(MovieDto movieDto) throws IOException {
        List<String> namesActor = movieDto.getActorNames();
        List<Actor> actors = new ArrayList<>();
        for (String name : namesActor) {
            actors.add(actorRepository.findByName(name));
        }
        Movie movie = Movie.builder().name(movieDto.getName()).img(movieDto.getImg()).schedule(actors).build();
        movieRepository.save(movie);
        return movieDto;
    }

    @Override
    public List<MovieAndActorDto> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieAndActorDto> moviesDto = movies.stream()
                .map(m -> MovieAndActorDto.builder()
                        .id(m.getId())
                        .name(m.getName())
                        .schedule(m.getSchedule()
                                .stream().map(a -> ActorDto.builder()
                                        .id(a.getId())
                                        .name(a.getName())
                                        .age(a.getAge())
                                        .img(a.getImg())
                                        .build())
                                .collect(Collectors.toList())
                        )
                        .img(m.getImg())
                        .build())
                .collect(Collectors.toList());
        return moviesDto;
    }

    @Override
    public void deleteMovie(Long id) {
      Movie movie =  movieRepository.getById(id);
      actorRepository.deleteAllById(movie.getSchedule().stream()
              .map(actor -> actorRepository.getById(
                      actor.getId()).getId())
              .collect(Collectors.toList()));
      movieRepository.deleteById(id);
    }


}

