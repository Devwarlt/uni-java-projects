/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpoo.assignment_5;

import javax.swing.JOptionPane;

/**
 *
 * @author devwarlt
 */
public final class Cliente extends Pessoa {

    private float valorCompra;

    public Cliente() {
        super();
    }

    public float getValorCompra() {
        return this.valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public void cadastrar() {
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    }

}
