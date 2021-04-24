/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpoo.assignment_5;

import br.projecao.ltpoo.assignment_5.extensions.JOptionPaneExtensions;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author devwarlt
 */
public class Main {

    // CLIENTE
    private static final String CLIENTE_NOME_LABEL = "[Cliente]\nInforme o nome:";
    private static final String CLIENTE_CPF_LABEL = "[Cliente]\nInforme o CPF:";
    private static final String CLIENTE_CELULAR_LABEL = "[Cliente]\nInforme o celular:";
    private static final String CLIENTE_DATA_NASCIMENTO_LABEL = "[Cliente]\nInforme a data de nascimento:";
    private static final String CLIENTE_VALOR_COMPRA_LABEL = "[Cliente]\nInforme o valor da compra:";

    // FUNCIONÁRIO
    private static final String FUNCIONARIO_NOME_LABEL = "[Funcionário]\nInforme o nome:";
    private static final String FUNCIONARIO_CPF_LABEL = "[Funcionário]\nInforme o CPF:";
    private static final String FUNCIONARIO_CELULAR_LABEL = "[Funcionário]\nInforme o celular:";
    private static final String FUNCIONARIO_DATA_NASCIMENTO_LABEL = "[Funcionário]\nInforme a data de nascimento:";
    private static final String FUNCIONARIO_SALARIO_LABEL = "[Funcionário]\nInforme o salário:";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            var nome = JOptionPaneExtensions.getJOptionInput(String.class, CLIENTE_NOME_LABEL);
            var cpf = JOptionPaneExtensions.getJOptionInput(String.class, CLIENTE_CPF_LABEL);
            var celular = JOptionPaneExtensions.getJOptionInput(String.class, CLIENTE_CELULAR_LABEL);
            var dataNascimento = JOptionPaneExtensions.getJOptionInput(Date.class, CLIENTE_DATA_NASCIMENTO_LABEL);
            var valorCompra = JOptionPaneExtensions.getJOptionInput(Float.class, CLIENTE_VALOR_COMPRA_LABEL);
            var cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setCelular(celular);
            cliente.setDataNascimento(dataNascimento);
            cliente.setValorCompra(valorCompra);
            cliente.cadastrar();

            nome = JOptionPaneExtensions.getJOptionInput(String.class, FUNCIONARIO_NOME_LABEL);
            cpf = JOptionPaneExtensions.getJOptionInput(String.class, FUNCIONARIO_CPF_LABEL);
            celular = JOptionPaneExtensions.getJOptionInput(String.class, FUNCIONARIO_CELULAR_LABEL);
            dataNascimento = JOptionPaneExtensions.getJOptionInput(Date.class, FUNCIONARIO_DATA_NASCIMENTO_LABEL);
            var salario = JOptionPaneExtensions.getJOptionInput(Float.class, FUNCIONARIO_SALARIO_LABEL);
            var funcionario = new Funcionario();
            funcionario.setNome(nome);
            funcionario.setCpf(cpf);
            funcionario.setCelular(celular);
            funcionario.setDataNascimento(dataNascimento);
            funcionario.setSalario(salario);
            funcionario.cadastrar();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.exit(0);
        }
    }

}
