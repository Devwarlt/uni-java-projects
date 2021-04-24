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
public final class Funcionario extends Pessoa {

    private float salario;

    public Funcionario() {
        super();
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public void cadastrar() {
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
    }

}
