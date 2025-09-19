package com.brandon.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//this does three things
//1 - enable auto configuration : based on my depenedcies, springboot will configure
//my app. Embedded tomcat, MVC, it will configure a web app
@SpringBootApplication
public class ToDoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

}
