package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button greetingButton = findViewById(R.id.boto);

        greetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetingButton.setBackgroundResource(R.drawable.button_backgorund_when_clicked);
            }
        });
    }
}