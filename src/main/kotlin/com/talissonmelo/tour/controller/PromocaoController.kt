package com.talissonmelo.tour.controller

import com.talissonmelo.tour.entities.Promocao
import com.talissonmelo.tour.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/promocoes"])
class PromocaoController {

   @Autowired
   lateinit var promocaoService: PromocaoService;

    @GetMapping
    fun buscarPromocoes(@RequestParam(required = false, defaultValue = "") local: String) =
        this.promocaoService.buscarPromocoes(local);

    @GetMapping(value = ["/{promocaoId}"])
    fun buscar(@PathVariable promocaoId: Long): ResponseEntity<Promocao?> {
        var promocao = this.promocaoService.buscar(promocaoId);
        var status =  if(promocao != null) HttpStatus.OK else HttpStatus.NOT_FOUND
        return ResponseEntity(promocao,status);
    }

    @PostMapping
    fun cadastrar(@RequestBody promocao: Promocao){
        this.promocaoService.cadastrar(promocao);
    }

    @DeleteMapping(value = ["/{promocaoId}"])
    fun delecao(@PathVariable promocaoId: Long){
        this.promocaoService.delecao(promocaoId);
    }

    @PutMapping(value = ["/{promocaoId}"])
    fun atualizar(@PathVariable promocaoId: Long, @RequestBody promocao: Promocao){
        this.promocaoService.atualizar(promocaoId,promocao);
    }
}