package com.brandon.todo.model;

public record UpdateTodoRequest(Long id, String header, String description, String dateDue, String dateCreated) {
}
