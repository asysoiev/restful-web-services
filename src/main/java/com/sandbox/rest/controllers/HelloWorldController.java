package com.sandbox.rest.controllers;

import com.sandbox.rest.models.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrii Sysoiev
 */
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world/{name}")
    public HelloWorldBean helloWorld(@PathVariable String name) {
        return new HelloWorldBean(name);
    }
}
