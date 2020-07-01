package com.mondemarcheur.api.projections;

import com.mondemarcheur.api.entities.Local;
import org.springframework.data.rest.core.config.Projection;

@Projection(
        name = "customApartment",
        types = { Local.class })
public interface ApartmentProjection {
}
