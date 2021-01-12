package com.talissonmelo.tour.controller

import com.talissonmelo.tour.entities.Promocao
import com.talissonmelo.tour.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController(var service: PromocaoService) {

    @GetMapping(value = ["/{promocaoId}"])
    fun buscar(@PathVariable promocaoId: Long): ResponseEntity<Promocao> {
        var promocao = service.buscarId(promocaoId);
        return ResponseEntity.ok().body(promocao);
    }

    @GetMapping
    fun buscarTodos(): List<Promocao> {
        return service.buscar();
    }

    @PostMapping
    fun cadastrar(@RequestBody promocao: Promocao): ResponseEntity<Promocao> {
       var promocao = service.adicionar(promocao);
        return ResponseEntity.ok().body(promocao);
    }

    @DeleteMapping(value = ["/{promocaoId}"])
    fun delecao(@PathVariable promocaoId: Long): ResponseEntity<Unit> {
        service.deletar(promocaoId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = ["/{promocaoId}"])
    fun atualizar(@PathVariable promocaoId: Long, @RequestBody promocao: Promocao): ResponseEntity<Promocao> {
        var promocao = service.atualizar(promocaoId, promocao);
        return ResponseEntity.ok().body(promocao);
    }
}