package com.talissonmelo.tour.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PromocaoController {

    @GetMapping(value = ["/promocoes"])
    fun olaMundo() : String {
        println("Olá Mundo");
        return "Olá Mundo";
    }
}