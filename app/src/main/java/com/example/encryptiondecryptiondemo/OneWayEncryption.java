package com.example.encryptiondecryptiondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class OneWayEncryption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_way_encryption);

        // initialises match/mismatch text view to invisible.
        TextView matchTextView = (TextView)findViewById(R.id.matchTextView);
        matchTextView.setVisibility(View.INVISIBLE);
        TextView nomatchTextView = (TextView)findViewById(R.id.nomatchTextView);
        nomatchTextView.setVisibility(View.INVISIBLE);

        // onclick listener for check-match button (displays encrypted passwords and checks match).
        Button oneWayButton = (Button) findViewById(R.id.CheckPasswordMatchBtn);
        oneWayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // onclick: brings user to one-way encryption activity.
                String firstPassword = ((EditText)findViewById(R.id.FirstPassword))
                                        .getText().toString();

                String secondPassword = ((EditText)findViewById(R.id.SecondPassword))
                        .getText().toString();

                String secureFirstPassword = "error";
                String secureSecondPassword = "error";

                try {
                    byte[] salt = MD5WithSaltGenerator.getSalt();
                    secureFirstPassword = MD5WithSaltGenerator.getSecurePassword(firstPassword, salt);
                    secureSecondPassword = MD5WithSaltGenerator.getSecurePassword(secondPassword, salt);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (NoSuchProviderException e) {
                    e.printStackTrace();
                }

                TextView firstPasswordEncrypted = (TextView)findViewById(R.id.FirstPasswordEncryptedTextView);
                firstPasswordEncrypted.setText(secureFirstPassword);

                TextView secondPasswordEncrypted = (TextView)findViewById(R.id.SecondPasswordEncryptedTextView);
                secondPasswordEncrypted.setText(secureSecondPassword);

                if (firstPassword.equals(secondPassword)) {
                    nomatchTextView.setVisibility(View.INVISIBLE);
                    matchTextView.setVisibility(View.VISIBLE);
                } else {
                    matchTextView.setVisibility((View.INVISIBLE));
                    nomatchTextView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}