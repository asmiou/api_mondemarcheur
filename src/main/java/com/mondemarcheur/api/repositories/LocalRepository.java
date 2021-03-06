package com.mondemarcheur.api.repositories;

import com.mondemarcheur.api.entities.Local;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends CrudRepository<Local, Long> {
    /*/users/search/nameStartsWith
    @RestResource(path = "usernameStartsWith", rel = "usernameStartsWith")
    public Page findByUsernameStartsWith(@Param("username") String username, Pageable p);*/
}
