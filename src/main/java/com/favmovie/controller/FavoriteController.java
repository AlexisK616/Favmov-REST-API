package com.favmovie.controller;

import com.favmovie.dto.FavoriteDto;
import com.favmovie.service.FavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FavoriteController {

    @Autowired
    FavoriteServiceImpl favoriteServiceImpl;

    @GetMapping("/favorites")
    public ResponseEntity<FavoriteDto> getFavoritesMovies(){
        return ResponseEntity.ok(favoriteServiceImpl.getFavoriteMovies());
    }

    @PostMapping(value = "/favorites/add",params = "movie")
    public ResponseEntity<?> addMovieFavorite(@RequestParam("movie") String movieName){
        favoriteServiceImpl.addMovieFavorite(movieName);
        return ResponseEntity.ok("Resource Added");
    }

    @DeleteMapping("/favorites/delete/{id}")
    public ResponseEntity<?> deleteMovieFavorite(@PathVariable("id") Long id){
        favoriteServiceImpl.deleteMovieFavorite(id);
        return ResponseEntity.ok("Delete Successfully");
    }
}
