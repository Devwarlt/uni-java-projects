package br.com.java.loja.principal;

import javax.swing.JOptionPane;

import br.com.java.loja.impl.Cliente;
import br.com.java.loja.impl.Funcionario;
import br.com.java.loja.impl.Venda;
import br.com.java.loja.extensions.JOptionPaneExtensions;

public final class Program {
    private static final String TIPO_PRODUTO_LABEL = "1 - Perecível\n2- Não perecível\n\nInforme o tipo do produto:";
    private static final String OPERACAO_VENDA_LABEL = "1 - Realizar venda\n2 - Cancelar venda\n\nInforme a operação da venda:";

    public static void main(String[] args) {
        try {
            var cliente = new Cliente();
            cliente.cadastrar();

            var funcionario = new Funcionario();
            funcionario.cadastrar();

            var tipoProduto = JOptionPaneExtensions.getJOptionInput(String.class, TIPO_PRODUTO_LABEL);
            var produto = new Produto();
            produto.cadastrarProduto(tipoProduto);

            var operacaoVenda = JOptionPaneExtensions.getJOptionInput(String.class, OPERACAO_VENDA_LABEL);
            var venda = new Venda();
            if (operacaoVenda == "1")
                venda.realizarVenda(cliente, produto, funcionario);
            if (operacaoVenda == "2")
                venda.cancelarVenda();
        }
        catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getStackTrace());
        }
    }
}