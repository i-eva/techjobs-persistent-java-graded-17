package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    private Employer employer;

    // Refactored Skill from String to ArrayList.
    @ManyToMany(fetch = FetchType.EAGER)
    // private List<Skill> skills = new ArrayList<>();
    private List<Skill> skills;


    public Job() {
    }

    // Initialize the id and value fields (anEmployer and someSkills).
    // Removed someSkills parameter to update after refactoring.
    public Job(Employer anEmployer, List<Skill> someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    // Getters and setters. Note: Task instructions want a setter for skills.
    // Chris Bay video demonstrates that we want to set lists to final, and final eliminates need for setter.
    // However, all setSkills methods in rest of code are red and halt the compiler.
    // After removing final, generated setter. setSkills methods now work.

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
