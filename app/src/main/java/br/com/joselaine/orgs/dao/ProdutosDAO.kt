package br.com.joselaine.orgs.dao

import br.com.joselaine.orgs.recycler.model.Produto

class ProdutosDAO {
    fun adiciona(produto: Produto) {
        Companion.produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return Companion.produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}