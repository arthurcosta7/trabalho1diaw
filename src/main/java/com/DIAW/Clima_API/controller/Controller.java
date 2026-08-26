package com.DIAW.Clima_API.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.DIAW.Clima_API.service.ClimaService;

@RestController
public class Controller {

    private final ClimaService service;

    public Controller(ClimaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String start() {
        return "API iniciada";
    }
    @GetMapping("/climaBH")
    public String getTempoBH() {
        return service.getTempoBH();
    }

    @GetMapping("/clima/{cidade}")
    public String getTempo(@PathVariable String cidade) {
        return service.getTempo(cidade);
    }

}