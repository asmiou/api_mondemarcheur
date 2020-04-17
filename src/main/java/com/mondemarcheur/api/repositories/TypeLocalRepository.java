package com.mondemarcheur.api.repositories;

import com.mondemarcheur.api.entities.TypeLocal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeLocalRepository extends CrudRepository<TypeLocal, Long> {
    /*/users/search/nameStartsWith
    @RestResource(path = "usernameStartsWith", rel = "usernameStartsWith")
    public Page findByUsernameStartsWith(@Param("username") String username, Pageable p);*/
}
