package com.talissonmelo.tour

import com.talissonmelo.tour.entities.Promocao
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap
import org.springframework.boot.runApplication as runApplication1

@SpringBootApplication
class TourApplication{
	companion object{
		val initialPromocoes = arrayOf(
				Promocao(1,"Maravilhosa viagem", "Cancun", 10,true, 4499.99),
				Promocao(2,"Viagem maravilhosa", "Cancun", 10,true, 4499.99),
				Promocao(3,"Praia Clube", "Uberlandia", 1,true, 99.99)
		)
	}

	//fun promocoes(): ConcurrentHashMap<Long, Promocao> {
	//	return ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy( Promocao:: id  ));
	//}

	@Bean
	fun promocoes() =
			ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy( Promocao:: id  ));
}

fun main(args: Array<String>) {
	runApplication1<TourApplication>(*args)
}
