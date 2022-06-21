package com.favmovie.dto;

import com.favmovie.models.Actor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class MovieAndActorDto implements Serializable {
    private Long id;
    private String name;
    private String img;
    private List<ActorDto> schedule;
}
