package com.sandbox.rest.helloworld.controllers;

import com.sandbox.rest.helloworld.models.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrii Sysoiev
 */
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world/{name}")
    public HelloBean helloWorld(@PathVariable String name) {
        String message = messageSource.getMessage("message.hello", new Object[]{name}, LocaleContextHolder.getLocale());

        HelloBean helloBean = new HelloBean(message);
        return helloBean;
    }
}
