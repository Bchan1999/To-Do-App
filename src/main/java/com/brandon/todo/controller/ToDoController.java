package com.brandon.todo.controller;

import com.brandon.todo.excpetion.ToDoNotFoundException;
import com.brandon.todo.model.CreateTodoRequest;
import com.brandon.todo.model.ToDo;
import com.brandon.todo.repository.ToDoRepo;
import com.brandon.todo.service.TodoApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//provides hints to people reading code, stereotype annotation
@RestController
public class ToDoController {

    private final ToDoRepo repo;

    private final TodoApplicationService todoApplicationService;

    public ToDoController(ToDoRepo repo, TodoApplicationService todoApplicationService) {
        this.repo = repo;
        this.todoApplicationService = todoApplicationService;
    }

    //routing info
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/todo")
    public List<ToDo> all(){
        return repo.findAll();
    }

    @GetMapping("/todo/{id}")
    public ToDo getItem(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new ToDoNotFoundException(id));
    }

    @PostMapping("/todo")
    public ToDo newTodo(@RequestBody CreateTodoRequest newTodo) {
        return todoApplicationService.createTodo(newTodo);
    }

    @PutMapping("/todo/{id}")
    public ToDo editHeader(@RequestBody String newHeader, @PathVariable Long id) {
       return repo.findById(id)
               .map(todo -> {
                   todo.setHeader(newHeader);
                   return repo.save(todo);
               })
               .orElseThrow(() -> new ToDoNotFoundException(id));
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable Long id){
        repo.deleteById(id);
    }
}
