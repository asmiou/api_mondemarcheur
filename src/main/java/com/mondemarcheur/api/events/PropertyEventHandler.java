package com.mondemarcheur.api.events;

import com.mondemarcheur.api.entities.Property;
import com.mondemarcheur.api.tools.RandomString;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class PropertyEventHandler {

    private RandomString randomString;

    @HandleBeforeSave
    public void HandleLocalBeforeSave(Property property){
        property.setReference("ppt-"+RandomString.generateReference(6)+"-"+property.getId());
    }
}
