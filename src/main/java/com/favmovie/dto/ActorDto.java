package com.favmovie.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ActorDto implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String img;
}
