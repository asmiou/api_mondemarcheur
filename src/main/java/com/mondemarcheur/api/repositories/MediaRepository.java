package com.mondemarcheur.api.repositories;

import com.mondemarcheur.api.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    /*/users/search/nameStartsWith
    @RestResource(path = "usernameStartsWith", rel = "usernameStartsWith")
    public Page findByUsernameStartsWith(@Param("username") String username, Pageable p);*/
}
