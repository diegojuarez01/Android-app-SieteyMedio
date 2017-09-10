package com.example.diego.sieteymedio;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;

import java.io.Serializable;

public class SolicitarBaraja extends AppCompatActivity {

    private ImageView española,francesa;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioGroup radioGroup;
    private int Tipodebaraja;
    private Button continuar;
    private String tipobaraja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_baraja);

        //Para ocular el action bar
        //getSupportActionBar().hide();

        española = (ImageView) findViewById(R.id.imageView);
        francesa = (ImageView) findViewById(R.id.imageView2);
        radioButton1 = (RadioButton) findViewById(R.id.radio2a);
        radioButton2 = (RadioButton) findViewById(R.id.radio2b);
        radioGroup = (RadioGroup) findViewById(R.id.grupo2);
        continuar = (Button) findViewById(R.id.continuar2);
        //Para que no se pueda girar la pantalla a vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Ion.with(española).load("http://www.banderas-e-himnos.com/images/banderas/bandera-espana-wehende-flagge-60x86.gif");
        Ion.with(francesa).load("http://www.banderas-e-himnos.com/images/banderas/bandera-francia-wehende-flagge-60x90.gif");

        continuar.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en Siguiente
        {
            @Override
            public void onClick(View v) {
                //Guardamos el id que esta seleccionado al pulsar siguiente en la variable Tipodejugador
                Tipodebaraja = radioGroup.getCheckedRadioButtonId();
                if (radioButton1.isChecked() || radioButton2.isChecked()) {
                    //Dependiendo de la id de respuesta se ejecutara un bloque de codigo distinto.
                    switch (Tipodebaraja) {
                        case R.id.radio2a:
                            tipobaraja = "Espanola";
                            // El jugador 2 se crea por defecto gracias al constructor
                            Intent siguiente = new Intent(SolicitarBaraja.this, MainActivity.class);
                            //Con el intent creado anteriormente le mandamos
                            // la informacion a la siguiente actividad
                            siguiente.putExtra("barajatipo",tipobaraja);
                            startActivity(siguiente);
                            break;
                        case R.id.radio2b:
                            tipobaraja = "Francesa";
                            Intent siguiente2 = new Intent(SolicitarBaraja.this, MainActivity.class);
                            //Con el intent creado anteriormente le mandamos
                            // la informacion a la siguiente actividad
                            siguiente2.putExtra("barajatipo",tipobaraja);
                            startActivity(siguiente2);
                            break;
                    }
                }
                //Solo pasara a la siguiente actividad cuando haya algun elemento de los radiobuttons checkeado
                else
                {
                    Toast.makeText(SolicitarBaraja.this, "Por favor seleccione una opción", Toast.LENGTH_SHORT).show();
                }
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
