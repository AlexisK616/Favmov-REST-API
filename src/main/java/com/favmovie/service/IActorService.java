package com.favmovie.service;

import com.favmovie.dto.ActorDto;

import java.util.List;

public interface IActorService {
    public List<ActorDto> getAllActor();
    public ActorDto addActor(ActorDto actorDto);
    public void deleteActor(Long id);
}
