package com.talissonmelo.tour

import com.talissonmelo.tour.entities.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap
import org.springframework.boot.runApplication as runApplication1

@SpringBootApplication
class TourApplication
fun main(args: Array<String>) {
	runApplication1<TourApplication>(*args)
}
