package com.mondemarcheur.api.events;

import com.mondemarcheur.api.entities.Local;
import com.mondemarcheur.api.tools.RandomString;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class LocalEventHandler {

    private RandomString randomString;

    @HandleBeforeSave
    public void HandleLocalBeforeSave(Local local){
        local.setReference("loc-"+RandomString.generateReference(6)+"-"+local.getId());
    }
}
