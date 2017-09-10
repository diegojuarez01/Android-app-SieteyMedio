package com.example.diego.sieteymedio;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;


public class MainActivity extends AppCompatActivity {

    //Declaracion de atributos y creacion de objetos
    private int modoJuego;
    private String continuar2,tipobaraja;
   // Scanner scanIn = new Scanner(System.in);
    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();
  //  Baraja barajatipo = new Baraja();
    TextView Bienvenida;
    Button continuar,tipodebaraja,reglas,opciones;
    ImageView saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continuar = (Button) findViewById(R.id.continuar);
        tipodebaraja = (Button) findViewById(R.id.tipodebaraja);
        reglas = (Button) findViewById(R.id.reglas);
        opciones = (Button) findViewById(R.id.opciones);
        //Para que no se pueda girar la pantalla a vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent=this.getIntent();
        if(intent !=null)
        {
            tipobaraja = intent.getStringExtra("barajatipo");
        }
        //Si el usuario no ha seleccionado un tipo de baraja, por defecto pondremos la española.
        else
        {
            tipobaraja="Espanola";
        }

        continuar.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en Siguiente
        {
            @Override
            public void onClick(View v) {
                //Creamos un intent que hara que pasemos de la actividad pregunta1
                // a la actividad "Pregunta2" mediante el evento de pulsar en Siguiente
                Intent siguiente = new Intent(MainActivity.this, SolicitarDatos.class);
                siguiente.putExtra("barajatipo",tipobaraja);
                //Iniciamos la actividad con el intent creado en este caso "siguiente"
                startActivity(siguiente);
            }

        });

        tipodebaraja.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en Siguiente
        {
            @Override
            public void onClick(View v) {
                //Creamos un intent que hara que pasemos de la actividad pregunta1
                // a la actividad "Pregunta2" mediante el evento de pulsar en Siguiente
                Intent siguiente = new Intent(MainActivity.this, SolicitarBaraja.class);
                //Iniciamos la actividad con el intent creado en este caso "siguiente"
                startActivity(siguiente);
            }
        });
        reglas.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en Siguiente
        {
            @Override
            public void onClick(View v) {
                //Creamos un intent que hara que pasemos de la actividad pregunta1
                // a la actividad "Pregunta2" mediante el evento de pulsar en Siguiente
                Intent siguiente = new Intent(MainActivity.this, reglas.class);
                siguiente.putExtra("barajatipo",tipobaraja);
                //Iniciamos la actividad con el intent creado en este caso "siguiente"
                startActivity(siguiente);
            }
        });
        opciones.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en Siguiente
        {
            @Override
            public void onClick(View v) {
                //Creamos un intent que hara que pasemos de la actividad pregunta1
                // a la actividad "Pregunta2" mediante el evento de pulsar en Siguiente
                Intent siguiente = new Intent(MainActivity.this, opciones.class);
                siguiente.putExtra("barajatipo",tipobaraja);
                //Iniciamos la actividad con el intent creado en este caso "siguiente"
                startActivity(siguiente);
            }
        });
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
