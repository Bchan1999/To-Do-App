package com.brandon.todo;

import com.brandon.todo.controller.ToDoController;
import com.brandon.todo.model.ToDo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class RestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ToDoController toDoController;

    @Disabled
    @Test
    void get_Todo_Items() throws Exception{
        ToDo mockTodo = new ToDo(Long.parseLong("1"), "Make To-Do App", "Implement to-do app to learn more about Springboot", "Jan-27-2025", "Feb-8-2025");

        when(toDoController.getItem(Long.parseLong("1"))).thenReturn(mockTodo);

        mockMvc.perform(get("/todo/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.header").value("Make To-Do App"));
    }

}
