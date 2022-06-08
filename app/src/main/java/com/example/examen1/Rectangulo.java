package com.example.examen1;

import java.io.Serializable;

public class Rectangulo implements Serializable {

    private float base;
    private float altura;

    public Rectangulo() {
    }

    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calculoArea(){
        float area;
        area = (base*altura);

        return area;
    }

    public float calculoPerimetro(){
        float perimetro;
        perimetro = 2*(base+altura);

        return perimetro;
    }
}
