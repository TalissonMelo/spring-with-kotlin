package com.talissonmelo.tour.controller

import com.talissonmelo.tour.entities.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {

    @Autowired
    lateinit var promocoes: ConcurrentHashMap<Long, Promocao>

    @GetMapping(value = ["/hello"])
    fun olaMundo() : String {
        println("Olá Mundo");
        return "Olá Mundo";
    }

    @GetMapping
    fun buscarPromocoes() = promocoes[1];

    @GetMapping(value = ["/{promocaoId}"])
    fun buscarPromocoes(@PathVariable promocaoId: Long) = promocoes[promocaoId];
}