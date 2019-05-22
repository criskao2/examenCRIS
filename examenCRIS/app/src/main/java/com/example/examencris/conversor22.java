package com.example.examencris;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class conversor22 extends AppCompatActivity {

    EditText unidad;
    TextView resul;
    Button sd;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int c;

    @Override
    protected void onDestroy() {


        String g = unidad.getText().toString();
        editor.putString("unidad",g);
        editor.commit();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor2);
        sharedPreferences = getSharedPreferences("dato", Context.MODE_PRIVATE);
        String hui=sharedPreferences.getString("unidad","NoEncontrado");

        if(hui.equals("NoEncontrado"))
        {
            unidad.setText("");
        }
        else
        {
            unidad.setText(hui);
        }

        c=0;
        String valor = getIntent().getStringExtra("Titulo");
        this.setTitle(valor);
        final String ope = getIntent().getStringExtra("Operacion");


        unidad=findViewById(R.id.editTextunidad);
        sd = findViewById(R.id.buttoncalcular);
        resul=findViewById(R.id.textViewResultado);

        sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    double dato = Double.valueOf(unidad.getText().toString());
                    double res;
                    String asd;
                    switch (ope) {
                        case "1":
                            res = (dato * 9 / 5) + 32;
                            asd= String.valueOf(res);
                            resul.setText(asd + "°F");
                            break;
                        case "2":
                            res = (dato - 32) * 5 / 9;
                            asd = String.valueOf(res);
                            resul.setText(asd + "°C");
                            break;
                        case "3":
                            res = dato + 273.15;
                           asd = String.valueOf(res);
                            resul.setText(asd+ "°K");
                            break;
                        case "4":
                            res = dato - 273.15;
                            asd = String.valueOf(res);
                            resul.setText(asd+ "°C");
                            break;
                        case "5":
                            res = dato *100;
                            asd = String.valueOf(res);
                            resul.setText(asd + "cm");
                            break;
                        case "6":
                            res = dato/100;
                            asd = String.valueOf(res);
                            resul.setText(asd + "m");
                            break;
                        case "7":
                            res = dato/2.54;
                            asd= String.valueOf(res);
                            resul.setText(asd + "plg");
                            break;
                        case "8":
                            res = dato*2.54;
                            asd = String.valueOf(res);
                            resul.setText(asd+ "cm");
                            break;

                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Ingrese un dato correcto"+e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
