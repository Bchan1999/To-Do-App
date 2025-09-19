package com.brandon.todo.excpetion;

public class ToDoNotFoundException extends RuntimeException{

    public ToDoNotFoundException(Long id){
        super("Could not find todo item " + id);
    }
}
