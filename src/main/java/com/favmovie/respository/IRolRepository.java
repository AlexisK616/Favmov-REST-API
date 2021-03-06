package com.favmovie.respository;

import com.favmovie.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findByName(String name);
}
