package com.talissonmelo.tour.service

import com.talissonmelo.tour.entities.Promocao
import com.talissonmelo.tour.repository.PromocaoRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PromocaoService {

    @Autowired
    lateinit var repository: PromocaoRepository;

    fun buscar(): List<Promocao> {
        return repository.findAll();
    }

    fun buscarId(id: Long): Promocao {
        return repository.findById(id).get();
    }

    fun adicionar(promocao : Promocao): Promocao {
        return repository.save(promocao);
    }

    fun deletar(id: Long) = repository.deleteById(id);

    fun atualizar(id: Long, promocao: Promocao): Promocao {
        var promocaoAtualizacao = repository.findById(id).get();
        BeanUtils.copyProperties(promocao , promocaoAtualizacao , "id");
        return promocaoAtualizacao;
    }
}