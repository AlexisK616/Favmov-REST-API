package com.favmovie.service;

import com.favmovie.dto.ActorDto;
import com.favmovie.dto.FavoriteDto;
import com.favmovie.dto.MovieAndActorDto;
import com.favmovie.models.MOVUser;
import com.favmovie.models.Favorite;
import com.favmovie.models.Movie;
import com.favmovie.respository.IFavoriteRepository;
import com.favmovie.respository.IMovieRepository;
import com.favmovie.util.SecurityUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements IFavoriteService {

    @Autowired
    SecurityUserContext securityUserContext;

    @Autowired
    IMovieRepository movieRepository;

    @Autowired
    IFavoriteRepository favoriteRepository;


    @Override
    public FavoriteDto getFavoriteMovies() {
        MOVUser user = securityUserContext.getUserByContext();
        Favorite favorite = favoriteRepository.findByUser(user);
        List<Movie> movie = favorite.getMovie();
        List<MovieAndActorDto> moviesDto = movie.stream().map(m -> MovieAndActorDto.builder().id(m.getId())
                .name(m.getName())
                .img(m.getImg())
                .schedule(m.getSchedule().stream()
                        .map(actor -> ActorDto.builder().id(actor.getId()).name(actor.getName())
                                .age(actor.getAge())
                                .img(actor.getImg())
                                .build()).collect(Collectors.toList())).build()).collect(Collectors.toList());
        FavoriteDto favoriteDto = FavoriteDto.builder().movies(moviesDto).build();
        return favoriteDto;
    }

    @Override
    public FavoriteDto addMovieFavorite(String movieName) {
        Movie movie = movieRepository.findByName(movieName);
        MOVUser user = securityUserContext.getUserByContext();
        Favorite favorite = favoriteRepository.findByUser(user);
        favorite.getMovie().add(movie);
        favoriteRepository.save(favorite);
        FavoriteDto favoriteDto = FavoriteDto
                .builder().movies(favorite.getMovie().stream()
                        .map(m -> MovieAndActorDto.builder().id(m.getId()).name(m.getName()).img(m.getImg())
                                .schedule(m.getSchedule().stream()
                                        .map(actor -> ActorDto.builder().id(actor.getId()).name(actor.getName())
                                                .age(actor.getAge())
                                                .img(actor.getImg())
                                                .build()).collect(Collectors.toList())).build())
                        .collect(Collectors.toList())).build();
        return favoriteDto;
    }

    @Override
    public void deleteMovieFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }
}
