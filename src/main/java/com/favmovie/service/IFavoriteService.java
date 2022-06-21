package com.favmovie.service;


import com.favmovie.dto.FavoriteDto;

public interface IFavoriteService {
     FavoriteDto getFavoriteMovies();
     FavoriteDto addMovieFavorite(String movie);
     void deleteMovieFavorite(Long id);
}
