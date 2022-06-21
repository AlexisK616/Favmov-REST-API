package com.favmovie.controller;

import com.favmovie.dto.MovieAndActorDto;
import com.favmovie.dto.MovieDto;
import com.favmovie.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieServiceImpl movieServiceImpl;


    @PostMapping("/movies/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieDto movieDto) throws IOException {
        movieServiceImpl.addMovie(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Resource added");
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieAndActorDto>> getAllMovies(){
        return ResponseEntity.ok(movieServiceImpl.getAllMovies());
    }

    @DeleteMapping("/movies/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id){
        movieServiceImpl.deleteMovie(id);
        return ResponseEntity.ok("Resource delete successfully");
    }
}
