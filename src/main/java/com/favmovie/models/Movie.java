package com.favmovie.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 150)
    private String name;
    @Lob
    @Column(name = "image")
    private String img;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "fk_movie",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "fk_actor",referencedColumnName = "id"))
    private List<Actor> schedule;

    public Movie(){}
}

