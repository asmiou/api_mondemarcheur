package com.mondemarcheur.api.repositories;

import com.mondemarcheur.api.entities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<Rate, Long> {
    /*/users/search/nameStartsWith
    @RestResource(path = "usernameStartsWith", rel = "usernameStartsWith")
    public Page findByUsernameStartsWith(@Param("username") String username, Pageable p);*/
}
