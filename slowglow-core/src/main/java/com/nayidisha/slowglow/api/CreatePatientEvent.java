package com.nayidisha.slowglow.api;

public class CreatePatientEvent {

    private Long id;
    private String name;

    public CreatePatientEvent(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
