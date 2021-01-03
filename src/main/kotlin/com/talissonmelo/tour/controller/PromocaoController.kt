package com.talissonmelo.tour.controller

import com.talissonmelo.tour.entities.Promocao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
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
    fun buscar(@PathVariable promocaoId: Long) = promocoes[promocaoId];

    @PostMapping
    fun cadastrar(@RequestBody promocao: Promocao){
        promocoes[promocao.id]= promocao;
    }

    @DeleteMapping(value = ["/{promocaoId}"])
    fun delecao(@PathVariable promocaoId: Long){
        promocoes.remove(promocaoId);
    }

    @PutMapping(value = ["/{promocaoId}"])
    fun atualizar(@PathVariable promocaoId: Long, @RequestBody promocao: Promocao){
        promocoes.remove(promocaoId);
        promocoes[promocaoId] = promocao
    }
}