package com.example.diego.sieteymedio;

/**
 * Created by Diego on 13/07/2016.
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable {

    private String alias;
    private String nombre;
    private String apellidos;
    private String tipodejugador;
    private ArrayList<Carta> Cartasmano = new ArrayList<Carta>();
    private double puntuacion;

    public ArrayList<Carta> getCartasmano() {
        return Cartasmano;
    }
    public void setCartasmano(Carta carta) {
        Cartasmano.add(carta);
    }
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTipodejugador() {
        return tipodejugador;
    }
    public void setTipodejugador(String tipodejugador) {
        this.tipodejugador = tipodejugador;
    }

    // Constructor por defecto para crear automaticamente el usuario maquina

    public Jugador ()

    {
        alias = "autogen";
        nombre = "player2";
        apellidos= "auto generado";
        tipodejugador= "maquina";

    }
    public double getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }


}