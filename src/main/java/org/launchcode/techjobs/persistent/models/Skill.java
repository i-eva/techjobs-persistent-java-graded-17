package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;git s

@Entity
public class Skill extends AbstractEntity {

    private String competency;

    private String description;

    public Skill(String competency, String description) {
        this(); // must be added for no-arg constructor to work, see below
        this.competency = competency;
        this.description = description;
    }

    public Skill() {
        // @Entity requires a no-arg constructor for hibernate to create an object
    }

    public String getCompetency() {
        return competency;
    }

//    public void setCompetency(String competency) {
//        this.competency = competency;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return competency;
    }

}
