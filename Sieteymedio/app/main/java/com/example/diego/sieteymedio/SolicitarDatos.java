package com.example.diego.sieteymedio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SolicitarDatos extends AppCompatActivity {

    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioGroup radioGroup;
    private Button continuar;
    private String valor;
    private String tipobaraja;
    private int Tipodejugador,modojuego;
    private TextView modoseleccionado,intro1,intro2,alias1,nombre1,apellido1,alias2,nombre2,apellido2;
    private EditText alias1et,nombre1et,apellido1et,alias2et,nombre2et,apellido2et;

    Context context = SolicitarDatos.this;
    SharedPreferences sharpref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_datos);





        // /Para ocular el action bar
        //getSupportActionBar().hide();



        radioButton1 = (RadioButton) findViewById(R.id.radioa);
        radioButton2 = (RadioButton) findViewById(R.id.radiob);
        radioGroup = (RadioGroup) findViewById(R.id.grupo1);
        continuar = (Button) findViewById(R.id.continuar2);
        modoseleccionado = (TextView) findViewById(R.id.modoseleccionado);
        intro1 = (TextView) findViewById(R.id.intro1);
        intro2 = (TextView) findViewById(R.id.intro2);

        alias1 = (TextView) findViewById(R.id.alias1);
        nombre1 = (TextView) findViewById(R.id.nombre1);
        apellido1 = (TextView) findViewById(R.id.apellido1);

        alias2 = (TextView) findViewById(R.id.alias2);
        nombre2 = (TextView) findViewById(R.id.nombre2);
        apellido2 = (TextView) findViewById(R.id.apellido2);

        alias1et = (EditText) findViewById(R.id.editText);
        nombre1et = (EditText) findViewById(R.id.editText2);
        apellido1et = (EditText) findViewById(R.id.editText3);

        alias2et = (EditText) findViewById(R.id.editText4);
        nombre2et = (EditText) findViewById(R.id.editText5);
        apellido2et = (EditText) findViewById(R.id.editText6);




        //Creamos sharedpreferences(archivo,contexto_privado)
