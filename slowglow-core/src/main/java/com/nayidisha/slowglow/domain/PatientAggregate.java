package com.nayidisha.slowglow.domain;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import com.nayidisha.slowglow.api.CreatePatientCommand;
import com.nayidisha.slowglow.api.CreatePatientEvent;

public class PatientAggregate extends AbstractAnnotatedAggregateRoot {

    private static final long serialVersionUID = -9049729046077489021L;

    @AggregateIdentifier
    private Long id;

    private String name;

    private int age;

    private Gender gender;

    public PatientAggregate() {
        //Required for Axon
    }

    public PatientAggregate(String name, int age, Gender gender) {
        //log.info("Creating a Patient. Wait... patiently!");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @CommandHandler
    public PatientAggregate(CreatePatientCommand createPatientCommand) {
        apply(new CreatePatientEvent(createPatientCommand.getId(), createPatientCommand.getName()));
    }

    @EventHandler
    public void on(CreatePatientEvent event) {
        this.id = event.getId();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (that == null)
            return false;
        if (getClass() != that.getClass())
            return false;
        PatientAggregate other = (PatientAggregate) that;
        if (age != other.age)
            return false;
        if (gender != other.gender)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Long getId() {
        return id;
    }

}
