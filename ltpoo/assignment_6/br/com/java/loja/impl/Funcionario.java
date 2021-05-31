package br.com.java.loja.impl;

import br.com.java.loja.Pessoa;
import br.com.java.loja.extensions.JOptionPaneExtensions;

public final class Funcionario extends Pessoa {
    private final String SALARIO_LABEL = "[Funcionário] Informe o salário:";

    public Funcionario() { }

    private String salario;

    public String getCpf() { return this.cpf; }
    public String getNome() { return this.nome; }
    public String getCelular() { return this.celular; }
    public int getDataNascimento() { return this.dataNascimento; }
    public String getSalario() { return this.salario; }

    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCelular(String celular) { this.celular = celular; }
    public void setDataNascimento(int dataNascimento) { this.dataNascimento = dataNascimento ;}
    public void setSalario(String salario) { this.salario = salario; }

    @Override
    public void cadastrar() {
        try {
            var cpf = JOptionPaneExtensions.getJOptionInput(String.class, CPF_LABEL);
            var nome = JOptionPaneExtensions.getJOptionInput(String.class, NOME_LABEL);
            var celular = JOptionPaneExtensions.getJOptionInput(String.class, CELULAR_LABEL);
            var dataNascimento = JOptionPaneExtensions.getJOptionInput(Integer.class, DATA_NASCIMENTO_LABEL);
            var salario = JOptionPaneExtensions.getJOptionInput(String.class, SALARIO_LABEL);
            
            setCpf(cpf);
            setNome(nome);
            setCelular(celular);
            setDataNascimento(dataNascimento);
            setSalario(salario);
        }
        catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getStackTrace());
        }
    }
}