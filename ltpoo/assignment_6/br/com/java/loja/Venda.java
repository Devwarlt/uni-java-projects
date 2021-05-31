package br.com.java.loja;

import java.util.Date;

import br.com.java.loja.impl.Cliente;
import br.com.java.loja.impl.Funcionario;

public final class Venda {
    public Venda() { }

    private Date dataVenda;
    private Date dataCancelamentoVenda;

    public Date getDataVenda() { return this.dataVenda; }
    public Date getDataCancelamentoVenda() { return this.dataCancelamentoVenda; }

    public void setDataVenda(Date dataVenda) { this.dataVenda = dataVenda; }
    public void setDataCancelamentoVenda(Date dataCancelamentoVenda) { this.dataCancelamentoVenda = dataCancelamentoVenda; }

    public void realizarVenda(Cliente cliente, Produto produto, Funcionario funcionario) {
        // TO-DO
    }

    public void cancelarVenda() {
        // TO-DO
    }
}