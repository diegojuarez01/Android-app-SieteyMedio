package com.example.diego.sieteymedio;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.app.Activity;
import android.os.Bundle;

public class Pantalladecarga extends AppCompatActivity
        {

    // Temporizador para la pantalla de bienvenida
    private static int SPLASH_TIEMPO = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalladecarga);
        Resources res = getResources();

        CustomProgress customProgressShowProgress = (CustomProgress) findViewById(R.id.customProgressShowProgress);
        customProgressShowProgress.setMaximumPercentage(1.0f);
        customProgressShowProgress.useRoundedRectangleShape(30.0f);
        customProgressShowProgress.setProgressColor(res.getColor(R.color.negro));
        customProgressShowProgress.setProgressBackgroundColor(res.getColor(R.color.negrosuave));
        customProgressShowProgress.setShowingPercentage(true);


        new Handler().postDelayed(new Runnable() {
			/*
			* Mostramos la pantalla de bienvenida con un temporizador.
			* De esta forma se puede mostrar el logo de la app o
			* compañia durante unos segundos.
			*/
            @Override
            public void run() {
                // Este método se ejecuta cuando se consume el tiempo del temporizador.
                // Se pasa a la activity principal
                Intent i = new Intent(Pantalladecarga.this, MainActivity.class);
                startActivity(i);
                // Cerramos esta activity
                finish();
            }
        }, SPLASH_TIEMPO);
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
