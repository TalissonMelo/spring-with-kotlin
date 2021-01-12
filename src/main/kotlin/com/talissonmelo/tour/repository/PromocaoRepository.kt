package com.talissonmelo.tour.repository

import com.talissonmelo.tour.entities.Promocao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PromocaoRepository : JpaRepository<Promocao, Long> {

}