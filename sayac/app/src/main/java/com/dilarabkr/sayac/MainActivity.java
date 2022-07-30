package com.dilarabkr.sayac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= findViewById(R.id.textView);

        new CountDownTimer(10000,1000) {

            @Override
            public void onTick(long l) //belirlediğimiz süre aralığında ne yapacağımızı yazacağımız kod bloğu
            {
                textView.setText(l/1000+" saniye");
            }

            @Override
            public void onFinish() //belirlenen süre bittiğinde ne olacağını yazacağımız kod bloğu
            {
                Toast.makeText(getApplicationContext(),"süreniz bitti!", Toast.LENGTH_LONG).show();
            }
        }.start();
    }
}