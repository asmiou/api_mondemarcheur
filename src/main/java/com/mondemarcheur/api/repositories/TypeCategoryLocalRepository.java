package com.mondemarcheur.api.repositories;

import com.mondemarcheur.api.entities.TypeCategoryLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCategoryLocalRepository extends JpaRepository<TypeCategoryLocal, Long> {
    /*/users/search/nameStartsWith
    @RestResource(path = "usernameStartsWith", rel = "usernameStartsWith")
    public Page findByUsernameStartsWith(@Param("username") String username, Pageable p);*/
}