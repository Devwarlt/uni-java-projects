package br.com.java.loja.impl;

import javax.swing.JOptionPane;

import br.com.java.loja.Pessoa;
import br.com.java.loja.extensions.JOptionPaneExtensions;

public final class Cliente extends Pessoa {
    private final String VALOR_COMPRA_LABEL = "[Cliente] Informe o valor da compra:";

    public Cliente() { }

    private float valorCompra;

    public String getCpf() { return this.cpf; }
    public String getNome() { return this.nome; }
    public String getCelular() { return this.celular; }
    public int getDataNascimento() { return this.dataNascimento; }
    public String getValorCompra() { return this.valorCompra; }

    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCelular(String celular) { this.celular = celular; }
    public void setDataNascimento(int dataNascimento) { this.dataNascimento = dataNascimento ;}
    public void setValorCompra(float valorCompra) { this.valorCompra = valorCompra; }

    @Override
    public void cadastrar() {
        try {
            var cpf = JOptionPaneExtensions.getJOptionInput(String.class, CPF_LABEL);
            var nome = JOptionPaneExtensions.getJOptionInput(String.class, NOME_LABEL);
            var celular = JOptionPaneExtensions.getJOptionInput(String.class, CELULAR_LABEL);
            var dataNascimento = JOptionPaneExtensions.getJOptionInput(Integer.class, DATA_NASCIMENTO_LABEL);
            var valorCompra = JOptionPaneExtensions.getJOptionInput(Float.class, VALOR_COMPRA_LABEL);
            
            setCpf(cpf);
            setNome(nome);
            setCelular(celular);
            setDataNascimento(dataNascimento);
            setValorCompra(valorCompra);
        }
        catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getStackTrace());
        }
    }
}