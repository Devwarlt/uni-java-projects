/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpoo.assignment_3;

import br.projecao.ltpoo.assignment_3.extensions.JOptionPaneExtensions;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author devwarlt
 */
public final class Main {

    private static final String PESSOA_NOME_LABEL = "Informe o nome do propriet�rio:";
    private static final String PESSOA_SOBRENOME_LABEL = "Informe o sobrenome do propriet�rio:";
    private static final String PESSOA_IDADE_LABEL = "Informe a idade do propriet�rio %s %s:";
    private static final String PESSOA_CPF_LABEL = "Informe o CPF do propriet�rio %s %s:";
    private static final String VEICULO_PLACA_LABEL = "Informe a placa do ve�culo:";
    private static final String VEICULO_MARCA_LABEL = "Informe a marca do ve�culo:";
    private static final String VEICULO_MODELO_LABEL = "Informe o modelo do ve�culo:";
    private static final String VEICULO_ANO_LABEL = "Informe o ano do ve�culo:";

    public static void main(String args[]) throws Exception {
        var nome = JOptionPaneExtensions.getJOptionInput(String.class, PESSOA_NOME_LABEL);
        var sobrenome = JOptionPaneExtensions.getJOptionInput(String.class, PESSOA_SOBRENOME_LABEL);
        var idade = JOptionPaneExtensions.getJOptionInput(Integer.class, String.format(PESSOA_IDADE_LABEL, nome, sobrenome));
        var cpf = JOptionPaneExtensions.getJOptionInput(String.class, String.format(PESSOA_CPF_LABEL, nome, sobrenome));
        var placa = JOptionPaneExtensions.getJOptionInput(String.class, VEICULO_PLACA_LABEL);
        var marca = JOptionPaneExtensions.getJOptionInput(String.class, VEICULO_MARCA_LABEL);
        var modelo = JOptionPaneExtensions.getJOptionInput(String.class, VEICULO_MODELO_LABEL);
        var ano = JOptionPaneExtensions.getJOptionInput(Integer.class, VEICULO_ANO_LABEL);

        var veiculo = new Veiculo();
        veiculo.setAno(ano);
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setPlaca(placa);

        var pessoa = new Pessoa();
        pessoa.setCpf(cpf);
        pessoa.setIdade(idade);
        pessoa.setNome(nome);
        pessoa.setSobrenome(sobrenome);
        pessoa.setVeiculo(veiculo);

        imprimir(veiculo, pessoa);

        System.exit(0);
    }

    public static void imprimir(Veiculo veiculo, Pessoa pessoa) {
        var df = new DecimalFormat("0");
        var sb = new StringBuffer();
        sb.append("### DADOS DO PROPRIET�RIO ###");
        sb.append("\n");
        sb.append(String.format("* Nome: %s\n", pessoa.getNome()));
        sb.append(String.format("* Sobrenome: %s\n", pessoa.getSobrenome()));
        sb.append(String.format("* Idade: %s\n", df.format(pessoa.getIdade())));
        sb.append(String.format("* CPF: %s\n", pessoa.getCpf()));
        sb.append("\n");
        sb.append("### DADOS DO VE�CULO ###");
        sb.append("\n");
        sb.append(String.format("* Placa: %s\n", veiculo.getPlaca()));
        sb.append(String.format("* Marca: %s\n", veiculo.getMarca()));
        sb.append(String.format("* Modelo: %s\n", veiculo.getModelo()));
        sb.append(String.format("* Ano: %s\n", df.format(veiculo.getAno())));

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
