package com.example.diego.sieteymedio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Diego on 14/07/2016.
 */
public class Baraja implements Serializable{
    //Declaracion de variables
    private String tipo;
    ArrayList<Carta> barajaArrayList =new ArrayList<Carta> ();

    //Metodo para diferenciar entre los diferentes tipos de barajas
    public void selecionarBaraja()
    {
        switch (tipo) {
            case "e":
            case "Espanola":
            //Creamos las cartas de la baraja española y las introducimos en el array barajaArrayList
                for (int i=1;i<7;i++)
                {
                    Carta carta1 = new Carta (""+i,"copas");
                    barajaArrayList.add(carta1);
                }
                Carta carta2 = new Carta ("sota","copas");
                barajaArrayList.add(carta2);
                Carta carta3 = new Carta ("caballo","copas");
                barajaArrayList.add(carta3);
                Carta carta4 = new Carta ("rey","copas");
                barajaArrayList.add(carta4);

                for (int i=1;i<7;i++)
                {
                    Carta carta1 = new Carta (""+i,"oros");
                    barajaArrayList.add(carta1);
                }

                Carta carta5 = new Carta ("sota","oros");
                barajaArrayList.add(carta5);
                Carta carta6 = new Carta ("caballo","oros");
                barajaArrayList.add(carta6);
                Carta carta7 = new Carta ("rey","oros");
                barajaArrayList.add(carta7);

                for (int i=1;i<7;i++)
                {
                    Carta carta1 = new Carta (""+i,"espadas");
                    barajaArrayList.add(carta1);
                }

                Carta carta8 = new Carta ("sota","espadas");
                barajaArrayList.add(carta8);
                Carta carta9 = new Carta ("caballo","espadas");
                barajaArrayList.add(carta9);
                Carta carta10 = new Carta ("rey","espadas");
                barajaArrayList.add(carta10);

                for (int i=1;i<7;i++)
                {
                    Carta carta1 = new Carta (""+i,"bastos");
                    barajaArrayList.add(carta1);
                }

                Carta carta11 = new Carta ("sota","bastos");
                barajaArrayList.add(carta11);
                Carta carta12 = new Carta ("caballo","bastos");
                barajaArrayList.add(carta12);
                Carta carta13 = new Carta ("rey","bastos");
                barajaArrayList.add(carta13);

                Barajar();
                System.out.println("Baraja española seleccionada");
                break;

            case "f":
            case "Francesa":

                for (int i=2;i<8;i++)
                {
                    Carta carta1 = new Carta (""+i,"picas");
                    barajaArrayList.add(carta1);
                }

                Carta carta14 = new Carta ("jota","picas");
                barajaArrayList.add(carta14);
                Carta carta15 = new Carta ("caballo","picas");
                barajaArrayList.add(carta15);
                Carta carta16 = new Carta ("rey","picas");
                barajaArrayList.add(carta16);
                Carta carta17 = new Carta ("as","picas");
                barajaArrayList.add(carta17);

                for (int i=2;i<8;i++)
                {
                    Carta carta1 = new Carta (""+i,"rombos");
                    barajaArrayList.add(carta1);
                }

                Carta carta18 = new Carta ("jota","rombos");
                barajaArrayList.add(carta18);
                Carta carta19 = new Carta ("caballo","rombos");
                barajaArrayList.add(carta19);
                Carta carta20 = new Carta ("rey","rombos");
                barajaArrayList.add(carta20);
                Carta carta21 = new Carta ("as","rombos");
                barajaArrayList.add(carta21);

                for (int i=2;i<8;i++)
                {
                    Carta carta1 = new Carta (""+i,"treboles");
                    barajaArrayList.add(carta1);
                }

                Carta carta22 = new Carta ("jota","treboles");
                barajaArrayList.add(carta22);
                Carta carta23 = new Carta ("caballo","treboles");
                barajaArrayList.add(carta23);
                Carta carta24 = new Carta ("rey","treboles");
                barajaArrayList.add(carta24);
                Carta carta25 = new Carta ("as","treboles");
                barajaArrayList.add(carta25);

                for (int i=2;i<8;i++)
                {
                    Carta carta1 = new Carta (""+i,"corazones");
                    barajaArrayList.add(carta1);
                }

                Carta carta26 = new Carta ("jota","corazones");
                barajaArrayList.add(carta26);
                Carta carta27 = new Carta ("caballo","corazones");
                barajaArrayList.add(carta27);
                Carta carta28 = new Carta ("rey","corazones");
                barajaArrayList.add(carta28);
                Carta carta29 = new Carta ("as","corazones");
                barajaArrayList.add(carta29);

                System.out.println("Baraja francesa seleccionada");
                Barajar();

            default:
                break;
        }
    }
    //Modificamos el metodo toString
    @Override
    public String toString() {
        return barajaArrayList.toString();
    }

    //Metodo para dar carta a los jugadores y borrarlas
    public Carta obtenerCartas()
    {
        Barajar();
        Carta carta = new Carta("","");
        carta.setNumeros(barajaArrayList.get(0).getNumeros());
        carta.setPalos(barajaArrayList.get(0).getPalos());
        barajaArrayList.remove(0);
        System.out.println(carta);
        return carta;
    }

    //Metodo para mover los elementos de posicion en el array barajaArrayList.
    private void Barajar()
    {
        Collections.shuffle(barajaArrayList);
    }

    //Metodos get and set para la variable tipo de baraja
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
