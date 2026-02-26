package com.brandon.todo.model;

public record CreateTodoRequest(String header, String description, String dateDue, String dateCreated) {}
