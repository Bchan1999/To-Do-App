package com.brandon.todo.service;

import com.brandon.todo.excpetion.ToDoNotFoundException;
import com.brandon.todo.model.CreateTodoRequest;
import com.brandon.todo.model.ToDo;
import com.brandon.todo.model.UpdateTodoRequest;
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
        todo.setDescription(request.description());
        todo.setDateDue(request.dateDue());
        todo.setDateCreated(request.dateCreated());

        return toDoRepo.save(todo);
    }

    @Transactional
    public ToDo updateTodo(Long id, UpdateTodoRequest request) {
        return toDoRepo.findById(id)
                .map(todo -> {
                    todo.setId(id);
                    if (request.header() != null){
                        todo.setHeader(request.header());
                    }
                    if (request.description() != null){
                        todo.setDescription(request.description());
                    }
                    todo.setDateCreated(request.dateCreated());
                    if (request.dateDue() != null){
                        todo.setDateDue(request.dateDue());
                    }
                    return toDoRepo.save(todo);
                })
                .orElseThrow(() -> new ToDoNotFoundException(id));
    }


}
