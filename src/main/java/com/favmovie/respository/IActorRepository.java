package com.favmovie.respository;

import com.favmovie.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActorRepository extends JpaRepository<Actor,Long> {
    Actor findByName(String name);
}
