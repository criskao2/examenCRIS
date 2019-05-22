package com.example.prue;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CountDownTimer temporizador;
    Button onii;
    EditText hora;
    EditText min;
    EditText sec;
    public long segundos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onii= findViewById(R.id.play);
        hora=findViewById(R.id.hora);
        min= findViewById(R.id.minutos);
        sec= findViewById(R.id.segundos);
        setContentView(R.layout.activity_main);
        onii.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                 horas();
             }
            });

    }

    public void horas(){
        String hr= hora.getText().toString();
        int n= Integer.valueOf(hr);
        segundos=n*3600*1000;
        temporizador= new CountDownTimer(segundos,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                segundos=millisUntilFinished;
                int horass= (int)millisUntilFinished/3600000;
                int minutes = (int)millisUntilFinished/60000;
                int seconds = (int)millisUntilFinished%60000/1000;
                String horr= String.valueOf(horass);

                String minn=String.valueOf(minutes);
                String secc= String.valueOf(seconds);

                hora.setText(horr);
                min.setText(minn);
                sec.setText(secc);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void minutos(){
        String mt= min.getText().toString();
        int n= Integer.valueOf(mt);
        segundos=n*60000;
        temporizador= new CountDownTimer(segundos,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                segundos=millisUntilFinished;
                int minutes = (int)millisUntilFinished/60000;
                int seconds = (int)millisUntilFinished%60000/1000;

                String minn=String.valueOf(minutes);
                String secc= String.valueOf(seconds);

                min.setText(minn);
                sec.setText(secc);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
    public void segundoss(){
        String hr= sec.getText().toString();
        int n= Integer.valueOf(hr);
        segundos=n*1000;
        temporizador= new CountDownTimer(segundos,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                segundos=millisUntilFinished;
                int seconds = (int)millisUntilFinished%60000/1000;
                String secc= String.valueOf(seconds);

                sec.setText(secc);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
