package com.example.miniact2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//diapo 5
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent data = getIntent();
        String message = data.getStringExtra("message");
        int repetitions = data.getIntExtra("repetitions",0);
        String msg = getRepeatedmssg(message,repetitions);

        TextView myStringTextView = findViewById(R.id.repeat_text);
        myStringTextView.setText(msg);

        Button back_boto = findViewById(R.id.backButton);

        back_boto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("messagekey", msg);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }

    private String getRepeatedmssg(String message, int repetitions) {
        String msg = "";
        for(int i = 0 ; i <= repetitions; i++){
            msg += message;
        }
        return msg;
    }

}