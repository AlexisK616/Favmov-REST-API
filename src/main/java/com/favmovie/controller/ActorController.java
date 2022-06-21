package com.favmovie.controller;

import com.favmovie.dto.ActorDto;
import com.favmovie.service.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActorController {

    @Autowired
    ActorServiceImpl actorService;

    @GetMapping("/actor")
    public ResponseEntity<List<ActorDto>> getAllActor(){
        return ResponseEntity.ok(actorService.getAllActor());
    }

    @PostMapping("/actor/add")
    public ResponseEntity<String> addActor(@RequestBody ActorDto actorDto){
        actorService.addActor(actorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Resourse Added succesfully");
    }

    @DeleteMapping(value = "/actor/delete",params = "id")
    public ResponseEntity<String> deleteActor(@RequestParam("id")Long id){
        actorService.deleteActor(id);
        return ResponseEntity.ok("Resource delete successfully");
    }
}
