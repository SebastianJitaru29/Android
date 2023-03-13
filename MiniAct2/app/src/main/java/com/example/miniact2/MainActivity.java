package com.example.miniact2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) { // 2 put extra , no startActivity , amb el launch getIntent recuperes el missatge de l'activity anterior, i despres fer getIntExtra("clau") per extreure el numero
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editText1 = findViewById(R.id.byeMessageEditText);
        this.editText1.requestFocus();
        this.editText2 = findViewById(R.id.number_of_repetitions);
        Button boto = findViewById(R.id.Boto);
        boto.setOnClickListener(new Catcher(this.editText1,this.editText2));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                editText1.getText().clear();
                this.editText1.requestFocus();
                editText2.getText().clear();
                Bundle passedData = data.getExtras();
                String message = passedData.getString("messagekey");
                TextView text = findViewById(R.id.hellomsg);
                if(message.isEmpty()){text.setText("empty from intent");}
                text.setText(message);
            }
        }
    }
    private class Catcher implements View.OnClickListener {
        EditText et1;
        EditText et2;

        public Catcher(EditText et1, EditText et2) {
            this.et1 = et1;
            this.et2 = et2;
        }

        @Override
        public void onClick(View v) {
            String message = this.et1.getText().toString();
            if (message.isEmpty()) message = getString(R.string.defaultBye);

            String reps = this.et2.getText().toString();
            if (reps.isEmpty()) reps = getString(R.string.defaultRep);
            int nReps = Integer.parseInt(reps);
            if (nReps > 50000) nReps = 10000;   //per evitar aturades en l'aplicació

            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("message", message);
            intent.putExtra("repetitions", nReps);
            startActivityForResult(intent,1);
        }
    }


}