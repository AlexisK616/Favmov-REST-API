package com.favmovie.service;

import com.favmovie.dto.ActorDto;
import com.favmovie.models.Actor;
import com.favmovie.respository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements IActorService{
    @Autowired
    IActorRepository actorRepository;

    @Override
    public List<ActorDto> getAllActor() {
        List<Actor> actorList =  actorRepository.findAll();
        List<ActorDto> actorDtoList = actorList.stream().map(actor -> ActorDto.builder()
                .id(actor.getId())
                .name(actor.getName())
                .age(actor.getAge())
                .img(actor.getImg())
                .build()
        ).collect(Collectors.toList());
        return actorDtoList;
    }

    @Override
    public ActorDto addActor(ActorDto actorDto) {
       Actor actor = actorRepository.findByName(actorDto.getName());
       actorRepository.save(actor);
       return actorDto;
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
