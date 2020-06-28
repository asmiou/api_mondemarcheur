package com.mondemarcheur.api.repositories;

import com.mondemarcheur.api.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository()
public interface UserRepository extends CrudRepository<User, Long> {

    @RestResource(path = "usernameStartsWith", rel = "usernameStartsWith")
    Page findByUsernameStartsWith(@Param("username") String username, Pageable p);

    @Query(value="select u from User u where u.isActive = true and (u.email = ?1 or u.username = ?1 )")
    Optional<User> loginQuery(String username);

    @Query(value="select u from User u where u.isActive = true and (u.email = ?1 or u.username = ?1 )")
    User userLoginQuery(String username);

    User findByUsername(String username);
}
