package com.favmovie.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Integer age;
    @Lob
    @Column(name = "image")
    private String img;

    @ManyToMany(mappedBy = "schedule")
    private List<Movie> movies;

}
