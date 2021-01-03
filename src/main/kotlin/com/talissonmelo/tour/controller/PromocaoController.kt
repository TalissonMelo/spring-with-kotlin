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

    @GetMapping
    fun buscarPromocoes(@RequestParam(required = false, defaultValue = "") local: String) =
        promocoes.filter {
            it.value.local.contains(local, true);
        }.map(Map.Entry<Long, Promocao>::value).toList();
    


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