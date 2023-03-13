package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button greetingButton = findViewById(R.id.boto);

        greetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // en el codi java es referencien els resources amb R. x recurs
                greetingButton.setBackgroundResource(R.drawable.button_backgorund_when_clicked);
                Toast.makeText(MainActivity.this, R.string.Toast_message, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}