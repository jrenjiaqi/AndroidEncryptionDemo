package com.example.encryptiondecryptiondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // onclick listener for one-way encryption button.
        Button oneWayButton = (Button) findViewById(R.id.OneWayBtn);
        oneWayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // onclick: brings user to one-way encryption activity.
                startActivity(new Intent(MainActivity.this, OneWayEncryption.class));
            }
        });

        // onclick listener for two-way en/decryption button.
        Button twoWayButton = (Button) findViewById(R.id.TwoWayBtn);
        twoWayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // onclick: brings user to two-way en/decryption activity.
                startActivity(new Intent(MainActivity.this, TwoWayEncryption.class));
            }
        });
    }
}