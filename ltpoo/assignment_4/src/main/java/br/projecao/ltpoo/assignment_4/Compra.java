/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpoo.assignment_4;

import java.util.Date;

/**
 *
 * @author devwarlt
 */
public final class Compra {

    private String codigo;
    private Date dataCompra;
    private double valorCompra;

    public String getCodigo() {
        return codigo;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public static Compra incluirCompra(String codigo, Date dataCompra, double valorCompra) {
        var compra = new Compra();
        compra.codigo = codigo;
        compra.dataCompra = dataCompra;
        compra.valorCompra = valorCompra;
        return compra;
    }
}
