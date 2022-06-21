package com.favmovie.dto;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class FavoriteDto implements Serializable {
    private List<MovieAndActorDto> movies;
}
