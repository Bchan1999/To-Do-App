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
    private Date dateCreated;
    private Date dateDue;

    public ToDo() {
    }

    public ToDo(Date dateDue, Date dateCreated, String description, String header) {
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }
}
