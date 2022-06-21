package com.favmovie.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.favmovie.models.Actor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class MovieDto implements Serializable {
    private String name;
    private String img;
    private List<String> actorNames;
}
