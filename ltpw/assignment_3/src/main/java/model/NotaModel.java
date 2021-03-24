/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author devwarlt
 */
public final class NotaModel {

    private final float nota1;
    private final float nota2;
    private final float nota3;

    public NotaModel(float nota1, float nota2, float nota3) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    
    public float calculaMedia() {
        return (this.nota1 + this.nota2 + this.nota3) / 3.0F;
    }
}
