package com.example.diego.sieteymedio;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class juego extends AppCompatActivity implements View.OnClickListener {

    private ImageView jugador1carta1,jugador1carta2,jugador1carta3,jugador1carta4,jugador1carta5,jugador1carta6,jugador1carta7,jugador1carta8,jugador1carta9,jugador1carta10,jugador1carta11,jugador1carta12,jugador1carta13,jugador1carta14,jugador1carta15;
    private ImageView jugador2carta1,jugador2carta2,jugador2carta3,jugador2carta4,jugador2carta5,jugador2carta6,jugador2carta7,jugador2carta8,jugador2carta9,jugador2carta10,jugador2carta11,jugador2carta12,jugador2carta13,jugador2carta14,jugador2carta15;
    private String resultado,tipobaraja;
    private  int id,contador=0,modojuego;
    private TextView nombrejugador1,nombrejugador2,controlpuntuacion,turno;
    private Button Parar,otracarta;
    private Baraja tipobarajaobtenido = new Baraja();
    private Jugador jugador1 = new Jugador();
    private Jugador jugador2 = new Jugador();
    private int contador2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        getSupportActionBar().hide();
        Toast.makeText(juego.this, "Empieza el juego,haga click en la carta para ver que carta le salio.", Toast.LENGTH_SHORT).show();
        nombrejugador1 = (TextView) findViewById(R.id.nombrejugador1);
        nombrejugador2 = (TextView) findViewById(R.id.nombrejugador2);
        jugador1carta1 = (ImageView) findViewById(R.id.imageView3);
        jugador1carta2 = (ImageView) findViewById(R.id.imageView4);
        jugador1carta3 = (ImageView) findViewById(R.id.imageView5);
        jugador1carta4 = (ImageView) findViewById(R.id.imageView6);
        jugador1carta5 = (ImageView) findViewById(R.id.imageView7);
        jugador1carta6 = (ImageView) findViewById(R.id.imageView9);
        jugador1carta7 = (ImageView) findViewById(R.id.imageView10);
        jugador1carta8 = (ImageView) findViewById(R.id.imageView11);
        jugador1carta9 = (ImageView) findViewById(R.id.imageView12);
        jugador1carta10 = (ImageView) findViewById(R.id.imageView13);
        jugador1carta11 = (ImageView) findViewById(R.id.imageView14);
        jugador1carta12 = (ImageView) findViewById(R.id.imageView15);
        jugador1carta13 = (ImageView) findViewById(R.id.imageView16);
        jugador1carta14 = (ImageView) findViewById(R.id.imageView17);
        jugador1carta15 = (ImageView) findViewById(R.id.imageView18);
        jugador2carta1 = (ImageView) findViewById(R.id.imageView19);
        jugador2carta2 = (ImageView) findViewById(R.id.imageView20);
        jugador2carta3 = (ImageView) findViewById(R.id.imageView23);
        jugador2carta4 = (ImageView) findViewById(R.id.imageView24);
        jugador2carta5 = (ImageView) findViewById(R.id.imageView25);
        jugador2carta6 = (ImageView) findViewById(R.id.imageView26);
        jugador2carta7 = (ImageView) findViewById(R.id.imageView28);
        jugador2carta8 = (ImageView) findViewById(R.id.imageView30);
        jugador2carta9 = (ImageView) findViewById(R.id.imageView31);
        jugador2carta10 = (ImageView) findViewById(R.id.imageView32);
        jugador2carta11 = (ImageView) findViewById(R.id.imageView33);
        jugador2carta12 = (ImageView) findViewById(R.id.imageView34);

        controlpuntuacion = (TextView) findViewById(R.id.puntuacion);
        turno = (TextView) findViewById(R.id.puntuacion);
        Parar = (Button) findViewById(R.id.plantarse);
        otracarta = (Button) findViewById(R.id.otracarta);
        jugador1 = (Jugador)getIntent().getExtras().getSerializable("jugador1");
        jugador2 = (Jugador)getIntent().getExtras().getSerializable("jugador2");
        tipobaraja = getIntent().getExtras().getString("barajatipo");
        modojuego = getIntent().getExtras().getInt("modojuego");

        jugador1carta1.setOnClickListener(juego.this);
        jugador1carta2.setOnClickListener(juego.this);
        jugador1carta3.setOnClickListener(juego.this);
        jugador1carta4.setOnClickListener(juego.this);
        jugador1carta5.setOnClickListener(juego.this);
        jugador1carta6.setOnClickListener(juego.this);
        jugador1carta7.setOnClickListener(juego.this);
        jugador1carta8.setOnClickListener(juego.this);
        jugador1carta9.setOnClickListener(juego.this);
        jugador1carta10.setOnClickListener(juego.this);
        jugador1carta11.setOnClickListener(juego.this);
        jugador1carta12.setOnClickListener(juego.this);
        jugador1carta13.setOnClickListener(juego.this);
        jugador1carta14.setOnClickListener(juego.this);
        jugador1carta15.setOnClickListener(juego.this);
        jugador2carta1.setOnClickListener(juego.this);
        jugador2carta2.setOnClickListener(juego.this);
        jugador2carta3.setOnClickListener(juego.this);
        jugador2carta4.setOnClickListener(juego.this);
        jugador2carta5.setOnClickListener(juego.this);
        jugador2carta6.setOnClickListener(juego.this);
        jugador2carta7.setOnClickListener(juego.this);
        jugador2carta8.setOnClickListener(juego.this);
        jugador2carta9.setOnClickListener(juego.this);
        jugador2carta10.setOnClickListener(juego.this);
        jugador2carta11.setOnClickListener(juego.this);
        jugador2carta12.setOnClickListener(juego.this);

        //Para que no se pueda girar la pantalla a vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        nombrejugador1.setText(jugador1.getNombre().toString());
        nombrejugador2.setText(jugador2.getNombre().toString());
        tipobarajaobtenido.setTipo(tipobaraja);
        tipobarajaobtenido.selecionarBaraja();

        jugador1.setCartasmano(tipobarajaobtenido.obtenerCartas());
        otracarta.setEnabled(false);
        otracarta.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en otracarta
        {
            @Override
            public void onClick(View v) {

                switch (contador) {
                    case 0:
                        break;
                    case 1:
                            //Obtenemos otra carta cada vez que le damos a otra carta
                            jugador1.setCartasmano(tipobarajaobtenido.obtenerCartas());
                            jugador1carta2.setVisibility(View.VISIBLE);
                            otracarta.setEnabled(false);
                            break;
                    case 2:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta3);
                        break;
                    case 3:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta4);
                        break;
                    case 4:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta5);
                        break;
                    case 5:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta6);
                        break;
                    case 6:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta7);
                        break;
                    case 7:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta8);
                        break;
                    case 8:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta9);
                        break;
                    case 9:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta10);
                        break;
                    case 10:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta11);
                        break;
                    case 11:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta12);
                        break;
                    case 12:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta13);
                        break;
                    case 13:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta14);
                        break;
                    case 14:
                        jugador1.setPuntuacion(0);
                        jugador2.setPuntuacion(0);
                        puntuar();
                        comprobarmano(jugador1carta15);
                        break;
                }

            }
        });
        Parar.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en plantarse
        {
            @Override
            public void onClick(View v) {
                contador2=contador2+1;
                switch (contador2) {
                   //Cuando el primer jugador se planta, se inicia la mano del jugador 2.
                    case 1:

                        //Si el modojuego es 1 al plantarse se deberia de iniciar la jugada del jugador2 (La CPU) y pasar a resumenpartida.
                        if(modojuego==1)
                        {
                            //El jugador 2 por defecto sacara siempre 2 cartas
                            jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                            jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                            puntuar();
                            //Si la maquina saca en sus dos primeras cartas menos de 5.5, pedira otra carta
                            if (jugador2.getPuntuacion()< 5.5)
                            {
                                jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                                Intent siguiente = new Intent(juego.this, ResumenPartida.class);
                                //Con el intent creado anteriormente le mandamos
                                // la informacion a la siguiente actividad
                                siguiente.putExtra("jugador1", jugador1);
                                siguiente.putExtra("jugador2", jugador2);
                                siguiente.putExtra("modojuego",modojuego);
                                siguiente.putExtra("barajatipo",tipobaraja);
                                finish();
                                startActivity(siguiente);

                            }
                            //Si la maquina saca en sus dos primeras cartas mas de 7.5, imprime las cartas con las que se ha pasado.
                            else if(jugador2.getPuntuacion()>7.5)
                            {
                                controlpuntuacion.setText("El jugador 2 se ha pasado.");
                                Intent siguiente = new Intent(juego.this, ResumenPartida.class);
                                //Con el intent creado anteriormente le mandamos
                                // la informacion a la siguiente actividad
                                siguiente.putExtra("jugador1", jugador1);
                                siguiente.putExtra("jugador2", jugador2);
                                siguiente.putExtra("modojuego",modojuego);
                                siguiente.putExtra("barajatipo",tipobaraja);
                                finish();
                                startActivity(siguiente);

                            }
                            //Si la maquina saca en sus dos primeras cartas entre 5.5 y 7.5 se plantara.
                            else {
                                controlpuntuacion.setText("El jugador 2 se planta.");
                                Intent siguiente = new Intent(juego.this, ResumenPartida.class);
                                //Con el intent creado anteriormente le mandamos
                                // la informacion a la siguiente actividad
                                siguiente.putExtra("jugador1", jugador1);
                                siguiente.putExtra("jugador2", jugador2);
                                siguiente.putExtra("modojuego",modojuego);
                                siguiente.putExtra("barajatipo",tipobaraja);
                                finish();
                                startActivity(siguiente);

                            }
                        }
                        else
                        {
                            //Si el modojuego es 2 se muestra la cartadeljugador2
                            jugador2carta1.setVisibility(View.VISIBLE);
                            otracarta.setEnabled(false);
                        }
                        break;
                    //Cuando el segundo jugador se planta, se pasa al resumen de la partida.
                    case 2:
                        Intent siguiente = new Intent(juego.this, ResumenPartida.class);
                        //Con el intent creado anteriormente le mandamos
                        // la informacion a la siguiente actividad
                        siguiente.putExtra("jugador1", jugador1);
                        siguiente.putExtra("jugador2", jugador2);
                        siguiente.putExtra("modojuego",modojuego);
                        siguiente.putExtra("barajatipo",tipobaraja);
                        finish();
                        startActivity(siguiente);

                        break;
                }

            }
        });
    }
    public void onClick(View v)
    {
        switch(v.getId())
        {
            //Cartas del jugador 1
            case R.id.imageView3:
                sacarcartajugador1(jugador1carta1);
                break;
            case R.id.imageView4:
                sacarcartajugador1(jugador1carta2);
                //Metodo para iniciar la jugada2 si el jugador 1 se pasa o se planta
                jugada2();
                break;
            case R.id.imageView5:
                sacarcartajugador1(jugador1carta3);
                jugada2();
                break;
            case R.id.imageView6:
                sacarcartajugador1(jugador1carta4);
                jugada2();
                break;
            case R.id.imageView7:
                sacarcartajugador1(jugador1carta5);
                jugada2();
                break;
            case R.id.imageView9:
                sacarcartajugador1(jugador1carta6);
                jugada2();
                break;
            case R.id.imageView10:
                sacarcartajugador1(jugador1carta7);
                jugada2();
                break;
            case R.id.imageView11:
                sacarcartajugador1(jugador1carta8);
                jugada2();
                break;
            case R.id.imageView12:
                sacarcartajugador1(jugador1carta9);
                jugada2();
                break;
            case R.id.imageView13:
                sacarcartajugador1(jugador1carta10);
                jugada2();
                break;
            case R.id.imageView14:
                sacarcartajugador1(jugador1carta11);
                jugada2();
                break;
            case R.id.imageView15:
                sacarcartajugador1(jugador1carta12);
                jugada2();
                break;
            case R.id.imageView16:
                sacarcartajugador1(jugador1carta13);
                jugada2();
                break;
            case R.id.imageView17:
                sacarcartajugador1(jugador1carta14);
                jugada2();
                break;
            case R.id.imageView18:
                sacarcartajugador1(jugador1carta15);
                jugada2();
                break;

            //Cartas del jugador 2
            case R.id.imageView19:
                contador=0;
                sacarcartajugador2(jugador2carta1);
                break;
        }
    }
    //Metodo para obtener la puntuacion actual de la mano.
    private void puntuar()
    {
        jugador1.setPuntuacion(0);
        jugador2.setPuntuacion(0);
        for (int j = 0; j < jugador1.getCartasmano().size() ; j++)
        {
            if(jugador1.getCartasmano().get(j).getNumeros().matches("1|2|3|4|5|6|7")){
                jugador1.setPuntuacion(jugador1.getPuntuacion() + Double.parseDouble(jugador1.getCartasmano().get(j).getNumeros()));
            }
            else if (jugador1.getCartasmano().get(j).getNumeros().matches("As")){
                jugador1.setPuntuacion(jugador1.getPuntuacion() + 1.0);
            }
            else {
                jugador1.setPuntuacion(jugador1.getPuntuacion() + 0.5);
            }
        }
        for (int j = 0; j < jugador2.getCartasmano().size() ; j++)
        {
            if(jugador2.getCartasmano().get(j).getNumeros().matches("1|2|3|4|5|6|7")){
                jugador2.setPuntuacion(jugador2.getPuntuacion() + Double.parseDouble(jugador2.getCartasmano().get(j).getNumeros()));
            }
            else if (jugador2.getCartasmano().get(j).getNumeros().matches("As")){
                jugador2.setPuntuacion(jugador2.getPuntuacion() + 1.0);
            }
            else{
                jugador2.setPuntuacion(jugador2.getPuntuacion() + 0.5);
            }
        }
    }
    private void jugada2()
    {
        jugador1.setPuntuacion(0);
        jugador2.setPuntuacion(0);
        puntuar();
        // Para cuando jugador1 saca 7.5  se inicia la jugada de jugador2.
        if (jugador1.getPuntuacion() == 7.5)
        {
            turno.setText("TURNO JUGADOR 2");
            //Tendremos que pasar a el turno del jugador2.
            if(modojuego == 1)
            {
                //El jugador 2 por defecto sacara siempre 2 cartas
                jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                puntuar();
                //Si la maquina saca en sus dos primeras cartas menos de 5.5, pedira otra carta
                if (jugador2.getPuntuacion()< 5.5)
                {
                    jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                    Intent siguiente = new Intent(juego.this, ResumenPartida.class);
                    //Con el intent creado anteriormente le mandamos
                    // la informacion a la siguiente actividad
                    siguiente.putExtra("jugador1", jugador1);
                    siguiente.putExtra("jugador2", jugador2);
                    siguiente.putExtra("modojuego",modojuego);
                    siguiente.putExtra("barajatipo",tipobaraja);
                    startActivity(siguiente);
                    finish();
                }
                //Si la maquina saca en sus dos primeras cartas mas de 7.5, imprime las cartas con las que se ha pasado.
                else if(jugador2.getPuntuacion()>7.5)
                {
                    controlpuntuacion.setText("El jugador 2 se ha pasado.");
                    Intent siguiente = new Intent(juego.this, ResumenPartida.class);
                    //Con el intent creado anteriormente le mandamos
                    // la informacion a la siguiente actividad
                    siguiente.putExtra("jugador1", jugador1);
                    siguiente.putExtra("jugador2", jugador2);
                    siguiente.putExtra("modojuego",modojuego);
                    siguiente.putExtra("barajatipo",tipobaraja);
                    startActivity(siguiente);
                    finish();
                }
                //Si la maquina saca en sus dos primeras cartas entre 5.5 y 7.5 se plantara.
                else {
                    controlpuntuacion.setText("El jugador 2 se planta.");
                    Intent siguiente = new Intent(juego.this, ResumenPartida.class);
                    //Con el intent creado anteriormente le mandamos
                    // la informacion a la siguiente actividad
                    siguiente.putExtra("jugador1", jugador1);
                    siguiente.putExtra("jugador2", jugador2);
                    siguiente.putExtra("modojuego",modojuego);
                    siguiente.putExtra("barajatipo",tipobaraja);
                    startActivity(siguiente);
                    finish();
                }
            }
            else
            {
                turno.setText("TURNO JUGADOR 2");
                controlpuntuacion.setText("Empieza el turno del jugador 2");
                jugador2carta1.setVisibility(View.VISIBLE);
                jugador2carta1.setEnabled(true);
            }
        }
        //Ganara directamente el jugador 2 si el jugador 1 se pasa.
        else if (jugador1.getPuntuacion() > 7.5){
            turno.setText("GANADOR JUGADOR 2");
            controlpuntuacion.setText("El jugador 1 se ha pasado.");
            Intent siguiente = new Intent(juego.this, ResumenPartida.class);
            //Con el intent creado anteriormente le mandamos
            // la informacion a la siguiente actividad
            siguiente.putExtra("jugador1", jugador1);
            siguiente.putExtra("jugador2", jugador2);
            siguiente.putExtra("modojuego",modojuego);
            siguiente.putExtra("barajatipo",tipobaraja);
            startActivity(siguiente);
            finish();
        }
    }
    //Metodo para manejar las cartas del jugador1 que se añaden a la baraja.
    private void sacarcartajugador1 (ImageView jugadorcarta)
    {
        resultado = jugador1.getCartasmano().get(contador).toString();
        id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
        jugadorcarta.setImageResource(id);
        contador++;
        jugadorcarta.setEnabled(false);
        otracarta.setEnabled(true);
    }
    //Metodo para manejar las cartas del jugador2 que se añaden a la baraja.
    private void sacarcartajugador2 (ImageView jugadorcarta)
    {
        resultado = jugador2.getCartasmano().get(contador).toString();
        id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
        jugadorcarta.setImageResource(id);
        contador++;
        jugadorcarta.setEnabled(false);
        otracarta.setEnabled(true);
    }
    //Metodo para comprobar si se ha pasado el usuario al pulsar otraCarta.
    private void comprobarmano(ImageView jugadorcarta)
    {
        if (jugador1.getPuntuacion() < 7.5) {
            //Obtenemos otra carta cada vez que le damos a otra carta
            jugador1.setCartasmano(tipobarajaobtenido.obtenerCartas());
            jugadorcarta.setVisibility(View.VISIBLE);
            otracarta.setEnabled(false);
        }
        // Para cuando jugador1 saca 7.5  se inicia la jugada de jugador2.
        else if (jugador1.getPuntuacion() == 7.5)
        {
            controlpuntuacion.setText("El jugador 1 ha obtenido la puntuacion perfecta.");
            //Tendremos que pasar a el turno del jugador2.
            if(modojuego==1)
            {
                //El jugador 2 por defecto sacara siempre 2 cartas
                jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                puntuar();
                //Si la maquina saca en sus dos primeras cartas menos de 5.5, pedira otra carta
                if (jugador2.getPuntuacion()<5.5)
                {
                    jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                }
                //Si la maquina saca en sus dos primeras cartas mas de 7.5, imprime las cartas con las que se ha pasado.
                else if(jugador2.getPuntuacion()>7.5)
                {
                    controlpuntuacion.setText("El jugador 2 se ha pasado.");
                }
                //Si la maquina saca en sus dos primeras cartas entre 5.5 y 7.5 se plantara.
                else {
                    controlpuntuacion.setText("El jugador 2 se planta.");
                    Intent siguiente = new Intent(juego.this, ResumenPartida.class);
                    //Con el intent creado anteriormente le mandamos
                    // la informacion a la siguiente actividad
                    siguiente.putExtra("jugador1", jugador1);
                    siguiente.putExtra("jugador2", jugador2);
                    siguiente.putExtra("modojuego",modojuego);
                    siguiente.putExtra("barajatipo",tipobaraja);
                    startActivity(siguiente);
                    finish();
                }
            }
            else if(modojuego==2)
            {
                turno.setText("TURNO JUGADOR 2");
                controlpuntuacion.setText("");
                jugador2carta1.setVisibility(View.VISIBLE);
                jugador2carta1.setEnabled(true);
            }

        }
        else {
            controlpuntuacion.setText("El jugador 1 se ha pasado.");
            //Tendremos que pasar a el turno del jugador2.
            if(modojuego==1)
            {
                //El jugador 2 por defecto sacara siempre 2 cartas
                jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                puntuar();
                //Si la maquina saca en sus dos primeras cartas menos de 5.5, pedira otra carta
                if (jugador2.getPuntuacion()<5.5)
                {
                    jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                }
                //Si la maquina saca en sus dos primeras cartas mas de 7.5, imprime las cartas con las que se ha pasado.
                else if(jugador2.getPuntuacion()>7.5)
                {
                    controlpuntuacion.setText("El jugador 2 se ha pasado.");
                }
                //Si la maquina saca en sus dos primeras cartas entre 5.5 y 7.5 se plantara.
                else {
                    controlpuntuacion.setText("El jugador 2 se planta.");
                    Intent siguiente = new Intent(juego.this, ResumenPartida.class);
                    //Con el intent creado anteriormente le mandamos
                    // la informacion a la siguiente actividad
                    siguiente.putExtra("jugador1", jugador1);
                    siguiente.putExtra("jugador2", jugador2);
                    siguiente.putExtra("modojuego",modojuego);
                    siguiente.putExtra("barajatipo",tipobaraja);
                    startActivity(siguiente);
                    finish();
                }
            }
            else if(modojuego==2)
            {
                turno.setText("TURNO JUGADOR 2");
                jugador2.setCartasmano(tipobarajaobtenido.obtenerCartas());
                controlpuntuacion.setText("");
                jugador2carta1.setVisibility(View.VISIBLE);
                jugador2carta1.setEnabled(true);
            }
        }
    }
   /*
    @Override
    public void onPause() {
        super.onPause();

        Intent i = new Intent(this, AudioService.class);
        i.putExtra("action", AudioService.PAUSE);
        startService(i);
    }
    @Override
    public void onResume() {
        super.onResume();
        Intent i = new Intent(this, AudioService.class);
        i.putExtra("action", AudioService.START);
        startService(i);

    }*/
}
