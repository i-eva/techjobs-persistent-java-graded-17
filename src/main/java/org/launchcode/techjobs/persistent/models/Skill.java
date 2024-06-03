package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;

@Entity
public class Skill extends AbstractEntity {

private String description;

    public Skill(String description) {
        this(); // must be added for no-arg constructor to work, see below
        this.description = description;
    }

    public Skill() {
        // @Entity requires a no-arg constructor for hibernate to create an object
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