/*
        sharpref = context.getSharedPreferences("datosjugador1",context.MODE_PRIVATE);
        sharpref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharpref.edit();
        editor.putString("aliasjugador1",alias1et.getText().toString());
        editor.commit();

        valor = sharpref.getString("aliasjugador1","vacio");
        Toast.makeText(SolicitarDatos.this, valor, Toast.LENGTH_SHORT).show();
*/

        Intent intent=this.getIntent();
        if(intent !=null)
        {
            tipobaraja = intent.getStringExtra("barajatipo");
        }

        else
        {
        }
        //Si el usuario no ha seleccionado un tipo de baraja, por defecto pondremos la española.
    if (tipobaraja==null)
    {
        tipobaraja="Espanola";
    }
        //Para que no se pueda girar la pantalla a vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        continuar.setOnClickListener(new View.OnClickListener() // Evento para cuando se haga click en Siguiente
        {
            @Override
            public void onClick(View v) {
                //Guardamos el id que esta seleccionado al pulsar siguiente en la variable Tipodejugador
                Tipodejugador = radioGroup.getCheckedRadioButtonId();
                //Desactivamos el modo de juego(RadioButton)
                /*
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    radioGroup.getChildAt(i).setEnabled(false);
                }
                */



                if (radioButton1.isChecked() || radioButton2.isChecked()) {
                    //Dependiendo de la id de respuesta se ejecutara un bloque de codigo distinto.
                    switch (Tipodejugador) {
                        case R.id.radioa:
                            if (alias1et.getText().toString().isEmpty()) {
                                Toast.makeText(SolicitarDatos.this, getString(R.string.introduzcaalias1), Toast.LENGTH_SHORT).show();
                            } else if (nombre1et.getText().toString().isEmpty()) {
                                Toast.makeText(SolicitarDatos.this, getString(R.string.introduzcanombre1), Toast.LENGTH_SHORT).show();
                            } else if (apellido1et.getText().toString().isEmpty()) {
                                Toast.makeText(SolicitarDatos.this, getString(R.string.introduzcaapellidos1), Toast.LENGTH_SHORT).show();
                            }
                            //Si todo esta introducido pasaremos a la siguiente actividad.
                            else {
                            //Pasamos los datos del jugador 1 y 2 despues de crearlos
                                jugador1.setAlias(alias1et.getText().toString());
                                jugador1.setNombre(nombre1et.getText().toString());
                                jugador1.setApellidos(apellido1et.getText().toString());
                                modojuego = 1;

                                // El jugador 2 se crea por defecto gracias al constructor
                                Intent siguiente = new Intent(SolicitarDatos.this,juego.class);
                                //Con el intent creado anteriormente le mandamos
                                // la informacion a la siguiente actividad
                                siguiente.putExtra("jugador1", jugador1);
                                siguiente.putExtra("jugador2", jugador2);
                                siguiente.putExtra("modojuego",modojuego);
                                siguiente.putExtra("barajatipo",tipobaraja);
                                startActivity(siguiente);
                            }
                            break;
                        case R.id.radiob:
                            if (alias1et.getText().toString().isEmpty()) {
                                Toast.makeText(SolicitarDatos.this, getString(R.string.introduzcaalias1), Toast.LENGTH_SHORT).show();
                            } else if (nombre1et.getText().toString().isEmpty()) {
                                Toast.makeText(SolicitarDatos.this, getString(R.string.introduzcanombre1), Toast.LENGTH_SHORT).show();
                            } else if (apellido1et.getText().toString().isEmpty()) {
                                Toast.makeText(SolicitarDatos.this, getString(R.string.introduzcaapellidos1), Toast.LENGTH_SHORT).show();
                            }
                            else if (alias2et.getText().toString().isEmpty()) {
                                Toast.makeText(SolicitarDatos.this, getString(R.string.introduzcaalias2), Toast.LENGTH_SHORT).show();
                            } else if (nombre2et.getText().toString().isEmpty()) {
                                Toast.makeText(SolicitarDatos.this, getString(R.string.introduzcanombre2), Toast.LENGTH_SHORT).show();
                            } else if (apellido2et.getText().toString().isEmpty()) {
                                Toast.makeText(SolicitarDatos.this, getString(R.string.introduzcaapellidos2), Toast.LENGTH_SHORT).show();
                            }
                            //Si todo esta introducido pasaremos a la siguiente actividad.
                            else {
                                //Pasamos los datos del jugador 1 y 2 despues de crearlos
                                jugador1.setAlias(alias1et.getText().toString());
                                jugador1.setNombre(nombre1et.getText().toString());
                                jugador1.setApellidos(apellido1et.getText().toString());

                                jugador2.setAlias(alias2et.getText().toString());
                                jugador2.setNombre(nombre2et.getText().toString());
                                jugador2.setApellidos(apellido2et.getText().toString());
                                modojuego = 2;
                                Intent siguiente = new Intent(SolicitarDatos.this,juego.class);
                                //Con el intent creado anteriormente le mandamos
                                // la informacion a la siguiente actividad
                                siguiente.putExtra("jugador1", jugador1);
                                siguiente.putExtra("jugador2", jugador2);
                                siguiente.putExtra("modojuego",modojuego);
                                siguiente.putExtra("barajatipo",tipobaraja);
                                startActivity(siguiente);

                            }
                            break;
                    }
                }
                //Solo pasara a la siguiente actividad cuando haya algun elemento de los radiobuttons checkeado
                else {
                    Toast.makeText(SolicitarDatos.this, "Por favor seleccione una opción", Toast.LENGTH_SHORT).show();
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                intro1.setVisibility(View.VISIBLE);
                alias1.setVisibility(View.VISIBLE);
                nombre1.setVisibility(View.VISIBLE);
                apellido1.setVisibility(View.VISIBLE);
                alias1et.setVisibility(View.VISIBLE);
                nombre1et.setVisibility(View.VISIBLE);
                apellido1et.setVisibility(View.VISIBLE);

                if (checkedId == R.id.radioa) {
                    intro2.setVisibility(View.INVISIBLE);
                    alias2.setVisibility(View.INVISIBLE);
                    nombre2.setVisibility(View.INVISIBLE);
                    apellido2.setVisibility(View.INVISIBLE);
                    alias2et.setVisibility(View.INVISIBLE);
                    nombre2et.setVisibility(View.INVISIBLE);
                    apellido2et.setVisibility(View.INVISIBLE);
                    modoseleccionado.setText(getString(R.string.seleccionado) + getString(R.string.unjugador));

                } else if (checkedId == R.id.radiob) {
                    modoseleccionado.setText(getString(R.string.seleccionado) + getString(R.string.dosjugador));
                    intro2.setVisibility(View.VISIBLE);
                    alias2.setVisibility(View.VISIBLE);
                    nombre2.setVisibility(View.VISIBLE);
                    apellido2.setVisibility(View.VISIBLE);
                    alias2et.setVisibility(View.VISIBLE);
                    nombre2et.setVisibility(View.VISIBLE);
                    apellido2et.setVisibility(View.VISIBLE);
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
