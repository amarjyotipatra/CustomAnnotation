package com.example.customannotation;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ForLoop {

    @TimeMonitor
    @RequestMapping("/{name}")
    public String doSomething(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        // Simulate processing delay
        for (int i = 0; i < 10000000; i++) {}

        // Return HTML response
        response.setContentType("text/html");
        if(name.equalsIgnoreCase("lucy"))
            response.getWriter().write("<html><body><h1>I love you, " + name + "</h1></body></html>");
        else
            response.getWriter().write("<html><body><h1>Hello World, " + name + "</h1></body></html>");
        return name;
    }
}
