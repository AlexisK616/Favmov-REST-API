package com.favmovie.respository;

import com.favmovie.models.MOVUser;
import com.favmovie.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite,Long> {
    Favorite findByUser(MOVUser user);
}
