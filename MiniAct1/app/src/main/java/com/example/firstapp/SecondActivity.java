package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//si vull recuperar una activitat anterior he de finalitzar l'activitat actual per treurela de la pila, s
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Button back_button = findViewById(R.id.back_boto);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // en el codi java es reference els resources amb R. x recurs
                back_button.setBackgroundResource(R.drawable.button_backgorund_when_clicked);
                Toast.makeText(SecondActivity.this, R.string.Toast_message, Toast.LENGTH_SHORT).show();
                finish();
                //Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                //startActivity(intent);// start activity no, pq ja esta a la pila d'execucio, el que s'hauria de fer es finalitzar la 2na per treurela de la pila
            }
        });
    }
}
