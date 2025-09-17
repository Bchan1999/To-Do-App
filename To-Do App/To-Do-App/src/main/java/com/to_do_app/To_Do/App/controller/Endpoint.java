package com.to_do_app.To_Do.App.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//provides hints to people reading code, stereotype annotation
@RestController
public class Endpoint {

    //routing info
    @RequestMapping("/")
    String home() {
        return "Hello World";
    }

}
