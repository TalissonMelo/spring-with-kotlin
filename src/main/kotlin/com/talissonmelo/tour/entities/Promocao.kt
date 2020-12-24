package com.talissonmelo.tour.entities

data class Promocao(
        val id: Long,
        var descricao: String,
        var local: String,
        var qtdDias: Int,
        var completo: Boolean,
        var preco: Double
)