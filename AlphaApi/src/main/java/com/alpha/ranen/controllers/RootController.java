package com.alpha.ranen.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;


@Controller
public class RootController {

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void adminRoot(final HttpServletRequest request, final HttpServletResponse response){
        final String rootUri = request.getRequestURL().toString();
        final URI finalURI = new UriTemplate("{rootUri}{resource}").expand(rootUri, "test");
    }

    /*@GetMapping("/")
    public String home(){
        return "localhost:8080/stock";
    }*/
}