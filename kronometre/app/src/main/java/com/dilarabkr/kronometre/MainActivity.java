package com.dilarabkr.kronometre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button= findViewById(R.id.buttonStart);
        number=0;
    }

    public void start(View view) {

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: "+ number);
                number++;
                textView.setText("Time: "+ number);
                handler.postDelayed(runnable,1000); //kaç saniyede çalışacak
                button.setEnabled(false);//save buttonuna bir kez tıkladıktan sonra tıklanamaz hale gelecek
            }
        };
            handler.post(runnable);
    }

    public void stop(View view) {

        button.setEnabled(true);//stop buttonuna tıklandığında start buttonu tekrar aktif hale gelir
        handler.removeCallbacks(runnable);//runnable'ı kapattık
        Toast.makeText(MainActivity.this, "Time: "+number,Toast.LENGTH_LONG).show();
        number=0;
        textView.setText("Time: "+ number);
    }
}