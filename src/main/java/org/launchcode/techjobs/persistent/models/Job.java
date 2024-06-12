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

    // Refactored Skill from String to ArrayList.
    @ManyToMany
    private List<Skill> skills = new ArrayList<>();


    public Job() {
    }

    // Initialize the id and value fields (anEmployer and someSkills).
    // Removed someSkills parameter to update after refactoring.
    public Job(Employer anEmployer) {
        super();
        this.employer = anEmployer;
    }

    // Getters and setters. Note: Task instructions want a setter for skills.
    // Chris Bay video demonstrates that we want to set lists to final, and final eliminates need for setter.
    // However, all setSkills methods in rest of code are red and halt the compiler.
    // After removing final, generated setter.

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
