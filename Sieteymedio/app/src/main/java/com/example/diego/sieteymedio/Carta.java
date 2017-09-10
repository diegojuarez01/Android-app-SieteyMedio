package com.example.diego.sieteymedio;

import java.io.Serializable;

/**
 * Created by Diego on 13/07/2016.
 */
public class Carta implements Serializable{
    private String palos;
    private String numeros;

    public Carta (String numeros,String palo)
    {
        this.setNumeros(numeros);
        this.setPalos(palo);

    }

    public String getPalos() {
        return palos;
    }

    @Override
    public String toString(){
        return numeros+palos;
    }

    public void setPalos(String palos) {
        this.palos = palos;
    }



    public String getNumeros() {
        return numeros;
    }

    public void setNumeros(String numeros) {
        this.numeros = numeros;
    }


}