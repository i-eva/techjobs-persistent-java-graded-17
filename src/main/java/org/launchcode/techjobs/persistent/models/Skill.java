package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    private String description;

    @ManyToMany(mappedBy = "skills", fetch = FetchType.EAGER)
    private List<Job> jobs = new ArrayList<>();

    public Skill(String description) {
        this(); // must be added for no-arg constructor to work, see below
        this.description = description;
    }

    public Skill() {
        // @Entity requires a no-arg constructor for hibernate to create an object
    }

    // getters and setters. Note: Task instructions want a setter for skills. Intellij didn't.

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

}
