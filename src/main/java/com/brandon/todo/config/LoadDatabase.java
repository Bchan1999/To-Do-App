package com.brandon.todo.config;

import com.brandon.todo.model.ToDo;
import com.brandon.todo.repository.ToDoRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ToDoRepo toDoRepo){
        Date d1 = new Date(2000, 11, 21);
        return args -> {
            log.info("Preloading " + toDoRepo.save(new ToDo("23", "23", "test", "Test Header")));
            log.info("Preloading " + toDoRepo.save(new ToDo("23", "23", "Launch game", "Game Shittt")));
        };
    }
}
