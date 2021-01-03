package com.talissonmelo.tour.service

import com.talissonmelo.tour.entities.Promocao

interface PromocaoService {
    fun buscarPromocoes(local:String): List<Promocao>
    fun buscar(promocaoId: Long): Promocao?
    fun cadastrar(promocao: Promocao)
    fun delecao(promocaoId: Long)
    fun atualizar(promocaoId: Long,promocao: Promocao)
}