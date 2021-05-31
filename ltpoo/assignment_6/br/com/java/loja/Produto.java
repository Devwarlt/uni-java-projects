package br.com.java.loja;

import java.util.Date;

import javax.swing.JOptionPane;

import br.com.java.loja.extensions.JOptionPaneExtensions;

public final class Produto {
    private final String CODIGO_LABEL = "[Produto] Informe o código:";
    private final String DESCRICAO_LABEL = "[Produto] Informe a descrição:";
    private final String DATA_VALIDADE_LABEL = "[Produto] Informe a data de validade:";
    private final String PRECO_CUSTO_LABEL = "[Produto] Informe o preço de custo:";
    private final String PRECO_VENDA_LABEL = "[Produto] Informe o preço da venda:";

    public Produto() { }

    private int codigo;
    private String descricao;
    private Date dataValidade;
    private float precoCusto;
    private float precoVenda;

    public int getCodigo() { return this.codigo; }
    public String getDescricao() { return this.descricao; }
    public Date getDataValidade() { return this.dataValidade; }
    public float getPrecoCusto() { return this.precoCusto; }
    public float getPrecoVenda() { return this.precoVenda; }

    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setDataValidade(Date dataValidade) { this.dataValidade = dataValidade; }
    public void setPrecoCusto(float precoCusto) { this.precoCusto = precoCusto; }
    public void setPrecoVenda(float precoVenda) { this.precoVenda = precoVenda; }

    public void cadastrarProduto(String tipoProduto) {
        if (tipoProduto == null || tipoProduto.isEmpty() || (tipoProduto != "1" && tipoProduto != "2"))
            throw new Exception(
                "Tipo de produto não definido! " +
                "Somente valores '1' ou '2' são permitidos."
            );

        try {
            var codigo = JOptionPaneExtensions.getJOptionInput(Integer.class, CODIGO_LABEL);
            var descricao = JOptionPaneExtensions.getJOptionInput(String.class, DESCRICAO_LABEL);
            var dataValidade = JOptionPaneExtensions.getJOptionInput(Date.class, DATA_VALIDADE_LABEL);
            var precoCusto = JOptionPaneExtensions.getJOptionInput(Float.class, PRECO_CUSTO_LABEL);
            var precoVenda = JOptionPaneExtensions.getJOptionInput(Float.class, PRECO_VENDA_LABEL);

            setCodigo(codigo);
            setDescricao(descricao);
            setDataValidade(dataValidade);
            setPrecoCusto(precoCusto * (tipoProduto == "1" ? 1.1f : 1.15f));
            setPrecoVenda(precoVenda);
        }
        catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getStackTrace());
        }
    }
}