package com.brandon.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class ToDo {

    private @Id
    @GeneratedValue Long id;
    private String header;
    private String description;
    private String dateCreated;
    private String dateDue;

    public ToDo() {
    }

    public ToDo(String dateDue, String dateCreated, String description, String header) {
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
