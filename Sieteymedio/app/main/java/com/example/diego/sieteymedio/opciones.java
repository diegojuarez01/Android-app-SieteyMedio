package com.example.diego.sieteymedio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class opciones extends AppCompatActivity {

    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioGroup radioGroup;
    private Button aplicar;
    private String tipobaraja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

       //Para ocular el action bar
        //getSupportActionBar().hide();



        radioButton1 = (RadioButton) findViewById(R.id.radioon);
        radioButton2 = (RadioButton) findViewById(R.id.radioff);
        radioGroup = (RadioGroup) findViewById(R.id.grupo3);
        aplicar = (Button) findViewById(R.id.volvermenu);

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

        aplicar.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en Siguiente
        {
            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent(opciones.this, MainActivity.class);
                siguiente.putExtra("barajatipo",tipobaraja);
                startActivity(siguiente);
                finish();
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
