package com.talissonmelo.tour.entities

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Promocao(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        var descricao: String,
        var local: String,
        var qtdDias: Int,
        var completo: Boolean,
        var preco: Double
)