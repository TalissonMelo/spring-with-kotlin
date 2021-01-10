package com.talissonmelo.tour.repository

import com.talissonmelo.tour.entities.Promocao
import org.springframework.data.jpa.repository.JpaRepository

interface PromocaoRepository : JpaRepository<Promocao, Long> {
}