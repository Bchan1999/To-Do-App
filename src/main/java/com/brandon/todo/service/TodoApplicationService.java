package com.brandon.todo.service;

import com.brandon.todo.model.CreateTodoRequest;
import com.brandon.todo.model.ToDo;
import com.brandon.todo.repository.ToDoRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TodoApplicationService {

    private final ToDoRepo toDoRepo;

    public TodoApplicationService(ToDoRepo toDoRepo){
        this.toDoRepo = toDoRepo;
    }

    @Transactional
    public ToDo createTodo(CreateTodoRequest request) {

        if (request.header() == null || request.header().isBlank()){
            throw new IllegalArgumentException("Header cannot be blank");
        }

        ToDo todo = new ToDo();
        todo.setHeader(request.header());
        todo.setDateDue(request.dateDue());
        todo.setDateCreated(request.dateCreated());

        return toDoRepo.save(todo);
    }

}
