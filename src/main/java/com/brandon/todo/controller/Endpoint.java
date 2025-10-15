package com.brandon.todo.controller;

import com.brandon.todo.excpetion.ToDoNotFoundException;
import com.brandon.todo.model.ToDo;
import com.brandon.todo.repository.ToDoRepo;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;

//provides hints to people reading code, stereotype annotation
@RestController
public class Endpoint {

    private final ToDoRepo repo;

    public Endpoint(ToDoRepo repo) {
        this.repo = repo;
    }

    //routing info
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/")
    String home() {
        return "Hello World";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/todo")
    List<ToDo> all(){
        return repo.findAll();
    }

    @GetMapping("/todo/{id}")
    ToDo getItem(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new ToDoNotFoundException(id));
    }

    @PostMapping("/todo")
    ToDo newTodo(@RequestBody ToDo newTodo) {
        return repo.save(newTodo);
    }

    @PutMapping("/todo/{id}")
    ToDo editHeader(@RequestBody String newHeader, @PathVariable Long id) {
       return repo.findById(id)
               .map(todo -> {
                   todo.setHeader(newHeader);
                   return repo.save(todo);
               })
               .orElseThrow(() -> new ToDoNotFoundException(id));
    }

    @DeleteMapping("/todo/{id}")
    void deleteTodo(@PathVariable Long id){
        repo.deleteById(id);
    }
}
