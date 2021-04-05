/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpoo.assignment_4;

import java.util.ArrayList;

/**
 *
 * @author devwarlt
 */
public final class ItensCompra {

    private final ArrayList<Produto> produtos;

    private Compra compra;

    public ItensCompra() {
        this.produtos = new ArrayList<>();
    }

    public void incluirProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Compra getCompra() {
        return compra;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
