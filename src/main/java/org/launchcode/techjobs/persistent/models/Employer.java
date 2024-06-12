package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Location is required")
    @Size(min = 3, max = 255, message = "Location must be between 3 and 255 characters")
    private String location;

    @OneToMany
    @JoinColumn(name = "employer_id")
    private final List<Job> jobs = new ArrayList<>();

    public Employer(String location) {
        this(); // must be added for no-arg constructor to work, see below
        this.location = location;
    }

    public Employer() {
        // @Entity requires a no-arg constructor for hibernate to create an object
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    @Override
    public String toString() {
        return location;
    }
}
