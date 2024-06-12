package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    @NotNull(message = "Please add an employer")
    private Employer employer;


    @ManyToMany
    private final List<Skill> skills = new ArrayList<>();


    public Job() {
    }

    // Initialize the id and value fields.
    public Job(Employer anEmployer) {
        super();
        this.employer = anEmployer;
    }

    // Getters and setters. Note: Task instructions want a setter for skills. Intellij didn't.

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

}
