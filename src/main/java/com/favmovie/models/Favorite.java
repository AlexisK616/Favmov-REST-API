package com.favmovie.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "favorite")
@Data
public class Favorite{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private MOVUser user;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "favorite_movie",
            joinColumns = @JoinColumn(name = "fk_favorite",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "fk_movie",referencedColumnName = "id"))
    private List<Movie> movie;
}
