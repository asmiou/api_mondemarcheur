package com.mondemarcheur.api.configuration;

import com.mondemarcheur.api.events.LocalEventHandler;
import com.mondemarcheur.api.events.PaymentEventHandler;
import com.mondemarcheur.api.events.PropertyEventHandler;
import com.mondemarcheur.api.events.ReservationEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventHandlerConfiguration {

    public EventHandlerConfiguration(){
        super();
    }

    @Bean
    LocalEventHandler localEventHandler(){
        return new LocalEventHandler();
    }

    @Bean
    PaymentEventHandler paymentEventHandler(){
        return new PaymentEventHandler();
    }

    @Bean
    PropertyEventHandler propertyEventHandler(){
        return  new PropertyEventHandler();
    }

    @Bean
    ReservationEventHandler reservationEventHandler(){
        return  new ReservationEventHandler();
    }
}
