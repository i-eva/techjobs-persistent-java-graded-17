package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Employer is required")
    @Size(min = 3, max = 255, message = "Employer must be between 3 and 255 characters")
    private String name;

    @NotBlank(message = "Location is required")
    @Size(min = 3, max = 255, message = "Location must be between 3 and 255 characters")
    private String location;

    public Employer(String name, String location) {
        this(); // must be added for no-arg constructor to work, see below
        this.name = name;
        this.location = location;
    }

    public Employer() {
        // @Entity requires a no-arg constructor for hibernate to create an object
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return name;
    }

}
