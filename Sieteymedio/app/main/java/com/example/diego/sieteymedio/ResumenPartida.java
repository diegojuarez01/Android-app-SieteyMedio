package com.example.diego.sieteymedio;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResumenPartida extends AppCompatActivity {

    private TextView ganador,jugador1et,jugador2et,resultadotxt;
    private String jugadorganador,resultado,tipobaraja;
    private int id,modojuego;
    private ImageView jugador1carta1,jugador1carta2,jugador1carta3,jugador1carta4,jugador1carta5,jugador1carta6,jugador1carta7,jugador1carta8,jugador1carta9,jugador1carta10,jugador1carta11,jugador1carta12,jugador1carta13,jugador1carta14,jugador1carta15;
    private ImageView jugador2carta1,jugador2carta2,jugador2carta3,jugador2carta4,jugador2carta5,jugador2carta6,jugador2carta7,jugador2carta8,jugador2carta9,jugador2carta10,jugador2carta11,jugador2carta12,jugador2carta13,jugador2carta14,jugador2carta15;
    private Jugador jugador1;
    private Jugador jugador2;
    private String ganador2;
    private Button volverajugar,menuprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_partida);
        getSupportActionBar().hide();
        ganador = (TextView) findViewById(R.id.etganador);
        jugador1et = (TextView) findViewById(R.id.etjugador1);
        jugador2et = (TextView) findViewById(R.id.etjugador2);
        resultadotxt = (TextView) findViewById(R.id.resultadotxt);
        jugador1carta1 = (ImageView) findViewById(R.id.imageView36);
        jugador1carta2 = (ImageView) findViewById(R.id.imageView37);
        jugador1carta3 = (ImageView) findViewById(R.id.imageView38);
        jugador1carta4 = (ImageView) findViewById(R.id.imageView39);
        jugador1carta5 = (ImageView) findViewById(R.id.imageView40);
        jugador1carta6 = (ImageView) findViewById(R.id.imageView41);
        jugador1carta7 = (ImageView) findViewById(R.id.imageView42);
        jugador1carta8 = (ImageView) findViewById(R.id.imageView43);
        jugador1carta9 = (ImageView) findViewById(R.id.imageView44);
        jugador1carta10 = (ImageView) findViewById(R.id.imageView45);
        jugador1carta11 = (ImageView) findViewById(R.id.imageView46);
        jugador1carta12 = (ImageView) findViewById(R.id.imageView47);
        jugador2carta1 = (ImageView) findViewById(R.id.imageView48);
        jugador2carta2 = (ImageView) findViewById(R.id.imageView49);
        jugador2carta3 = (ImageView) findViewById(R.id.imageView50);
        jugador2carta4 = (ImageView) findViewById(R.id.imageView51);
        jugador2carta5 = (ImageView) findViewById(R.id.imageView52);
        jugador2carta6 = (ImageView) findViewById(R.id.imageView53);
        jugador2carta7 = (ImageView) findViewById(R.id.imageView54);
        jugador2carta8 = (ImageView) findViewById(R.id.imageView55);
        jugador2carta9 = (ImageView) findViewById(R.id.imageView56);
        jugador2carta10 = (ImageView) findViewById(R.id.imageView57);
        jugador2carta11 = (ImageView) findViewById(R.id.imageView58);
        jugador2carta12 = (ImageView) findViewById(R.id.imageView59);
        volverajugar = (Button) findViewById(R.id.volverajugar);
        menuprincipal = (Button) findViewById(R.id.menuprincipal);
        jugador1 = (Jugador)getIntent().getExtras().getSerializable("jugador1");
        jugador2 = (Jugador)getIntent().getExtras().getSerializable("jugador2");
        modojuego = getIntent().getExtras().getInt("modojuego");
        tipobaraja = getIntent().getExtras().getString("barajatipo");
        //Para crear animacion de victoria o derrota

        //Para que aparezca el texto:
        final AlphaAnimation fadeIn = new AlphaAnimation(0.0f,1.0f);
        //Tiempo de duracion
        fadeIn.setDuration(1000);
        //Despues de la animacion
        fadeIn.setStartOffset(500);
        fadeIn.setFillAfter(true);

        //Para que desaparezca el texto:
        final AlphaAnimation fadeOut= new AlphaAnimation(1.0f,0.0f);
        //Tiempo de duracion
        fadeOut.setDuration(1000);
        //Despues de la animacion
        fadeOut.setStartOffset(3000);
        fadeOut.setFillAfter(true);

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //Para que desaparezca el texto
                resultadotxt.startAnimation(fadeOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        //Para que no se pueda girar la pantalla a vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        puntuar();
        establecerGanador();
        mostrarResumen();

        if(modojuego==1)
        {

            if(ganador2=="jugador1")
            {
                resultadotxt.setText("VICTORIA");
                resultadotxt.setTextColor(getResources().getColor(R.color.green_500));
            }
            else if(ganador2=="jugador2")
            {
                resultadotxt.setText("DERROTA");
                resultadotxt.setTextColor(getResources().getColor(R.color.rojo));
            }
            else{
                resultadotxt.setText("EMPATE");
                resultadotxt.setTextColor(getResources().getColor(R.color.amarillo));
            }
        }
        else
        {
        }
        //Para que aparezca el texto
        resultadotxt.startAnimation(fadeIn);
    }

    //Metodo encargado de establecer un ganador dependiendo de las puntuaciones y teniendo en cuenta que si es mayor a 7,5 equivale a derrota
    private void establecerGanador ()
    {
        //Establecemos los valores para asignar el ganador de las partidas
        if (jugador1.getPuntuacion()==jugador2.getPuntuacion())
        {
            jugadorganador = "Empate nadie gana";
        }
        else if(jugador1.getPuntuacion()>7.5 && jugador2.getPuntuacion()>7.5){
            jugadorganador = ("No hay ganador");
        }
        else if(jugador1.getPuntuacion()>jugador2.getPuntuacion() && jugador1.getPuntuacion()<7.5)
        {
            jugadorganador = jugador1.getNombre()+" "+ jugador1.getApellidos()+ "(" + jugador1.getAlias() + ")";
             ganador2 = "jugador1";
        }
        else if(jugador2.getPuntuacion()>jugador1.getPuntuacion() && jugador2.getPuntuacion()<7.5)
        {
            jugadorganador = jugador2.getNombre()+" "+ jugador2.getApellidos()+ "(" + jugador2.getAlias() + ")";
          ganador2 = "jugador2";
        }
        else if(jugador1.getPuntuacion()<jugador2.getPuntuacion() && jugador2.getPuntuacion()>7.5)
        {
            jugadorganador = jugador1.getNombre()+" "+ jugador1.getApellidos()+ "(" + jugador1.getAlias() + ")";
            ganador2 = "jugador1";
        }
        else if(jugador2.getPuntuacion()<jugador1.getPuntuacion() && jugador1.getPuntuacion()>7.5)
        {
            jugadorganador = jugador2.getNombre()+" "+ jugador2.getApellidos()+ "(" + jugador2.getAlias() + ")";
            ganador2 = "jugador2";
        }
        else if (jugador2.getPuntuacion()==7.5 && jugador1.getPuntuacion()!=7.5){
            jugadorganador = jugador2.getNombre()+" "+ jugador2.getApellidos()+ "(" + jugador2.getAlias() + ")";
            ganador2 = "jugador2";
        }
        else if (jugador1.getPuntuacion()==7.5 && jugador2.getPuntuacion()!=7.5){
            jugadorganador = jugador1.getNombre()+" "+ jugador1.getApellidos()+ "(" + jugador1.getAlias() + ")";
            ganador2 = "jugador1";
        }
    }

    //Metodo encargado de mostrar el resumen de la jugada
    private void mostrarResumen()
    {
        ganador.setText("GANADOR: " + jugadorganador);
        ganador.setTextColor(Color.parseColor("#3B83BD"));
        jugador1et.setText("Jugador 1 acabo con: " + jugador1.getPuntuacion() + " y las siguiente cartas: ");

        //Recorre las cartas de jugador1 y las muestra
        for(int x=0;x<jugador1.getCartasmano().size();x++) {
            switch (x)
            {
                case 0:
                resultado = jugador1.getCartasmano().get(x).toString();
                id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                jugador1carta1.setImageResource(id);
                    break;
                case 1:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta2.setImageResource(id);
                    break;
                case 2:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta3.setImageResource(id);
                    break;
                case 3:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta4.setImageResource(id);
                    break;
                case 4:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta5.setImageResource(id);
                    break;
                case 5:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta6.setImageResource(id);
                    break;
                case 6:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta7.setImageResource(id);
                    System.out.println("Carta: " + jugador1.getCartasmano().get(x));
                    break;
                case 7:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta8.setImageResource(id);
                    break;
                case 8:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta9.setImageResource(id);
                    break;
                case 9:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta10.setImageResource(id);
                    break;
                case 10:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta11.setImageResource(id);
                    break;
                case 11:
                    resultado = jugador1.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador1carta12.setImageResource(id);
                    break;
            }
        }
        jugador2et.setText("Jugador 2 acabo con: "  + jugador2.getPuntuacion() +" y estas cartas: ");
        //Recorre las cartas de jugador2 y las muestra
        for(int x=0;x<jugador2.getCartasmano().size();x++) {
            switch (x)
            {
                case 0:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta1.setImageResource(id);
                    break;
                case 1:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta2.setImageResource(id);
                    break;
                case 2:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta3.setImageResource(id);
                    break;
                case 3:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta4.setImageResource(id);
                    break;
                case 4:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta5.setImageResource(id);
                    break;
                case 5:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta6.setImageResource(id);
                    break;
                case 6:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta7.setImageResource(id);
                    System.out.println("Carta: " + jugador1.getCartasmano().get(x));
                    break;
                case 7:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta8.setImageResource(id);
                    break;
                case 8:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta9.setImageResource(id);
                    break;
                case 9:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta10.setImageResource(id);
                    break;
                case 10:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta11.setImageResource(id);
                    break;
                case 11:
                    resultado = jugador2.getCartasmano().get(x).toString();
                    id = getResources().getIdentifier("a" + resultado, "drawable", getPackageName());
                    jugador2carta12.setImageResource(id);
                    break;
            }
        }
        volverajugar.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en Siguiente
        {
            @Override
            public void onClick(View v) {
                            Intent siguiente = new Intent(ResumenPartida.this, SolicitarDatos.class);
                siguiente.putExtra("barajatipo",tipobaraja);
                finish();
                startActivity(siguiente);

            }
        });

        menuprincipal.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en Siguiente
        {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(ResumenPartida.this, MainActivity.class);
                siguiente.putExtra("barajatipo",tipobaraja);
                startActivity(siguiente);
                finish();
            }
        });


    }
    private void puntuar()
    {
        jugador1.setPuntuacion(0);
        jugador2.setPuntuacion(0);
        for (int j = 0; j < jugador1.getCartasmano().size() ; j++)
        {
            if(jugador1.getCartasmano().get(j).getNumeros().matches("1|2|3|4|5|6|7")){
                jugador1.setPuntuacion(jugador1.getPuntuacion() + Double.parseDouble(jugador1.getCartasmano().get(j).getNumeros()));
            }
            else if (jugador1.getCartasmano().get(j).getNumeros().matches("as")){
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
            else if (jugador2.getCartasmano().get(j).getNumeros().matches("aas")){
                jugador2.setPuntuacion(jugador2.getPuntuacion() + 1.0);
            }
            else{
                jugador2.setPuntuacion(jugador2.getPuntuacion() + 0.5);
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
