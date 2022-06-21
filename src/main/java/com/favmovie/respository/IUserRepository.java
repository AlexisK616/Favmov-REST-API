package com.favmovie.respository;

import com.favmovie.models.MOVUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<MOVUser,Long> {
    MOVUser findByUsername(String username);
    Boolean existsByUsername(String username);
}
