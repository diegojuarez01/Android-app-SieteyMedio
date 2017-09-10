package com.example.diego.sieteymedio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class reglas extends AppCompatActivity {

    private TextView tv1,tv2,tv3;
    private Button volvermenu;
    private String tipobaraja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglas);

        //Para ocular el action bar
        //getSupportActionBar().hide();

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        volvermenu = (Button) findViewById(R.id.volvermenu);

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

        volvermenu.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en Siguiente
        {
            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent(reglas.this, MainActivity.class);
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
