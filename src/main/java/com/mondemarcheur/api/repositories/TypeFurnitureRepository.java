package com.mondemarcheur.api.repositories;

import com.mondemarcheur.api.entities.TypeFurniture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeFurnitureRepository extends CrudRepository<TypeFurniture, Long> {
    /*/users/search/nameStartsWith
    @RestResource(path = "usernameStartsWith", rel = "usernameStartsWith")
    public Page findByUsernameStartsWith(@Param("username") String username, Pageable p);*/
}
