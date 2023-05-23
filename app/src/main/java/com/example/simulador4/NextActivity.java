package com.example.simulador4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class NextActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewHits;
    private Button buttonHit;
    private Button buttonError;

    private String name;
    private int hitCount = 0;
    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        textViewName = findViewById(R.id.textViewName);
        textViewHits = findViewById(R.id.textViewHits);
        buttonHit = findViewById(R.id.buttonHit);
        buttonError = findViewById(R.id.buttonError);

        //buttonError.setBackgroundColor(getResources().getColor(R.color.red));

        name = getIntent().getStringExtra("name");
        textViewName.setText(name);

        buttonHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitCount++;
                counter++;
                checkHitCount();
            }
        });

        buttonError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                checkHitCount();
            }
        });
    }

    private void checkHitCount() {
        if (counter >= 5) {
            Intent intent = new Intent(NextActivity.this, ResultActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("hitCount", hitCount);
            startActivity(intent);
            finish();
        } else {
            textViewHits.setText("Intentos restantes: " + (5-counter));
        }
    }
}