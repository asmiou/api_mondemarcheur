package com.mondemarcheur.api.events;

import com.mondemarcheur.api.entities.Payment;
import com.mondemarcheur.api.tools.RandomString;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class PaymentEventHandler {
    private RandomString randomString;
    @HandleAfterSave
    public void HandleLocalBeforeSave(Payment payment){
        payment.setReference("pay-"+RandomString.generateReference(6)+"-"+payment.getId());
    }
}
