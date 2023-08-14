/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRiblet;

import java.io.*;

/**
 *
 * @author danil
 */
public class Riblet implements Serializable {
    
    private double angulo;
    private double tam;
    private double dr;
    private double dr0;
    private double altura;

    public Riblet(double angulo, double tam, double altura, double dr, double dr0) {
        this.angulo = angulo;
        this.tam = tam;
        this.altura = altura;
        this.dr = dr;
        this.dr0 = dr0;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public double getTam() {
        return tam;
    }

    public void setTam(double tam) {
        this.tam = tam;
    }

    public double getDr() {
        return dr;
    }

    public void setDr(double dr) {
        this.dr = dr;
    }

    public double getDr0() {
        return dr0;
    }

    public void setDr0(double dr0) {
        this.dr0 = dr0;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    
    
    
    
}
