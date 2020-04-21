package com.mondemarcheur.api.configuration;

import com.mondemarcheur.api.events.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventHandlerConfiguration {

    public EventHandlerConfiguration(){
        super();
    }

    /*
    @Bean
    UserEventHandler UserEventHandler(){
        return new UserEventHandler();
    }*/

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
