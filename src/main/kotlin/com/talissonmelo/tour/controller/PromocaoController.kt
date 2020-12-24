package com.talissonmelo.tour.controller

import com.talissonmelo.tour.entities.Promocao
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {

    @GetMapping(value = ["/hello"])
    fun olaMundo() : String {
        println("Olá Mundo");
        return "Olá Mundo";
    }

    @GetMapping
    fun buscarPromocoes(): Promocao {
        val promocao = Promocao(1,"Maravilhosa viagem", "Cancun", 10,true, 4499.99)
        return promocao
    }
}