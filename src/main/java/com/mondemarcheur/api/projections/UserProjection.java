package com.mondemarcheur.api.projections;

import com.mondemarcheur.api.entities.Identity;
import com.mondemarcheur.api.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(
        name = "customUser",
        types = { User.class })
public interface UserProjection {
    @Value("#{target.id}")
    long getId();

    String getUsername();
    String getEmail();
    String getRoles();
    Boolean getIsActive();
    Identity getIdentity();
}
