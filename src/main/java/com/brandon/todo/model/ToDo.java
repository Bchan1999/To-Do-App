package com.brandon.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//This is a JPA entity
//This is what H2 will use to create a table from
@Entity
public class ToDo {
    @Id
    @GeneratedValue
    private Long id;
    private String dateCreated;
    private String dateDue;
    private String description;
    private String header;

    public ToDo() {
    }

    public ToDo(Long id,String dateCreated, String dateDue, String description, String header) {
        this.id = id;
        this.dateDue = dateDue;
        this.dateCreated = dateCreated;
        this.description = description;
        this.header = header;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateDue() {
        return dateDue;
    }

    public void setDateDue(String dateDue) {
        this.dateDue = dateDue;
    }
}
