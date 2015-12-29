package com.nayidisha.slowglow.config;

import javax.inject.Inject;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nayidisha.slowglow.domain.PatientAggregate;

@Configuration
public class PatientConfig {

    @Inject
    private EventStore eventStore;

    @Inject
    private EventBus eventBus;

    @Bean(name = "patientAggregateRepository")
    public EventSourcingRepository<PatientAggregate> userAggregateRepository() {

        EventSourcingRepository repository = new EventSourcingRepository<>(PatientAggregate.class, eventStore);
        repository.setEventBus(eventBus);

        return repository;
    }
}
