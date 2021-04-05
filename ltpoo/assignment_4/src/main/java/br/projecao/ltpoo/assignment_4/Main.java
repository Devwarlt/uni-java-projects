/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpoo.assignment_4;

import br.projecao.ltpoo.assignment_4.extensions.JOptionPaneExtensions;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author devwarlt
 */
public final class Main {

    private static final String NUM_PRODUTOS_LABEL = "Informe o número de produtos para esta compra:";
    private static final String CODIGO_PRODUTO_LABEL = "Informe o código do produto:";
    private static final String NOME_PRODUTO_LABEL = "Informe o nome do produto:";
    private static final String VALOR_VENDA_PRODUTO_LABEL = "Informe o valor da venda do produto:";
    private static final String CODIGO_COMPRA_LABEL = "Informe o código da compra:";
    private static final String DATA_COMPRA_LABEL = "Informe a data da compra:";

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        var numProdutos = JOptionPaneExtensions.getJOptionInput(Integer.class, NUM_PRODUTOS_LABEL);
        if (numProdutos <= 0) {
            throw new Exception("'numProdutos' cannot be below zero.");
        }

        var itensCompra = new ItensCompra();
        for (var i = 0; i < numProdutos; i++) {
            var codigo = JOptionPaneExtensions.getJOptionInput(Integer.class, CODIGO_PRODUTO_LABEL);
            var nome = JOptionPaneExtensions.getJOptionInput(String.class, NOME_PRODUTO_LABEL);
            var venda = JOptionPaneExtensions.getJOptionInput(Float.class, VALOR_VENDA_PRODUTO_LABEL);
            var produto = Produto.incluirProduto(codigo, nome, venda);
            itensCompra.incluirProduto(produto);
        }

        var codigo = JOptionPaneExtensions.getJOptionInput(String.class, CODIGO_COMPRA_LABEL);
        var dataCompra = JOptionPaneExtensions.getJOptionInput(Date.class, DATA_COMPRA_LABEL);
        var valorCompra = 0;
        for (var produto : itensCompra.getProdutos()) {
            var venda = produto.getVenda();
            valorCompra += venda;
        }

        var compra = Compra.incluirCompra(codigo, dataCompra, valorCompra);
        itensCompra.setCompra(compra);

        imprimir(itensCompra);

        System.exit(0);
    }

    public static void imprimir(ItensCompra itensCompra) {
        var compra = itensCompra.getCompra();
        var produtos = itensCompra.getProdutos();
        var sdf = new SimpleDateFormat("dd/MM/yyyy");
        var df = new DecimalFormat("0.00");
        var sb = new StringBuilder();
        sb.append("### DADOS DA COMPRA ###");
        sb.append("\n");
        sb.append(String.format("* Código: %s\n", compra.getCodigo()));
        sb.append(String.format("* Valor: $%s\n", df.format(compra.getValorCompra())));
        sb.append(String.format("* Data: %s\n", sdf.format(compra.getDataCompra())));
        sb.append("\n");
        sb.append("### DADOS DOS PRODUTOS ###");

        for (var produto : produtos) {
            sb.append("\n");
            sb.append(String.format("* Código: %s\n", produto.getCodigo()));
            sb.append(String.format("* Nome: %s\n", produto.getNome()));
            sb.append(String.format("* Venda: $%s\n", df.format(produto.getVenda())));
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
