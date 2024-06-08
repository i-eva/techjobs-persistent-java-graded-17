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

    @OneToMany(mappedBy = "employer")
    @JoinColumn(name = "id")
    private List<Job> jobs;

    public Employer(String location) {
        this(); // must be added for no-arg constructor to work, see below
        this.location = location;
        this.jobs = new ArrayList<>();
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
