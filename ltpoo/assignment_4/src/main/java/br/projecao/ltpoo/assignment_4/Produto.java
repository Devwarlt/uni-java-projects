/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpoo.assignment_4;

/**
 *
 * @author devwarlt
 */
public final class Produto {

    private int codigo;
    private String nome;
    private float venda;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public float getVenda() {
        return venda;
    }

    public static Produto incluirProduto(int codigo, String nome, float venda) {
        var produto = new Produto();
        produto.codigo = codigo;
        produto.nome = nome;
        produto.venda = venda;
        return produto;
    }
}
