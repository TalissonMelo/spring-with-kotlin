package com.talissonmelo.tour.service.impl

import com.talissonmelo.tour.entities.Promocao
import com.talissonmelo.tour.service.PromocaoService
import java.util.concurrent.ConcurrentHashMap

class PromocaoServiceImpl: PromocaoService {

    companion object{
        val initialPromocoes = arrayOf(
                Promocao(1,"Maravilhosa viagem", "Cancun", 10,true, 4499.99),
                Promocao(2,"Viagem maravilhosa", "Cancun", 10,true, 4499.99),
                Promocao(3,"Praia Clube", "Uberlandia", 1,true, 99.99)
        )
    }

    var promocoes =
            ConcurrentHashMap<Long, Promocao>(initialPromocoes.associateBy( Promocao:: id  ));

    override fun buscarPromocoes(local: String): List<Promocao> {
        return promocoes.filter {
            it.value.local.contains(local, true);
        }.map(Map.Entry<Long, Promocao>::value).toList();
    }

    override fun buscar(promocaoId: Long): Promocao? {
        return promocoes[promocaoId];
    }

    override fun cadastrar(promocao: Promocao) {
        promocoes[promocao.id] = promocao;
    }

    override fun delecao(promocaoId: Long) {
        promocoes.remove(promocaoId);
    }

    override fun atualizar(promocaoId: Long, promocao: Promocao) {
        delecao(promocaoId);
        cadastrar(promocao);
    }
}